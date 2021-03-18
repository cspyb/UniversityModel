/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.Map;

/**
 *
 * @author kal bugrara
 */
public class CourseLoad {
    String semester;
    ArrayList<SeatAssignment> seatassignments;
    String grade;

    public String getGrade() {
        return grade;
    }

    public CourseLoad(String s){
        seatassignments = new ArrayList<SeatAssignment>();
        semester = s;
    }
    public SeatAssignment newSeatAssignment(CourseOffer co){
        
        Seat seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat==null) return null;
        SeatAssignment sa = seat.newSeatAssignment();
        seatassignments.add(sa);  //add to students course 
        return sa;
    }
    
    public void registerStudent(SeatAssignment sa){
        
        
        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }
    
    public ArrayList<String> getListOfCoursesCompleted(HashMap<String, CourseLoad> courseloadlist){
        ArrayList<String> courses = new ArrayList();
            for(CourseLoad cl : courseloadlist.values()){
                for(SeatAssignment sa : cl.seatassignments){
                           courses.add(sa.seat.getCourseName());
                }
        }
        return courses;
    } 

    
    public double calculateGPA(HashMap<String, CourseLoad> courseloadlist) {
        double sumCredits = 0;
        double sumGradePoints = 0.0;
        double gpa = 0.0;
        for(CourseLoad cl : courseloadlist.values()){
            for(SeatAssignment sa : cl.seatassignments){
                sumCredits = sumCredits + sa.seat.getCourseCredit();
                sumGradePoints = sumGradePoints + sa.getGradePoints() * sa.seat.getCourseCredit();
            }
        }
        
        gpa = sumGradePoints / sumCredits;
        setGrade(gpa);
        return gpa;
    }

    public void setGrade(double calculateGPA) {
        if(calculateGPA == 4){
            this.grade = "A";
        }else if(calculateGPA >= 3.67 && calculateGPA < 4){
            this.grade = "A-";
        }else if(calculateGPA >= 3.33 && calculateGPA < 3.67){
            this.grade = "B+";
        }else if(calculateGPA >= 3.00 && calculateGPA < 3.33){
            this.grade = "B";
        }else if(calculateGPA >= 2.67 && calculateGPA < 3.00){
            this.grade = "B-";
        }else if(calculateGPA >= 2.33 && calculateGPA < 2.67){
            this.grade = "C+";
        }else if(calculateGPA >= 2.00 && calculateGPA < 2.33){
            this.grade = "C";
        }else if(calculateGPA >= 1.67 && calculateGPA < 2.00){
            this.grade = "C-";
        }else{
            this.grade = "F";
        }
    }
    
}
