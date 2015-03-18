/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import DAO.DAOLugar;
import DAO.DAOMotorista;
import DAO.DAOPessoa;
import DAO.DAOVeiculo;
import Model.Carona;
import Model.Lugar;
import Model.Motorista;
import Model.Pessoa;
import Model.Veiculo;
import Utils.EnumLocais;
import Utils.GeradorDeCarros;
import Utils.GeradorDeMotorista;
import Utils.GeradorDePessoas;
import Utils.GeradorLugar;
import Utils.GeradorRDF;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Victor
 */
public class EasyRideApp {
    Scanner scanner = new Scanner(System.in);
     
    public void start() throws IOException, SQLException, ClassNotFoundException{
        GeradorDePessoas gerador = new GeradorDePessoas();
        GeradorDeCarros geradorCarro = new GeradorDeCarros();
        List<Pessoa> lstUsers = new ArrayList<Pessoa>();
        List<Veiculo> lstCarros = new ArrayList<Veiculo>();
        List<Carona> lstCaronaToRDF = new ArrayList<Carona>();
        
        CaronaMaker caronaMaker = new CaronaMaker();
        Carona carona = caronaMaker.montarCarona();
        lstCaronaToRDF.add(carona);
        
   
        //PESSOA
        DAOPessoa dao = new DAOPessoa();
        List<Pessoa> lstbanco = dao.findAll();
        
        //CARRO
        DAOVeiculo daoCar = new DAOVeiculo(); 
        List<Veiculo> lstbancoCar = daoCar.findAll();
        
        //Motorista
        DAOMotorista daoMotor = new DAOMotorista();
        Motorista motorBanco = daoMotor.findAll().get(0);
        
        
         //Lugar
//        DAOLugar daolugar = new DAOLugar();
//        List<Lugar> lstbancolugar = daolugar.findAll();
        
        
        
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
        
        
//           System.out.println("----> Destinos no banco --->");
//        for(Lugar banco : lstbancolugar){
//            System.out.println(banco.toString());
//        }
        
//        for(Pessoa users: lstUsers){
//            System.out.println(users.toString());
//        }
        
        GeradorRDF rdfGerador = new GeradorRDF();
        rdfGerador.gerarRdf(lstCaronaToRDF);
    }
    
}
