import { Injectable } from '@angular/core';
import { Livros } from '../models/livros';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { URL_ROOT } from '../config/config';

@Injectable()
export class LivrosServiceService {

  urlRoot = 'http://'+URL_ROOT.url+':'+URL_ROOT.port;

  constructor(private httpClient: HttpClient) { }

  //Inserir novo livro
  insertLivro(livro: Livros): Observable<HttpResponse<any>>{

    return this.httpClient.post(
      this.urlRoot+'/api/livros',
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
      this.urlRoot+'/api/livros',
        {
          observe : 'response'
        }
    )
  }//--- Fim retornar tudos os livros ---

  //Atualizar novo livro 
  atualizarLivro(livro: Livros): Observable<HttpResponse<any>>{

    return this.httpClient.put(
      this.urlRoot+'/api/livros',
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
      this.urlRoot+'/api/livros'+"/"+livro.idLivros      
    )
  }//--- Fim remover livro ---

}
