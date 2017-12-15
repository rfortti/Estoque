/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class CategoriaDAO extends GenericDAO 
{

    public CategoriaDAO()
    {
        super(); //chama o contrutor da classe mãe extendida(GenericDAO)
    }
            
    public boolean inserir(Categoria categoria)
    {
        String sql = "INSERT INTO categoria (cat_cod, cat_tipo) VALUES (?, ?)";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1,categoria.getCodCategoria());
            this.stmte.setString(2,categoria.getTipoCategoria());
            this.stmte.execute();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public boolean excluir(Categoria categoria)
    {
        String sql = "DELETE FROM categoria WHERE cat_cod = ?";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1, categoria.getCodCategoria());
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
    
     public boolean editar(Categoria categoria)
    {
        String sql = "UPDATE categoria SET cat_tipo = ? WHERE cat_cod = ?";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1,categoria.getTipoCategoria());
            this.stmte.setInt(2, categoria.getCodCategoria());
            this.stmte.execute();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public Categoria getCategoriaByTipo(String tipocategoria)
    {
        Categoria cat = new Categoria();
        
        String sql = "SELECT * FROM categoria WHERE cat_tipo LIKE ?";
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1,tipocategoria+'%');
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            rs.first();
            cat.setCodCategoria(rs.getInt("cat_cod"));
            cat.setTipoCategoria(rs.getString("cat_tipo"));
            return cat;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Categoria> getFindByCat(int parametro, String categ)
    {
        ArrayList<Categoria> categoria = new ArrayList<Categoria>();
                
        String sql = "";
        if(parametro == 1){
            //BUSCA PELO CÓDIGO
           sql = "SELECT * FROM categoria WHERE cat_cod LIKE ? ORDER BY cat_cod ASC";
        }else if(parametro == 2){
            //BUSCA PELO TIPO
           sql = "SELECT * FROM categoria WHERE cat_tipo LIKE ? ORDER BY cat_tipo ASC";
        }
                        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1,categ+'%');// busca pela primeiro letra do nome
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            //rs.first();
            while (rs.next())
            {
                Categoria cat = new Categoria();
                    cat.setCodCategoria(rs.getInt("cat_cod"));
                    cat.setTipoCategoria(rs.getString("cat_tipo"));
                categoria.add(cat);   
            }
            return categoria;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Categoria> getCategoriasByCod() //L I S T A
    {
        ArrayList<Categoria> categoria = new ArrayList<Categoria>();
        //Categoria[] categorias = new Categoria[200];
        int x = 0;
        String sql = "SELECT * FROM categoria ORDER BY cat_cod ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Categoria c = new Categoria();
                c.setCodCategoria(rs.getInt("cat_cod"));
                c.setTipoCategoria(rs.getString("cat_tipo"));
                categoria.add(c);
                x++;
            }
            return categoria;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Categoria> getCategorias(int parametro) //L I S T A
    {
        ArrayList<Categoria> cat = new ArrayList<>();

        String sql = "";
        if(parametro == 1){
            //ORDENA PELO ID DA CATEGORIA
           sql = "SELECT * FROM categoria ORDER BY cat_cod ASC";
        }else if(parametro == 2){
            //ORDENA PELO NOME DA CATEGORIA
            sql = "SELECT * FROM categoria ORDER BY cat_tipo ASC";
        }
               
        try {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(sql); //sempre usar quando fazer uma consulta(SELECT)
            rs.beforeFirst();
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setCodCategoria(rs.getInt("cat_cod"));
                c.setTipoCategoria(rs.getString("cat_tipo"));
                cat.add(c);
                //x++;
            }
            return cat;
        } catch (Exception e) {
            return null;
        } 
    }        
    
    public int AutoIncCod()
    {
        String sql = "SELECT (MAX(cat_cod) + 1) as codigo FROM categoria";
        this.prepareStmte(sql);
        ResultSet rs;
        int retorno = 0;
        try {
            rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            rs.first();
            retorno = rs.getInt("codigo");
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;

    }

}
