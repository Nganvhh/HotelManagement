/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.component;

import bll.dto.Hotel;
import gui.PrintFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MY LAPTTOP
 */
public class SearchHotelList {
    public static  void searchByHotelID(List<Hotel> list){
        List<Hotel> tmp = new ArrayList();
        String id = DataValidation.inputHotelID("Enter ID to be search: ");
        for (Hotel h : list) {
            if(h.getId().contentEquals(id.toUpperCase())) 
                tmp.add(h);
        }
        tmp.sort((h1,h2) -> h2.getId().compareToIgnoreCase(h1.getId()));
        PrintFormat.printFormat(tmp);
    }
    
    public static  void searchByHotelName(List<Hotel> list){
        List<Hotel> tmp = new ArrayList();
        String name = DataValidation.inputHotelName();
        for (Hotel h : list) {
            if(h.getName().equalsIgnoreCase(name))
                tmp.add(h);
        }
        PrintFormat.printFormat(tmp);
    }
    
    
}
