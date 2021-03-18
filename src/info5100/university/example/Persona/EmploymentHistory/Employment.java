/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona.EmploymentHistory;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.Employer.EmployerProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Employment {
    //ArrayList<CourseOffer> relevantcourseoffers;
    ArrayList<Course> relevantcourseoffers;
    int weight;
    String quality;
    String job;
    Employment nextemplyment;  //next job so they are in a sequence 
    
    EmployerProfile employer;
    public Employment(String j, String employerName){
        this.job = job;
        employer = new EmployerProfile(employerName);
        ArrayList relevantcourseoffers = new ArrayList();
    }

    public ArrayList<Course> getRelevantcourseoffers() {
        return relevantcourseoffers;
    }

    public String getJob() {
        return job;
    }

    public EmployerProfile getEmployer() {
        return employer;
    }
    
    
    
}
