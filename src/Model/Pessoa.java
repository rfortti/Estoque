/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.ResultSet;

/**
 *
 * @author Strong
 */
public class Pessoa 
{
    private int p_id;
    private String p_tipo;
    private String p_nome;
    private String p_rg;
    private String p_cpf;
    private String p_endereco;
    private String p_bairro;
    private String p_cidade;
    private String p_fone;
    private String p_email;
    
    //ALT + Insert (Getter e Setter) gera os métodos  abaixo

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_tipo() {
        return p_tipo;
    }

    public void setP_tipo(String p_tipo) {
        this.p_tipo = p_tipo;
    }

    public String getP_nome() {
        return p_nome;
    }

    public void setP_nome(String p_nome) {
        this.p_nome = p_nome;
    }

    public String getP_rg() {
        return p_rg;
    }

    public void setP_rg(String p_rg) {
        this.p_rg = p_rg;
    }

    public String getP_cpf() {
        return p_cpf;
    }

    public void setP_cpf(String p_cpf) {
        this.p_cpf = p_cpf;
    }

    public String getP_endereco() {
        return p_endereco;
    }

    public void setP_endereco(String p_endereco) {
        this.p_endereco = p_endereco;
    }

    public String getP_bairro() {
        return p_bairro;
    }

    public void setP_bairro(String p_bairro) {
        this.p_bairro = p_bairro;
    }

    public String getP_cidade() {
        return p_cidade;
    }

    public void setP_cidade(String p_cidade) {
        this.p_cidade = p_cidade;
    }

    public String getP_fone() {
        return p_fone;
    }

    public void setP_fone(String p_fone) {
        this.p_fone = p_fone;
    }

    public String getP_email() {
        return p_email;
    }

    public void setP_email(String p_email) {
        this.p_email = p_email;
    }

}
