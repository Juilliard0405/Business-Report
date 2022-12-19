/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juilliardwu.homework4;

/**
 *
 * @author juilliardwu
 */
public class MyDate {
    /**
     * member variable month,day and year
     */

    private int month;
    private int day;
    private int year;
    /**
    * Default constructor set each variable to the initially value
    */
    public MyDate() {
        this.month = 1;
        this.day = 1;
        this.year = 2021;
    }
    /**
     * default constructor equal to the parameter
     * @param m int 
     * @param d int 
     * @param y int 
     */
    public MyDate(int m, int d, int y ){
        this.month = m;
        this.day = d;
        this.year = y;
    }
    /**
     * set month equal to m
     * @param m int
     */

    public void setMonth(int m) {
        month = m;

    }
    /**
     * set day equal to d
     * @param d int
     */

    public void setDay(int d) {
        day = d;
    }
    /**
     * set year equal to y
     * @param y int 
     */

    public void setyear(int y) {
        year = y;
    }
    /**
     * get the month value
     * @return month
     */

    public int getMonth() {
        return month;
    }
    /**
     * get the day value
     * @return day
     */

    public int getDay() {
        return day;
    }
    /**
     * get the year value
     * @return year
     */

    public int getYear() {
        return year;
    }
    /**
     * 
     * @return string that contain the formatted date
     */
    @Override
    public String toString(){
        String s = month + "/" + day +"/" + year;
        return s;
    }
    /**
     * 
     * @param other
     * @return true when month, day and year are equal between instance
     */
    
    public boolean equals(MyDate other){
        if(day == other.getDay()&& month == other.getMonth()&& year == other.getYear()){
            return true;
        }
        else
            return false;
        
    }
       
            
        
        
    
}