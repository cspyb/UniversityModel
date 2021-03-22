/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Employer;

import info5100.university.example.Persona.EmploymentHistory.Employment;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class EmployerProfile {
    String name;
    String location;
    int companyAge;
    int companyAssociationWithUniversity;
    String contactNo;
    
    ArrayList<Employment> employments;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCompanyAge() {
        return companyAge;
    }

    public void setCompanyAge(int companyAge) {
        this.companyAge = companyAge;
    }

    public int getCompanyAssociationWithUniversity() {
        return companyAssociationWithUniversity;
    }

    public void setCompanyAssociationWithUniversity(int companyAssociationWithUniversity) {
        this.companyAssociationWithUniversity = companyAssociationWithUniversity;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public ArrayList<Employment> getEmployments() {
        return employments;
    }

    public void setEmployments(ArrayList<Employment> employments) {
        this.employments = employments;
    }
    
    
    public EmployerProfile(String n){  //could be company instead of just a name as a string
        name = n;
    }
    
    
    public void addEmployerDetails(String l, String contact, int age, int companyAssociation) {
        location = l;
        companyAge = age;
        contactNo = contact;
        companyAssociationWithUniversity = companyAssociation;
    }
    public boolean isMatch(String id){
        if(name.equals(id)) return true;             //String is an object and can do equal matach
        return false;
    }

    public String getName() {
        return name;
    }
         
    
    
}
