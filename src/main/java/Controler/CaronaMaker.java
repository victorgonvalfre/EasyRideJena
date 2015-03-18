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
import Utils.EnumEstado;
import Utils.EnumLocais;
import Utils.GeradorDeCarros;
import Utils.GeradorDeMotorista;
import Utils.GeradorDePessoas;
import Utils.GeradorLugar;
import Utils.PesquisadorDBpedia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Victor
 */
public class CaronaMaker {
    Carona carona;
    
    public Carona montarCarona() throws SQLException, ClassNotFoundException{
        PesquisadorDBpedia pesquisador = new PesquisadorDBpedia();
        GeradorDePessoas gerador = new GeradorDePessoas();
        GeradorDeCarros geradorCarro = new GeradorDeCarros();
        List<Pessoa> lstUsers = new ArrayList<Pessoa>();
        Veiculo carro = new Veiculo();
        carona = new Carona();
        
        System.out.println("----->  PRIMEIRO PASSO: CRIAR AS PESSOAS");
        lstUsers = gerador.gerarUsuarios(2);
        
        //Inserindo no banco de dados.
        DAOPessoa dao = new DAOPessoa();
        for(Pessoa pessoa: lstUsers){
            dao.insert(pessoa);
        }
        
        System.out.println("----->  SEGUNDO PASSO: CRIAR OS VEICULO");
        carro = geradorCarro.gerarCarros(1).get(0);
        
        //Inserindo no banco de dados.
        DAOVeiculo daoCar = new DAOVeiculo();
        daoCar.insert(carro);
        
        
        System.out.println("----->  Terceiro PASSO: CRIAR O MOTORISTAS DA CARONA");
        GeradorDeMotorista geradorMotor = new GeradorDeMotorista();
        DAOMotorista daoMotor = new DAOMotorista();
        Motorista motorista = geradorMotor.gerarMotorista(lstUsers.get(0), carro);
        lstUsers.remove(0);
        
        //Inserindo no banco de dados.
        daoMotor.insert(motorista);
        
        System.out.println("----->  Quarto PASSO: Listar cidades do Estado em que vc vai roar:");
        List<String> lstCidadesEstado = pesquisador.pesquisarLocaisPorEstado(EnumEstado.Espirito_Santo.valueDBpedia);
        
        for(String cidades: lstCidadesEstado){
            System.out.println(cidades);
        }
        
        System.out.println("----->  Quinto PASSO: Criar Destinos");
        
                Lugar lugarAux;
        GeradorLugar geradorLugar = new GeradorLugar();
        
        List<Lugar> lstDestinos = new ArrayList<Lugar>();
        List<EnumLocais> listEnum = new ArrayList<EnumLocais>();
        
        for(EnumLocais enums: EnumLocais.values()){
            listEnum.add(enums);
        }
        
        for(int x = 0; x < 2; x++){
            Collections.shuffle(listEnum);
            lugarAux = new Lugar();
            
            lugarAux = geradorLugar.gerarLugar(listEnum.get(0)); 
            listEnum.remove(0);
            lstDestinos.add(lugarAux);
        }
        
//        DAOLugar daolugar = new DAOLugar();
//        for(Lugar place: lstDestinos){
//            daolugar.insert(place);
//        }
        
        
        
        
        
        carona.lstDestinos = lstDestinos;
        carona.lstPessoasParaCarona =lstUsers;
        carona.motorista= motorista;
        carona.saida = geradorLugar.gerarLugar(EnumLocais.randomLocal()); 
        
        
        return carona;
    }
    
}
