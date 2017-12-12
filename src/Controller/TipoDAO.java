/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Tipo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Multas
 */
public class TipoDAO extends GenericDAO
{
    public TipoDAO()
    {
        super(); //chama o contrutor da classe mãe extendida(GenericDAO)
    }
    
    public boolean inserir(Tipo tipo)
    {
        String sql = "INSERT INTO tipo (tipo_cod, tipo_desc, tipo_sigla) VALUES (?, ?, ?)";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1,tipo.getCodTipo());
            this.stmte.setString(2,tipo.getDescTipo());
            this.stmte.setString(3,tipo.getSiglaTipo());
            this.stmte.execute();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public boolean excluir(Tipo tipo)
    {
        String sql = "DELETE FROM tipo WHERE tipo_cod = ?";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1, tipo.getCodTipo());
            //this.stmte.execute();
            
            int exec = this.stmte.executeUpdate();
            
            if(exec > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
     public boolean editar(Tipo tipo)
    {
        String sql = "UPDATE tipo SET tipo_desc = ?, tipo_sigla = ? WHERE tipo_cod = ?";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1, tipo.getDescTipo());
            this.stmte.setString(2, tipo.getSiglaTipo());
            this.stmte.execute();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public ArrayList<Tipo> getTiposByCod() //L I S T A
    {
        ArrayList<Tipo> tipo = new ArrayList<Tipo>();
        //Categoria[] categorias = new Categoria[200];
        int x = 0;
        String sql = "SELECT * FROM tipo ORDER BY tipo_cod ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Tipo t = new Tipo();
                t.setCodTipo(rs.getInt("tipo_cod"));
                t.setDescTipo(rs.getString("tipo_desc"));
                t.setSiglaTipo(rs.getString("tipo_sigla"));
                tipo.add(t);
                x++;
            }
            return tipo;
            
        }
        catch(Exception e)
        {
            return null;
        }
    } 
     
    public Tipo getTipoByDesc(String tipodesc)
    {
        Tipo tipo = new Tipo();
        
        String sql = "SELECT * FROM tipo WHERE tipo_desc LIKE ?";
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1,'%'+tipodesc);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            rs.first();
            tipo.setCodTipo(rs.getInt("tipo_cod"));
            tipo.setDescTipo(rs.getString("tipo_desc"));
            tipo.setSiglaTipo(rs.getString("tipo_sigla"));
            return tipo;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Tipo> getTipos(int parametro) //L I S T A
    {
        ArrayList<Tipo> tipo = new ArrayList<>();

        String sql = "";
        if(parametro == 1){
            //ORDENA PELO ID DO TIPO
           sql = "SELECT * FROM tipo ORDER BY tipo_cod ASC";
        }else if(parametro == 2){
            //ORDENA PELO NOME DO TIPO
            sql = "SELECT * FROM tipo ORDER BY tipo_desc ASC";
        }
               
        try {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(sql); //sempre usar quando fazer uma consulta(SELECT)
            rs.beforeFirst();
            while (rs.next()) {
                Tipo t = new Tipo();
                t.setCodTipo(rs.getInt("tipo_cod"));
                t.setDescTipo(rs.getString("tipo_desc"));
                t.setSiglaTipo(rs.getString("tipo_sigla"));
                tipo.add(t);
                //x++;
            }
            return tipo;
        } catch (Exception e) {
            return null;
        } 
    }        
    
    public int AutoIncCod()
    {
        String sql = "SELECT (MAX(tipo_cod) + 1) as codigo FROM tipo";
        this.prepareStmte(sql);
        ResultSet rs;
        int retorno = 0;
        try {
            rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            rs.first();
            retorno = rs.getInt("codigo");
        } catch (SQLException ex) {
            Logger.getLogger(TipoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;

    }
}
