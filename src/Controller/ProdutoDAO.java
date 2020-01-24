/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Categoria;
import Model.Produto;
import Model.Tipo;
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
        String sql = "INSERT INTO tblproduto(prod_cod, prod_desc, prod_qtde, prod_min, tipo_cod, cat_cod) VALUES(?, ?, ?, ?, ?, ?)";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1,produto.getCodProduto());
            this.stmte.setString(2,produto.getDescProduto());
            this.stmte.setInt(3,produto.getQtdeProduto());
            this.stmte.setInt(4,produto.getMinProduto());
            this.stmte.setInt(5,produto.getCod_tipo().getCodTipo());
            this.stmte.setInt(6,produto.getCod_cat().getCodCategoria());
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
       String sql = "DELETE FROM tblproduto WHERE prod_cod = ?";
       
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
        String sql = "UPDATE tblproduto SET prod_desc = ?, prod_qtde = ?, prod_min = ?, tipo_cod = ?, cat_cod = ? WHERE prod_cod = ?";
        
        try
        {
            this.prepareStmte(sql);
            
            this.stmte.setString(1,produto.getDescProduto());
            this.stmte.setInt(2,produto.getQtdeProduto());
            this.stmte.setInt(3,produto.getMinProduto());
            this.stmte.setInt(4,produto.getCod_tipo().getCodTipo());
            this.stmte.setInt(5,produto.getCod_cat().getCodCategoria());
            this.stmte.setInt(6, produto.getCodProduto());
            this.stmte.execute();
            return true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao modificar produto!\n" + e);
            return false;
        }
    }
    
    public Produto getProduto(String descproduto)
    {
        
        Produto prod = new Produto();
        
        String sql = "SELECT * FROM tblproduto p "
                + "JOIN tblcategoria c ON p.cat_cod = c.cat_cod "
                + "JOIN tbltipo t ON p.tipo_cod = t.tipo_cod "
                + "WHERE prod_desc LIKE ?";
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1,descproduto+'%');
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            rs.first();
            prod.setCodProduto(rs.getInt("cod_produto"));

            stmte.close();
            this.closeAll();
            rs.close();
                  
            return prod;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    

    public ArrayList<Produto> getProdutosByCod()
    {
        ArrayList<Produto> produto = new ArrayList<Produto>();
        
        String sql = "SELECT * FROM tblproduto p "
                + "JOIN tblcategoria c ON p.cat_cod = c.cat_cod "
                + "JOIN tbltipo t ON p.tipo_cod = t.tipo_cod "
                + "ORDER BY prod_cod ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Produto p = new Produto();
                p.setCodProduto(rs.getInt("prod_cod"));
                p.setDescProduto(rs.getString("prod_desc"));
                p.setCodProduto(rs.getInt("prod_qtde"));
                p.setMinProduto(rs.getInt("prod_min"));
                //p.setCod_tipo(rs.getInt("tipo_cod"));
                Tipo t = new Tipo();
                t.setCodTipo(rs.getInt("tipo_cod"));
                t.setDescTipo(rs.getString("tipo_desc"));
                t.setSiglaTipo(rs.getString("tipo_sigla"));
                p.setCod_tipo(t);                                
                
                Categoria c = new Categoria();
                c.setCodCategoria(rs.getInt("cat_cod"));
                c.setTipoCategoria(rs.getString("cat_tipo"));
                p.setCod_cat(c);
                
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
        
        String sql = "SELECT * FROM tblproduto p "
                + "JOIN tblcategoria c ON p.cat_cod = c.cat_cod "
                + "JOIN tbltipo t ON p.tipo_cod = t.tipo_cod "
                + "ORDER BY prod_desc ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Produto p = new Produto();
                p.setCodProduto(rs.getInt("prod_cod"));
                p.setDescProduto(rs.getString("prod_desc"));
                p.setCodProduto(rs.getInt("prod_qtde"));
                p.setMinProduto(rs.getInt("prod_min"));
                //p.setCod_tipo(rs.getInt("tipo_cod"));
                Tipo t = new Tipo();
                t.setCodTipo(rs.getInt("tipo_cod"));
                t.setDescTipo(rs.getString("tipo_desc"));
                t.setSiglaTipo(rs.getString("tipo_sigla"));
                p.setCod_tipo(t);
                                                
                Categoria c = new Categoria();
                c.setCodCategoria(rs.getInt("cat_cod"));
                c.setTipoCategoria(rs.getString("cat_tipo"));
                p.setCod_cat(c);
                
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
        
        String sql = "SELECT * FROM tblproduto p "
                + "JOIN tblcategoria c ON p.cat_cod = c.cat_cod "
                + "JOIN tbltipo t ON p.tipo_cod = t.tipo_cod "
                + "ORDER BY t.tipo_desc ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Produto p = new Produto();
                p.setCodProduto(rs.getInt("prod_cod"));
                p.setDescProduto(rs.getString("prod_desc"));
                p.setCodProduto(rs.getInt("prod_qtde"));
                p.setMinProduto(rs.getInt("prod_min"));
                //p.setCod_tipo(rs.getInt("tipo_cod"));
                Tipo t = new Tipo();
                t.setCodTipo(rs.getInt("tipo_cod"));
                t.setDescTipo(rs.getString("tipo_desc"));
                t.setSiglaTipo(rs.getString("tipo_sigla"));
                p.setCod_tipo(t);
                                               
                Categoria c = new Categoria();
                c.setCodCategoria(rs.getInt("cat_cod"));
                c.setTipoCategoria(rs.getString("cat_tipo"));
                p.setCod_cat(c);
                
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
        
        String sql = "SELECT * FROM tblproduto p "
                + "JOIN tblcategoria c ON p.cat_cod = c.cat_cod "
                + "JOIN tbltipo t ON p.tipo_cod = t.tipo_cod "
                + "ORDER BY c.cat_tipo, p.prod_desc ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Produto p = new Produto();
                p.setCodProduto(rs.getInt("prod_cod"));
                p.setDescProduto(rs.getString("prod_desc"));
                p.setCodProduto(rs.getInt("prod_qtde"));
                p.setMinProduto(rs.getInt("prod_min"));
                //p.setCod_tipo(rs.getInt("tipo_cod"));
                Tipo t = new Tipo();
                t.setCodTipo(rs.getInt("tipo_cod"));
                t.setDescTipo(rs.getString("tipo_desc"));
                t.setSiglaTipo(rs.getString("tipo_sigla"));
                p.setCod_tipo(t);
                              
                Categoria c = new Categoria();
                c.setCodCategoria(rs.getInt("cat_cod"));
                c.setTipoCategoria(rs.getString("cat_tipo"));
                p.setCod_cat(c);
                
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
        String sql = "SELECT (MAX(prod_cod) + 1) as codigo FROM tblproduto";
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
