/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import static Utils.EnumLocais.values;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Victor
 */
public enum EnumEstado {
       Espirito_Santo("Esp%C3%ADrito_Santo");

    
  private static final List<EnumEstado> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
  private static final int SIZE = VALUES.size();
  private static final Random RANDOM = new Random();

  public static EnumEstado randomModelo()  {
    return VALUES.get(RANDOM.nextInt(SIZE));
  }
  
  public static EnumEstado getLocalByOrder(int pos){
      return VALUES.get(pos);
  }
  
    public  String valueDBpedia;

    private EnumEstado(String DBpediaValue){
            this.valueDBpedia = DBpediaValue;
    }
    
}
