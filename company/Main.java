package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File ("C:\\Users\\Игорь\\IdeaProjects\\Лабораторный работы\\Lab5\\users.txt");
        File file2 = new File("C:\\Users\\Игорь\\IdeaProjects\\Лабораторный работы\\Lab5\\emlpoyers.txt");
        Scanner scanner = new Scanner("C:\\Users\\Игорь\\IdeaProjects\\Лабораторный работы\\Lab5\\users.txt");
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Employer> employers = new ArrayList<>();
        ArrayList<pairWork> pairs = new ArrayList<>();
        ArrayList<Admin> admins = new ArrayList<>();
        try {
            //заполнение массива users
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while(line != null) {
                String[] arr = line.split(" ");
                if (arr.length == 2) {
                    String log = arr[0];
                    String pass = arr[1];
                    User obj = new User(log,pass);
                    users.add(obj);
                    line = reader.readLine();
                }
                else {
                    String log = arr[0];
                    String pass = arr[1];
                    User obj = new User(log,pass);
                    String name = arr[2];
                    obj.setName(name);
                    String work = arr[3];
                    obj.setWork(work);
                    String money = arr[4];
                    obj.setMoney(Integer.parseInt(money));
                    users.add(obj);
                    line = reader.readLine();
                }
            }
            reader.close();

            //заполнение массива employers
            reader = new BufferedReader(new FileReader(file2));
            line = reader.readLine();
            while(line != null) {
                String[] arr = line.split(" ");
                if (arr.length == 2) {
                    String log = arr[0];
                    String pass = arr[1];
                    Employer obj = new Employer(log,pass);
                    employers.add(obj);
                    line = reader.readLine();
                }
                else {
                    String log = arr[0];
                    String pass = arr[1];
                    Employer obj = new Employer(log,pass);
                    String name = arr[2];
                    obj.setName(name);
                    String work = arr[3];
                    obj.setWork(work);
                    String money = arr[4];
                    obj.setMoney(Integer.parseInt(money));
                    employers.add(obj);
                    line = reader.readLine();
                }
            }
            System.out.println(employers.size());
        }catch(IOException ex) {
            ex.printStackTrace();
        }
        Scanner in = new Scanner(System.in);
        Admin admin = new Admin("admin", "admin");
        admins.add(admin);
//        JFileChooser fileopen = new JFileChooser();
//        int ret = fileopen.showDialog(null, "Открыть файл");
//        File fuser = fileopen.getSelectedFile();
        classGUI app = new classGUI(users, employers, pairs);
        app.setVisible(true);
    }
}
