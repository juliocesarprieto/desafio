import { Injectable } from '@angular/core';
import { URL_ROOT } from '../config/config';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Categorias } from '../models/categorias';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class CategoriasService {

  urlRoot = 'http://'+URL_ROOT.url+':'+URL_ROOT.port;

  constructor(private httpClient: HttpClient) { }

  getAllCategorias() : Observable<HttpResponse<Categorias[]>>{
    
    return this.httpClient.get<Categorias[]>(
      this.urlRoot+'/api/categorias',
        {
          observe : 'response'
        }
    )
  }

}
