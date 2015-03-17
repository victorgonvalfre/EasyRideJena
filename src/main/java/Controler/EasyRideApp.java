/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import DAO.DAOMotorista;
import DAO.DAOPessoa;
import DAO.DAOVeiculo;
import Model.Lugar;
import Model.Motorista;
import Model.Pessoa;
import Model.Veiculo;
import Utils.GeradorDeCarros;
import Utils.GeradorDeMotorista;
import Utils.GeradorDePessoas;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jair
 */
public class EasyRideApp {
    Scanner scanner = new Scanner(System.in);
     
    public void start() throws IOException, SQLException, ClassNotFoundException{
        GeradorDePessoas gerador = new GeradorDePessoas();
        GeradorDeCarros geradorCarro = new GeradorDeCarros();
        List<Pessoa> lstUsers = new ArrayList<Pessoa>();
        List<Veiculo> lstCarros = new ArrayList<Veiculo>();
        
        
        System.out.println("----->  PRIMEIRO PASSO: CRIAR AS PESSOAS");
        System.out.println("Quantos Pessoas Deseja criar?");
        int quantUsuarios = Integer.parseInt(scanner.nextLine());
        
        lstUsers = gerador.gerarUsuarios(quantUsuarios);
        
        
        DAOPessoa dao = new DAOPessoa();
        for(Pessoa pessoa: lstUsers){
            dao.insert(pessoa);
        }
        
        List<Pessoa> lstbanco = dao.findAll();
        
        System.out.println("----->  SEGUNDO PASSO: CRIAR OS VEICULOS");
        System.out.println("Quantos Veiculos Deseja criar?");
        
        int quantVeiculos = Integer.parseInt(scanner.nextLine());
        
        lstCarros = geradorCarro.gerarCarros(quantVeiculos);
        
        DAOVeiculo daoCar = new DAOVeiculo();
        for(Veiculo carro: lstCarros){
            daoCar.insert(carro);
        }
        
        List<Veiculo> lstbancoCar = daoCar.findAll();
        
        System.out.println("----->  Terceiro PASSO: CRIAR O MOTORISTAS DA CARONA");
        GeradorDeMotorista geradorMotor = new GeradorDeMotorista();
        DAOMotorista daoMotor = new DAOMotorista();
        Motorista motorista = geradorMotor.gerarMotorista(lstbanco, lstCarros);
        
        daoMotor.insert(motorista);
        Motorista motorBanco = daoMotor.findAll().get(0);
        
        
        System.out.println("----->  Quarto PASSO: CRIAR E BAIXAR OS DADOS DO DBPEDIA DOS DESTINOS");
        System.out.println("Quantos destinos deseja criar? (de 1 a 5)");
        int quantDestinos = Integer.parseInt(scanner.nextLine());
        
        List<Lugar> lstDestinos = new ArrayList<Lugar>();
        for(int x = 0; x < quantDestinos; x++){
            
        }
        
        
        System.out.println("----> Pessoas no banco --->");
        for(Pessoa banco : lstbanco){
            System.out.println(banco.toString());
        }
        
        
        System.out.println("----> Carros no banco --->");
        for(Veiculo banco : lstbancoCar){
            System.out.println(banco.toString());
        }    
        
        System.out.println("----> Motoristas no banco --->");
        System.out.println(motorBanco.toString());
        
//        for(Pessoa users: lstUsers){
//            System.out.println(users.toString());
//        }
//        GeradorRdf rdfGerador = new GeradorRdf();
//        rdfGerador.gerarRdf(lstUsers);
    }
    
}
