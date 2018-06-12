import { Injectable } from '@angular/core';
import { URL_ROOT } from '../config/config';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Categorias } from '../models/categorias';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class CategoriasService {

  urlRoot = 'http://'+URL_ROOT.url+':'+URL_ROOT.port;

  constructor(private httpClient: HttpClient) { }

  //Procurar tudas as categorias
  getAllCategorias() : Observable<HttpResponse<Categorias[]>>{
    
    return this.httpClient.get<Categorias[]>(
      this.urlRoot+'/api/categorias',
        {
          observe : 'response'
        }
    );
  }

  //Metodo para inserir nova categoria
  insertCategoria(categoria: Categorias) : Observable<HttpResponse<any>>{
    return this.httpClient.post(
          this.urlRoot+'/api/categorias',
          categoria,
          {
            observe: 'response',
            responseType: 'text'
          }
        );
  }

  //Metodo para atualizar categoria
  atualizarCategoria(categoria: Categorias) : Observable<HttpResponse<any>>{
    return this.httpClient.put(
          this.urlRoot+'/api/categorias',
          categoria,
          {
            observe: 'response',
            responseType: 'text'
          }
        );
  }

  //Metodo para Remover categoria
  deleteCategoria(categoria : Categorias) : Observable<HttpResponse<any>>{
    return this.httpClient.delete<any>(
      this.urlRoot+'/api/categorias/'+categoria.idCategorias      
    )
  }

}
