import { Component, OnInit } from '@angular/core';
import { CategoriasService } from '../../../services/categorias.service';
import { Categorias } from '../../../models/categorias';

@Component({
  selector: 'app-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent implements OnInit {

  categorias: Categorias[];

  descricaoCategorias: string ='';
  categoria: Categorias;
  titleView: string = "Adicionar Categoría"
  atualizarCategoria: boolean = false;

  constructor(public categoriasService: CategoriasService) { }

  ngOnInit() {
     this.getAllCategorias();
  }

  getAllCategorias(){
    this.categoriasService.getAllCategorias().subscribe(
      resp=>{
          this.categorias= resp.body;
      },error=>{

      }
)
  }

  //Ação do boton Salvars
  actionBtnInsertCategoria(event){

    let categoria : Categorias={
      idCategorias : 0,
      descricaoCategoria : this.descricaoCategorias
    }

    this.categoriasService.insertCategoria(categoria).subscribe(
        resp=>{
           this.getAllCategorias();
        },error=>{
          
        }
    );
  }

  actionBtnAtualizarCategoria(){
    let categoria : Categorias={
      idCategorias : this.categoria.idCategorias,
      descricaoCategoria : this.descricaoCategorias
    }

    this.categoriasService.atualizarCategoria(categoria).subscribe(
          resp=>{
            this.getAllCategorias();
          },error=>{

          }
    )
  }

  actionBtnShowViewUpdate(event, categoria: Categorias){
    this.atualizarCategoria = true;
    this.descricaoCategorias = categoria.descricaoCategoria;
    this.categoria =categoria;
    this.titleView = "Atualizar Categoría"
  }

  actionBtnDeleteCategoria(event, categoria: Categorias){
    this.categoriasService.deleteCategoria(categoria).subscribe(
      resp=>{
        this.getAllCategorias();
      },error=>{

      }
    )
  }

}
