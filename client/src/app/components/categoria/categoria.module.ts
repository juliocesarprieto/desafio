import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoriaRoutingModule } from './categoria-routing.module';
import { CategoriaComponent } from './categoria/categoria.component';
import { CategoriasService } from '../../services/categorias.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    CategoriaRoutingModule,
    HttpClientModule
  ],
  declarations: [
    CategoriaComponent
  ],
  providers: [
    CategoriasService
  ]
})
export class CategoriaModule { }
