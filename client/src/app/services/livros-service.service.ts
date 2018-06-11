import { Injectable } from '@angular/core';
import { Livros } from '../models/livros';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class LivrosServiceService {

  constructor(private httpClient: HttpClient) { }

  //Inserir novo livro
  insertLivro(livro: Livros): Observable<HttpResponse<any>>{

    return this.httpClient.post(
      'http://Localhost:8080/api/livros',
      livro,
      {
        observe: 'response',
        responseType: 'text'
      }
    )
  }//--- Fim Inserir novo livro ---

  //Retornar tudos os livros
  getAllLivros() : Observable<HttpResponse<Livros>>{
    
    return this.httpClient.get<Livros>(
        'http://localhost:8080/api/livros',
        {
          observe : 'response'
        }
    )
  }//--- Fim retornar tudos os livros ---

  //Atualizar novo livro 
  atualizarLivro(livro: Livros): Observable<HttpResponse<any>>{

    return this.httpClient.put(
      'http://Localhost:8080/api/livros',
        livro,
        {
          observe: 'response',
          responseType: 'text'
        }
    );
  }//--- Fim Inserir novo livro ---

  //Remover livro
  removerLivro(livro : Livros) : Observable<HttpResponse<any>>{
    return this.httpClient.delete<any>(
      'http://localhost:8080/api/livros'+"/"+livro.idLivros      
    )
  }//--- Fim remover livro ---

}
