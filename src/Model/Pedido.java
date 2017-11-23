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
public class Pedido 
{
    private int ped_item;
    private String ped_produto;
    private int ped_qtde;
    private float ped_vtotal;
    private String ped_pgto;
    private String ped_cliente;
    private String ped_data;
    private String ped_situacao;
    private String ped_func;
    
    //ALT + Insert (Getter e Setter) gera os métodos  abaixo
    public int getPedItem() {
        return ped_item;
    }

    public void setPedItem(int ped_item) {
        this.ped_item = ped_item;
    }

    public String getPedProduto() {
        return ped_produto;
    }

    public void setPedProduto(String ped_produto) {
        this.ped_produto = ped_produto;
    }

    public int getPedQtde() {
        return ped_qtde;
    }

    public void setPedQtde(int ped_qtde) {
        this.ped_qtde = ped_qtde;
    }

    public double getPedVtotal() {
        return ped_vtotal;
    }

    public void setPedVtotal(float ped_vtotal) {
        this.ped_vtotal = ped_vtotal;
    }

    public String getPedPgto() {
        return ped_pgto;
    }

    public void setPedPgto(String ped_pgto) {
        this.ped_pgto = ped_pgto;
    }

    public String getPedCliente() {
        return ped_cliente;
    }

    public void setPedCliente(String ped_cliente) {
        this.ped_cliente = ped_cliente;
    }

    public String getPedData() {
        return ped_data;
    }

    public void setPedData(String ped_data) {
        this.ped_data = ped_data;
    }

    public String getPedSituacao() {
        return ped_situacao;
    }

    public void setPedSituacao(String ped_situacao) {
        this.ped_situacao = ped_situacao;
    }
    
    public String getPedFunc() {
        return ped_func;
    }

    public void setPedFunc(String ped_func) {
        this.ped_func = ped_func;
    }
    
}
