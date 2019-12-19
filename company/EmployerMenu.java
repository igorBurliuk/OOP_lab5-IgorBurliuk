package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EmployerMenu extends JFrame {
    private JButton button = new JButton("Сохранить");
    private JButton button2 = new JButton("Удалить");
    private JLabel label1 = new JLabel("Ваше имя: ");
    private JLabel label2 = new JLabel("Вакансия: ");
    private JLabel label3 = new JLabel("Требуемая оплата: ");
    private JLabel label4 = new JLabel("Сохранить изменения: ");
    private JLabel label5 = new JLabel("Удалить пользователя ");
    private JTextField input1 = new JTextField("",2);
    private JTextField input2 = new JTextField("",2);
    private JTextField input3 = new JTextField("",2);
    public EmployerMenu(Employer employer, File file2) {
        super("Система распределения вакансий");
        this.setBounds(1500, 500, 1000, 1100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 30);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5, 2, 2, 2));
        container.add(label1).setFont(BigFontTR);
        if (employer.getName() == "")
            input1.setText(null);
        else
            input1.setText(employer.getName());
        container.add(input1).setFont(BigFontTR);
        container.add(label2).setFont(BigFontTR);
        if (employer.getNeedWork() == "")
            input2.setText(null);
        else
            input2.setText(employer.getNeedWork());
        container.add(input2).setFont(BigFontTR);
        container.add(label3).setFont(BigFontTR);
        if (employer.getPay() == 0)
            input3.setText(null);
        else
            input3.setText(String.valueOf(employer.getPay()));
        container.add(input3).setFont(BigFontTR);
        container.add(label4).setFont(BigFontTR);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file2));
                    String line = reader.readLine();
                    File file3 = new File("testEmployers.txt");
                    while (line != null) {
                        String[] arr = line.split(" ");
                        if (employer.getLogin().equals(arr[0])) {
                            String[] newArr = new String[5];
                            newArr[0] = arr[0];//login
                            newArr[1] = arr[1];//password
                            newArr[2] = input1.getText();//name
                            employer.setName(newArr[2]);
                            newArr[3] = input2.getText();//вакансия
                            employer.setWork(newArr[3]);
                            newArr[4] = String.valueOf(input3.getText());//зарплата
                            employer.setMoney(Integer.parseInt(newArr[4]));
                            BufferedWriter writer = new BufferedWriter(new FileWriter(file3, true));
                            String data = newArr[0] + " " + newArr[1] + " " + newArr[2] + " " + newArr[3] + " " + newArr[4] + "\n";
                            writer.write(data);
                            writer.flush();
                            writer.close();
                        }
                        else {
                            BufferedWriter writer = new BufferedWriter(new FileWriter(file3,true));
                            writer.write(line + '\n');
                            writer.flush();
                            writer.close();
                        }
                        line = reader.readLine();
                    }
                    reader.close();
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
                    writer.write("");
                    writer.flush();
                    writer.close();

                    reader = new BufferedReader(new FileReader(file3));
                    line = reader.readLine();
                    while (line != null) {
                        writer = new BufferedWriter(new FileWriter(file2, true));
                        writer.write(line + '\n');
                        writer.flush();
                        writer.close();
                        line = reader.readLine();
                    }
                    reader.close();
                    if (file3.delete()) {
                    }
                    JOptionPane.showMessageDialog(null, "Данные успешно изменены", "Уведомление", JOptionPane.PLAIN_MESSAGE);
                }catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        container.add(button).setFont(BigFontTR);
        container.add(label5).setFont(BigFontTR);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file2));
                    String line = reader.readLine();
                    File file3 = new File("testEmployers.txt");
                    while (line != null) {
                        String[] arr = line.split(" ");
                        if (employer.getLogin().equals(arr[0])) {

                        }
                        else {
                            BufferedWriter writer = new BufferedWriter(new FileWriter(file3,true));
                            writer.write(line + '\n');
                            writer.flush();
                            writer.close();
                        }
                        line = reader.readLine();
                    }
                    reader.close();
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
                    writer.write("");
                    writer.flush();
                    writer.close();

                    reader = new BufferedReader(new FileReader(file3));
                    line = reader.readLine();
                    while (line != null) {
                        writer = new BufferedWriter(new FileWriter(file2, true));
                        writer.write(line + '\n');
                        writer.flush();
                        writer.close();
                        line = reader.readLine();
                    }
                    reader.close();
                    if (file3.delete()) {
                    }
                    JOptionPane.showMessageDialog(null, "Пользователь успешно удален", "Уведомление", JOptionPane.PLAIN_MESSAGE);
                    dispose();
                }catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        container.add(button2).setFont(BigFontTR);
    }
}
