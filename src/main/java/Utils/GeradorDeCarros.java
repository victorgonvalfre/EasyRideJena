/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Pessoa;
import Model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.fluttercode.datafactory.impl.DataFactory;

/**
 *
 * @author Victor
 */
public class GeradorDeCarros {
    
    public List<Veiculo> gerarCarros(int quantidade){
        DataFactory df = new DataFactory();
        Random RANDOM = new Random();
        List<Veiculo> lstCarros = new ArrayList<Veiculo>();
        Veiculo carroModel;
        
        while(quantidade > 0){
            carroModel = new Veiculo();
            carroModel.placa = df.getRandomText(3)+df.getNumberText(4);
            carroModel.Modelo = EnumCarros.randomModelo().toString();
            carroModel.vagas = RANDOM.nextInt(5);
      
            lstCarros.add(carroModel);
            quantidade --;
        }

        return lstCarros;
    }
}
