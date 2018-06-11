import { Component, OnInit, Input } from '@angular/core';
import { LivrosServiceService } from '../../../services/livros-service.service';
import { Livros } from '../../../models/livros';

@Component({
  selector: 'app-libro',
  templateUrl: './libro.component.html',
  styleUrls: ['./libro.component.css']
})
export class LibroComponent implements OnInit {

  showAdicionarLivro: boolean = false;
  atualizarLivro: boolean =false;
  titleView: string = '';

  id: number = 0;
  titulo: string ='';
  descricao: string ='';
  autor: string ='';
  ano: number =0;
  totalPaginas: number =0;

  livros: Livros;
  livroAtualizar: any;

  constructor(public livroService: LivrosServiceService) { }

  ngOnInit() {
    this.getLivros();
  }

  getLivros(){
    this.livroService.getAllLivros().subscribe(
      resp=>{
          this.livros = resp.body;
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
        totalPaginas : this.totalPaginas        
      };

      this.livroService.insertLivro(livro).subscribe(
            resp=>{
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
          totalPaginas : this.totalPaginas
        };
console.log(livro);
        this.livroService.atualizarLivro(livro).subscribe(
                  resp=>{
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

    this.titleView = "Atualizar livro";
    this.atualizarLivro=true;
    this.livroAtualizar = livro;
    this.showAdicionarLivro = true;
  }

}
