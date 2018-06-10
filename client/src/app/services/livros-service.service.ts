import { Injectable } from '@angular/core';
import { Livros } from '../models/livros';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class LivrosServiceService {

  constructor(private httpClient: HttpClient) { }

  insertLivro(livro: Livros): Observable<HttpResponse<any>>{

    return this.httpClient.post(
      'http://Localhost:8080/api/livros',
      livro,
      {
        observe: 'response',
        responseType: 'text'
      }
    )
  }

}
