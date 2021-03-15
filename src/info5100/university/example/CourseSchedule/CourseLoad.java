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
            System.out.println("info5100.university.example.CourseSchedule.CourseLoad.getListOfCoursesCompleted()");
        return courses;
    } 
    
}
