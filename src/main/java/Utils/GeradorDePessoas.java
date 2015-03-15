/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Pessoa;
import java.util.ArrayList;
import java.util.List;
import org.fluttercode.datafactory.impl.DataFactory;

/**
 *
 * @author Victor
 */
public class GeradorDePessoas {
    
    
     public List<Pessoa> gerarUsuarios(int quantidade){
        DataFactory df = new DataFactory();
        List<Pessoa> lstUsers = new ArrayList<Pessoa>();
        Pessoa user;
        
        while(quantidade > 0){
            user = new Pessoa();
            user.nome = df.getFirstName() + " " + df.getLastName();
            user.email = df.getEmailAddress();
            user.telefone = df.getNumberText(8);
            user.endereco = df.getAddress();
      
            lstUsers.add(user);
            quantidade --;
        }

        return lstUsers;
    }
    
}
