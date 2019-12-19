package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class AdminMenu extends JFrame {
    private JButton button1 = new JButton("Показать");
    private JButton button2 = new JButton("Показать");
    private JButton button3 = new JButton("Вывести");
    private JLabel label1 = new JLabel("Список всех работников: ");
    private JLabel label2 = new JLabel("Список всех работодателей: ");
    private JLabel label3 = new JLabel("Подобрать пары работник/работодатель: ");
    private JTextArea output1 = new JTextArea();
    private JTextArea output2 = new JTextArea();
    private JTextArea output3 = new JTextArea();

    public AdminMenu(ArrayList<User> users, ArrayList<Employer> employers, ArrayList<pairWork> pairs) {
        super("Система распределения вакансий");
        this.setBounds(500, 500, 2900, 1100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Font BigFontTR = new Font("TimesRoman", Font.BOLD, 30);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 3, 1, 2));
        container.add(label1).setFont(BigFontTR);
        container.add(label2).setFont(BigFontTR);
        container.add(label3).setFont(BigFontTR);
        //кнопка вывода всех работников
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output1.setText(null);
                int j = -1;
                //сортировка работников
                j = -1;
                while (j != 0) {
                    j = 0;
                    for (int i = 0 ; i < users.size() - 1; i++) {
                        User p = users.get(i);
                        User next = users.get(i + 1);
                        if(p.getMoney() < next.getMoney()) {
                            j = j + 1;
                            User p1 = users.get(i);
                            users.set(i,users.get(i + 1));
                            users.set(i + 1, p1);
                        }
                    }
                }
                for (User user : users) {
                    if (user.getName() != "") {
                        output1.append("Работник " + user.getName() + " является " + user.getWork() + " и берет за работу " + user.getMoney() + '\n');
                    }
                }

            }
        });
        container.add(button1).setFont(BigFontTR);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output2.setText(null);
                int j1 = -1;
                j1 = -1;
                j1 = -1;
                while (j1 != 0) {
                    j1 = 0;
                    for (int i = 0 ; i < employers.size() - 1; i++) {
                        Employer p = employers.get(i);
                        Employer next = employers.get(i + 1);
                        if(p.getPay() < next.getPay()) {
                            j1 = j1 + 1;
                            Employer p1 = employers.get(i);
                            employers.set(i,employers.get(i + 1));
                            employers.set(i + 1, p1);
                        }
                    }
                }
                for (Employer employer : employers) {
                    if (employer.getName() != "") {
                        output2.append("Работодатель " + employer.getName() + " ищет " + employer.getNeedWork() + ", зарплата " + employer.getPay() + '\n');
                    }
                }
            }
        });
        container.add(button2).setFont(BigFontTR);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int k = 0;
                int j = -1;
                int j1 = -1;
                output3.setText(null);
                //сортировка работников
                while (j != 0) {
                    j = 0;
                    for (int i = 0 ; i < users.size() - 1; i++) {
                        User p = users.get(i);
                        User next = users.get(i + 1);
                        if(p.getMoney() < next.getMoney()) {
                            j = j + 1;
                            User p1 = users.get(i);
                            users.set(i,users.get(i + 1));
                            users.set(i + 1, p1);
                        }
                    }
                }
                //сортировка работодателей
                while (j1 != 0) {
                    j1 = 0;
                    for (int i = 0 ; i < employers.size() - 1; i++) {
                        Employer p = employers.get(i);
                        Employer next = employers.get(i + 1);
                        if(p.getPay() < next.getPay()) {
                            j1 = j1 + 1;
                            Employer p1 = employers.get(i);
                            employers.set(i,employers.get(i + 1));
                            employers.set(i + 1, p1);
                        }
                    }
                }
                for (Employer employer : employers) {
                    if (employer.checkWorkMark() == 0) {
                        String work = employer.getNeedWork();
                        k = 0;
                        for (User user : users) {
                            if (user.checkWorkMark() == 0) {
                                String work2 = user.getWork();
                                if (work.equals(work2)) {
                                    output3.append("Работодателю " + employer.getName() + " подходит работник " + user.getName() + '\n');
                                    employer.changeWorkMark();
                                    user.changeWorkMark();
                                    pairWork obj = new pairWork(employer.getName(), user.getName());
                                    pairs.add(obj);
                                    k = k + 1;
                                    break;
                                }
                            }

                        }
                        if (k == 0) {
                            output3.append("Работодателю " + employer.getName() + " не найден работник!" + '\n');
                        }
                    }
                }
            }
        });
        container.add(button3).setFont(BigFontTR);
        container.add(output1).setFont(BigFontTR);
        container.add(output2).setFont(BigFontTR);
        container.add(output3).setFont(BigFontTR);
    }
}
