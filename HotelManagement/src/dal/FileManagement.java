/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.dto.Hotel;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author MY LAPTTOP
 */
public class FileManagement {

    public static boolean loadDataFromFile (List<Hotel> list, String filename) {
        list.clear();
        File f = new File(filename);
        if(!f.exists()) 
            return false;
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String line = "";
            while((line = bf.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(line, ",");
                String id = tokens.nextToken().trim().toUpperCase();
                String name = tokens.nextToken().trim();
                int roomAvailable = Integer.parseInt(tokens.nextToken().trim());
                String address = tokens.nextToken().trim();
                String phone = tokens.nextToken().trim();
                int rating = Integer.parseInt(tokens.nextToken().trim());
                Hotel h = new Hotel(id, name, roomAvailable, address, phone, rating);
                list.add(h);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public static boolean saveDataToFile(List<Hotel> list, String filename) {
        File f = new File(filename);
        if(!f.exists()) {
            System.out.println("Empty list");
            return false;
        }
        try {
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Hotel h : list) {
                pw.println(h.getId() + "," + h.getName() + "," + h.getRoomAvailable() 
                    + "," + h.getAddress() + "," + h.getPhone() + "," + h.getRating());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public static boolean saveDataToFile(List<Hotel> list, String filename, String msg) {
        File f = new File(filename);
        if(!f.exists()) {
            System.out.println("Empty list");
            return false;
        }
        try {
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Hotel h : list) {
                pw.println(h.getId() + "," + h.getName() + "," + h.getRoomAvailable() 
                    + "," + h.getAddress() + "," + h.getPhone() + "," + h.getRating());
            }
            pw.close();
            fw.close();
            System.out.println(msg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
   
}
