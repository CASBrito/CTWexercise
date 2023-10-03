/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctwexercise;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author gfgma
 */
public class CTWExercise {
    
    static Reservation res = new Reservation();
    static Scanner myObj = new Scanner(System.in);
    static Car carDefault = new Car();
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Testes Temporários
        //Timestamp pickupDate = Timestamp.valueOf("2018-09-01 09:01:15");
        //Timestamp dropOffDate = Timestamp.valueOf("2018-09-06 09:01:15");
        
        menu();
               
    }
    
    private static void menu(){
        
            System.out.println("MENU");
            System.out.println("1: Add Car");
            System.out.println("2: List Cars");
            System.out.println("3: Consult Car details");
            System.out.println("4: Remove Car");
            System.out.println("5: Reserve a Car");
            System.out.println("6: Consult reserve history");
            System.out.println("7: Exit");
        
            System.out.print("Select an option: ");
            String option = myObj.nextLine();
        
            switch (option){
                case "1":{
                    System.out.print("Insert car brand: ");
                    String carBrand = myObj.nextLine();
                    System.out.print("Insert car Model: ");
                    String carModel = myObj.nextLine();
                    System.out.print("Insert car Seats: ");
                    String carSeatsS = myObj.nextLine();
                    int carSeats = Integer.parseInt(carSeatsS);
                    System.out.print("Insert car Licence pPlate: ");
                    String carLicPlate = myObj.nextLine();
                    System.out.print("Insert car Engine Type (COMBUSTION, ELECTRIC, HYBRID): ");
                    String carEngType = myObj.nextLine();
                    System.out.print("Insert car Current Autonomy: ");
                    String carCurAutonomyS = myObj.nextLine();
                    int carCurAutonomy = Integer.parseInt(carCurAutonomyS);
                    
                    Car car = new Car(carBrand, carModel, carSeats, carLicPlate, carEngType, carCurAutonomy);
                    car.addCar();
                    break;
                }
                case "2":{
                    carDefault.getCar();
                    break;
                }
                case "3":{
                    System.out.print("Insert car Model: ");
                    String carModel = myObj.nextLine();
                    
                    carDefault.getCarDetail(carModel);
                    break;
                }
                case "4":{
                    System.out.print("Insert car Model to be Deleted: ");
                    String carModel = myObj.nextLine();
                    
                    carDefault.deleteCar(carModel);
                    break;
                }
                case "5":{                    
                    try{
                        System.out.print("Insert Pickup Date: ");
                        String pickupDateS = myObj.nextLine();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        Date parseDatePUD = dateFormat.parse(pickupDateS);
                        Timestamp pickupDate = new java.sql.Timestamp(parseDatePUD.getTime());
                        
                        System.out.print("Insert Drop Off Date: ");
                        String dropOffDateS = myObj.nextLine();
                        Date parseDateDOD = dateFormat.parse(dropOffDateS);
                        Timestamp dropOffDate = new java.sql.Timestamp(parseDateDOD.getTime());
                        
                        res.newReservation(pickupDate, dropOffDate);
                        
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    
                    break;
                    
                }
                case "6":{
                    res.checkReservation();
                    break;
                }
                case "7":{
                    System.exit(0);
                    break;
                }
                default:{
                    System.out.println("Not valid option");
                    break;
                }
            }
            
            menu();
        }
        
    }
    
