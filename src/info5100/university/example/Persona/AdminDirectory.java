/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

import java.util.ArrayList;

/**
 *
 * @author harshikag
 */
public class AdminDirectory {
    ArrayList<AdminProfile> adminList;

    public ArrayList<AdminProfile> getAdminList() {
        return adminList;
    }

    public void setAdminList(ArrayList<AdminProfile> adminList) {
        this.adminList = adminList;
    }
    
    public AdminDirectory() {
        adminList = new ArrayList();
    }
    
    public AdminProfile newAdminProfile(Person p) {

        AdminProfile sp = new AdminProfile(p);
        adminList.add(sp);
        return sp;
    }

    public AdminProfile findAdmin(String id) {

        for (AdminProfile sp : adminList) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
            return null; //not found after going through the whole list
         }
    
     public ArrayList<AdminProfile> getStudentlist() {
        return adminList;
    }
}
