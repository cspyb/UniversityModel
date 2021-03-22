/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseCatalog;

/**
 *
 * @author kal bugrara
 */
public class Course {
    String number;
    String name;
    int credits;
    int price = 1500; //per credit hour
    String skills;
    public Course(String n, String numb, int ch,String skills){
        name = n;
        number = numb;
        credits = ch;
        this.skills = skills;
    }
    
    public Course(String n, String numb, int ch){
        name = n;
        number = numb;
        credits = ch;
//        this.skills = skills;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String getCOurseNumber(){
        return number;
    }
    
    public int getCoursePrice(){
        return price*credits;
        
    }
    
    public int getCourseCredits(){
        return credits;
    }
}
