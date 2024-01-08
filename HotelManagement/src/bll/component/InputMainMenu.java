/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.component;

import gui.Menu;

/**
 *
 * @author MY LAPTTOP
 */
public class InputMainMenu {
    public static int mainMenu(){
        Menu menuFunction = new Menu("HOTEL MANAGEMENT");
        menuFunction.addNewOption("Adding new Hotel");
        menuFunction.addNewOption("Checking exits Hotel");
        menuFunction.addNewOption("Updating Hotel information");
        menuFunction.addNewOption("Deleting Hotel");
        menuFunction.addNewOption("Searching Hotel");
        menuFunction.addNewOption("Displaying a hotel list");
        menuFunction.addNewOption("Save to file");
        menuFunction.addNewOption("Others Quit");
        
        menuFunction.printMenu();
        return menuFunction.getChoice();
    }
    
}
