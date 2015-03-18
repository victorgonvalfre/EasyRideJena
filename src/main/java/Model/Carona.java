/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author Victor
 */
public class Carona {
    public Motorista motorista;
    private int vagas;
    public Lugar saida;
    public List<Lugar> lstDestinos;
    public List<Pessoa> lstPessoasParaCarona;
    
    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public List<Pessoa> getLstPessoasParaCarona() {
        return lstPessoasParaCarona;
    }

    public void setLstPessoasParaCarona(List<Pessoa> lstPessoasParaCarona) {
        this.lstPessoasParaCarona = lstPessoasParaCarona;
    }
    
    
    public int getVagas() {
        return vagas;
    }
    
    public String getVagasString(){
        this.vagas = this.motorista.veiculo.getVagas();
     return Integer.toString(vagas);
    }

    public void setVagas() {
        this.vagas = this.motorista.veiculo.getVagas();
    }

    public Lugar getSaida() {
        return saida;
    }

    public void setSaida(Lugar saida) {
        this.saida = saida;
    }

    public List<Lugar> getLstDestinos() {
        return lstDestinos;
    }

    public void setLstDestinos(List<Lugar> lstDestinos) {
        this.lstDestinos = lstDestinos;
    } 
    
    public void inserirCaroneiro(Pessoa pessoa){
        if(this.vagas > 0){
            this.lstPessoasParaCarona.add(pessoa);
            this.vagas --;
        }
        else{ 
            System.out.println("--------> CARONA CHEIA! Não da para alocar mais ninguem!");
        }
    }
    
    public void insierirDestino(Lugar lugar){
        this.lstDestinos.add(lugar);
    }

    
    public String getID(){
        
        return this.motorista.getPessoa().getNome() + this.motorista.getVeiculo().getModelo() + this.getVagas();
    }

}


