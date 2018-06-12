import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {
    path: 'libros',
    loadChildren: 'app/components/libros/libros.module#LibrosModule'
  }, 
  {
    path: 'categorias',
    loadChildren: 'app/components/categoria/categoria.module#CategoriaModule'
  }, 
  {
    path: '',
    redirectTo: '',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
