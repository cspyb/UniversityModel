/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentProfile;
import info5100.university.example.University;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author harshikag
 */
public class CourseRegistration extends javax.swing.JPanel {

    String[] courses;
    String[] selectedCourses;
    StudentProfile student;
    Department selectedDepartment;
    CourseSchedule cs;
    JFrame rframe = new JFrame();
    String[] semesterList;
    University uni;
    List<Department> departmentList;
    JComboBox listOfCourses;
    JComboBox listOfSeachedCourses = new JComboBox();
    ImageIcon northeasternLogo = new ImageIcon("husky.png");
    HashMap<String, String> allCourses = new HashMap<String, String>();
    String searchedSemester;
    String addCourse;
    String searchedDepartment;
    
    /**
     * Creates new form CourseRegistration
     */
    public CourseRegistration(String[] semesterlist, University uni, StudentProfile sp) {
        initComponents();
        student = sp;
        semesterList = new String[semesterlist.length + 1];
        semesterList[0] = "--None--";
        for (int i = 0; i < semesterlist.length; i++) {
            semesterList[i + 1] = semesterlist[i];
        }
        listOfSeachedCourses.insertItemAt("--None", 0);
        listOfSeachedCourses.setBounds(270, 405, 240, 30);
        this.uni = uni;
        jLabel6.setIcon(northeasternLogo);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        jPanel1.setBorder(blackline);
        getSemesters();
        getDepartments();
    }

    public void getSemesters() {
        JComboBox profiles = new JComboBox(this.semesterList);
        profiles.setSelectedIndex(0);
        profiles.setBounds(270, 230, 240, 30);
        profiles.setBackground(Color.white);
        add(profiles);
        searchedSemester = "--None--";
        profiles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Get the source of the component, which is our combo
                JComboBox profiles = (JComboBox) event.getSource();

                // Print the selected items and the action command.
                searchedSemester = profiles.getSelectedItem().toString();
            }
        });
    }

    public void getDepartments() {
        List<Department> listOfDepartments = uni.getDepartmentList();
        String[] departmentLists = new String[listOfDepartments.size() + 1];
        departmentLists[0] = "--None--";
        for (int i = 0; i < listOfDepartments.size(); i++) {
            departmentLists[i + 1] = listOfDepartments.get(i).getName();
        }
        JComboBox profiles = new JComboBox(departmentLists);
//        for(int i=0;i<departmentLists.length;i++){
//            jComboBox_Department.addItem(departmentLists[i]);
//        }
       // jComboBox_Department.addItem(departmentLists[0]);
        profiles.setSelectedIndex(0);
        profiles.setBounds(270, 270, 240, 30);
        profiles.setBackground(Color.white);
        add(profiles);
        searchedDepartment = "--None--";
        profiles.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Get the source of the component, which is our combo
                // box.
                JComboBox profiles = (JComboBox) event.getSource();

                // Print the selected items and the action command.
                searchedDepartment = profiles.getSelectedItem().toString();
            }
        });
    }

    public void getSearchedCourses() {
        List<Department> listOfDepartments = uni.getDepartmentList();

        for (int i = 0; i < listOfDepartments.size(); i++) {
            String name = listOfDepartments.get(i).getName();
            if ((searchedDepartment.equalsIgnoreCase(name))) {
                for (int j = 0; j < this.semesterList.length; j++) {
                    if ((this.semesterList[j].equalsIgnoreCase(searchedSemester))) {
                        CourseSchedule cs = listOfDepartments.get(i).getCourseSchedule(this.semesterList[j]);
                        if (cs != null) {
                            errorMsgLabel.setText("");
                            removeItem();
                            courses = new String[cs.getSchedule().size()];
                            selectedCourses = new String[cs.getSchedule().size()];
                            for (int k = 0; k < cs.getSchedule().size(); k++) {
                                this.allCourses.put(cs.getSchedule().get(k).getCourseName(), cs.getSchedule().get(k).getCourseNumber());
                                courses[k] = cs.getSchedule().get(k).getCourseName();
                                selectedCourses[k] = courses[k];
                                listOfSeachedCourses.insertItemAt(courses[k], k + 1);
                            }
                            listOfSeachedCourses.getItemAt(0);
                            listOfSeachedCourses.setSelectedIndex(0);
                            listOfSeachedCourses.setBounds(270, 430, 240, 30);
                            listOfSeachedCourses.setBackground(Color.white);
                            add(listOfSeachedCourses);

                            listOfSeachedCourses.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent event) {
                                    // Get the source of the component, which is our combo
                                    JComboBox listOfSeachedCourses = (JComboBox) event.getSource();
                                    addCourse = listOfSeachedCourses.getSelectedItem().toString();
                                }
                            });
                        } else if (cs == null) {
                            removeItem();
                            errorMsgLabel.setText("No courses available for selected semester and department");
                        }
                    }
                }
            }
        }
    }

    public void removeItem() {
        if (listOfSeachedCourses != null && courses != null && courses.length > 0) {
            for (int i = 0; i < courses.length; i++) {
                listOfSeachedCourses.removeItem(courses[i]);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AddCourseBtn1 = new javax.swing.JButton();
        SemesterText2 = new javax.swing.JLabel();
        SearchButton1 = new javax.swing.JButton();
        SemesterText3 = new javax.swing.JLabel();
        RevenueTitle3 = new javax.swing.JLabel();
        SubmitButton2 = new javax.swing.JButton();
        DepartmentText1 = new javax.swing.JLabel();
        errorMsgLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel6.setText("jLabel6");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("STUDENT MANAGEMENT SYSTEM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(165, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );

        AddCourseBtn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddCourseBtn1.setText("Add a course");
        AddCourseBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCourseBtn1ActionPerformed(evt);
            }
        });

        SemesterText2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SemesterText2.setText("Available Courses");
        SemesterText2.setLocation(new java.awt.Point(0, 420));

        SearchButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SearchButton1.setText("Search");
        SearchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButton1ActionPerformed(evt);
            }
        });

        SemesterText3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SemesterText3.setText("Semester");
        SemesterText3.setLocation(new java.awt.Point(0, 215));

        RevenueTitle3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        RevenueTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RevenueTitle3.setText("Register a course");
        RevenueTitle3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        SubmitButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SubmitButton2.setText("Clear");
        SubmitButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButton2ActionPerformed(evt);
            }
        });

        DepartmentText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DepartmentText1.setText("Department");
        DepartmentText1.setLocation(new java.awt.Point(0, 255));
        DepartmentText1.setSize(new java.awt.Dimension(0, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SearchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SubmitButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(AddCourseBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorMsgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SemesterText2)
                            .addComponent(DepartmentText1)
                            .addComponent(SemesterText3))))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(RevenueTitle3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(SemesterText3)
                .addGap(18, 18, 18)
                .addComponent(DepartmentText1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchButton1)
                    .addComponent(SubmitButton2))
                .addGap(18, 18, 18)
                .addComponent(errorMsgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(SemesterText2)
                .addGap(24, 24, 24)
                .addComponent(AddCourseBtn1)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(170, 170, 170)
                    .addComponent(RevenueTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(468, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddCourseBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCourseBtn1ActionPerformed
        // TODO add your handling code here:
        List<Department> listOfDepartments = uni.getDepartmentList();
        Department dept = selectedDepartment;
        StudentProfile sp = student;
        CourseLoad cl = sp.getCurrentCourseLoad();
        for (int i = 0; i < listOfDepartments.size(); i++) {
            System.out.println(listOfDepartments.get(i).getStudentDirectory() +  " abc " + student.getId() + " seacrhedDepartment" + student.getId());
            if (listOfDepartments.get(i).getStudentDirectory().findStudent(student.getId()) == student) {
                dept = listOfDepartments.get(i);
                System.out.println("dept..." + dept.getName() + " course " + addCourse + "seacrhedDepartment" + searchedDepartment);
                if(dept.getName().equalsIgnoreCase(searchedDepartment)) {
                    CourseSchedule cs = dept.getMastercoursecatalog().get(searchedSemester);
                    this.allCourses.get(addCourse);
                    System.out.println(this.allCourses.get(addCourse)+ "...courses.....");
                    CourseOffer co = cs.getCourseOfferByNumber(this.allCourses.get(addCourse));
                    co.assignEmptySeat(cl);
                    System.out.println(student.getTranscript() + "registration");
                    JOptionPane.showMessageDialog(null, "Course added successfully.");
                    return;
                } else {
                    System.out.println("mis match in department");
                }
            } else {
                System.out.println(" student not in same department");
            }
            
        }
        
    }//GEN-LAST:event_AddCourseBtn1ActionPerformed

    private void SearchButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButton1ActionPerformed
        // TODO add your handling code here:
        if (searchedDepartment.contentEquals("--None--") || searchedSemester.contentEquals("--None--")) {
            errorMsgLabel.setText("Kindly select a semester and department inorder to register for courses");
        } else {
            getSearchedCourses();
            addCourse = null;
        }
    }//GEN-LAST:event_SearchButton1ActionPerformed

    private void SubmitButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubmitButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCourseBtn1;
    private javax.swing.JLabel DepartmentText1;
    private javax.swing.JLabel RevenueTitle3;
    private javax.swing.JButton SearchButton1;
    private javax.swing.JLabel SemesterText2;
    private javax.swing.JLabel SemesterText3;
    private javax.swing.JButton SubmitButton2;
    private javax.swing.JLabel errorMsgLabel;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
