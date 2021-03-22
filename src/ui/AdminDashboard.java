/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseSchedule.CourseLoad;
import info5100.university.example.CourseSchedule.CourseOffer;
import info5100.university.example.CourseSchedule.CourseSchedule;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.AdminProfile;
import info5100.university.example.Persona.Person;
import info5100.university.example.Persona.PersonDirectory;
import info5100.university.example.Persona.StudentDirectory;
import info5100.university.example.Persona.StudentProfile;
import info5100.university.example.University;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

/**
 *
 * @author harshikag
 */
public class AdminDashboard extends javax.swing.JFrame {

    String[] semesterList = new String[]{"Fall 2021", "Spring 2021", "Summer 2021"};
    University uni;
    AdminProfile admin;
    StudentProfile student;
    Department department;
    
    ImageIcon studentLogo = new ImageIcon("adminIcon.png");
    ImageIcon homeIcon = new ImageIcon("HomeIcon.png");
    ImageIcon logoutIcon = new ImageIcon("logoutIcon.png");
    ImageIcon facultyIcon = new ImageIcon("teacherIcon.png");
    ImageIcon employerIcon = new ImageIcon("employerIcon.png");
    ImageIcon studentIcon = new ImageIcon("studentIcon.png");
    ImageIcon revenueIcon = new ImageIcon("revenue.png");
    ImageIcon departmentIcon = new ImageIcon("departmentIcon.jpeg");
    ImageIcon analysisIcon = new ImageIcon("reportIcon.png");

    public void generateData() {
        // TODO add your handling code here:
        Department department1 = new Department("Information Systems");
        Department department2 = new Department("Engineering Management");

        this.uni.getDepartmentList().add(department1);
        this.uni.getDepartmentList().add(department2);

        System.out.println("kay kat kat aahe>>>" + uni.getDepartmentList().size());

//
        Course course = department1.newCourse("app eng", "info 5100", 4, "abc");
        Course course1 = department1.newCourse("app dev", "info 5200", 4, "abc");
//
//
        CourseSchedule courseschedule = department1.newCourseSchedule("Fall 2021");
//
        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        CourseOffer courseoffer1 = courseschedule.newCourseOffer("info 5200");

        courseoffer.generatSeats(10);
        courseoffer1.generatSeats(20);
        PersonDirectory pd = department1.getPersonDirectory();
        Person person = pd.newPerson("0112303", 26.0, "harshika@gmail.com", "123-345", "Boston", "Harshika", "Harshika");
        StudentDirectory sd = department1.getStudentDirectory();
        this.student = sd.newStudentProfile(person);
        CourseLoad courseload = student.newCourseLoad("Fall 2021");

        courseload.newSeatAssignment(courseoffer);
        courseload.newSeatAssignment(courseoffer1);
    }

    public void generatePopRevData() {
        department = new Department("Information Systems");

        Course course3 = department.newCourse("app eng", "info 5100", 4, "abc");
        Course course1 = department.newCourse("app dev", "info 5200", 4, "abc");

        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");

        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
        CourseOffer courseoffer1 = courseschedule.newCourseOffer("info 5200");

        courseoffer.generatSeats(10);
        courseoffer1.generatSeats(10);

        PersonDirectory pd = department.getPersonDirectory();
        Person person = pd.newPerson("0112303", 26.0, "harshika@gmail.com", "123-345", "Boston", "Harshika", "Harshika");
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person);
        CourseLoad courseload = student.newCourseLoad("Fall2020");

        courseload.newSeatAssignment(courseoffer); //register student in class        

        // person 2
        PersonDirectory pd1 = department.getPersonDirectory();
        Person person1 = pd1.newPerson("0112304", 25.0, "Mrudul@gmail.com", "123-345", "Boston", "Mrudul", "Mrudul");
        StudentDirectory sd1 = department.getStudentDirectory();
        StudentProfile student1 = sd1.newStudentProfile(person1);
        CourseLoad courseload1 = student1.newCourseLoad("Fall2020");
        courseload1.newSeatAssignment(courseoffer1);

        // person 3
        PersonDirectory pd2 = department.getPersonDirectory();
        Person person2 = pd2.newPerson("0112305", 19.0, "Snehal@gmail.com", "123-345", "Boston", "Snehal", "Snehal");
        StudentDirectory sd2 = department.getStudentDirectory();
        StudentProfile student2 = sd2.newStudentProfile(person2);
        CourseLoad courseload2 = student2.newCourseLoad("Fall2020");
        courseload2.newSeatAssignment(courseoffer1);
    }

    /**
     * Creates new form StudentDashboardFinal
     */
    public AdminDashboard(University university, AdminProfile a) {
        initComponents();
        setResizable(false);
        setSize(1440, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logoLabel.setIcon(studentLogo);
        homeLabel.setIcon(homeIcon);
        studentImgLabel.setIcon(studentIcon);
        facultyImgLabel.setIcon(facultyIcon);
        employerImgLabel.setIcon(employerIcon);
        revenueImgLabel.setIcon(revenueIcon);
        departmentImgLabel.setIcon(departmentIcon);
        logoutImgLabel.setIcon(logoutIcon);
        AnalysisImgLabel.setIcon(analysisIcon);
        uni = university;
        admin = a;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        AdminTitle = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        HomeButton = new javax.swing.JButton();
        FacultyButton = new javax.swing.JButton();
        StudentButton = new javax.swing.JButton();
        EmployersButton = new javax.swing.JButton();
        RevenueButton = new javax.swing.JButton();
        DepartmentsButton = new javax.swing.JButton();
        AnalysisButton = new javax.swing.JButton();
        homeLabel = new javax.swing.JLabel();
        studentImgLabel = new javax.swing.JLabel();
        facultyImgLabel = new javax.swing.JLabel();
        employerImgLabel = new javax.swing.JLabel();
        revenueImgLabel = new javax.swing.JLabel();
        departmentImgLabel = new javax.swing.JLabel();
        AnalysisImgLabel = new javax.swing.JLabel();
        LogoutButton = new javax.swing.JButton();
        logoutImgLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setBackground(new java.awt.Color(239, 242, 239));

        jPanel1.setBackground(new java.awt.Color(68, 71, 68));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 436));

        AdminTitle.setBackground(new java.awt.Color(248, 248, 243));
        AdminTitle.setFont(new java.awt.Font("Malayalam Sangam MN", 0, 24)); // NOI18N
        AdminTitle.setForeground(new java.awt.Color(248, 248, 243));
        AdminTitle.setText("Admin");

        HomeButton.setBackground(new java.awt.Color(0, 0, 0));
        HomeButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        HomeButton.setForeground(new java.awt.Color(248, 248, 243));
        HomeButton.setText("Profiles");
        HomeButton.setBorderPainted(false);
        HomeButton.setContentAreaFilled(false);
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });

        FacultyButton.setBackground(new java.awt.Color(0, 0, 0));
        FacultyButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        FacultyButton.setForeground(new java.awt.Color(248, 248, 243));
        FacultyButton.setText("Faculty");
        FacultyButton.setBorderPainted(false);
        FacultyButton.setContentAreaFilled(false);
        FacultyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacultyButtonActionPerformed(evt);
            }
        });

        StudentButton.setBackground(new java.awt.Color(0, 0, 0));
        StudentButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        StudentButton.setForeground(new java.awt.Color(248, 248, 243));
        StudentButton.setText("Students");
        StudentButton.setBorderPainted(false);
        StudentButton.setContentAreaFilled(false);
        StudentButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        StudentButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        StudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentButtonActionPerformed(evt);
            }
        });

        EmployersButton.setBackground(new java.awt.Color(0, 0, 0));
        EmployersButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        EmployersButton.setForeground(new java.awt.Color(248, 248, 243));
        EmployersButton.setText("Employer");
        EmployersButton.setBorderPainted(false);
        EmployersButton.setContentAreaFilled(false);
        EmployersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployersButtonActionPerformed(evt);
            }
        });

        RevenueButton.setBackground(new java.awt.Color(0, 0, 0));
        RevenueButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        RevenueButton.setForeground(new java.awt.Color(248, 248, 243));
        RevenueButton.setText("Revenue");
        RevenueButton.setBorderPainted(false);
        RevenueButton.setContentAreaFilled(false);
        RevenueButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RevenueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RevenueButtonActionPerformed(evt);
            }
        });

        DepartmentsButton.setBackground(new java.awt.Color(0, 0, 0));
        DepartmentsButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        DepartmentsButton.setForeground(new java.awt.Color(248, 248, 243));
        DepartmentsButton.setText("Department");
        DepartmentsButton.setBorderPainted(false);
        DepartmentsButton.setContentAreaFilled(false);
        DepartmentsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DepartmentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentsButtonActionPerformed(evt);
            }
        });

        AnalysisButton.setBackground(new java.awt.Color(0, 0, 0));
        AnalysisButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        AnalysisButton.setForeground(new java.awt.Color(248, 248, 243));
        AnalysisButton.setText("Analysis");
        AnalysisButton.setBorderPainted(false);
        AnalysisButton.setContentAreaFilled(false);
        AnalysisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalysisButtonActionPerformed(evt);
            }
        });

        LogoutButton.setBackground(new java.awt.Color(0, 0, 0));
        LogoutButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        LogoutButton.setForeground(new java.awt.Color(248, 248, 243));
        LogoutButton.setText("Logout");
        LogoutButton.setBorderPainted(false);
        LogoutButton.setContentAreaFilled(false);
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AdminTitle)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(employerImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(EmployersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(homeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(HomeButton))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(facultyImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FacultyButton))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(studentImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(StudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(departmentImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(revenueImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(DepartmentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(RevenueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(AnalysisImgLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(logoutImgLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(AnalysisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(LogoutButton))))))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AdminTitle)
                    .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FacultyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(facultyImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EmployersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employerImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(revenueImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(departmentImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DepartmentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AnalysisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(AnalysisImgLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(RevenueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(239, 242, 239));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnalysisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalysisButtonActionPerformed
        // TODO add your handling code here:
        generateData();
        generatePopRevData();
        String popCourse = department.getPopularCourseBySemester("Fall2020");
        EmployerFeedback se = new EmployerFeedback(popCourse);
        jSplitPane1.setRightComponent(se);
    }//GEN-LAST:event_AnalysisButtonActionPerformed

    private void DepartmentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentsButtonActionPerformed
        // TODO add your handling code here:
        DepartmentDetails dept = new DepartmentDetails();
        jSplitPane1.setRightComponent(dept);
    }//GEN-LAST:event_DepartmentsButtonActionPerformed

    private void RevenueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RevenueButtonActionPerformed
        // TODO add your handling code here:
        generatePopRevData();
        Revenue se = new Revenue(department, semesterList);
        jSplitPane1.setRightComponent(se);
    }//GEN-LAST:event_RevenueButtonActionPerformed

    private void EmployersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployersButtonActionPerformed
        // TODO add your handling code here:
        EmployerDetails se = new EmployerDetails();
        jSplitPane1.setRightComponent(se);
    }//GEN-LAST:event_EmployersButtonActionPerformed

    private void StudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentButtonActionPerformed
        // TODO add your handling code here:
        AddStudent student = new AddStudent(uni);
        jSplitPane1.setRightComponent(student);
    }//GEN-LAST:event_StudentButtonActionPerformed

    private void FacultyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacultyButtonActionPerformed
        // TODO add your handling code here:
        AddFaculty faculty = new AddFaculty(uni);
        jSplitPane1.setRightComponent(faculty);
    }//GEN-LAST:event_FacultyButtonActionPerformed

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        // TODO add your handling code here:
        AdminHome a = new AdminHome(uni, admin);
        jSplitPane1.setRightComponent(a);
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        // TODO add your handling code here:
        LoginForm lg = new LoginForm();
        this.dispose();
        lg.setVisible(true);
    }//GEN-LAST:event_LogoutButtonActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                AdminDashboard sd = new AdminDashboard();
//                sd.setResizable(false);
//                sd.setSize(1440, 800);
//                sd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                sd.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdminTitle;
    private javax.swing.JButton AnalysisButton;
    private javax.swing.JLabel AnalysisImgLabel;
    private javax.swing.JButton DepartmentsButton;
    private javax.swing.JButton EmployersButton;
    private javax.swing.JButton FacultyButton;
    private javax.swing.JButton HomeButton;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton RevenueButton;
    private javax.swing.JButton StudentButton;
    private javax.swing.JLabel departmentImgLabel;
    private javax.swing.JLabel employerImgLabel;
    private javax.swing.JLabel facultyImgLabel;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel logoutImgLabel;
    private javax.swing.JLabel revenueImgLabel;
    private javax.swing.JLabel studentImgLabel;
    // End of variables declaration//GEN-END:variables
}
