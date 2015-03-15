/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Motorista;
import Model.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class DAOMotorista extends DAOGeneric implements DAO<Motorista> {
    
        public DAOMotorista() throws SQLException, ClassNotFoundException {
        this.criarTabela();
    }

    //CRIANDO A TABELA Jogador
    public void criarTabela() throws ClassNotFoundException, SQLException {
	try{
            this.openConnection();
			
		String sql = "CREATE TABLE IF NOT EXISTS Motorista " +
					 " (ID INTEGER GENERATED BY DEFAULT AS IDENTITY "+
                                         " (START WITH 1, INCREMENT BY 1) NOT NULL," +
					 " pessoaId INTEGER," +
					 " cnh varchar(25)," +
                                         " veiculoId INTEGER," +
					 " PRIMARY KEY (ID) )";

			this.execute(sql);
			this.closeConnection();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}	
    }

    public void insert(Motorista obj) throws SQLException, ClassNotFoundException {

		try{
			this.openConnection();

			String sql = "INSERT INTO Motorista (pessoaId, cnh, veiculoId)"
					+ " VALUES (" + obj.getPessoaId() + ", '" + obj.getCnh()+ "', "+obj.getVeiculoId()+ " )";

			int id = this.executeUpdate(sql);

			obj.setId(id);

			this.closeConnection();

		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
        
    }

    public void update(Motorista obj) throws ClassNotFoundException, SQLException {

        this.openConnection();

        String sql = "UPDATE Motorista"
                + " SET pessoaId = " + obj.getPessoaId()
                + " , cnh = '" + obj.getCnh()
                + "' , veiculoId = " + obj.getVeiculoId()
                + " Where ID = " + obj.getId();

        // System.out.println(sql);
        int id = this.executeUpdate(sql);

        obj.setId(id);

        this.closeConnection();

    }

    public void delete(Motorista obj) throws ClassNotFoundException, SQLException {

        this.openConnection();

        String sql = "DELETE FROM Motorista " + "Where ID = " + obj.getId();

        int id = this.executeUpdate(sql);

        obj.setId(id);

        this.closeConnection();


    }

    public Motorista findbyID(int id) throws ClassNotFoundException, SQLException {
        //Query para buscar o card
        this.openConnection();

        String sql = "SELECT * FROM Motorista WHERE ID =" + id;

        ResultSet rs = this.executeQuery(sql);

        List<Motorista> cards = retriveJogadors(rs);

        this.closeConnection();

        return cards.get(0);
    }

    public List<Motorista> findAll() throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
      this.openConnection();

        String sql = "SELECT * FROM Motorista ";

        ResultSet rs = this.executeQuery(sql);

        List<Motorista> cards = retriveJogadors(rs);

       this.closeConnection();

        return cards;
    }

    //fazer primeiro jogador Dao
    private List<Motorista> retriveJogadors(ResultSet rs) throws SQLException, ClassNotFoundException {
        List<Motorista> jogadoreslist = new ArrayList<Motorista>();
        DAOPessoa daoPessoa = new DAOPessoa();
        DAOVeiculo daoVeicuolo = new DAOVeiculo();
        
        while (rs.next()) {
            Motorista j = new Motorista();

            j.setId(rs.getInt("ID"));

            j.setPessoa(daoPessoa.findbyID(Integer.parseInt(rs.getString("pessoaId"))));
            
            j.setCnh(rs.getString("cnh"));
      
            j.setVeiculo(daoVeicuolo.findbyID(Integer.parseInt(rs.getString("veiculoId"))));
            
            jogadoreslist.add(j);
        }

        return jogadoreslist;
    }

    public Motorista create() {
        return new Motorista();
    }

	public Motorista findbyID(Long id) throws SQLException, ClassNotFoundException {
		throw new UnsupportedOperationException("Not supported yet.");
	}
    
}
