/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Jair
 */
public class Lugar extends Model{
    public String nome;
    public String descricao;
  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    @Override
    public String toString() {
        return "Lugar{" + "nome=" + nome + ", descricao=" + descricao +"}";
    }
}
