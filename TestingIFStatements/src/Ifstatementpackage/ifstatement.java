package Ifstatementpackage;

import java.util.Scanner;

public class ifstatement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int age;
        System.out.println("Enter the User Age");
        age = input.nextInt();
        if (age > 0) {
            if (age < 18) {
                System.out.println("You are not allowed to use the Application");
                System.out.println("You are not allowed to use the Application");
            } else if (age > 18) {
                System.out.println("Welcome to the Application");

            }
            else{
                System.out.println("Invalid Age");}
        }
    }

}
