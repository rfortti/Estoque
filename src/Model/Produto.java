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
    private int min_produto;
    
    private Tipo cod_tipo;
    private Categoria cod_cat;

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

    public int getMinProduto() {
        return min_produto;
    }

    public void setMinProduto(int min_produto) {
        this.min_produto = min_produto;
    }
    
    public Tipo getCod_tipo() {
        return cod_tipo;
    }

    public void setCod_tipo(Tipo cod_tipo) {
        this.cod_tipo = cod_tipo;
    } 
       
    public Categoria getCod_cat() {
        return cod_cat;
    }

    public void setCod_cat(Categoria cod_cat) {
        this.cod_cat = cod_cat;
    }

}
