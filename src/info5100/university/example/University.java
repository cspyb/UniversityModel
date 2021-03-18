/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.Department.Department;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mrudu
 */
public class University {
    
    List<Department> departmentList = new ArrayList<>();

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }
    
}
