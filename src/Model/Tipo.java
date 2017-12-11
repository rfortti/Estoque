/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;

/**
 *
 * @author Multas
 */
public class Tipo 
{
    private int cod_tipo;
    private String desc_tipo;
    private String sigla_tipo;
    
    //ALT + Insert (Getter e Setter) gera os métodos  abaixo
    public int getCodTipo() {
        return cod_tipo;
    }

    public void setCodTipo(int cod_tipo) {
        this.cod_tipo = cod_tipo;
    }

    public String getDescTipo() {
        return desc_tipo;
    }

    public void setDescTipo(String desc_tipo) {
        this.desc_tipo = desc_tipo;
    }

    public String getSiglaTipo() {
        return sigla_tipo;
    }

    public void setSiglaTipo(String sigla_tipo) {
        this.sigla_tipo = sigla_tipo;
    }

    @Override
    public String toString() {
        return getDescTipo();
    }
        
        //Esse método serve para definirmos qual nossa regra para tipos iguais.
        //Ou seja, os tipos serão IGUAIS quando seus Cod_tipo forem IGUAIS.
    @Override
        public boolean equals(Object o)
        {
            Tipo t = (Tipo) o;
            return this.cod_tipo == t.getCodTipo();
        }
}
