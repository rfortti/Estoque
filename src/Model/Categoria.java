/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.ResultSet;

/**
 *
 * @author Aluno
 */
public class Categoria 
{
    private int cod_categoria;
    private String tipo_categoria;
       
   
    //ALT + Insert (Getter e Setter) gera os métodos  abaixo

    public int getCodCategoria() {
        return cod_categoria;
    }

    public void setCodCategoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public String getTipoCategoria() {
        return tipo_categoria;
    }

    public void setTipoCategoria(String tipo_categoria) {
        this.tipo_categoria = tipo_categoria;
    }
    
    //Adicionado por AGUADO
        @Override
        public String toString() {
            return getTipoCategoria();
        }
        
        //Esse método serve para definirmos qual nossa regra para categorias iguais.
        //Ou seja, as categorias serão IGUAIS quando seus Cod_cat forem IGUAIS.
    @Override
        public boolean equals(Object o)
        {
            Categoria c = (Categoria) o;
            return this.cod_categoria == c.getCodCategoria();
        }   
         
}
