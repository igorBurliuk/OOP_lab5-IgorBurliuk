package com.company;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;


public class classGUI extends JFrame {
    private JButton button1 = new JButton("Вход");
    private JButton button2 = new JButton("Регистрация");
    private JButton button3 = new JButton("Вход");
    private JButton button4 = new JButton("Регистрация");
    private JButton button5 = new JButton("Вход");
    private JButton button6 = new JButton("Выбрать файл для работника");
    private JButton button7 = new JButton("Выбрать файл для работодателя");
    private JButton button8 = new JButton("Сохранить данные работников");
    private JButton button9 = new JButton("Сохранить данные работодателей");
    private JTextField input1 = new JTextField("",2);
    private JTextField input2 = new JTextField("",2);
    private JTextField input3 = new JTextField("",2);
    private JTextField input4 = new JTextField("",2);
    private JTextField input5 = new JTextField("",2);
    private JTextField input6 = new JTextField("",2);
    private JLabel label1 = new JLabel("Работник");
    private JLabel label2 = new JLabel("Работодатель");
    private JLabel label3 = new JLabel("Admin");



    public classGUI(ArrayList<User> users, ArrayList<Employer> employers, ArrayList<pairWork> pairs) {
        super("Система распределения вакансий");

        this.setBounds(1200,300,1500,1600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 30);
        Container container = this.getContentPane();
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        container.add(label1).setFont(BigFontTR);
        container.add(input1).setFont(BigFontTR);
        container.add(input2).setFont(BigFontTR);
        //кнопка входа для работника
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int k = 0;
                String log = input1.getText();
                String pass = input2.getText();
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                File file = fileopen.getSelectedFile();
                //File file = new File("C:\\Users\\Игорь\\IdeaProjects\\Лабораторный работы\\Lab5\\users.txt");
                while (k != users.size()) {
                    for (User user : users) {
                        k = k + 1;
                        String userLogin = user.getLogin();
                        String userPassword = user.getPassword();
                        if (log.equals(userLogin) && pass.equals(userPassword)) {
                            WorkerMenu workerMenu = new WorkerMenu(user, file);
                            workerMenu.setVisible(true);
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Неправильный логин или пароль", "Уведомление", JOptionPane.PLAIN_MESSAGE);
                return;

            }
        });
        container.add(button1).setFont(BigFontTR);//кнопка входа работника
        //регистрация работника
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("C:\\Users\\Игорь\\IdeaProjects\\Лабораторный работы\\Lab5\\users.txt");
                Scanner scanner = new Scanner("C:\\Users\\Игорь\\IdeaProjects\\Лабораторный работы\\Lab5\\users.txt");
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = reader.readLine();
                    if (line == null) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                        String log = input1.getText();
                        String pass = input2.getText();
                        writer.write(log + " ");
                        writer.write(pass + "\n");
                        writer.flush();
                        writer.close();
                        User obj = new User(log, pass);
                        users.add(obj);
                        JOptionPane.showMessageDialog(null, "Пользователь успешно зарегистрирован", "Уведомление", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        String log = input1.getText();
                        //проверка есть ли уже такой логин
                        while (line != null) {
                            String[] arr = line.split(" ");//line приходит 0
                            String login = arr[0];
                            line = reader.readLine();
                            if (log.equals(login)) {
                                JOptionPane.showMessageDialog(null, "Такой пользователь уже зарегистрирован", "Уведомление", JOptionPane.PLAIN_MESSAGE);
                                return;
                            }
                        }
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                        log = input1.getText();
                        String pass = input2.getText();
                        writer.write(log + " ");
                        writer.write(pass + "\n");
                        writer.flush();
                        writer.close();
                        User obj = new User(log,pass);
                        users.add(obj);
                        JOptionPane.showMessageDialog(null, "Пользователь успешно зарегистрирован", "Уведомление", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        container.add(button2).setFont(BigFontTR);//кнопка регистрации работника
        container.add(label2).setFont(BigFontTR);
        container.add(input3).setFont(BigFontTR);
        container.add(input4).setFont(BigFontTR);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int k = 0;
                String log = input3.getText();
                String pass = input4.getText();
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                File file2 = fileopen.getSelectedFile();
                //File file2 = new File("C:\\Users\\Игорь\\IdeaProjects\\Лабораторный работы\\Lab5\\emlpoyers.txt");
                while (k != employers.size()) {
                    for (Employer employer : employers) {
                        k = k + 1;
                        String userLogin = employer.getLogin();
                        String userPassword = employer.getPassword();
                        if (log.equals(userLogin) && pass.equals(userPassword)) {
                            EmployerMenu employerMenu = new EmployerMenu(employer, file2);
                            employerMenu.setVisible(true);
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Неправильный логин или пароль", "Уведомление", JOptionPane.PLAIN_MESSAGE);
                return;
            }
        });
        container.add(button3).setFont(BigFontTR);//кнопка входа работодателя

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file2 = new File("C:\\Users\\Игорь\\IdeaProjects\\Лабораторный работы\\Lab5\\emlpoyers.txt");
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file2));
                    String line = reader.readLine();
                    if (line == null) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file2, true));
                        String log = input3.getText();
                        String pass = input4.getText();
                        writer.write(log + " ");
                        writer.write(pass + "\n");
                        writer.flush();
                        writer.close();
                        Employer obj = new Employer(log, pass);
                        employers.add(obj);
                        JOptionPane.showMessageDialog(null, "Пользователь успешно зарегистрирован", "Уведомление", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        String log = input3.getText();
                        //проверка есть ли уже такой логин
                        while (line != null) {
                            String[] arr = line.split(" ");//line приходит 0
                            String login = arr[0];
                            line = reader.readLine();
                            if (log.equals(login)) {
                                JOptionPane.showMessageDialog(null, "Такой пользователь уже зарегистрирован", "Уведомление", JOptionPane.PLAIN_MESSAGE);
                                return;
                            }
                        }
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file2, true));
                        log = input3.getText();
                        String pass = input4.getText();
                        writer.write(log + " ");
                        writer.write(pass + "\n");
                        writer.flush();
                        writer.close();
                        Employer obj = new Employer(log,pass);
                        employers.add(obj);
                        JOptionPane.showMessageDialog(null, "Пользователь успешно зарегистрирован", "Уведомление", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        container.add(button4).setFont(BigFontTR);//кнопка регистрации работодателя
        container.add(label3).setFont(BigFontTR);
        container.add(input5).setFont(BigFontTR);
        container.add(input6).setFont(BigFontTR);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (input5.getText().equals("admin") && input6.getText().equals("admin")) {
                    AdminMenu adminMenu = new AdminMenu(users, employers, pairs);
                    adminMenu.setVisible(true);
                }
            }
        });
        container.add(button5).setFont(BigFontTR);//кнопка входа админа
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                 int ret = fileopen.showDialog(null, "Открыть файл");
                 File fuser = fileopen.getSelectedFile();
            }
        });
//        container.add(button6).setFont(BigFontTR);
//        container.add(button7).setFont(BigFontTR);
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                File fuser = fileopen.getSelectedFile();
                File file = new File("C:\\Users\\Игорь\\IdeaProjects\\Лабораторный работы\\Lab5\\users.txt");
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));

                    BufferedWriter clear = new BufferedWriter(new FileWriter(fuser));
                    clear.write("");

                    String line = reader.readLine();
                    while(line != null) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fuser,true));
                        writer.write(line + '\n');
                        writer.flush();
                        writer.close();
                        line = reader.readLine();
                    }
                    reader.close();
                }catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        container.add(button8).setFont(BigFontTR);
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                File fuser = fileopen.getSelectedFile();
                File file = new File("C:\\Users\\Игорь\\IdeaProjects\\Лабораторный работы\\Lab5\\emlpoyers.txt");
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));

                    BufferedWriter clear = new BufferedWriter(new FileWriter(fuser));
                    clear.write("");

                    String line = reader.readLine();
                    while(line != null) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fuser,true));
                        writer.write(line + '\n');
                        writer.flush();
                        writer.close();
                        line = reader.readLine();
                    }
                    reader.close();
                }catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        container.add(button9).setFont(BigFontTR);
    }
}
