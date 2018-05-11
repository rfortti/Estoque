/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Multas
 */
public class Pedido extends Pessoa
{
    private int ped_cod;
    private String ped_data;
    private String ped_tipo;
    private Pessoa pes_id;
    //private int pes_id;
    private String ped_destino;
    
    private int item_cod;
    private int item_qtde;
    private float item_valor;
    private int prod_cod;
    
    //ALT + Insert (Getter e Setter) gera os métodos  abaixo

    public int getPed_cod() {
        return ped_cod;
    }

    public void setPed_cod(int ped_cod) {
        this.ped_cod = ped_cod;
    }

    public String getPed_data() {
        return ped_data;
    }

    public void setPed_data(String ped_data) {
        this.ped_data = ped_data;
    }

    public String getPed_tipo() {
        return ped_tipo;
    }

    public void setPed_tipo(String ped_tipo) {
        this.ped_tipo = ped_tipo;
    }

    public Pessoa getPes_id() {
        return pes_id;
    }

    public void setPes_id(Pessoa pes_id) {
        this.pes_id = pes_id;
    }

    public String getPed_destino() {
        return ped_destino;
    }

    public void setPed_destino(String ped_destino) {
        this.ped_destino = ped_destino;
    }

    public int getItem_cod() {
        return item_cod;
    }

    public void setItem_cod(int item_cod) {
        this.item_cod = item_cod;
    }

    public int getItem_qtde() {
        return item_qtde;
    }

    public void setItem_qtde(int item_qtde) {
        this.item_qtde = item_qtde;
    }

    public float getItem_valor() {
        return item_valor;
    }

    public void setItem_valor(float item_valor) {
        this.item_valor = item_valor;
    }

    public int getProd_cod() {
        return prod_cod;
    }

    public void setProd_cod(int prod_cod) {
        this.prod_cod = prod_cod;
    }
    
}
