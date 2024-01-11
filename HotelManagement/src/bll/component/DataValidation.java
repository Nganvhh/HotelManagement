/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.component;

import bll.dto.Hotel;
import java.util.List;
import java.util.Scanner;
import utils.Inputter;

/**
 *
 * @author MY LAPTTOP
 */
public class DataValidation extends Inputter{
    private static Scanner sc = new Scanner(System.in);
    
    public static Hotel search(List<Hotel> list, String id) {
        for (Hotel h : list) {
            if (h.getId().equalsIgnoreCase(id)) {
                return h;
            }
        }
        return null;
    }
    public static Hotel search(List<Hotel> listOld, List<Hotel> listNew, String id) {
        for (Hotel h : listOld) {
            if (h.getId().equalsIgnoreCase(id))
                return h;
        }
        for (Hotel h : listNew) {
            if(h.getId().equalsIgnoreCase(id))
                return h;
        }
        return null;
    }
    
    public static String inputHotelID(List<Hotel> listOld, List<Hotel> listNew){
        String id;
        do {
            id = Inputter.getStringreg("Enter ID: ", "[H|h]\\d+$", "ID is not null", "ID format is wrong");
            Hotel h = search(listOld, listNew, id);
            if (h != null) {
                System.out.println("ID Dupplicated");
            } else {
                break;
            }
        } while (true);
        return id;
    }
    
    public static String inputHotelID(String msg){
        return Inputter.getStringreg(msg, "[H|h]\\d+$", "ID is not null", "ID format is wrong");
    }
    
    public static String inputHotelName() {
        return Inputter.getNonBlankStr("Enter Name: ");
    }
    
    public static int inputHotelRoomAvailable() {
        return Inputter.getAnInteger("Enter Hotel Room Available: ", "Number format is wrong", -1);
    }
    
    public static String inputHotelAddress() {
        return Inputter.getStringreg("Enter Hotel Address: ", "^[A-Za-z0-9 /,]+$", "Address is not null","Address format is wrong");
    }
    
    public static String inputHotelPhone() {
        return Inputter.getStringreg("Enter Hotel Phone (0XXXXXXXXX): ", "^0\\d{9}$", "Phone is not null", "Phone number format is wrong");
    }
    
    public static int inputHotelRating() {
        return Inputter.getAnInteger("Enter Hotel Rating (0-6): ", "Choose a Rating from 1 to 6", "Rating format is wrong", 0, 6);
    }
    
    public static int updateRoomAvailable(Hotel h, String welcome, int min) {
        boolean check = true;
        int roomNumber = 0;
        do {
                try {
                System.out.print(welcome);
                roomNumber = Integer.parseInt(sc.nextLine());
                if (roomNumber < min) {
                    System.out.println("Number must be large than " + min);
                } else {
                    check = false;
                }
            } catch (Exception e) {
                return h.getRoomAvailable();
            }
        } while (check || roomNumber < min);
        return roomNumber;
    }
    
    public static int updateRating(Hotel h, String welcome, int lowerBound, int upperBound) {
        int number, tmp;
        boolean  check = true;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        do {
            try {
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                if (number < lowerBound || number > upperBound) {
                    System.out.println("Number must be between " + lowerBound + " to " + upperBound);
                } else {
                    check = false;
                }
            } catch (Exception e) {
                return h.getRating();
            }
        } while (check || number < lowerBound || number > upperBound);
        return number;
        }
    
    
}
