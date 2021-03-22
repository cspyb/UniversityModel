/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Department;

import info5100.university.example.CourseSchedule.CourseSchedule;

/**
 *
 * @author harshikag
 */
class DepartmentAccount {
    Department department;
    public DepartmentAccount(Department d) {
        department = d;
    }
    
    public int calculateRevenuesBySemester(String semester) {

        CourseSchedule css = department.getCourseSchedule(semester);
        if (css != null) {
            return css.calculateTotalRevenues();
        } else {
            return 0;
        }

    }
    
    public int calculateLossBySemester(String semester) {
        CourseSchedule css = department.getCourseSchedule(semester);
        if (css != null) {
            return css.calculateTotalLoss();
        } else {
            return 0;
        }
    }
}
