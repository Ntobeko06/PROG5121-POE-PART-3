/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mainapp;

/**
 *
 * @author Student
 */
import java.util.*;

public class ChatApp {

    static ArrayList<Message> sentMessages = new ArrayList<>();
    static ArrayList<Message> storedMessages = new ArrayList<>();
    static ArrayList<Message> discardedMessages = new ArrayList<>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        // REGISTER
        System.out.println("=== REGISTER ===");
        
        System.out.println("Please Enter first name: ");
        String firstName = input.nextLine();

        System.out.println("Please Enter last name: ");
        String lastName = input.nextLine();
        
        System.out.println("Please Enter username: ");
        String username = input.nextLine();

        System.out.println("Please Enter password: ");
        String password = input.nextLine();

        System.out.println("Please Enter phone (starting with South African international code (+27...)): ");
        String phone = input.nextLine();
       
        boolean validatePhone = login.checkUserName(username);
        boolean validateUsername = login.checkPasswordComplexity(password);
        boolean validatePassword = login.checkCellPhoneNumber(phone);
        
        //username validation
        if(validateUsername == true){
            System.out.println("Username succesfully captured");
        }else{
            System.out.println("Username is not correctly formatted: please ensure that the username contains at least 5 characters in length,");
        }
        //validate cell phone number
        if(validatePhone == true){
            System.out.println("Cell phone number successfully added");
        }else{
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
        }
        //validate password
        if(validatePassword == true){
            System.out.println("Password successfully captured.");
        }else{
            System.out.println("Password is not correctly formatted: please ensure that the password contains at least eight characters in length");
        }
    
        System.out.println(login.registerUser(username, password, phone, firstName, lastName));

        // LOGIN
        System.out.println("\n=== LOGIN ===");
        System.out.print("Username: ");
        String u = input.nextLine();

        System.out.println("Password: ");
        String p = input.nextLine();

        boolean loggedIn = login.loginUser(u, p);
        System.out.println(login.returnLoginStatus(loggedIn));

        if (!loggedIn) return;

        // CHAT SYSTEM
        System.out.println("\nWelcome to QuickChat");

        OUTER:
        while (true) {
            System.out.println("\n1. Send Message");
            System.out.println("2. Show Messages (Coming Soon)");
            System.out.println("3. Reports");
            System.out.println("4. Quit");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("How many messages: ");
                    int num = input.nextInt();
                    input.nextLine();
                    for (int i = 0; i < num; i++) {
                        
                        System.out.println("Recipient: ");
                        String recipient = input.nextLine();
                        
                        System.out.println("Message: ");
                        String msg = input.nextLine();
                        
                        Message message = new Message(i, recipient, msg);
                        
                       
                        
                        if (!message.checkMessageLength()) {
                            System.out.println("Message too long.");
                            continue;
                        }
                        
                        System.out.println("1. Send\n2. Discard\n3. Store");
                        int action = input.nextInt();
                        input.nextLine();
                        
                        System.out.println(message.sentMessage(action));
                        
                        switch (action) {
                            case 1 -> {
                                sentMessages.add(message);
                                System.out.println(message.printMessage());
                            }
                            case 2 -> discardedMessages.add(message);
                            case 3 -> storedMessages.add(message);
                            default -> {
                            }
                        }
                    }
                }
                case 3 -> showReports(input);
                case 4 -> {
                    System.out.println("Goodbye!");
                    break OUTER;
                }
                default -> {
                }
            }
        }
    }

    // REPORT FEATURES
    public static void showReports(Scanner input) {
        char choice;
        boolean exit = false;

        while (!exit) {
        System.out.println("\n--- REPORT MENU ---");
        System.out.println("a). 1Display all sender and recipient stored messages.");
        System.out.println("b). 2Display longest stored message.");
        System.out.println("c). 3Search for message ID. Display the corresponding recipient and message.");
        System.out.println("d). 4Search for all stored messages stored for a particulare recipient.");
        System.out.println("e). 5Delete by using hash.");
        System.out.println("f). 6Display a report that lists the full details of all the stored messages.");
        }
        String userInput = input.next().toLowerCase();
        choice = userInput.charAt(0);
        
        switch (choice) {
            case 'a' -> System.out.println("\n[Displaying all sender and recipient stored messages...]");
                // Call your method to display senders and recipients
                
            case 'b' -> System.out.println("\n[Finding longest stored message...]");
                // Call your method to find and display the longest message
                
            case 'c' -> System.out.println("\n[Searching for message ID...]");
                // Prompt for ID and call your search-by-ID method
                
            case 'd' -> System.out.println("\n[Searching for recipient messages...]");
                // Prompt for recipient name and call your search method
                
            case 'e' -> System.out.println("\n[Deleting record using hash...]");
                // Prompt for hash key, find index, and perform array shifting
                
            case 'f' -> System.out.println("\n[Displaying full details of all stored messages...]");
                // Call your method to print the entire dataset details
                
            case 'q' -> {
                System.out.println("Exiting Report Menu.");
                exit = true;
                }
                
            default -> System.out.println("Invalid choice! Please select an option from a to f, or q to quit.");
        }
    }
}

