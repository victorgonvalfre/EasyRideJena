/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplication;

import Controler.EasyRideApp;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class EasyRideStart {
    
        public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        System.out.println(" ---- > Bem Vindo ao EasyRide!");
        EasyRideApp app = new EasyRideApp();
        app.start();
    }
    
}
