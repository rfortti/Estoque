/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Strong
 */
public class Produto 
{
    private int cod_produto;
    private String desc_produto;
    private String tipo_produto;
    private int min_produto;
    private int cod_cat;

    //ALT + Insert (Getter e Setter) gera os métodos  abaixo
    public int getCodProduto() {
        return cod_produto;
    }

    public void setCodProduto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getDescProduto() {
        return desc_produto;
    }

    public void setDescProduto(String desc_produto) {
        this.desc_produto = desc_produto;
    }

    public String getTipoProduto() {
        return tipo_produto;
    }

    public void setTipoProduto(String tipo_produto) {
        this.tipo_produto = tipo_produto;
    }
    
    public int getMinProduto() {
        return min_produto;
    }

    public void setMinProduto(int min_produto) {
        this.min_produto = min_produto;
    }

    public int getCod_cat() {
        return cod_cat;
    }

    public void setCod_cat(int cod_cat) {
        this.cod_cat = cod_cat;
    }

}
