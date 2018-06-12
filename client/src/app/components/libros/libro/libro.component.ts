import { Component, OnInit, Input } from '@angular/core';
import { LivrosServiceService } from '../../../services/livros-service.service';
import { Livros } from '../../../models/livros';
import { Categorias } from '../../../models/categorias';
import { CategoriasService } from '../../../services/categorias.service';
import { forEach } from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-libro',
  templateUrl: './libro.component.html',
  styleUrls: ['./libro.component.css']
})
export class LibroComponent implements OnInit {

  showAdicionarLivro: boolean = false;
  atualizarLivro: boolean =false;
  titleView: string = '';
  msgFiltarPelo = "Filter"

  id: number = 0;
  titulo: string ='';
  descricao: string ='';
  autor: string ='';
  ano: number =0;
  totalPaginas: number =0;
  categoria: Categorias=null;

  mostrarAlert: boolean = false;

  livros: Livros;
  livroAtualizar: any;
  categorias: Categorias[];
  selectChangeOption:number;

  constructor(public livroService: LivrosServiceService, public categoriasService : CategoriasService) { }

  ngOnInit() {
    this.getLivros();
    
   this.getCategorias();
  }

  actionBtnShowFormCadastrar(event){
    this.showAdicionarLivro = true;
    this.atualizarLivro =false;
    this.titleView = 'Adicionar Livro';
  }

  getLivros(){
    this.livroService.getAllLivros().subscribe(
      resp=>{
          this.livros = resp.body;
          this.showAdicionarLivro = false;
          this.atualizarLivro =false;
      },
      error=>{
        console.log(error.status)
      }
    )
  }

  search(criterio: any){
    this.livroService.getAllLivrosCriterio(criterio).subscribe(
      resp=>{
          this.livros = resp.body;
          this.showAdicionarLivro = false;
          this.atualizarLivro =false;
      },
      error=>{
        console.log(error.status)
      }
    )
  }

  actionBtnSalvar(event){
    
    let livro: Livros ={       
        idLivros : 0,
        tituloLivro : this.titulo,
        descricaoLivro : this.descricao,
        autor : this.autor,
        ano : this.ano,
        totalPaginas : this.totalPaginas,
        categoria: this.categoria     
      };

      this.livroService.insertLivro(livro).subscribe(
            resp=>{
              this.getLivros();
            },
            error=>{
              console .log(error);
            }
          );      
   
  }//--- Fim actionBtnSalvar ---

  actionBtnAtualizar(event){

    let livro: Livros= {
          idLivros : this.livroAtualizar.idLivros,
          tituloLivro : this.titulo,
          descricaoLivro : this.descricao,
          autor : this.autor,
          ano : this.ano,
          totalPaginas : this.totalPaginas,
          categoria: this.categoria
        };
          console.log(livro);
        this.livroService.atualizarLivro(livro).subscribe(
                  resp=>{
                    this.getLivros();
                    this.mostrarAlert=true;
                  },
                  error=>{                    
                  });
     
  }//--- Fim actionBtnAtualizar ---

  actionBtnShowViewUpdate(event, livro: Livros){    
   
    this.id = livro.idLivros;
    this.titulo = livro.tituloLivro;
    this.descricao = livro.descricaoLivro;
    this.autor = livro.autor;
    this.ano = livro.ano;
    this.totalPaginas = livro.totalPaginas;
    this.categoria = livro.categoria;

    this.titleView = "Atualizar livro";
    this.atualizarLivro=true;
    this.livroAtualizar = livro;
    this.showAdicionarLivro = true;
  }

  actionBtnRemoverLivro(event, livro : Livros){
    this.livroService.removerLivro(livro).subscribe(resp=>{
      this.getLivros();
    }, error=>{

    })
  }

  getCategorias(){
    this.categoriasService.getAllCategorias()
        .subscribe(
            resp=>{
              this.categorias = resp.body;
            },
            error=>{

            }
        )
  }

  onChangeSelect(event) {
    for (let index = 0; index < this.categorias.length; index++) {
       const element = this.categorias[index];
       if(element.idCategorias == event.target.value ){
          this.categoria = element;         
       }
     }    
  }

}
