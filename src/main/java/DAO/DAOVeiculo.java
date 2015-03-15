/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Pessoa;
import Model.Veiculo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jair
 */
public class DAOVeiculo extends DAOGeneric implements DAO<Veiculo>{
    
     public DAOVeiculo() throws SQLException, ClassNotFoundException {
        this.criarTabela();
    }

    //CRIANDO A TABELA Jogador
    public void criarTabela() throws ClassNotFoundException, SQLException {
	try{
            this.openConnection();
			
		String sql = "CREATE TABLE IF NOT EXISTS Veiculo " +
					 " (ID INTEGER GENERATED BY DEFAULT AS IDENTITY "+
                                         " (START WITH 1, INCREMENT BY 1) NOT NULL," +
					 " placa varchar(8)," +
					 " modelo varchar(25)," +
                                         " vagas INTEGER," +
					 " PRIMARY KEY (ID) )";

			this.execute(sql);
			this.closeConnection();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}	
    }

    public void insert(Veiculo obj) throws SQLException, ClassNotFoundException {

		try{
			this.openConnection();

			String sql = "INSERT INTO Veiculo (placa, modelo, vagas)"
					+ " VALUES ('" + obj.getPlaca() + "', '" + obj.getModelo()+ "', "+obj.getVagas()+")";

			int id = this.executeUpdate(sql);

			obj.setId(id);

			this.closeConnection();

		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
        
    }

    public void update(Veiculo obj) throws ClassNotFoundException, SQLException {

        this.openConnection();

        String sql = "UPDATE Veiculo"
                + " SET placa = '" + obj.getPlaca()
                + "' , modelo = '" + obj.getModelo()
                + "' , vagas = " + obj.getVagas()
                + " Where ID = " + obj.getId();

        // System.out.println(sql);
        int id = this.executeUpdate(sql);

        obj.setId(id);

        this.closeConnection();

    }

    public void delete(Veiculo obj) throws ClassNotFoundException, SQLException {

        this.openConnection();

        String sql = "DELETE FROM Veiculo " + "Where ID = " + obj.getId();

        int id = this.executeUpdate(sql);

        obj.setId(id);

        this.closeConnection();


    }

    public Veiculo findbyID(int id) throws ClassNotFoundException, SQLException {
        //Query para buscar o card
        this.openConnection();

        String sql = "SELECT * FROM Veiculo WHERE ID =" + id;

        ResultSet rs = this.executeQuery(sql);

        List<Veiculo> cards = retriveJogadors(rs);

        this.closeConnection();

        return cards.get(0);
    }

    public List<Veiculo> findAll() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
      this.openConnection();

        String sql = "SELECT * FROM Veiculo ";

        ResultSet rs = this.executeQuery(sql);

        List<Veiculo> cards = retriveJogadors(rs);

       this.closeConnection();

        return cards;
    }

    //fazer primeiro jogador Dao
    private List<Veiculo> retriveJogadors(ResultSet rs) throws SQLException {
        List<Veiculo> jogadoreslist = new ArrayList<Veiculo>();

        while (rs.next()) {
            Veiculo j = new Veiculo();

            j.setId(rs.getInt("ID"));

            j.setPlaca(rs.getString("placa"));
            
            j.setModelo(rs.getString("modelo"));
      
            j.setVagas(Integer.parseInt(rs.getString("vagas")));
            
            jogadoreslist.add(j);
        }

        return jogadoreslist;
    }

    public Veiculo create() {
        return new Veiculo();
    }

	public Veiculo findbyID(Long id) throws SQLException, ClassNotFoundException {
		throw new UnsupportedOperationException("Not supported yet.");
	}
    
}