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
public class Login 
{
    private int id;
    private String usuario;
    private String senha;

    public void login(String usuario1, String senha1)
        {
            usuario = usuario1;
            senha = senha1;
        }
    
    public void logout()
        {
            usuario = null;
            senha = null;
        }
    
    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getUsuario() 
    {
        return usuario;
    }

    public void setUsuario(String usuario) 
    {
        this.usuario = usuario;
    }

    public String getSenha() 
    {
        return senha;
    }

    public void setSenha(String senha) 
    {
        this.senha = senha;
    }
    
    
}
