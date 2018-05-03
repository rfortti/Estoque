/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Pedido;
import Model.Pessoa;
import java.sql.ResultSet;
import java.sql.Statement;
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
    
    public boolean inserirPedido(Pedido pedido)
    {
        String sql = "INSERT INTO tblpedido (ped_cod, ped_data, ped_tipo, pes_id, ped_destino)"
                +" VALUES (?, ?, ?, ?, ?)";
        /*
        String sql2 = "INSERT INTO tblitem (item_cod, item_qtde, item_valor, ped_cod, prod_cod)"
                +" VALUES (?, ?, ?, ?, ?)";
        */
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1,pedido.getPed_cod());
            this.stmte.setString(2,pedido.getPed_data());
            this.stmte.setString(3,pedido.getPed_tipo());
            this.stmte.setInt(4,pedido.getPes_id());
            this.stmte.setString(5,pedido.getPed_destino());
            //this.stmte.execute();
            /*
            this.prepareStmte(sql2);
            this.stmte.setInt(1,pedido.getItem_cod());
            this.stmte.setInt(2,pedido.getItem_qtde());
            this.stmte.setFloat(3,pedido.getItem_valor());
            this.stmte.setInt(4,pedido.getPed_cod());
            this.stmte.setInt(5,pedido.getProd_cod());
            this.stmte.execute();
            */
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean inserirItem(Pedido pedido)
    {
        String sql2 = "INSERT INTO tblitem (item_cod, item_qtde, item_valor, ped_cod, prod_cod)"
                +" VALUES (?, ?, ?, ?, ?)";
        
        try
        {
            this.prepareStmte(sql2);
            this.stmte.setInt(1,pedido.getItem_cod());
            this.stmte.setInt(2,pedido.getItem_qtde());
            this.stmte.setFloat(3,pedido.getItem_valor());
            this.stmte.setInt(4,pedido.getPed_cod());
            this.stmte.setInt(5,pedido.getProd_cod());
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
        String sql = "UPDATE tblpedido SET ped_cod = ?, ped_data = ?, ped_tipo = ?, pes_id = ?, ped_destino = ? "
                +" WHERE ped_cod = ?";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1,pedido.getPed_cod());
            this.stmte.setString(2,pedido.getPed_data());
            this.stmte.setString(3,pedido.getPed_tipo());
            this.stmte.setInt(4,pedido.getPes_id());
            this.stmte.setString(5,pedido.getPed_destino());
            this.stmte.execute();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    //**************************************************************************
    public ArrayList<Pedido> getPedidoByTipo() //L I S T A
     {
        ArrayList<Pedido> pedido = new ArrayList<Pedido>();
        
        String sql = "SELECT * FROM tblpedido ORDER BY ped_tipo ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next())
            {
                Pedido ped = new Pedido();
                ped.setPed_cod(rs.getInt("ped_cod"));
                ped.setPed_data(rs.getString("ped_data"));
                ped.setPed_tipo(rs.getString("ped_tipo"));
                ped.setPes_id(rs.getInt("pes_id"));
                ped.setPed_destino(rs.getString("ped_destino"));
                                
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
