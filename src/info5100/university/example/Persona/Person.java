/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.Persona;

/**
 *
 * @author kal bugrara
 */
public class Person {
    
    String id;
    String userName;
    Double age;
    String password;
    String email;
    String contact;
    String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Person (String id){
        
        this.id = id;
    }
    
    public Person updatePerson(String id, Double age, String email, String contact, String address) {
        this.id = id;
        this.age = age;
        this.email = email;
        this.contact = contact;
        this.address = address;
        return this;
    }
    
    public Person(String id, Double age, String email, String contact, String address, String uName, String pwd) {
        this.id = id;
        this.age = age;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.userName = uName;
        this.password = pwd;
    }
    
    public String getPersonId(){
        return id;
    }

        public boolean isMatch(String id){
        if(getPersonId().equals(id)) return true;
        return false;
    }
    
}
