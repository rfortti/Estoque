/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Pedido;
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
        String sql = "INSERT INTO tblpedido (ped_cod, ped_data, ped_tipo, pes_id, ped_destino)"
                +" VALUES (?, ?, ?, ?, ?)";
        
        String sql2 = "INSERT INTO tblitem (item_cod, item_qtde, item_valor, ped_cod, prod_cod)"
                +" VALUES (?, ?, ?, ?, ?)";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1,pedido.getPed_cod());
            this.stmte.setString(2,pedido.getPed_data());
            this.stmte.setString(3,pedido.getPed_tipo());
            this.stmte.setInt(4,pedido.getPes_id());
            this.stmte.setString(5,pedido.getPed_destino());
            this.stmte.execute();
            
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
        String sql = "UPDATE pedido SET ped_cod = ?, ped_data = ?, ped_tipo = ?, pes_id = ?, ped_destino = ? "
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
}
