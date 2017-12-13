/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Model.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Strong
 */
public class PessoaDAO extends GenericDAO 
{
    public PessoaDAO()
    {
        super(); //chama o contrutor da classe mãe extendida(GenericDAO)
    }
    
    public boolean inserir(Pessoa pessoa)
    {
        String sql = "INSERT INTO pessoa (pes_cod, pes_tipo, pes_nome, pes_rg, pes_cpf, "
                + "pes_endereco, pes_bairro, pes_cidade, pes_fone, pes_email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1,pessoa.getP_cod());
            this.stmte.setString(2,pessoa.getP_tipo());
            this.stmte.setString(3,pessoa.getP_nome());
            this.stmte.setString(4,pessoa.getP_rg());
            this.stmte.setString(5,pessoa.getP_cpf());
            this.stmte.setString(6,pessoa.getP_endereco());
            this.stmte.setString(7,pessoa.getP_bairro());
            this.stmte.setString(8,pessoa.getP_cidade());
            this.stmte.setString(9,pessoa.getP_fone());
            this.stmte.setString(10,pessoa.getP_email());
            this.stmte.execute();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    public boolean excluir(Pessoa pessoa)
    {
        String sql = "DELETE FROM pessoa WHERE pes_cod = ?";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1, pessoa.getP_cod());
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
    
    public boolean editar(Pessoa pessoa)
    {
        String sql = "UPDATE pessoa SET pes_tipo = ?, pes_nome = ?, pes_rg = ?, pes_cpf = ?, "
                + "pes_endereco = ?, pes_bairro = ?, pes_cidade = ?, pes_fone = ?, pes_email = ? WHERE pes_cod = ?";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setString(1,pessoa.getP_tipo());
            this.stmte.setString(2,pessoa.getP_nome());
            this.stmte.setString(3,pessoa.getP_rg());
            this.stmte.setString(4,pessoa.getP_cpf());
            this.stmte.setString(5,pessoa.getP_endereco());
            this.stmte.setString(6,pessoa.getP_bairro());
            this.stmte.setString(7,pessoa.getP_cidade());
            this.stmte.setString(8,pessoa.getP_fone());
            this.stmte.setString(9,pessoa.getP_email());
            this.stmte.setInt(10,pessoa.getP_cod());
            this.stmte.execute();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
     
    public Pessoa getPesquisaByNome(String pesnome)
    {
        Pessoa p = new Pessoa();
        
        String sql = "SELECT * FROM pessoa WHERE pes_nome LIKE ?";
        
        try
        {
            this.prepareStmte(sql);
            //this.stmte.setString(1,'%'+pnome+'%');// busca pelo nome ou sobrenome
            this.stmte.setString(1,pesnome+'%');// busca pelo primeiro nome
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            rs.first();
            p.setP_cod(rs.getInt("pes_cod"));
            p.setP_tipo(rs.getString("pes_tipo"));
            p.setP_nome(rs.getString("pes_nome"));
            p.setP_rg(rs.getString("pes_rg"));
            p.setP_cpf(rs.getString("pes_cpf"));
            p.setP_endereco(rs.getString("pes_endereco"));
            p.setP_bairro(rs.getString("pes_bairro"));
            p.setP_cidade(rs.getString("pes_cidade"));
            p.setP_fone(rs.getString("pes_fone"));
            p.setP_email(rs.getString("pes_email"));
            return p;
        }
        catch(Exception e)
        {
            return null;
        }
    }
      
     public ArrayList<Pessoa> getPessoaByCod() //L I S T A
     {
        ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
        
        String sql = "SELECT * FROM pessoa ORDER BY pes_cod ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next())
            {
                Pessoa p = new Pessoa();
                p.setP_cod(rs.getInt("pes_cod"));
                p.setP_tipo(rs.getString("pes_tipo"));
                p.setP_nome(rs.getString("pes_nome"));
                p.setP_rg(rs.getString("pes_rg"));
                p.setP_cpf(rs.getString("pes_cpf"));
                p.setP_endereco(rs.getString("pes_endereco"));
                p.setP_bairro(rs.getString("pes_bairro"));
                p.setP_cidade(rs.getString("pes_cidade"));
                p.setP_fone(rs.getString("pes_fone"));
                p.setP_email(rs.getString("pes_email"));
                
                pessoa.add(p);
            }
            return pessoa;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
     
     public ArrayList<Pessoa> getPessoaByNome() //L I S T A
     {
        ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
        
        String sql = "SELECT * FROM pessoa ORDER BY pes_nome ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
           while(rs.next())
            {
                Pessoa p = new Pessoa();
                p.setP_cod(rs.getInt("pes_cod"));
                p.setP_tipo(rs.getString("pes_tipo"));
                p.setP_nome(rs.getString("pes_nome"));
                p.setP_rg(rs.getString("pes_rg"));
                p.setP_cpf(rs.getString("pes_cpf"));
                p.setP_endereco(rs.getString("pes_endereco"));
                p.setP_bairro(rs.getString("pes_bairro"));
                p.setP_cidade(rs.getString("pes_cidade"));
                p.setP_fone(rs.getString("pes_fone"));
                p.setP_email(rs.getString("pes_email"));
                
                pessoa.add(p);
            }
            return pessoa;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
     
     public Pessoa[] getFunc() //V E T O R
     {
        Pessoa[] pessoa = new Pessoa[100];
        int x = 0;
        String sql = "SELECT * FROM pessoa WHERE pes_tipo = 'Funcionário' ORDER BY pes_nome ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Pessoa pes = new Pessoa();
                
                pes.setP_nome(rs.getString("pes_nome"));
                
                pessoa[x] = pes;
                x++;
            }
            return pessoa;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
     
     public ArrayList<Pessoa> getCliente() //L I S T A
     {
        ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
        
        String sql = "SELECT * FROM pessoa WHERE pes_tipo = 'Cliente' ORDER BY pes_nome ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next()){
                Pessoa pes = new Pessoa();
                
                pes.setP_nome(rs.getString("pes_nome"));
                
                pessoa.add(pes);
            }
            return pessoa;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
     
     public int AutoIncCod(){
        String sql = "SELECT (MAX(pes_cod) + 1) as codigo FROM pessoa";
        this.prepareStmte(sql);
        ResultSet rs;
        int retorno = 0;
        try {
            rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            rs.first();
            retorno = rs.getInt("codigo");
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;

    }

}
