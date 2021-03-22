/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.AdminDirectory;
import info5100.university.example.Persona.AdminProfile;
import info5100.university.example.Persona.Faculty.FacultyAssignment;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;

/**
 *
 * @author mrudu
 */
public class University {
    
    List<Department> departmentList = new ArrayList<>();    
    List<AdminProfile> adminList = new ArrayList<>();
    
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public List<AdminProfile> getAdminList() {
        return adminList;
    }
    
    public void setAdminList(List<AdminProfile> adminList) {
        this.adminList = adminList;
    }
    
    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
    
    public void setData(){
        Department d1 = new Department("Information Systems");
        Department d2 = new Department("Computer Systems Engineer");
        Department d3 = new Department("Engineering Management");
        departmentList.add(d1);
        departmentList.add(d2);
        departmentList.add(d3);
       
        Course c1 = d1.newCourse("Program Structure and Algorithms", "INFO 5004", 4, "Data Structures, Algorithms");
        Course c2 = d1.newCourse("Application Engineering and Development", "INFO 5005", 4, "Java, Swing");
        Course c3 = d1.newCourse("Data Science Engineering with Python", "INFO 5006", 4, "Python, Big-Data Processing, Data Visualization");
        Course c4 = d1.newCourse("Web Design and User Experience Engineering", "INFO 5007", 4, "Html, Css, JavaScript, BootStrap, React");
        Course c5 = d1.newCourse("Data Management and Database Design", "INFO 5008", 4, "Dmbs, SQL");
        Course c6 = d1.newCourse("Business Analysis and Information Engineering", "INFO 5009", 4, "SDLC");
        Course c7 = d1.newCourse("Engineering of Big-Data Systems", "INFO 5010", 4, "MongoDB, Hadoop, NoSQL");
        Course c8 = d1.newCourse("Data Science Engineering Methods and Tools", "INFO 5011", 4, "Machine Learning Algorithms, Data pipelining");
       
        CourseSchedule cs = d1.newCourseSchedule("Fall2020");
       CourseOffer co1 = cs.newCourseOffer("INFO 5010");
       co1.generatSeats(30);
        CourseOffer co2 = cs.newCourseOffer("INFO 5009");
        co2.generatSeats(30);
        
        PersonDirectory pd = d1.getPersonDirectory();
        Person p1 = pd.newPerson("Harshika", 26.0, "harshika@gmail.com", "1233457890", "Boston", "Harshika", "Harshika");
        Person p2 = pd.newPerson("Mrudul", 25.0, "Mrudul@gmail.com", "1233452323", "Boston", "Mrudul", "Mrudul");
        Person p3 = pd.newPerson("Snehal", 19.0, "Snehal@gmail.com", "1233453434", "Boston", "Snehal", "Snehal");        
        Person p4 = pd.newPerson("admin", 40.0, "admin@gmail.com", "1233455678", "Boston", "admin", "admin");

       
        StudentDirectory sd = d1.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(p1);
        
        AdminDirectory adminD = new AdminDirectory();
        AdminProfile admin = adminD.newAdminProfile(p4);
        adminList.add(admin);
        FacultyDirectory fd1 = d1.getFacultydirectory();
//        FacultyProfile fp1 = fd1.newFacultyProfile(p2);
//        FacultyProfile fp2 = fd1.newFacultyProfile(p3);
        
       
        
//        co1.AssignAsTeacher(fd1.getTeacherlist().get(0));
        
        Person p = new Person("Professor H");
        Person f = new Person("Professor M");
        CourseLoad courseload = student.newCourseLoad("Fall2020");
        courseload.newSeatAssignment(co1);                
        courseload.newSeatAssignment(co2);
        FacultyProfile fp = new FacultyProfile(p);
       FacultyAssignment fp1 = fp.AssignAsTeacher(co1);
       d1.addFucultyToDirectory(fp);
       FacultyProfile fp2 = new FacultyProfile(f);
       FacultyAssignment fa2 = fp2.AssignAsTeacher(co2);
       d1.addFucultyToDirectory(fp2);
       fp1.assignGradePointsToStudent("INFO 5010", fp);
       fa2.assignGradePointsToStudent("INFO 5009", fp2);
       
    }

    
}
