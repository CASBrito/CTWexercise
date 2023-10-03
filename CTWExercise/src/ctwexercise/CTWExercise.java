/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctwexercise;

import java.sql.Timestamp;

/**
 *
 * @author gfgma
 */
public class CTWExercise {
    
    private static Reservation res = new Reservation();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        

        
        Timestamp pickupDate = Timestamp.valueOf("2018-09-01 09:01:15");
        Timestamp dropOffDate = Timestamp.valueOf("2018-09-06 09:01:15");
        
        res.newReservation(pickupDate, dropOffDate);
    }
    
}
