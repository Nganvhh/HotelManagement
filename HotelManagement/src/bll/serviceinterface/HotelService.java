/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.serviceinterface;

import bll.component.DataValidation;
import bll.component.SearchHotelList;
import bll.dto.Hotel;
import dal.FileManagement;
import gui.Menu;
import gui.PrintFormat;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import utils.Inputter;

/**
 *
 * @author MY LAPTTOP
 */
public class HotelService implements IHotelService {
    public static List<Hotel> listOld = new ArrayList<Hotel>();
    public static List<Hotel> listNew = new ArrayList<Hotel>();
    
    public HotelService() {
    }
    public void loadFromFile() {
        try {
            FileManagement.loadDataFromFile(listOld, "hotel.dat");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        if(listOld.isEmpty()) {
            System.out.println("No hotels found in the file. Adding a new one");
            addHotel();
        }
    }
    

    @Override
    public void addHotel() {
//        AddNewHotel.addHotel(listOld, listNew);
        String choice;
        do {
            String id, name, address, phone;
            int roomAvailable, rating;
            System.out.println("Enter new Hotel detail");
            id = DataValidation.inputHotelID(listOld, listNew);
            name = DataValidation.inputHotelName();
            roomAvailable = DataValidation.inputHotelRoomAvailable();
            address = DataValidation.inputHotelAddress();
            phone = DataValidation.inputHotelPhone();
            rating = DataValidation.inputHotelRating();
            Hotel h = new Hotel(id, name, roomAvailable, address, phone, rating);
            listNew.add(h);
            System.out.println("Hotel added!");
            System.out.println("Product save file successfull!");
        } while (Inputter.inputYN("Do you want to continue(Y/N): "));
    }

    @Override
    public void checkExitsHotel() {
//        loadFromFile();
        if (listOld.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        String id = DataValidation.inputHotelID("Enter ID to be check:");
        Hotel h = DataValidation.search(listOld, id);
        if (h != null) {
            System.out.println("Exist Hotel");
            h.hotelInfor();
        } else {
            System.out.println("No Hotel Found!");
        }
    }

    @Override
    public void updateHotelInfomation() {
//        loadFromFile();
        String searchId = DataValidation.inputHotelID("Enter ID to be update: ");
        Hotel h = DataValidation.search(listOld, listNew, searchId);
        if (h == null) {
            System.out.println("Hotel does not exist");
            return;
        }
        String name, address, phone;
        int roomAvailable, rating;

        name = Inputter.getString("Enter Name: ");
        if (Inputter.isBlank(name)) {
            name = h.getName();
        }
        roomAvailable = DataValidation.updateRoomAvailable(h,"Enter Room Available: ", 0);
        if (Inputter.isBlank(roomAvailable)) {
            roomAvailable = h.getRoomAvailable();
        }
        address = Inputter.getBlankStringreg("Enter Address: ", "^[A-Za-z0-9 ]+$", "Address format is wrong");
        if (Inputter.isBlank(address)) {
            address = h.getAddress();
        }
        phone = Inputter.getBlankStringreg("Enter Hotel Phone (0XXXXXXXXX): ", "^0\\d{9}$", "Phone number format is wrong");
        if (Inputter.isBlank(phone)) {
            phone = h.getPhone();
        }
        rating = DataValidation.updateRating(h, "Enter Rating: ", 0, 6);
        if (Inputter.isBlank(rating)) {
            rating = h.getRating();
        }
        if (DataValidation.search(listOld, searchId) != null) {
            listOld.set(listOld.indexOf(h), new Hotel(searchId, name, roomAvailable, address, phone, rating));
        } else {
            listNew.set(listNew.indexOf(h), new Hotel(searchId, name, roomAvailable, address, phone, rating));
        }
    }

    @Override
    public void deleteHotel() {
        String searchId = DataValidation.inputHotelID("Enter ID to be detele: ");
        Hotel h = DataValidation.search(listOld, searchId);
        if (h == null) {
            System.out.println("Hotel does not exist");
            return;
        }
        System.out.println("Do you ready want to delete this hotel? (Y/N)");
        if (Inputter.inputYN(Inputter.getString()) == false) {
            return;
        }
        listOld.remove(listOld.indexOf(h));
        if (DataValidation.search(listOld, searchId) != null) {
            System.out.println("Delete failed");
        } else {
            System.out.println("Deleted successfully");
        }
//        saveToFile();
    }

    @Override
    public void searchHotel() {
        Menu smenu = new Menu("Search Hotel");
        smenu.addNewOption("Search by Hotel ID");
        smenu.addNewOption("Search by Hotel Name");
        smenu.printMenu();
        int choice = smenu.getChoice();
        switch (choice) {
            case 1:
                SearchHotelList.searchByHotelID(listOld);
                break;
            case 2:
                SearchHotelList.searchByHotelName(listOld);
                break;
        }
    }

    @Override
    public void displayHotel() {
//        loadFromFile();
        if(listOld.isEmpty()) {
            System.out.println("No Hotel Found");
            return;
        }
        listOld.sort((h1, h2) -> h2.getName().compareToIgnoreCase(h1.getName()));
        PrintFormat.printFormat(listOld);
    }

    @Override
    public void saveToFile() {
        listOld.addAll(listNew);
        if(!listOld.isEmpty()||!listNew.isEmpty()){
//            FileManagement.saveDataToFile(listNew, "hotel.dat");
            FileManagement.saveDataToFile(listOld, "hotel.dat");
            
            System.out.println("Saved successfully");
        }
            
    }

}
