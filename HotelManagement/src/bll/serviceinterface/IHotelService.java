/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.serviceinterface;

/**
 *
 * @author MY LAPTTOP
 */
public interface IHotelService {
    public abstract void addHotel();
    public abstract void checkExitsHotel();
    public abstract void updateHotelInfomation();
    public abstract void deleteHotel(); 
    public abstract void searchHotel();
    public abstract void displayHotel();
    public abstract void saveToFile();
}
