/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.dto.Hotel;
import java.util.List;

/**
 *
 * @author MY LAPTTOP
 */
public class HotelDAO {
    private final FileManagement fm;
    
    public HotelDAO() {
        fm = new FileManagement();
    }
    
    public boolean loadDataFromFile(List<Hotel> list, String filename) {
        return fm.loadDataFromFile(list, filename);
    }
    
    public boolean saveDataToFile(List<Hotel> list, String filename, String msg) {
        return fm.saveDataToFile(list, filename, msg);
    }
    
    public boolean saveDataToFile(List<Hotel> list1, List<Hotel> list2, String filename, String msg) {
        return fm.saveDataToFile(list2, list2, filename, msg);
    }
}
