/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Strong
 */
public class LoginDAO extends GenericDAO
{
    public LoginDAO()
    {
        super(); //chama o contrutor da classe mãe extendida(GenericDAO)
    }
    
    public Login[] getUsuario()
    {
        Login[] log = new Login[200];
        int x = 0;
        String sql = "SELECT * FROM tblusuario ORDER BY pes_id ASC ";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Login l = new Login();
                
                l.setUsuario(rs.getString("login"));
                
                log[x] = l;
                x++;
            }
            return log;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public boolean acessaSistema(String login, String senha)
    {
        boolean autentic = false;
        Login log = new Login();
        String sql = "SELECT login, senha FROM tblusuario WHERE login = ? AND senha = ?";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1,login);
            this.stmte.setString(2,senha);
                
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            rs.next();
            log.setUsuario(rs.getString("login"));
            log.setSenha(rs.getString("senha"));
            //return log;
            autentic = true;
        }
        catch(Exception e)
        {
            //return null;
            autentic = false;
        }
        return autentic;               
    }
}
