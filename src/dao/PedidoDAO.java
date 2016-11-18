/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import estoque.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Multas
 */
public class PedidoDAO extends GenericDAO 
{
    public PedidoDAO()
    {
        super(); //chama o contrutor da classe mãe extendida(GenericDAO)
    }
    
    public boolean inserir(Pedido pedido)
    {
        //ped_item = auto-incremento no banco 
        String sql = "INSERT INTO pedido (ped_produto, ped_qtde, ped_vtotal, ped_pgto, ped_cliente, ped_data, ped_situacao, ped_func)"
                +" VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1,pedido.getPedProduto());
            this.stmte.setInt(2,pedido.getPedQtde());
            this.stmte.setDouble(3,pedido.getPedVtotal());
            this.stmte.setString(4,pedido.getPedPgto());
            this.stmte.setString(5,pedido.getPedCliente());
            this.stmte.setString(6,pedido.getPedData());
            this.stmte.setString(7,pedido.getPedSituacao());
            this.stmte.setString(8,pedido.getPedFunc());
            this.stmte.execute();
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean editar(Pedido pedido)
    {
        String sql = "UPDATE pedido SET ped_produto = ?, ped_qtde = ?, ped_vtotal = ?, ped_pgto = ?, ped_cliente = ?,"
                +" ped_data = ?, ped_situacao = ?, ped_func = ? WHERE ped_item = ?";
        
        try
        {
             this.prepareStmte(sql);
            this.stmte.setString(1,pedido.getPedProduto());
            this.stmte.setInt(2,pedido.getPedQtde());
            this.stmte.setDouble(3,pedido.getPedVtotal());
            this.stmte.setString(4,pedido.getPedPgto());
            this.stmte.setString(5,pedido.getPedCliente());
            this.stmte.setString(6,pedido.getPedData());
            this.stmte.setString(7,pedido.getPedSituacao());
            this.stmte.setString(8,pedido.getPedFunc());
            this.stmte.setInt(9, pedido.getPedItem());
            this.stmte.execute();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public ArrayList<Pedido> getPedidoByItemA() //L I S T A
     {
        ArrayList<Pedido> pedido = new ArrayList<Pedido>();
        
        String sql = "SELECT * FROM pedido ORDER BY ped_item ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next())
            {
                Pedido ped = new Pedido();
                ped.setPedItem(rs.getInt("ped_item"));
                ped.setPedProduto(rs.getString("ped_produto"));
                ped.setPedQtde(rs.getInt("ped_qtde"));
                ped.setPedVtotal(rs.getFloat("ped_vtotal"));
                ped.setPedPgto(rs.getString("ped_pgto"));
                ped.setPedCliente(rs.getString("ped_cliente"));
                ped.setPedData(rs.getString("ped_data"));
                ped.setPedSituacao(rs.getString("ped_situacao"));
                ped.setPedFunc(rs.getString("ped_func"));
                
                pedido.add(ped);
            }
            return pedido;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
        
    public ArrayList<Pedido> getPedidoByItemD() //L I S T A
     {
        ArrayList<Pedido> pedido = new ArrayList<Pedido>();
        
        String sql = "SELECT * FROM pedido ORDER BY ped_item DESC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next())
            {
                Pedido ped = new Pedido();
                ped.setPedItem(rs.getInt("ped_item"));
                ped.setPedProduto(rs.getString("ped_produto"));
                ped.setPedQtde(rs.getInt("ped_qtde"));
                ped.setPedVtotal(rs.getFloat("ped_vtotal"));
                ped.setPedPgto(rs.getString("ped_pgto"));
                ped.setPedCliente(rs.getString("ped_cliente"));
                ped.setPedData(rs.getString("ped_data"));
                ped.setPedSituacao(rs.getString("ped_situacao"));
                ped.setPedFunc(rs.getString("ped_func"));
                
                pedido.add(ped);
            }
            return pedido;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Pedido> getPedidoByProduto() //L I S T A
     {
        ArrayList<Pedido> pedido = new ArrayList<Pedido>();
        
        String sql = "SELECT * FROM pedido ORDER BY ped_produto ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next())
            {
                Pedido ped = new Pedido();
                ped.setPedItem(rs.getInt("ped_item"));
                ped.setPedProduto(rs.getString("ped_produto"));
                ped.setPedQtde(rs.getInt("ped_qtde"));
                ped.setPedVtotal(rs.getFloat("ped_vtotal"));
                ped.setPedPgto(rs.getString("ped_pgto"));
                ped.setPedCliente(rs.getString("ped_cliente"));
                ped.setPedData(rs.getString("ped_data"));
                ped.setPedSituacao(rs.getString("ped_situacao"));
                ped.setPedFunc(rs.getString("ped_func"));
                
                pedido.add(ped);
            }
            return pedido;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Pedido> getPedidoByPgto() //L I S T A
     {
        ArrayList<Pedido> pedido = new ArrayList<Pedido>();
        
        String sql = "SELECT * FROM pedido ORDER BY ped_pgto ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next())
            {
                Pedido ped = new Pedido();
                ped.setPedItem(rs.getInt("ped_item"));
                ped.setPedProduto(rs.getString("ped_produto"));
                ped.setPedQtde(rs.getInt("ped_qtde"));
                ped.setPedVtotal(rs.getFloat("ped_vtotal"));
                ped.setPedPgto(rs.getString("ped_pgto"));
                ped.setPedCliente(rs.getString("ped_cliente"));
                ped.setPedData(rs.getString("ped_data"));
                ped.setPedSituacao(rs.getString("ped_situacao"));
                ped.setPedFunc(rs.getString("ped_func"));
                
                pedido.add(ped);
            }
            return pedido;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Pedido> getPedidoByData() //L I S T A
     {
        ArrayList<Pedido> pedido = new ArrayList<Pedido>();
        
        String sql = "SELECT * FROM pedido ORDER BY ped_data ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next())
            {
                Pedido ped = new Pedido();
                ped.setPedItem(rs.getInt("ped_item"));
                ped.setPedProduto(rs.getString("ped_produto"));
                ped.setPedQtde(rs.getInt("ped_qtde"));
                ped.setPedVtotal(rs.getFloat("ped_vtotal"));
                ped.setPedPgto(rs.getString("ped_pgto"));
                ped.setPedCliente(rs.getString("ped_cliente"));
                ped.setPedData(rs.getString("ped_data"));
                ped.setPedSituacao(rs.getString("ped_situacao"));
                ped.setPedFunc(rs.getString("ped_func"));
                
                pedido.add(ped);
            }
            return pedido;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Pedido> getPedidoByFunc() //L I S T A
     {
        ArrayList<Pedido> pedido = new ArrayList<Pedido>();
        
        String sql = "SELECT * FROM pedido ORDER BY ped_func ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next())
            {
                Pedido ped = new Pedido();
                ped.setPedItem(rs.getInt("ped_item"));
                ped.setPedProduto(rs.getString("ped_produto"));
                ped.setPedQtde(rs.getInt("ped_qtde"));
                ped.setPedVtotal(rs.getFloat("ped_vtotal"));
                ped.setPedPgto(rs.getString("ped_pgto"));
                ped.setPedCliente(rs.getString("ped_cliente"));
                ped.setPedData(rs.getString("ped_data"));
                ped.setPedSituacao(rs.getString("ped_situacao"));
                ped.setPedFunc(rs.getString("ped_func"));
                
                pedido.add(ped);
            }
            return pedido;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Pedido> getPedidoByCliente(String nome) //L I S T A
    {
        ArrayList<Pedido> pedido = new ArrayList<Pedido>();
        
        //String sql = "SELECT * FROM cantina.pedido where ped_cliente LIKE ?";
        String sql = "SELECT * FROM pedido WHERE coalesce(ped_cliente,'') LIKE ?";
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1,nome+'%');
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            //if (rs.first())
            //    JOptionPane.showMessageDialog(null, "X");
            while (rs.next())
            {
                Pedido ped = new Pedido();
                ped.setPedItem(rs.getInt("ped_item"));
                ped.setPedProduto(rs.getString("ped_produto"));
                ped.setPedQtde(rs.getInt("ped_qtde"));
                ped.setPedVtotal(rs.getFloat("ped_vtotal"));
                ped.setPedPgto(rs.getString("ped_pgto"));
                ped.setPedCliente(rs.getString("ped_cliente"));
                ped.setPedData(rs.getString("ped_data"));
                ped.setPedSituacao(rs.getString("ped_situacao"));
                ped.setPedFunc(rs.getString("ped_func"));
                
                pedido.add(ped);
            }
            return pedido;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Pedido> getPedidoAberto() //L I S T A
    {
        ArrayList<Pedido> pedido = new ArrayList<Pedido>();
        
        String sql = "SELECT * FROM pedido WHERE ped_situacao = 'Em Aberto' ORDER BY ped_cliente ASC, ped_data ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next())
            {
                Pedido ped = new Pedido();
                ped.setPedItem(rs.getInt("ped_item"));
                ped.setPedProduto(rs.getString("ped_produto"));
                ped.setPedQtde(rs.getInt("ped_qtde"));
                ped.setPedVtotal(rs.getFloat("ped_vtotal"));
                ped.setPedPgto(rs.getString("ped_pgto"));
                ped.setPedCliente(rs.getString("ped_cliente"));
                ped.setPedData(rs.getString("ped_data"));
                ped.setPedSituacao(rs.getString("ped_situacao"));
                ped.setPedFunc(rs.getString("ped_func"));
                
                pedido.add(ped);
            }
            return pedido;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public ArrayList<Pedido> getPedidoPago() //L I S T A
    {
        ArrayList<Pedido> pedido = new ArrayList<Pedido>();
        
        String sql = "SELECT * FROM pedido WHERE ped_situacao = 'P A G O' ORDER BY ped_cliente, ped_data ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next())
            {
                Pedido ped = new Pedido();
                ped.setPedItem(rs.getInt("ped_item"));
                ped.setPedProduto(rs.getString("ped_produto"));
                ped.setPedQtde(rs.getInt("ped_qtde"));
                ped.setPedVtotal(rs.getFloat("ped_vtotal"));
                ped.setPedPgto(rs.getString("ped_pgto"));
                ped.setPedCliente(rs.getString("ped_cliente"));
                ped.setPedData(rs.getString("ped_data"));
                ped.setPedSituacao(rs.getString("ped_situacao"));
                ped.setPedFunc(rs.getString("ped_func"));
                
                pedido.add(ped);
            }
            return pedido;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
