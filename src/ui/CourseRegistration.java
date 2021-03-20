/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.PersonDirectory;
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
import javax.swing.border.Border;

/**
 *
 * @author harshikag
 */
public class CourseRegistration extends javax.swing.JPanel {

    String[] courses;
    String[] selectedCourses;
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
    public CourseRegistration(String[] semesterlist, University uni) {
        initComponents();
        semesterList = new String[semesterlist.length + 1];
        semesterList[0] = "--None--";
        for (int i = 0; i < semesterlist.length; i++) {
            semesterList[i + 1] = semesterlist[i];
        }
        listOfSeachedCourses.insertItemAt("--None", 0);
//        semesterList = semesterlist;
        this.uni = uni;
        jLabel6.setIcon(northeasternLogo);
        Border blackline = BorderFactory.createLineBorder(Color.black);
        jPanel1.setBorder(blackline);
        getSemesters();
        getDepartments();
//        getAllCourses();
    }

    public void getSemesters() {
        JComboBox profiles = new JComboBox(this.semesterList);
        profiles.setSelectedIndex(0);
        profiles.setBounds(170, 205, 240, 30);
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
        profiles.setSelectedIndex(0);
        profiles.setBounds(170, 245, 240, 30);
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
//                System.out.println(listOfDepartments.get(i).getName() + " department ");
                for (int j = 0; j < this.semesterList.length; j++) {
                    if ((this.semesterList[j].equalsIgnoreCase(searchedSemester))) {
                        CourseSchedule cs = listOfDepartments.get(i).getCourseSchedule(this.semesterList[j]);
                        if (cs != null) {
                            errorMsgLabel.setText("");
                            removeItem();
//                            if (courses != null && courses.length <= 0) {
//                                listOfSeachedCourses.insertItemAt("--None", 0);
//                            }
                            courses = new String[cs.getSchedule().size()];
                            selectedCourses = new String[cs.getSchedule().size()];
                            for (int k = 0; k < cs.getSchedule().size(); k++) {
                                this.allCourses.put(cs.getSchedule().get(k).getCourseName(), cs.getSchedule().get(k).getCourseNumber());
                                courses[k] = cs.getSchedule().get(k).getCourseName();

                            }
                            System.out.println(listOfSeachedCourses.getItemAt(0));
                            for (i = 0; i < courses.length; i++) {
                                selectedCourses[i] = courses[i];
                                listOfSeachedCourses.insertItemAt(courses[i], i + 1);
                            }

//                            listOfSeachedCourses = new JComboBox(courses);
                            listOfSeachedCourses.getItemAt(0);
                            listOfSeachedCourses.setSelectedIndex(0);
                            listOfSeachedCourses.setBounds(170, 420, 240, 30);
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
//                            String[] arr = new String[1];
//                            arr[0] = "--None--";
//                            JComboBox iprofiles = new JComboBox(arr);
//                            iprofiles.setSelectedIndex(0);
//                            iprofiles.setBounds(170,420,240,30);
//                            iprofiles.setBackground(Color.white);
//                            add(iprofiles);
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

        TitleText = new javax.swing.JLabel();
        SemesterText = new javax.swing.JLabel();
        DepartmentText = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        SearchButton = new javax.swing.JButton();
        CourseIdText = new javax.swing.JLabel();
        KeywordText = new javax.swing.JLabel();
        SubmitButton1 = new javax.swing.JButton();
        CourseIdField = new javax.swing.JTextField();
        KeywordField = new javax.swing.JTextField();
        SemesterText1 = new javax.swing.JLabel();
        AddCourseBtn = new javax.swing.JButton();
        errorMsgLabel = new javax.swing.JLabel();

        TitleText.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        TitleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleText.setText("Register for a course");

        SemesterText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SemesterText.setText("Semester");

        DepartmentText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DepartmentText.setText("Department");

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
                    .addContainerGap(29, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        CourseIdText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CourseIdText.setText("Course Id");

        KeywordText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        KeywordText.setText("Keyword");

        SubmitButton1.setText("Clear");
        SubmitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButton1ActionPerformed(evt);
            }
        });

        SemesterText1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SemesterText1.setText("Available Courses");

        AddCourseBtn.setText("Add a course");
        AddCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCourseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TitleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(AddCourseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(SemesterText1)
                                        .addGap(29, 29, 29)
                                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addComponent(SubmitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(errorMsgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 278, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(SemesterText)
                                .addComponent(DepartmentText)
                                .addComponent(KeywordText)
                                .addComponent(CourseIdText))
                            .addGap(43, 43, 43)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CourseIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(KeywordField, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(273, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(TitleText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchButton)
                    .addComponent(SubmitButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorMsgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SemesterText1)
                .addGap(31, 31, 31)
                .addComponent(AddCourseBtn)
                .addGap(66, 66, 66))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(70, 70, 70)
                    .addComponent(SemesterText)
                    .addGap(18, 18, 18)
                    .addComponent(DepartmentText)
                    .addGap(23, 23, 23)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(KeywordText)
                        .addComponent(KeywordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CourseIdText)
                        .addComponent(CourseIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(302, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed

        if (searchedDepartment.contentEquals("--None--") || searchedSemester.contentEquals("--None--")) {
            errorMsgLabel.setText("Kindly select a semester and department inorder to register for courses");
        } else {
            getSearchedCourses();
            addCourse = null;
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void SubmitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubmitButton1ActionPerformed

    private void AddCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCourseBtnActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_AddCourseBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCourseBtn;
    private javax.swing.JTextField CourseIdField;
    private javax.swing.JLabel CourseIdText;
    private javax.swing.JLabel DepartmentText;
    private javax.swing.JTextField KeywordField;
    private javax.swing.JLabel KeywordText;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel SemesterText;
    private javax.swing.JLabel SemesterText1;
    private javax.swing.JButton SubmitButton1;
    private javax.swing.JLabel TitleText;
    private javax.swing.JLabel errorMsgLabel;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
