/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bll.dto.Hotel;
import java.util.List;

/**
 *
 * @author MY LAPTTOP
 */
public class PrintFormat {
    public static void printFormat(List<Hotel> list) {
        for (int i = 0; i < 118; i++) {
            System.out.printf("-");
        }
        System.out.println("");
        System.out.printf("| ID |%8s%4s%8s|Room Available|%25s%7s%25s|   Phone  |Rating|\n"," ", "Name"," "," ","Address" ," ", "Phone", "Rating");
        for (int i = 0; i < 118; i++) {
            System.out.printf("-");
        }
        System.out.println("");
        for (Hotel h : list) {
            h.hotelInfor();
        }
        for (int i = 0; i < 118; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
    
}
