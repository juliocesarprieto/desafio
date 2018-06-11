import { Categorias } from "./categorias";

export interface Livros {

    idLivros: number;
    tituloLivro: string;
    descricaoLivro: string;
    ano: number;
    totalPaginas: number;
    autor: string;
    categoria: Categorias;
    
}