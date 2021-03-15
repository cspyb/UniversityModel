/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Info5001UniversityExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Department department = new Department("Information Systems");
//
//        Course course = department.newCourse("app eng", "info 5100", 4);        
//        Course course1 = department.newCourse("app dev", "info 5200", 4);
//
//
//        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");
//
//        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");        
//        CourseOffer courseoffer1 = courseschedule.newCourseOffer("info 5200");
//
//        
//        courseoffer.generatSeats(10);
//        courseoffer1.generatSeats(20);
//        
//        PersonDirectory pd = department.getPersonDirectory();
//        Person person = pd.newPerson("0112303");
//        StudentDirectory sd = department.getStudentDirectory();
//        StudentProfile student = sd.newStudentProfile(person);
//        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
////
//                courseload.newSeatAssignment(courseoffer);                
//                courseload.newSeatAssignment(courseoffer1); //register student in class
// //register student in class
////        courseload.getListOfCoursesCompleted();

        Department department = new Department("Information Systems");

 

        Course course3 = department.newCourse("app eng", "info 5100", 4);         
        Course course1 = department.newCourse("app dev", "info 5200", 4); 
        Course course4 = department.newCourse("web", "info 5555", 4);
        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");
        CourseSchedule courseschedule1 = department.newCourseSchedule("Spring21");
 

        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");       
        CourseOffer courseoffer1 = courseschedule.newCourseOffer("info 5200");
        CourseOffer courseoffer2 = courseschedule1.newCourseOffer("info 5555");
        
        courseoffer.generatSeats(10);        
        courseoffer1.generatSeats(10);
        courseoffer2.generatSeats(10);
 

        
        PersonDirectory pd = department.getPersonDirectory();
        Person person = pd.newPerson("0112303");
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person);
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
        courseload.newSeatAssignment(courseoffer); //register student in class
        CourseLoad courseload11 = student.newCourseLoad("Spring21");
        courseload11.newSeatAssignment(courseoffer2);
        

        // person 2
        
        PersonDirectory pd1 = department.getPersonDirectory();
        Person person1 = pd1.newPerson("0112304");
        StudentDirectory sd1 = department.getStudentDirectory();
        StudentProfile student1 = sd1.newStudentProfile(person1);
        CourseLoad courseload1 = student1.newCourseLoad("Fall2020"); 
        courseload1.newSeatAssignment(courseoffer1);
        
        // person 3
        PersonDirectory pd2 = department.getPersonDirectory();
        Person person2 = pd2.newPerson("0112305");
        StudentDirectory sd2 = department.getStudentDirectory();
        StudentProfile student2 = sd2.newStudentProfile(person2);
        CourseLoad courseload2 = student2.newCourseLoad("Fall2020"); 
        courseload2.newSeatAssignment(courseoffer1);

        StudentProfile findStudent = sd.findStudent("0112304");
        ArrayList<String> courseStudent = findStudent.getTranscript();
        for(int i=0;i<courseStudent.size();i++){
            System.out.println("name "+courseStudent.get(i));
        }

        int total = department.calculateRevenuesBySemester("Fall2020");
        System.out.print("Total: " + total);

    }

}
