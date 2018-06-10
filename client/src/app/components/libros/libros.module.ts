import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LibrosRoutingModule } from './libros-routing.module';
import { LibroComponent } from './libro/libro.component';

@NgModule({
  imports: [
    CommonModule,
    LibrosRoutingModule
  ],
  declarations: [LibroComponent]
})
export class LibrosModule { }
