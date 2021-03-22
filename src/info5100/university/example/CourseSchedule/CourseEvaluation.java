/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author snehalchavan
 */
public class CourseEvaluation {
    FacultyAssignment facultyAssignment;
    FacultyDirectory fd;
    Department department;
    HashMap<FacultyProfile,Integer> hmFacultyRatingData = new HashMap<>();
    
    public void setFacultyFeedback(String facultyName,int rating,FacultyDirectory teacherlist){
        FacultyProfile faculty = teacherlist.findTeachingFaculty(facultyName);
        hmFacultyRatingData.put(faculty, rating);
        System.out.println("added....."+hmFacultyRatingData.size());
    }
}
