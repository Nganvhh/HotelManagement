/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bll.component.InputMainMenu;
import bll.serviceinterface.HotelService;
import java.io.EOFException;

/**
 *
 * @author MY LAPTTOP
 */
public class Main {

    public static void main(String[] args) throws EOFException {
        HotelService h = new HotelService();
        int choice;
        do {
            choice = InputMainMenu.mainMenu();
            switch (choice) {
                case 1:
                    h.addHotel();
                    break;
                case 2:
                    h.checkExitsHotel();
                    break;
                case 3:
                    h.updateHotelInfomation();
                    break;
                case 4:
                    h.deleteHotel();
                    break;
                case 5:
                    h.searchHotel();
                    break;
                case 6:
                    h.displayHotel();
                    break;
                case 7:
                    h.saveToFile();
                    break;
                case 8:
                    System.out.println("\nQuit");
                    break;
            }
        } while (choice > 0 && choice < 8);
    }
}
