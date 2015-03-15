/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Victor
 */
public class Motorista extends Model{
    public Pessoa pessoa;
    public String cnh;
    public Veiculo veiculo;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public int getPessoaId(){
      return  this.pessoa.getId();
    }
    
    public int getVeiculoId(){
        return this.veiculo.getId();
    }

    @Override
    public String toString() {
        return "Motorista{" + "pessoa=" + pessoa.nome + ", cnh=" + cnh + ", veiculo=" + veiculo.Modelo + '}';
    }
    
    
}
