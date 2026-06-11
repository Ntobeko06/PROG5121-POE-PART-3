/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapp;

/**
 *
 * @author Student
 */
public class Login {

    private String storedUsername;
    private String storedPassword;
    private String firstName;
    private String lastName;

    
    // First name validation
    public boolean checkFirstName(String firstName) {
    // Checks that the name is not null, not empty, and contains only letters
    return firstName != null && !firstName.trim().isEmpty() && firstName.matches("^[A-Za-z]+$");
    }

    // Last name validation
    public boolean checkLastName(String lastName) {
    // Checks that the name is not null, not empty, and contains only letters
    return lastName != null && !lastName.trim().isEmpty() && lastName.matches("^[A-Za-z]+$");
    }
    // Username validation
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Password validation
    public boolean checkPasswordComplexity(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }

    // SA phone validation
    public boolean checkCellPhoneNumber(String phone) {
        return phone.matches("^\\+27\\d{9}$");
    }

    // Register
    public String registerUser(String firstName, String lastName, String username,
                               String password, String phone) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure it contains an underscore and is no more than 5 characters.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; must contain 8 characters, capital letter, number, and special character.";
        }

        if (!checkCellPhoneNumber(phone)) {
            return "Cell phone number incorrectly formatted or missing international code.";
        }
        if (!checkFirstName(firstName)) {
        return "First name is incorrectly formatted; it must not be empty and should contain letters only.";
        }
    
        if (!checkLastName(lastName)) {
        return "Last name is incorrectly formatted; it must not be empty and should contain letters only.";
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.storedUsername = username;
        this.storedPassword = password;

        return "User successfully registered.";
    }

    // Login
    public boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    // Login message
    public String returnLoginStatus(boolean status) {
        if (status) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
