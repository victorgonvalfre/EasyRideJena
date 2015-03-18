/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Victor
 */
public enum EnumLocais {
    
     Linhares("Linhares"), CachoeiroItapemirim("Cachoeiro_de_Itapemirim"), Colatina("Colatina"), Guarapari("Guarapari");

    
  private static final List<EnumLocais> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
  private static final int SIZE = VALUES.size();
  private static final Random RANDOM = new Random();

  public static EnumLocais randomLocal()  {
    return VALUES.get(RANDOM.nextInt(SIZE));
  }
  
  public static EnumLocais getLocalByOrder(int pos){
      return VALUES.get(pos);
  }
  
    public  String valueDBpedia;

    private EnumLocais(String DBpediaValue){
            this.valueDBpedia = DBpediaValue;
    }
    
}
