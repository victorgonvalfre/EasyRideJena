/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.DAO;
import Model.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jair
 */
public class DAOPessoa extends DAOGeneric implements DAO<Pessoa>  {
  
    public DAOPessoa() throws SQLException, ClassNotFoundException {
        this.criarTabela();
    }

    //CRIANDO A TABELA Jogador
    public void criarTabela() throws ClassNotFoundException, SQLException {
	try{
            this.openConnection();
			
		String sql = "CREATE TABLE IF NOT EXISTS Pessoa " +
					 " (ID INTEGER GENERATED BY DEFAULT AS IDENTITY "+
                                         " (START WITH 1, INCREMENT BY 1) NOT NULL," +
					 " name varchar(25)," +
					 " email varchar(25)," +
                                         " tell varchar(17)," +
                                         " adress varchar(25)," +
					 " PRIMARY KEY (ID) )";

			this.execute(sql);
			this.closeConnection();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}	
    }

    public void insert(Pessoa obj) throws SQLException, ClassNotFoundException {

		try{
			this.openConnection();

			String sql = "INSERT INTO Pessoa (name, email, tell, adress)"
					+ " VALUES ('" + obj.getNome() + "', '" + obj.getEmail()+ "', '"+obj.getTelefone()+ "', '"+ obj.getEndereco()+"')";

			int id = this.executeUpdate(sql);

			obj.setId(id);

			this.closeConnection();

		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
        
    }

    public void update(Pessoa obj) throws ClassNotFoundException, SQLException {

        this.openConnection();

        String sql = "UPDATE Pessoa"
                + " SET name = '" + obj.getNome()
                + "' , email = '" + obj.getEmail()
                + "' , tell = '" + obj.getTelefone()
                + "' , adress = '" + obj.getEndereco()
                + "' Where ID = " + obj.getId();

        // System.out.println(sql);
        int id = this.executeUpdate(sql);

        obj.setId(id);

        this.closeConnection();

    }

    public void delete(Pessoa obj) throws ClassNotFoundException, SQLException {

        this.openConnection();

        String sql = "DELETE FROM Pessoa " + "Where ID = " + obj.getId();

        int id = this.executeUpdate(sql);

        obj.setId(id);

        this.closeConnection();


    }

    public Pessoa findbyID(int id) throws ClassNotFoundException, SQLException {
        //Query para buscar o card
        this.openConnection();

        String sql = "SELECT * FROM Pessoa WHERE ID =" + id;

        ResultSet rs = this.executeQuery(sql);

        List<Pessoa> cards = retriveJogadors(rs);

        this.closeConnection();

        return cards.get(0);
    }

    public List<Pessoa> findAll() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
      this.openConnection();

        String sql = "SELECT * FROM Pessoa ";

        ResultSet rs = this.executeQuery(sql);

        List<Pessoa> cards = retriveJogadors(rs);

       this.closeConnection();

        return cards;
    }

    //fazer primeiro jogador Dao
    private List<Pessoa> retriveJogadors(ResultSet rs) throws SQLException {
        List<Pessoa> jogadoreslist = new ArrayList<Pessoa>();

        while (rs.next()) {
            Pessoa j = new Pessoa();

            j.setId(rs.getInt("ID"));

            j.setNome(rs.getString("name"));
            
            j.setEmail(rs.getString("email"));
      
            j.setTelefone(rs.getString("tell"));
            
            j.setEndereco(rs.getString("adress"));
            
            jogadoreslist.add(j);
        }

        return jogadoreslist;
    }

    public Pessoa create() {
        return new Pessoa();
    }

	public Pessoa findbyID(Long id) throws SQLException, ClassNotFoundException {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
