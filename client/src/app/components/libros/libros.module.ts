import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { LibrosRoutingModule } from './libros-routing.module';
import { LibroComponent } from './libro/libro.component';
import { LivrosServiceService } from '../../services/livros-service.service';
import { HttpClientModule } from '@angular/common/http';
import { CategoriasService } from '../../services/categorias.service';

@NgModule({
  imports: [
    CommonModule,
    LibrosRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  declarations: [
    LibroComponent
  ],
  providers: [
    LivrosServiceService,
    CategoriasService
  ]
})
export class LibrosModule { }
