package userInfo;

import java.util.Scanner;
import java.lang.Math;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("code is executed successfully");
        Scanner scanner = new Scanner(System.in);
        System.out.println("what is username ");

        String username = scanner.nextLine();
        System.out.println("what is your password");
        String password = scanner.nextLine();

        scanner.close();
        User user1 = new User(username, password);
        String filename = String.format("%s.txt", user1.username).toLowerCase();
        File file = new File(filename);
        if (file.exists()) {
            try {
                System.out.println("user is already exist");
                FileReader filereader = new FileReader(filename);
                BufferedReader bufferreader = new BufferedReader(filereader);
                String filePassword = bufferreader.readLine();
                boolean flag = false;
                while (filePassword != null) {

                    System.out.println(filePassword);

                    if (filePassword.equals(user1.password)) {
                        System.out.println("user is authenticted");
                        flag = true;
                        break;
                    }
                    filePassword = bufferreader.readLine();
                }
                if(!flag){
                    System.out.println("user is not authenticated may be password may be wrong");
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } else {
            try {
                FileWriter filewriter = new FileWriter(filename);
                filewriter.write(user1.password);
                System.out.println("file is created and user is registered");
                filewriter.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }

}

class User {
    double id;
    String username;
    String password;

    User(String username, String password) {
        this.id = Math.random() * 1000;
        this.username = username;
        this.password = password;
    }

}
