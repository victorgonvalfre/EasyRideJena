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
public enum EnumCarros {
    HondaFit(0), MustangueGT(1), Corola(2), Palio(3), Fusca(4), HondaCivic(5), Camaro(6), Mobilete(7);



  private static final List<EnumCarros> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
  private static final int SIZE = VALUES.size();
  private static final Random RANDOM = new Random();

  public static EnumCarros randomModelo()  {
    return VALUES.get(RANDOM.nextInt(SIZE));
  }
    public final int iD;

    private EnumCarros(int Id){
            this.iD = Id;
    }
    
}
