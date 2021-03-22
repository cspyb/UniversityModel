/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Department;

import java.util.ArrayList;

/**
 *
 * @author harshikag
 */
public class DepartmentDirectory {
    ArrayList<Department> departmentList;

    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(ArrayList<Department> departmentList) {
        this.departmentList = departmentList;
    }
    
    public DepartmentDirectory() {
        departmentList = new ArrayList();
    }
    
    
    
    public Department newDepartment(String n, String head, String desc, int age) {
        Department d = new Department(n);
        d.newDepartment(head, desc, age);
        departmentList.add(d);
        return d;
    }
    
    public Boolean deleteEmployer(String n) {
        for(int i = 0; i < departmentList.size(); i ++) {
            Boolean a = departmentList.get(i).getName().matches(n);
            if (a) {
                departmentList.remove(departmentList.get(i));
                return true;
            }
        }
        return false;
    }
}
