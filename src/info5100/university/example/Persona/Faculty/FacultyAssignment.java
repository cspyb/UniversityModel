/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.Faculty;

import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.Seat;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class FacultyAssignment {
    
    CourseOffer courseoffer;
    FacultyProfile facultyprofile;
    public FacultyAssignment(FacultyProfile fp, CourseOffer co){
        courseoffer = co;
        facultyprofile = fp;
    }
    public FacultyProfile getFacultyProfile(){
        return facultyprofile;
    }
    
    public ArrayList<Seat> getSeatList(FacultyProfile fp){
        return courseoffer.getSeatList();
    }    

    public void assignGradePointsToStudent(String name, FacultyProfile fp) {
        ArrayList<FacultyAssignment> facultyassignments = fp.facultyassignments;
        String coursename;
        ArrayList<Seat> seatList = null;
        for(FacultyAssignment fa : facultyassignments){
            if(fa.facultyprofile == fp){
                coursename = fp.getCourseOffer(fp);
                seatList = fa.courseoffer.getSeatList();
            }
        }
        for(Seat s : seatList){
            s.setGradePoint(3.2);
        }
    }
}
