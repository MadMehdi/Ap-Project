import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Management {

    public Management() {
        BaseManagement baseManagement = new BaseManagement();
    }

    // Management
    JFrame managementFrame = new JFrame("Management");
    JButton staffMButton = new JButton("Staff Management");
    JButton patientsMButton = new JButton("Patients Management");

    // Staff Management
    JFrame staffMFrame = new JFrame("Staff Management");
    JButton addStaffButton = new JButton("Add Staff");
    JButton editStaffButton = new JButton("Edit Staff");
    JButton deleteStaffButton = new JButton("Delete Staff");
    JButton searchStaffButton = new JButton("Search Staff");
    JButton backButton = new JButton("Back");

    // Patience Management
    JFrame patientsMFrame = new JFrame("Patients Management");
    JButton addPatientsButton = new JButton("Add Patience");
    JButton editPatientsButton = new JButton("Edit Patience");
    JButton deletePatientsButton = new JButton("Delete Patience");
    JButton searchPatientsButton = new JButton("Search Patience");
    JButton viewPatientsButton = new JButton("View Patience's List");
    JButton viewRoomsButton = new JButton("View Available Rooms");



    public class BaseManagement implements ActionListener {
        public BaseManagement(){
            managementFrame.setSize(500,500);
            managementFrame.setLocationRelativeTo(null);


            staffMButton.setBounds(0,0,150,30);
            patientsMButton.setBounds(0,30,150,30);

            managementFrame.add(staffMButton);
            managementFrame.add(patientsMButton);

            managementFrame.setLayout(null);
            managementFrame.setVisible(true);
            managementFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            staffMButton.addActionListener(this);
            patientsMButton.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            managementFrame.setVisible(false);
            if (e.getSource() == staffMButton) {
                StaffManagement staffManagement = new StaffManagement();
            }
            else if (e.getSource() == patientsMButton) {
                PatientsManagement patienceManagement = new PatientsManagement();
            }
        }
    }

    public class StaffManagement implements ActionListener {
        public StaffManagement(){
            staffMFrame.setSize(500,500);
            staffMFrame.setLocationRelativeTo(null);

            addStaffButton.setBounds(0,0,150,30);
            editStaffButton.setBounds(0,30,150,30);
            deleteStaffButton.setBounds(0,60,150,30);
            searchStaffButton.setBounds(0,90,150,30);
            backButton.setBounds(0,120,150,30);

            staffMFrame.add(addStaffButton);
            staffMFrame.add(editStaffButton);
            staffMFrame.add(deleteStaffButton);
            staffMFrame.add(searchStaffButton);
            staffMFrame.add(backButton);

            addStaffButton.addActionListener(this);
            editStaffButton.addActionListener(this);
            deleteStaffButton.addActionListener(this);
            searchStaffButton.addActionListener(this);
            backButton.addActionListener(this);

            staffMFrame.setLayout(null);
            staffMFrame.setVisible(true);
            staffMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            staffMFrame.setVisible(false);
            if (e.getSource() == addStaffButton) {
                AddStaffClass addStaffClass = new AddStaffClass();
            }
            else if (e.getSource() == editStaffButton) {
                EditStaffClass editStaffClass = new EditStaffClass();
            }
            else if (e.getSource() == deleteStaffButton) {
                DeleteStaffClass deleteStaffClass = new DeleteStaffClass();
            }
            else if (e.getSource() == searchStaffButton) {
                SearchStaffClass searchStaffClass = new SearchStaffClass();
            }
            else if (e.getSource() == backButton) {
                managementFrame.setVisible(true);
            }
        }
    }

    public class PatientsManagement implements ActionListener {

        public PatientsManagement(){
            patientsMFrame.setSize(500,500);
            patientsMFrame.setLocationRelativeTo(null);

            addPatientsButton.setBounds(0,0,150,30);
            editPatientsButton.setBounds(0,30,150,30);
            deletePatientsButton.setBounds(0,60,150,30);
            searchPatientsButton.setBounds(0,90,150,30);
            viewPatientsButton.setBounds(0,120,150,30);
            viewRoomsButton.setBounds(0,150,150,30);
            backButton.setBounds(0,180,150,30);

            addPatientsButton.addActionListener(this);
            editPatientsButton.addActionListener(this);
            deletePatientsButton.addActionListener(this);
            searchPatientsButton.addActionListener(this);
            viewPatientsButton.addActionListener(this);
            viewRoomsButton.addActionListener(this);
            backButton.addActionListener(this);

            patientsMFrame.add(addPatientsButton);
            patientsMFrame.add(editPatientsButton);
            patientsMFrame.add(deletePatientsButton);
            patientsMFrame.add(searchPatientsButton);
            patientsMFrame.add(viewPatientsButton);
            patientsMFrame.add(viewRoomsButton);
            patientsMFrame.add(backButton);

            patientsMFrame.setLayout(null);
            patientsMFrame.setVisible(true);
            patientsMFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            patientsMFrame.setVisible(false);
            if (e.getSource() == addPatientsButton) {
                AddPatientsClass addPatientsClass = new AddPatientsClass();
            }
            else if (e.getSource() == editPatientsButton) {
                EditPatientsClass editPatience = new EditPatientsClass();
            }
            else if (e.getSource() == deletePatientsButton) {
                DeletePatientsClass deletePatienceClass = new DeletePatientsClass();
            }
            else if (e.getSource() == searchPatientsButton) {
                SearchPatientsClass searchPatienceClass = new SearchPatientsClass();
            }

            else if (e.getSource() == viewPatientsButton) {
                ViewPatientsList displayTableData = new ViewPatientsList();
            }
            else if (e.getSource() == viewRoomsButton) {}

            else if (e.getSource() == backButton) {
                managementFrame.setVisible(true);
            }

        }
    }

    public class AddPatientsClass {
        String[] patientsSection = {"Ofooni", "Atfal", "ICU"};
        JComboBox patientsbox = new JComboBox(patientsSection);
        JLabel patientsboxlabel = new JLabel("Section:");
        JLabel ageEx=new JLabel("example:21");
        JFrame reception = new JFrame("reception");
        JButton register= new JButton("Register");
        JLabel nameL=new JLabel("Name:");
        JLabel ageL=new JLabel("age of patient:");
        JLabel National_codeL=new JLabel("National code:");
        JLabel example1=new JLabel("example:Amir");
        JTextField ageT=new JTextField();
        JTextField nameT=new JTextField();
        JTextField National_codeT=new JTextField();
        JLabel National_code_example=new JLabel("example:22701649997");
        JTextField history=new JTextField();
        JLabel historyL=new JLabel("History of patient:");
        JButton backButton=new JButton("Back");
        JLabel statusLabel = new JLabel();

        void pageAdding(){

        }
        public class patient_reception implements ActionListener, Adder{
            patient_reception(){
                adding();
                pageAttribute();

            }
            @Override
            public void adding(){
                reception.add(ageEx);
                reception.add(historyL);
                reception.add(history);
                reception.add(ageL);
                reception.add(National_code_example);
                reception.add(example1);
                reception.add(register);
                reception.add(nameL);
                reception.add(ageL);
                reception.add(National_codeL);
                reception.add(ageT);
                reception.add(nameT);
                reception.add(National_codeT);
                reception.add(history);
                reception.add(patientsbox);
                reception.add(patientsboxlabel);
                reception.add(register);
                reception.add(backButton);
                reception.add(statusLabel);

            }
            @Override
            public void pageAttribute(){
                reception.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reception.setLocationRelativeTo(null);
                reception.setLayout(null);
                reception.getContentPane().setBackground(Color.CYAN);
                reception.setSize(500,500);
                patientsbox.setBounds(165,120,100,25);
                patientsboxlabel.setBounds(115,125,100,15);
                nameL.setBounds(125,150,60,15);
                nameT.setBounds(165,150,100,15);
                ageT.setBounds(165,170,100,15);
                ageEx.setBounds(270,170,80,15);
                National_codeT.setBounds(165,190,100,15);
                example1.setBounds(270,150,100,15);
                National_code_example.setBounds(270,190,124,15);
                ageL.setBounds(80,170,90,15);
                history.setBounds(165,225,100,50);
                historyL.setBounds(65,225,100,15);
                National_codeL.setBounds(80,190,90,15);
                register.setBounds(165,290,100,30);
                backButton.setBounds(165,330,100,20);
                statusLabel.setBounds(140,360,150,30);


                patientsbox.addActionListener(this);
                backButton.addActionListener(this);
                register.addActionListener(this);

                reception.setVisible(true);

            }


            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== register){
                    String patientsSection = patientsbox.getSelectedItem().toString();
                    String patientsName = nameT.getText();
                    int patientsAge = Integer.parseInt(ageT.getText());
                    long patientsNationalCode = Long.parseLong(National_codeT.getText());
                    String patientsHistory = history.getText();

                    PatientsDB.DbAddPatients addPatients = new PatientsDB.DbAddPatients(patientsSection, patientsName, patientsAge,
                            patientsNationalCode, patientsHistory);

                if (!addPatients.getAppError()) {
                    nameT.setText("");
                    ageT.setText("");
                    National_codeT.setText("");
                    history.setText("");

                    statusLabel.setText("Patient Added Successfully");
                    statusLabel.setForeground(Color.GREEN);
                } else if (addPatients.getAppError()) {
                    statusLabel.setText("Patient Added Failed");
                    statusLabel.setForeground(Color.RED);

                }


                } else if (e.getSource()==backButton) {
                    reception.setVisible(false);
                    patientsMFrame.setVisible(true);
                }

            }
        }
        AddPatientsClass(){
            patient_reception mohsen=new patient_reception();
        }

    }

    public class AddStaffClass {
        String[] patienceSection = {"Doctor","Nurse"};
        JComboBox staffComboBox = new JComboBox(patienceSection);
        JLabel staffBoxLabel = new JLabel("Job:");
        JLabel ageEx=new JLabel("example:21");
        JFrame addStaffFrame = new JFrame("Add Staff");
        JButton registerButton = new JButton("Register");
        JLabel nameL=new JLabel("Name:");
        JLabel ageL=new JLabel("age of staff:");
        JLabel National_codeL=new JLabel("National code:");
        JLabel example1=new JLabel("example:Amir");
        JTextField ageT=new JTextField();
        JTextField nameT=new JTextField();
        JTextField National_codeT=new JTextField();
        JLabel National_code_example=new JLabel("example:22701649997");
        JButton backButton=new JButton("Back");
        JLabel statusLabel = new JLabel();


        void pageAdding(){

        }
        public class patient_reception implements ActionListener, Adder{


            patient_reception(){
                adding();
                pageAttribute();

            }
            @Override
            public void adding(){
                addStaffFrame.add(ageEx);
                addStaffFrame.add(ageL);
                addStaffFrame.add(National_code_example);
                addStaffFrame.add(example1);
                addStaffFrame.add(registerButton);
                addStaffFrame.add(nameL);
                addStaffFrame.add(ageL);
                addStaffFrame.add(National_codeL);
                addStaffFrame.add(ageT);
                addStaffFrame.add(nameT);
                addStaffFrame.add(National_codeT);
                addStaffFrame.add(staffComboBox);
                addStaffFrame.add(staffBoxLabel);
                addStaffFrame.add(registerButton);
                addStaffFrame.add(backButton);
                addStaffFrame.add(statusLabel);

            }
            @Override
            public void pageAttribute(){
                addStaffFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                addStaffFrame.setLocationRelativeTo(null);
                addStaffFrame.setLayout(null);
                addStaffFrame.getContentPane().setBackground(Color.CYAN);
                addStaffFrame.setSize(500,500);
                staffComboBox.setBounds(165,120,100,25);
                staffBoxLabel.setBounds(135,125,100,15);
                nameL.setBounds(125,150,60,15);
                nameT.setBounds(165,150,100,15);
                ageT.setBounds(165,170,100,15);
                ageEx.setBounds(270,170,80,15);
                National_codeT.setBounds(165,190,100,15);
                example1.setBounds(270,150,100,15);
                National_code_example.setBounds(270,190,124,15);
                ageL.setBounds(95,170,90,15);
                National_codeL.setBounds(80,190,90,15);
                registerButton.setBounds(165,210,100,30);
                backButton.setBounds(165,245,100,20);
                statusLabel.setBounds(140,280,100,30);


                staffComboBox.addActionListener(this);
                registerButton.addActionListener(this);
                backButton.addActionListener(this);

                addStaffFrame.setVisible(true);

            }


            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource()== registerButton){
                    String staffJob = staffComboBox.getSelectedItem().toString();
                    String staffName = nameT.getText();
                    int staffAge = Integer.valueOf(ageT.getText());
                    long staffNationalCode = Long.valueOf(National_codeT.getText());
                    StaffDB.DbAddStaff staffDb = new StaffDB.DbAddStaff(staffName, staffAge, staffJob, staffNationalCode);

                if (!staffDb.appError()) {
                    nameT.setText("");
                    ageT.setText("");
                    National_codeT.setText("");

                    statusLabel.setText("Staff Added Successfully");
                    statusLabel.setForeground(Color.GREEN);
                } else if (staffDb.appError()) {
                    statusLabel.setText("Staff Added Failed");
                    statusLabel.setForeground(Color.RED);
                }
                }
                else if (e.getSource()==backButton) {
                    addStaffFrame.setVisible(false);
                    staffMFrame.setVisible(true);
                }

            }
        }
        AddStaffClass(){
            patient_reception mohsen=new patient_reception();
        }

    }

    public class EditStaffClass {
        String[] patienceSection = {"Doctor","Nurse"};
        JComboBox staffComboBox = new JComboBox(patienceSection);
        JLabel staffBoxLabel = new JLabel("Job:");
        JLabel ageEx=new JLabel("example:21");
        JFrame addStaffFrame = new JFrame("Edit Staff");
        JButton editButton = new JButton("Edit");
        JLabel nameL=new JLabel("Name:");
        JLabel ageL=new JLabel("age of staff:");
        JLabel National_codeL=new JLabel("National code:");
        JLabel example1=new JLabel("example:Amir");
        JTextField ageT=new JTextField();
        JTextField nameT=new JTextField();
        JTextField National_codeT=new JTextField();
        JLabel National_code_example=new JLabel("example:22701649997");
        JButton backButton=new JButton("Back");
        JButton searchButton = new JButton("Search");
        JLabel statusLabel = new JLabel();


        void pageAdding(){

        }
        public class patient_reception implements ActionListener, Adder{


            patient_reception(){
                adding();
                pageAttribute();

            }
            @Override
            public void adding(){
                addStaffFrame.add(ageEx);
                addStaffFrame.add(ageL);
                addStaffFrame.add(National_code_example);
                addStaffFrame.add(example1);
                addStaffFrame.add(editButton);
                addStaffFrame.add(nameL);
                addStaffFrame.add(ageL);
                addStaffFrame.add(National_codeL);
                addStaffFrame.add(ageT);
                addStaffFrame.add(nameT);
                addStaffFrame.add(National_codeT);
                addStaffFrame.add(staffComboBox);
                addStaffFrame.add(staffBoxLabel);
                addStaffFrame.add(editButton);
                addStaffFrame.add(backButton);
                addStaffFrame.add(searchButton);
                addStaffFrame.add(statusLabel);

            }
            @Override
            public void pageAttribute(){
                addStaffFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                addStaffFrame.setLocationRelativeTo(null);
                addStaffFrame.setLayout(null);
                addStaffFrame.getContentPane().setBackground(Color.magenta);
                addStaffFrame.setSize(500,500);
                staffComboBox.setBounds(165,175,100,25);
                staffBoxLabel.setBounds(135,180,100,15);
                nameL.setBounds(125,135,60,15);
                nameT.setBounds(165,135,100,15);
                example1.setBounds(270,135,100,15);
                ageT.setBounds(165,155,100,15);
                ageEx.setBounds(270,155,80,15);
                ageL.setBounds(95,155,90,15);
                National_codeT.setBounds(165,80,100,15);
                National_code_example.setBounds(270,80,124,15);
                National_codeL.setBounds(80,80,150,15);
                searchButton.setBounds(165,105,100,20);
                editButton.setBounds(165,210,100,30);
                backButton.setBounds(165,245,100,20);
                statusLabel.setBounds(165,280,100,30);

                staffComboBox.addActionListener(this);
                searchButton.addActionListener(this);
                editButton.addActionListener(this);
                backButton.addActionListener(this);

                addStaffFrame.setVisible(true);

            }


            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource()== searchButton) {
                    StaffDB.DbEditStaff aa = new StaffDB.DbEditStaff(Long.valueOf(National_codeT.getText()));
                    StaffDB.DbDeleteStaff ab = new StaffDB.DbDeleteStaff(Long.valueOf(National_codeT.getText()));
                    if (!ab.getAppError()) {
                        nameT.setText(aa.getName());
                        ageT.setText(String.valueOf(aa.getAge()));
                        staffComboBox.setSelectedItem(aa.getJob().toString());

                        statusLabel.setText("Staff Found Successfully");
                        statusLabel.setForeground(Color.GREEN);
                    } else if (ab.getAppError()) {
                        statusLabel.setForeground(Color.RED);
                        statusLabel.setText("Staff Not Found");

                    }
                }

                else if(e.getSource()== editButton){
                    String staffJob = staffComboBox.getSelectedItem().toString();
                    String staffName = nameT.getText();
                    int staffAge = Integer.valueOf(ageT.getText());
                    long staffNationalCode = Long.valueOf(National_codeT.getText());
                    StaffDB.DbAddStaff staffDb = new StaffDB.DbAddStaff(staffName, staffAge, staffJob, staffNationalCode);


                    if (!staffDb.appError()) {
                        nameT.setText("");
                        ageT.setText("");
                        National_codeT.setText("");

                        statusLabel.setText("Staff Edited Successfully");
                        statusLabel.setForeground(Color.GREEN);
                    } else if (staffDb.appError()) {
                        statusLabel.setText("Staff FAiled to edit");
                        statusLabel.setForeground(Color.RED);

                    }
                }
                else if (e.getSource()==backButton) {
                    addStaffFrame.setVisible(false);
                    staffMFrame.setVisible(true);
                }

            }
        }
        EditStaffClass(){
            EditStaffClass.patient_reception mohsen=new EditStaffClass.patient_reception();
        }

    }

    public class EditPatientsClass {
        String[] patientsSection = {"Ofooni", "Atfal", "ICU"};
        JComboBox patientsbox = new JComboBox(patientsSection);
        JLabel patientsboxlabel = new JLabel("Section:");
        JLabel ageEx=new JLabel("example:21");
        JFrame reception = new JFrame("Edit Patients");
        JButton editButton = new JButton("Edit");
        JLabel nameL=new JLabel("Name:");
        JLabel ageL=new JLabel("age of patient:");
        JLabel National_codeL=new JLabel("National code:");
        JLabel example1=new JLabel("example:Amir");
        JTextField ageT=new JTextField();
        JTextField nameT=new JTextField();
        JTextField National_codeT=new JTextField();
        JLabel National_code_example=new JLabel("example:22701649997");
        JTextField history=new JTextField();
        JLabel historyL=new JLabel("History of patient:");
        JButton backButton=new JButton("Back");
        JButton searchButton=new JButton("Search");
        JLabel statusLAbel = new JLabel();

        void pageAdding(){

        }
        public class patient_reception implements ActionListener, Adder{
            patient_reception(){
                adding();
                pageAttribute();

            }
            @Override
            public void adding(){
                reception.add(ageEx);
                reception.add(historyL);
                reception.add(history);
                reception.add(ageL);
                reception.add(National_code_example);
                reception.add(example1);
                reception.add(editButton);
                reception.add(nameL);
                reception.add(ageL);
                reception.add(National_codeL);
                reception.add(ageT);
                reception.add(nameT);
                reception.add(National_codeT);
                reception.add(history);
                reception.add(patientsbox);
                reception.add(patientsboxlabel);
                reception.add(editButton);
                reception.add(backButton);
                reception.add(searchButton);
                reception.add(statusLAbel);

            }
            @Override
            public void pageAttribute(){
                reception.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reception.setLocationRelativeTo(null);
                reception.setLayout(null);
                reception.getContentPane().setBackground(Color.CYAN);
                reception.setSize(500,500);
                patientsbox.setBounds(165,190,100,25);
                patientsboxlabel.setBounds(115,195,100,15);
                nameL.setBounds(125,150,60,15);
                nameT.setBounds(165,150,100,15);
                example1.setBounds(270,150,100,15);
                ageT.setBounds(165,170,100,15);
                ageEx.setBounds(270,170,80,15);
                ageL.setBounds(80,170,90,15);
                history.setBounds(165,225,100,50);
                historyL.setBounds(65,225,100,15);
                National_codeT.setBounds(165,100,100,15);
                National_code_example.setBounds(270,100,124,15);
                National_codeL.setBounds(80,100,90,15);
                searchButton.setBounds(165,120,100,20);
                editButton.setBounds(165,290,100,30);
                backButton.setBounds(165,330,100,20);
                statusLAbel.setBounds(145,370,100,30);


                patientsbox.addActionListener(this);
                backButton.addActionListener(this);
                editButton.addActionListener(this);
                searchButton.addActionListener(this);

                reception.setVisible(true);

            }


            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== searchButton) {
                    PatientsDB.DbEditPatients aa = new PatientsDB.DbEditPatients(Long.valueOf(National_codeT.getText()));
                    PatientsDB.DbDeletePatients ab = new PatientsDB.DbDeletePatients(Long.valueOf(National_codeT.getText()));

                    if (!aa.getAppError()) {
                        nameT.setText(aa.getName());
                        ageT.setText(String.valueOf(aa.getAge()));
                        history.setText(aa.getHistory());

                        statusLAbel.setText("Patient Found Successfully");
                        statusLAbel.setForeground(Color.GREEN);
                    } else if (ab.appError) {
                        statusLAbel.setForeground(Color.RED);
                        statusLAbel.setText("Patient Not Found");

                    }
                }

                else if(e.getSource()== editButton){
                    String patientsSection = patientsbox.getSelectedItem().toString();
                    String patientsName = nameT.getText();
                    int patientsAge = Integer.parseInt(ageT.getText());
                    long patientsNationalCode = Long.parseLong(National_codeT.getText());
                    String patientsHistory = history.getText();

                    PatientsDB.DbAddPatients addPatients = new PatientsDB.DbAddPatients(patientsSection, patientsName, patientsAge,
                            patientsNationalCode, patientsHistory);

                    if (!addPatients.getAppError()) {
                        patientsbox.removeAllItems();
                        nameT.setText("");
                        ageT.setText("");
                        National_codeT.setText("");
                        history.setText("");

                        statusLAbel.setText("Patient Edited Successfully");
                        statusLAbel.setForeground(Color.GREEN);
                    } else if (addPatients.getAppError()) {
                        statusLAbel.setForeground(Color.RED);
                        statusLAbel.setText("Patient Failed to Edit");

                    }
                } else if (e.getSource()==backButton) {
                    reception.setVisible(false);
                    patientsMFrame.setVisible(true);
                }

            }
        }
        EditPatientsClass(){
            patient_reception mohsen=new patient_reception();
        }

    }

    public class DeleteStaffClass implements ActionListener, Adder {
        DeleteStaffClass(){
            adding();
            pageAttribute();
        }
        JFrame del=new JFrame("Fire Personal");
        JLabel National_codeL=new JLabel("National code:");
        JTextField National_codeT  =  new JTextField();
        JLabel National_codeEx=new JLabel("example: 2270164997");
        JButton deleteButton =new JButton("Delete");
        JButton backButton =new JButton("Back");
        JLabel statusLabel = new JLabel();

        @Override
        public void adding(){
            del.add(deleteButton);
            del.add(National_codeT);
            del.add(National_codeL);
            del.add(National_codeEx);
            del.add(deleteButton);
            del.add(backButton);
            del.add(statusLabel);

        }
        @Override
        public void pageAttribute(){

            del.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            del.setLocationRelativeTo(null);
            del.setLayout(null);
            del.getContentPane().setBackground(Color.GREEN);
            del.setSize(500,500);
            National_codeL.setBounds(98,150,90,15);
            National_codeT.setBounds(180,150,70,15);
            National_codeEx.setBounds(260,150,120,15);
            deleteButton.setBounds(180,180,100,25);
            backButton.setBounds(180,220,100,25);
            statusLabel.setBounds(180,260,100,30);
            del.setVisible(true);

            deleteButton.addActionListener(this);
            backButton.addActionListener(this);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()== deleteButton) {
                StaffDB.DbDeleteStaff deleteStaff = new StaffDB.DbDeleteStaff(Long.valueOf(National_codeT.getText()));
                if (!deleteStaff.getAppError()) {
                    statusLabel.setText("Staff Deleted Successfully");
                    statusLabel.setForeground(Color.GREEN);
                } else if (deleteStaff.getAppError()) {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Staff Failed to Delete");
                }
            } else if (e.getSource()== backButton) {
                del.setVisible(false);
                staffMFrame.setVisible(true);
            }
        }
    }

    public class DeletePatientsClass implements ActionListener, Adder{
        DeletePatientsClass(){
            adding();
            pageAttribute();
        }
        JFrame del=new JFrame("Discharge");
        JLabel National_codeL=new JLabel("National code:");
        JTextField National_codeT  =  new JTextField();
        JLabel National_codeEx=new JLabel("example: 2270164997");
        JButton dischargeButton =new JButton("Discharge");
        JLabel statusLabel = new JLabel();

        @Override
        public void adding(){
            del.add(dischargeButton);
            del.add(National_codeT);
            del.add(National_codeL);
            del.add(National_codeEx);
            del.add(statusLabel);

        }
        @Override
        public void pageAttribute(){

            del.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            del.setLocationRelativeTo(null);
            del.setLayout(null);
            del.getContentPane().setBackground(Color.GREEN);
            del.setSize(500,500);
            National_codeL.setBounds(98,150,90,15);
            National_codeT.setBounds(180,150,70,15);
            National_codeEx.setBounds(260,150,120,15);
            dischargeButton.setBounds(170,180,110,35);
            statusLabel.setBounds(170,220,100,30);
            del.setVisible(true);

            dischargeButton.addActionListener(this);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()== dischargeButton) {
                PatientsDB.DbDeletePatients deletePatients = new PatientsDB.DbDeletePatients(Long.valueOf(National_codeT.getText()));
                if (!deletePatients.appError){
                    statusLabel.setText("Patient Deleted Successfully");
                    statusLabel.setForeground(Color.GREEN);
                } else if (deletePatients.appError) {
                    statusLabel.setForeground(Color.RED);
                    statusLabel.setText("Patient Failed to Delete");
                }
            }
        }
    }

    public class SearchStaffClass{


        JLabel staffBoxLabel = new JLabel("Job:");

        JFrame addStaffFrame = new JFrame("Search Staff");

        JLabel nameL=new JLabel("Name:");
        JLabel ageL=new JLabel("age of staff:");
        JLabel National_codeL=new JLabel("National code:");
        JLabel statusLabel = new JLabel();



        JTextField National_codeT=new JTextField();
        JLabel National_code_example=new JLabel("example:22701649997");
        JButton backButton=new JButton("Back");
        JButton searchButton = new JButton("Search");
        JTextField nameTextField =new JTextField();
        JTextField ageTextField =new JTextField();
        JTextField jobTextField =new JTextField();


        void pageAdding(){

        }
        public class patient_reception implements ActionListener, Adder{


            patient_reception(){
                adding();
                pageAttribute();

            }
            @Override
            public void adding(){
                addStaffFrame.add(ageTextField);
                addStaffFrame.add(ageL);
                addStaffFrame.add(National_code_example);
                addStaffFrame.add(nameTextField);
                addStaffFrame.add(jobTextField);
                addStaffFrame.add(nameL);
                addStaffFrame.add(ageL);
                addStaffFrame.add(National_codeL);
                addStaffFrame.add(statusLabel);


                addStaffFrame.add(National_codeT);

                addStaffFrame.add(staffBoxLabel);

                addStaffFrame.add(backButton);
                addStaffFrame.add(searchButton);
                nameTextField.setEditable(false);
                ageTextField.setEditable(false);
                jobTextField.setEditable(false);

            }
            @Override
            public void pageAttribute(){
                addStaffFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                addStaffFrame.setLocationRelativeTo(null);
                addStaffFrame.setLayout(null);
                addStaffFrame.getContentPane().setBackground(Color.gray);
                addStaffFrame.setSize(500,500);

                nameTextField.setBounds(165,135,100,20);
                ageTextField.setBounds(165,160,100,20);
                jobTextField.setBounds(165,185,100,20);

                staffBoxLabel.setBounds(135,185,100,20);
                nameL.setBounds(125,135,60,20);


                ageL.setBounds(95,160,90,20);
                National_codeT.setBounds(165,80,100,20);
                National_code_example.setBounds(270,80,124,20);
                National_codeL.setBounds(80,80,150,20);
                searchButton.setBounds(165,105,100,20);

                backButton.setBounds(165,210,100,20);
                statusLabel.setBounds(165,250,100,30);



                searchButton.addActionListener(this);

                backButton.addActionListener(this);

                addStaffFrame.setVisible(true);

            }


            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource()== searchButton) {
                    StaffDB.DbEditStaff aa = new StaffDB.DbEditStaff(Long.valueOf(National_codeT.getText()));
                    if (!aa.getAppError()) {
                        nameTextField.setText(aa.getName());
                        ageTextField.setText(String.valueOf(aa.getAge()));
                        jobTextField.setText(aa.getJob().toString());
                        statusLabel.setText("Staff Found");
                        statusLabel.setForeground(Color.GREEN);
                    } else if (aa.getAppError()) {
                        statusLabel.setForeground(Color.RED);
                        statusLabel.setText("Staff Not Found");

                    }
                }


                else if (e.getSource()==backButton) {
                    addStaffFrame.setVisible(false);
                    staffMFrame.setVisible(true);
                }

            }
        }
        SearchStaffClass(){
            patient_reception mohsen = new patient_reception();
        }
    }

    public class SearchPatientsClass  {

        JLabel patientsboxlabel = new JLabel("Section:");
        JFrame reception = new JFrame("Search Patients");

        JLabel nameL=new JLabel("Name:");
        JLabel ageL=new JLabel("age of patient:");
        JLabel National_codeL=new JLabel("National code:");

        JTextField ageT=new JTextField();
        JTextField nameT=new JTextField();
        JTextField National_codeT=new JTextField();
        JLabel National_code_example=new JLabel("example:22701649997");
        JTextField history=new JTextField();
        JLabel historyL=new JLabel("History of patient:");
        JButton backButton=new JButton("Back");
        JButton searchButton=new JButton("Search");
        JTextField sectionLabel=new JTextField();
        JLabel statusLabel = new JLabel();

        void pageAdding(){

        }
        public class patient_reception implements ActionListener, Adder{
            patient_reception(){
                adding();
                pageAttribute();

            }
            @Override
            public void adding(){

                reception.add(historyL);
                reception.add(history);
                reception.add(ageL);
                reception.add(National_code_example);


                reception.add(nameL);
                reception.add(ageL);
                reception.add(National_codeL);
                reception.add(ageT);
                reception.add(nameT);
                reception.add(National_codeT);
                reception.add(history);
                reception.add(sectionLabel);
                reception.add(patientsboxlabel);

                reception.add(backButton);
                reception.add(searchButton);
                reception.add(statusLabel);

            }
            @Override
            public void pageAttribute(){
                reception.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reception.setLocationRelativeTo(null);
                reception.setLayout(null);
                reception.getContentPane().setBackground(Color.gray);
                reception.setSize(500,500);
                sectionLabel.setBounds(165,190,100,25);
                patientsboxlabel.setBounds(115,195,100,15);
                nameL.setBounds(125,150,60,15);
                nameT.setBounds(165,150,100,15);

                ageT.setBounds(165,170,100,15);

                ageL.setBounds(80,170,90,15);
                history.setBounds(165,225,100,50);
                historyL.setBounds(65,225,100,15);
                National_codeT.setBounds(165,100,100,15);
                National_code_example.setBounds(270,100,124,15);
                National_codeL.setBounds(80,100,90,15);
                searchButton.setBounds(165,120,100,20);

                backButton.setBounds(165,290,100,20);
                statusLabel.setBounds(165,330,100,30);
                ageT.setEditable(false);
                nameT.setEditable(false);
                sectionLabel.setEditable(false);
                history.setEditable(false);



                backButton.addActionListener(this);

                searchButton.addActionListener(this);

                reception.setVisible(true);

            }


            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()== searchButton) {
                    PatientsDB.DbEditPatients aa = new PatientsDB.DbEditPatients(Long.valueOf(National_codeT.getText()));


                    if (!aa.getAppError()) {
                        nameT.setText(aa.getName());
                        ageT.setText(String.valueOf(aa.getAge()));
                        sectionLabel.setText(aa.section);
                        history.setText(aa.getHistory());
                        statusLabel.setText("Patient Found");
                        statusLabel.setForeground(Color.GREEN);
                    } else if (aa.getAppError()) {
                        statusLabel.setForeground(Color.RED);
                        statusLabel.setText("Patient Not Found");

                    }
                }

                else if (e.getSource()==backButton) {
                    reception.setVisible(false);
                    patientsMFrame.setVisible(true);
                }

            }
        }
        SearchPatientsClass(){
            patient_reception mohsen = new patient_reception();
        }
    }

    public class ViewPatientsList implements ActionListener{
        public ViewPatientsList() {
            // Create a JFrame
            JFrame frame = new JFrame("Patient Records");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            frame.getContentPane().setBackground(Color.BLACK);
            JButton backButton = new JButton("Back");
            backButton.setBounds(200,400,100,30);
            frame.add(backButton);


            // Create a table model
            DefaultTableModel tableModel = new DefaultTableModel();

            // Add columns to the table model
            tableModel.addColumn("ID");
            tableModel.addColumn("Section");
            tableModel.addColumn("Name");
            tableModel.addColumn("Age");
            tableModel.addColumn("National Code");
            tableModel.addColumn("History");

            // Fetch data from the database and populate the table model
            fetchData(tableModel);

            // Create a JTable with the model
            JTable table = new JTable(tableModel);

            // Add the table to a JScrollPane
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);

            // Display the frame
            frame.setVisible(true);
        }

        public static void fetchData(DefaultTableModel tableModel) {
            // Database connection details
            String url = "jdbc:mysql://localhost:3306/apdb";
            String username = "root";
            String password = "";

            // SQL query to fetch all rows from the patients table
            String query = "SELECT id, section, name, age, nationalcode, history FROM patients";

            try {
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                // Iterate through the ResultSet and add rows to the table model
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String section = resultSet.getString("section");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    long nationalCode = resultSet.getLong("nationalcode");
                    String history = resultSet.getString("history");

                    // Add the row to the table model
                    tableModel.addRow(new Object[]{id, section, name, age, nationalCode, history});
                }

                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }




}
