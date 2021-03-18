/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.Department.Department;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

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
    
    public void setData(){
        
        try{
            
            File f1 = new File("Courses.xlsx");
            Workbook wb1 = Workbook.getWorkbook(f1);
            Sheet s1 = wb1.getSheet(0);
            int rowC = s1.getRows();
            int colC = s1.getColumns();
            
            File f = new File("University.xlsx");
            Workbook wb = Workbook.getWorkbook(f);
            Sheet s = wb.getSheet(0);
            int row = s.getRows();
            int col = s.getColumns();
            
                int i = 1;
                int j = 0;
                Cell c1 = s.getCell(j, i);
                String departmentName = c1.getContents();
                Department d = new Department(departmentName);
                departmentList.add(d);
                j++;
                
                CourseCatalog cc = new CourseCatalog(d);
                for (int k = 1; k < 10; k++) {
                    int l = 0;
                    Cell c2 = s1.getCell(l, k);
                    String CourseName = c2.getContents();
                    l++;
                
                    Cell c3 = s1.getCell(l, k);
                    String courseNumber = c3.getContents();
                    l++;
                
                    Cell c4 = s1.getCell(l, k);
                    String creditHours = c4.getContents();
                    int credits = Integer.parseInt(creditHours);
                    
                    cc.newCourse(CourseName, CourseName, credits);
            
                }
                
                i = 2;
                j = 0;
                Cell c5 = s.getCell(j, i);
                String departmentName2 = c5.getContents();
                Department d2 = new Department(departmentName2);
                departmentList.add(d2);
                j++;
                
                CourseCatalog cc2 = new CourseCatalog(d2);
                for (int k = 1; k < 10; k++) {
                    int l = 0;
                    Cell c2 = s1.getCell(l, k);
                    String CourseName = c2.getContents();
                    l++;
                
                    Cell c3 = s1.getCell(l, k);
                    String courseNumber = c3.getContents();
                    l++;
                
                    Cell c4 = s1.getCell(l, k);
                    String creditHours = c4.getContents();
                    int credits = Integer.parseInt(creditHours);
                    
                    cc2.newCourse(CourseName, CourseName, credits);
                }
                
                i = 3;
                j = 0;
                Cell c6 = s.getCell(j, i);
                String departmentName3 = c6.getContents();
                Department d3 = new Department(departmentName3);
                departmentList.add(d3);
                j++;
                
                CourseCatalog cc3 = new CourseCatalog(d3);
                for (int k = 1; k < 10; k++) {
                    int l = 0;
                    Cell c2 = s1.getCell(l, k);
                    String CourseName = c2.getContents();
                    l++;
                
                    Cell c3 = s1.getCell(l, k);
                    String courseNumber = c3.getContents();
                    l++;
                
                    Cell c4 = s1.getCell(l, k);
                    String creditHours = c4.getContents();
                    int credits = Integer.parseInt(creditHours);
                    
                    cc3.newCourse(CourseName, CourseName, credits);
                }
            
        }catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }
    
}
