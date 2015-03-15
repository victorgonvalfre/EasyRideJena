/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Motorista;
import Model.Pessoa;
import Model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import org.fluttercode.datafactory.impl.DataFactory;

/**
 *
 * @author Victor
 */
public class GeradorDeMotorista {
    
    public Motorista gerarMotorista(List<Pessoa> lstPessoa, List<Veiculo> lstCarros){
        DataFactory df = new DataFactory();
        Motorista motor = new Motorista();
        
        motor.pessoa = lstPessoa.get(0);
        motor.cnh = df.getNumberText(9);
        motor.veiculo = lstCarros.get(0);
        
        return motor;
    }
    
}
