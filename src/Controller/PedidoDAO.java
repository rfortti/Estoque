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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public int AutoIncCod(){
        String sql = "SELECT (MAX(ped_cod) + 1) as codigo FROM tblpedido";
        this.prepareStmte(sql);
        ResultSet rs;
        int retorno = 0;
        try 
        {
            rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            rs.first();
            retorno = rs.getInt("codigo");
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
    
    
    public boolean inserirPedido(Pedido pedido)
    {
        String sql = "INSERT INTO tblpedido (ped_data, ped_tipo, pes_id, ped_destino)"
                +" VALUES (?, ?, ?, ?)";
        
        try
        {
            this.prepareStmte(sql);
            //this.stmte.setInt(1,pedido.getPed_cod());
            this.stmte.setString(1,pedido.getPed_data());
            this.stmte.setString(2,pedido.getPed_tipo());
            this.stmte.setInt(3,pedido.getP_id());
            this.stmte.setString(4,pedido.getPed_destino());
            this.stmte.execute();
           
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
        String sql2 = "INSERT INTO tblitem (item_qtde, item_valor)"
                +" VALUES (?, ?)";
        
        try
        {
            this.prepareStmte(sql2);
            //this.stmte.setInt(1,pedido.getItem_cod());
            this.stmte.setInt(1,pedido.getItem_qtde());
            this.stmte.setFloat(2,pedido.getItem_valor());
            //this.stmte.setInt(3,pedido.getPed_cod());
            //this.stmte.setInt(4,pedido.getProd_cod());
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
            this.stmte.setInt(4,pedido.getP_id());
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
                ped.setP_id(rs.getInt("pes_id"));
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
