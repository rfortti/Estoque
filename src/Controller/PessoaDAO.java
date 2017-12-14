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
        String sql = "INSERT INTO pessoa (pes_id, pes_tipo, pes_nome, pes_rg, pes_cpf, "
                + "pes_endereco, pes_bairro, pes_cidade, pes_fone, pes_email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1,pessoa.getP_id());
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
        String sql = "DELETE FROM pessoa WHERE pes_id = ?";
        
        try
        {
            this.prepareStmte(sql);
            this.stmte.setInt(1, pessoa.getP_id());
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
                + "pes_endereco = ?, pes_bairro = ?, pes_cidade = ?, pes_fone = ?, pes_email = ? WHERE pes_id = ?";
        
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
            this.stmte.setInt(10,pessoa.getP_id());
            this.stmte.execute();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
     
    public ArrayList<Pessoa> getFindByTipo(int parametro, String pesnome)
    {
        ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
        String msg = "Dados não encontrado !";
        
        String sql = "";
        if(parametro == 1){
            //BUSCA PELO TIPO "Fornecedor"
           sql = "SELECT * FROM pessoa WHERE pes_tipo = 'Fornecedor' AND pes_nome LIKE ? ORDER BY pes_nome ASC";
        }else if(parametro == 2){
            //BUSCA PELO TIPO "Funcionário"
           sql = "SELECT * FROM pessoa WHERE pes_tipo = 'Funcionário' AND pes_nome LIKE ? ORDER BY pes_nome ASC";
        }
        
        //String sql = "SELECT * FROM pessoa WHERE pes_nome LIKE ? AND pes_tipo = 'Fornecedor' ORDER BY pes_nome ASC";
        
        try
        {
            this.prepareStmte(sql);
            //this.stmte.setString(1,'%'+pnome+'%');// busca pelo nome ou sobrenome
            this.stmte.setString(1,pesnome+'%');// busca pela primeiro letra do nome
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            //rs.first();
            while (rs.next())
            {
                Pessoa pes = new Pessoa();
                    pes.setP_id(rs.getInt("pes_id"));
                    pes.setP_tipo(rs.getString("pes_tipo"));
                    pes.setP_nome(rs.getString("pes_nome"));
                    pes.setP_rg(rs.getString("pes_rg"));
                    pes.setP_cpf(rs.getString("pes_cpf"));
                    pes.setP_endereco(rs.getString("pes_endereco"));
                    pes.setP_bairro(rs.getString("pes_bairro"));
                    pes.setP_cidade(rs.getString("pes_cidade"));
                    pes.setP_fone(rs.getString("pes_fone"));
                    pes.setP_email(rs.getString("pes_email"));
                pessoa.add(pes);   
            }
            return pessoa;
        }
        catch(Exception e)
        {
            return null;
        }
    }
      
     public ArrayList<Pessoa> getPessoaByCod() //L I S T A
     {
        ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
        
        String sql = "SELECT * FROM pessoa ORDER BY pes_id ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
            while(rs.next())
            {
                Pessoa p = new Pessoa();
                p.setP_id(rs.getInt("pes_id"));
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
                p.setP_id(rs.getInt("pes_id"));
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
     
     public ArrayList<Pessoa> getFuncionario() //L I S T A
     {
        ArrayList<Pessoa> funcionario = new ArrayList<Pessoa>();
        
        String sql = "SELECT * FROM pessoa WHERE pes_tipo = 'Funcionário' ORDER BY pes_nome ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            
           while(rs.next())
            {
                Pessoa fcn = new Pessoa();
                fcn.setP_id(rs.getInt("pes_id"));
                fcn.setP_tipo(rs.getString("pes_tipo"));
                fcn.setP_nome(rs.getString("pes_nome"));
                fcn.setP_rg(rs.getString("pes_rg"));
                fcn.setP_cpf(rs.getString("pes_cpf"));
                fcn.setP_endereco(rs.getString("pes_endereco"));
                fcn.setP_bairro(rs.getString("pes_bairro"));
                fcn.setP_cidade(rs.getString("pes_cidade"));
                fcn.setP_fone(rs.getString("pes_fone"));
                fcn.setP_email(rs.getString("pes_email"));
                
                funcionario.add(fcn);
            }
            return funcionario;
            
        }
        catch(Exception e)
        {
            return null;
        }
    }
     
     public ArrayList<Pessoa> getFornecedor() //L I S T A
     {
        ArrayList<Pessoa> fornecedor = new ArrayList<Pessoa>();
        
        String sql = "SELECT * FROM pessoa WHERE pes_tipo = 'Fornecedor' ORDER BY pes_nome ASC";
        
        try
        {
            this.prepareStmte(sql);
            ResultSet rs = this.stmte.executeQuery(); //sempre usar quando fazer uma consulta(SELECT)
            //rs.first();
            while (rs.next())
            {
                Pessoa pes = new Pessoa();
                pes.setP_id(rs.getInt("pes_id"));
                pes.setP_tipo(rs.getString("pes_tipo"));
                pes.setP_nome(rs.getString("pes_nome"));
                pes.setP_rg(rs.getString("pes_rg"));
                pes.setP_cpf(rs.getString("pes_cpf"));
                pes.setP_endereco(rs.getString("pes_endereco"));
                pes.setP_bairro(rs.getString("pes_bairro"));
                pes.setP_cidade(rs.getString("pes_cidade"));
                pes.setP_fone(rs.getString("pes_fone"));
                pes.setP_email(rs.getString("pes_email"));
                fornecedor.add(pes);
            }
            return fornecedor;
        }
        catch(Exception e)
        {
            return null;
        }
    }
     
     public int AutoIncCod(){
        String sql = "SELECT (MAX(pes_id) + 1) as codigo FROM pessoa";
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
