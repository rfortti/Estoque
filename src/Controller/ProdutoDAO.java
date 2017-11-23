/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class ProdutoDAO extends GenericDAO {

    public ProdutoDAO()
    {
        super(); //chama o contrutor da classe mãe extendida(GenericDAO)
    }
            
    public boolean inserir(Produto produto)
    {
        String sql = "INSERT INTO produto(prod_cod, prod_desc, prod_tipo, prod_min, cat_cod) VALUES(?, ?, ?, ?, ?)";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1,produto.getCodProduto());
            this.stmte.setString(2,produto.getDescProduto());
            this.stmte.setString(3,produto.getTipoProduto());
            this.stmte.setInt(4,produto.getMinProduto());
            this.stmte.setInt(5,produto.getCod_cat());
            this.stmte.execute();
            return true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar produto!\n" + e);
            return false;
        }
    }
    
    public boolean excluir(Produto produto)
    {
       String sql = "DELETE FROM produto WHERE prod_cod = ?";
       
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1, produto.getCodProduto());
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
    
     public boolean editar(Produto produto)
    {
        String sql = "UPDATE produto SET prod_desc = ?, prod_tipo = ?, prod_min = ?, cat_cod = ? WHERE prod_cod = ?";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1, produto.getCodProduto());
            this.stmte.setString(2,produto.getDescProduto());
            this.stmte.setString(3,produto.getTipoProduto());
            this.stmte.setInt(4,produto.getMinProduto());
            this.stmte.setInt(5,produto.getCod_cat());
            this.stmte.execute();
            return true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao modificar produto!\n" + e);
            return false;
        }
    }
    
    public Produto getProdutoByDesc(String descproduto)
    {
        Produto prod = new Produto();
        
        String sql = "SELECT * FROM produto WHERE prod_desc LIKE ?";
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1,descproduto+'%');
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            rs.first();
            prod.setCodProduto(rs.getInt("prod_cod"));
            prod.setDescProduto(rs.getString("prod_desc"));
            prod.setTipoProduto(rs.getString("prod_tipo"));
            prod.setMinProduto(rs.getInt("prod_min"));
            prod.setCod_cat(rs.getInt("cat_cod"));
            return prod;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Produto> getProdutosByCod()
    {
        ArrayList<Produto> produto = new ArrayList<Produto>();
        
        String sql = "SELECT * FROM produto ORDER BY prod_cod ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Produto p = new Produto();
                p.setCodProduto(rs.getInt("prod_cod"));
                p.setDescProduto(rs.getString("prod_desc"));
                p.setTipoProduto(rs.getString("prod_tipo"));
                p.setMinProduto(rs.getInt("prod_min"));
                p.setCod_cat(rs.getInt("cat_cod"));
                
                produto.add(p);
            }
            return produto;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Produto> getProdutosByDesc()
    {
        ArrayList<Produto> produto = new ArrayList<Produto>();
        
        String sql = "SELECT * FROM produto ORDER BY prod_desc ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Produto p = new Produto();
                p.setCodProduto(rs.getInt("prod_cod"));
                p.setDescProduto(rs.getString("prod_desc"));
                p.setTipoProduto(rs.getString("prod_tipo"));
                p.setMinProduto(rs.getInt("prod_min"));
                p.setCod_cat(rs.getInt("cat_cod"));
                
                produto.add(p);
            }
            return produto;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Produto> getProdutosByTipo()
    {
        ArrayList<Produto> produto = new ArrayList<Produto>();
        
        String sql = "SELECT * FROM produto ORDER BY prod_tipo ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Produto p = new Produto();
                p.setCodProduto(rs.getInt("prod_cod"));
                p.setDescProduto(rs.getString("prod_desc"));
                p.setTipoProduto(rs.getString("prod_tipo"));
                p.setMinProduto(rs.getInt("prod_min"));
                p.setCod_cat(rs.getInt("cat_cod"));
                
                produto.add(p);
            }
            return produto;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Produto> getProdutosByCateg()
    {
        ArrayList<Produto> produto = new ArrayList<Produto>();
        
        String sql = "SELECT * FROM produto ORDER BY cat_cod ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Produto p = new Produto();
                p.setCodProduto(rs.getInt("prod_cod"));
                p.setDescProduto(rs.getString("prod_desc"));
                p.setTipoProduto(rs.getString("prod_tipo"));
                p.setMinProduto(rs.getInt("prod_min"));
                p.setCod_cat(rs.getInt("cat_cod"));
                
                produto.add(p);
            }
            return produto;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public int AutoIncCod(){
        String sql = "SELECT (MAX(prod_cod) + 1) as codigo FROM produto";
        this.prepareStmte(sql);
        ResultSet rs;
        int retorno = 0;
        try 
        {
            rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            rs.first();
            retorno = rs.getInt("codigo");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;

    }

}
