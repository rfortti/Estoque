/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estoque;

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
    //Adicionado por AGUADO
    public String getTipoCategoria() {
        return tipo_categoria;
    }

    public void setCodCategoria(int codcat) {
        this.cod_categoria = codcat;
    }

    public String getTipo() {
        return tipo_categoria;
    }

    public void setTipo(String tipocat) {
        this.tipo_categoria = tipocat;
    }
    
        //Adicionado por AGUADO
        @Override
        public String toString() {
            return getTipoCategoria();
        }
 
}
