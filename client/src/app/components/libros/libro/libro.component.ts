import { Component, OnInit, Input } from '@angular/core';
import { LivrosServiceService } from '../../../services/livros-service.service';
import { Livros } from '../../../models/livros';

@Component({
  selector: 'app-libro',
  templateUrl: './libro.component.html',
  styleUrls: ['./libro.component.css']
})
export class LibroComponent implements OnInit {

  titulo: '';
  descricao: '';
  autor: '';
  ano: number= 0;
  totalPaginas: number =0;

  constructor(public livroService: LivrosServiceService) { }

  ngOnInit() {
  }

  actionBtnSalvar(event){

    console.log("Entrie no action");

    let livro: Livros={
      idLivro : 0,
      tituloLivro : this.titulo,
      descricaoLivro : this.descricao,
      autor : this.autor,
      ano : this.ano,
      totalPaginas : this.totalPaginas
    };

    this.livroService.insertLivro(livro).subscribe(
      resp=>{
        console.log(resp.body)
      },
      error=>{        
       // if(error.status == 403){
          console .log(error)                 
          //this.router.navigate(['/auth']);
        //}      
      }
    )  ;

  }

}
