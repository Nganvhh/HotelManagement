/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import utils.Inputter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MY LAPTTOP
 */
public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private String menuTitle;
    private ArrayList<String> optionList = new ArrayList();
    
    public Menu(String menuTitle) {
        this.menuTitle = menuTitle;
    }
    
    public void addNewOption(String newOption) {
        optionList.add(newOption);
    }
    
    public void printMenu() {
        if(optionList.isEmpty(
        )) {
            System.out.println("There is no option in the menu");
            return;
        }
        System.out.println("\n");
        for (int i = 0; i < 22 - menuTitle.length()/2 ; i++) {
            System.out.print("=");
        }
        System.out.print(" *" + menuTitle + "* ");
        for (int i = 0; i < 22 - menuTitle.length()/2 ; i++) {
            System.out.print("=");
        }
        System.out.println("");
        for (int i = 0; i < optionList.size(); i++) {
            System.out.println((i + 1) + "-" + optionList.get(i) + ".");
        }
        System.out.println("================================================"); //48 dấu =
    }
    
    public int getChoice() {
        String inputMsg = "Enter your choice [1.." + optionList.size() + "]: ";
        String errorMsg = "You are required to choose the option 1.." + optionList.size();
        return Inputter.getAnInteger(inputMsg, errorMsg, errorMsg, 1, optionList.size());
    }
    
}