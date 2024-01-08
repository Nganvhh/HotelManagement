/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll.dto;

/**
 *
 * @author MY LAPTTOP
 */
public class Hotel implements Comparable<Hotel>{
    private String id;
    private String name;
    private int roomAvailable;
    private String address;
    private String phone;
    private int rating;

    public Hotel() {
    }

    public Hotel(String id, String name, int roomAvailable, String address, String phone, int rating) {
        this.id = id;
        this.name = name;
        this.roomAvailable = roomAvailable;
        this.address = address;
        this.phone = phone;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomAvailable() {
        return roomAvailable;
    }

    public void setRoomAvailable(int roomAvailable) {
        this.roomAvailable = roomAvailable;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "HotelManagement{" + "id=" + id + ", name=" + name + ", roomAvailable=" + roomAvailable + ", address=" + address + ", phone=" + phone + ", rating=" + rating + '}';
    }

    public void hotelInfor() {
        System.out.printf("|%-4s|%-20s|%14d|%-57s|%-10s|%6s|\n", id, name, roomAvailable, address, phone, (rating + " star"));
    }
    
    @Override
    public int compareTo(Hotel that) {
        return this.id.compareToIgnoreCase(that.id);
    }
}
