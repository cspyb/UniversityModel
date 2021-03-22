/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Employer;

import info5100.university.example.Persona.Faculty.*;
import info5100.university.example.Persona.*;
import info5100.university.example.Department.Department;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class EmployerDirectory {

    Department department;
    ArrayList<EmployerProfile> employerlist;

    public void setEmployerlist(ArrayList<EmployerProfile> employerlist) {
        this.employerlist = employerlist;
    }
    
    public EmployerDirectory(Department d) {

        department = d;
        employerlist = new ArrayList();

    }
    
    public EmployerDirectory() {
        employerlist = new ArrayList();
    }
    
    
    
    public EmployerProfile newEmployer(String n, String l, String contact, int age, int companyAssociation) {

        EmployerProfile sp = new EmployerProfile(n);
        sp.addEmployerDetails(l, contact, age, companyAssociation);
        employerlist.add(sp);
        return sp;
    }
    
    public EmployerProfile newEmployerProfile(String n) {

        EmployerProfile sp = new EmployerProfile(n);
        employerlist.add(sp);
        return sp;
    }
    
    public Boolean deleteEmployer(String n) {
        for(int i = 0; i < employerlist.size(); i ++) {
            Boolean a = employerlist.get(i).getName().matches(n);
            if (a) {
                employerlist.remove(employerlist.get(i));
                return true;
            }
        }
        return false;
    }

    public EmployerProfile findTeachingFaculty(String id) {

        for (EmployerProfile ep : employerlist) {

            if (ep.isMatch(id)) {
                return ep;
            }
        }
            return null; //not found after going through the whole list
         }

    public ArrayList<EmployerProfile> getEmployerlist() {
        return employerlist;
    }
}
