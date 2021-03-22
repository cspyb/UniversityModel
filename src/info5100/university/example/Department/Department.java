/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Department;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Persona.Faculty.FacultyDirectory;
import info5100.university.example.Persona.Faculty.FacultyProfile;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class Department {

    String name;
    String deptHead;
    String deptDescription;
    double deptAge;
    CourseCatalog coursecatalog;
    PersonDirectory persondirectory;
    StudentDirectory studentdirectory;
    FacultyDirectory facultydirectory;
    DepartmentAccount departmentAccount;

    public String getDeptHead() {
        return deptHead;
    }

    public void setDeptHead(String deptHead) {
        this.deptHead = deptHead;
    }

    public String getDeptDescription() {
        return deptDescription;
    }

    public void setDeptDescription(String deptDescription) {
        this.deptDescription = deptDescription;
    }

    public double getDeptAge() {
        return deptAge;
    }

    public void setDeptAge(double deptAge) {
        this.deptAge = deptAge;
    }
    
    public FacultyDirectory getFacultydirectory() {
        return facultydirectory;
    }

    public void addFucultyToDirectory(FacultyProfile fp){
        facultydirectory.addTeacherToList(fp);
    }
    HashMap<String, CourseSchedule> mastercoursecatalog;

    public Department(String n) {
        name = n;
        mastercoursecatalog = new HashMap<String, CourseSchedule>();
        coursecatalog = new CourseCatalog(this);
        studentdirectory = new StudentDirectory(this); //pass the department object so it stays linked to it
        persondirectory = new PersonDirectory();
        facultydirectory = new FacultyDirectory(this);
        departmentAccount = new DepartmentAccount(this);
    }
    
    public Department() {
        
    }
    
    public void newDepartment(String head, String desc, double age) {
        deptHead = head;
        deptDescription = desc;
        deptAge = age;
    }

    public PersonDirectory getPersonDirectory() {

        return persondirectory;
    }

    public String getName() {
        return name;
    }

    public StudentDirectory getStudentDirectory() {
    return studentdirectory;
    }

    public CourseSchedule newCourseSchedule(String semester) {

        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        mastercoursecatalog.put(semester, cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {

        return mastercoursecatalog.get(semester);

    }

    public CourseCatalog getCourseCatalog() {

        return coursecatalog;

    }

    public Course newCourse(String n, String nm, int cr, String skill) {

        Course c = coursecatalog.newCourse(n, nm, cr,skill);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {

//        CourseSchedule css = mastercoursecatalog.get(semester);

        return departmentAccount.calculateRevenuesBySemester(semester);

    }
    
    public String getPopularCourseBySemester(String semester) {
        CourseSchedule css = mastercoursecatalog.get(semester);
        return css.getPopularCourse();
    }
    
    public int calculateLossBySemester(String semester) {
        return departmentAccount.calculateLossBySemester(semester);
    }

    public void RegisterForAClass(String studentid, String cn, String semester) {

        StudentProfile sp = studentdirectory.findStudent(studentid);

        CourseLoad cl = sp.getCurrentCourseLoad();

        CourseSchedule cs = mastercoursecatalog.get(semester);

        CourseOffer co = cs.getCourseOfferByNumber(cn);

        co.assignEmptySeat(cl);

    }

    public Course newCourse(String app_eng, String info_5100, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public HashMap<String, CourseSchedule> getMastercoursecatalog() {
        return mastercoursecatalog;
    }

    public void setMastercoursecatalog(HashMap<String, CourseSchedule> mastercoursecatalog) {
        this.mastercoursecatalog = mastercoursecatalog;
    }
    
    
}
