/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mainapp;

import java.util.Random;

/**
 *
 * @author Student
 */

public class Message {

    private final String messageID;
    private final int messageNumber;
    private final String recipient;
    private final String message;
    private final String messageHash;

    //Static counter to keep track of accumulated messages.
    private static int totalMessagesSent =0;
    
    public Message(int messageNumber, String recipient, String message) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    Message() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private String generateMessageID() {
        Random rand = new Random();
        //Generates a value between 1000000000L and 9999999999L
        long num = (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(num);
    }

    public boolean checkMessageID() {
        return messageID != null && messageID.length() ==10;
    }

    public String checkRecipientCell() {
        if (recipient != null && (recipient.matches("^\\+27\\d{9}$")||recipient.matches("^0\\d{10}$") || recipient.length() == 11)) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public boolean checkMessageLength() {
        return message.length() <= 250;
    }

    public final String createMessageHash() {
        if (message == null || message.trim().isEmpty()){
            return messageID.substring(0, 2) + ":" + messageNumber + ":";
        }
        String[] words = message.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", "").toUpperCase();
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "").toUpperCase();
        
        return messageID.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord;
    }

    public String sentMessage(int choice) {
        switch (choice) {
            case 1 -> {
                totalMessagesSent++; // Increment total messages when successfully sent
                return "Message successfully sent.";
            }
            case 2 -> {
                return "Press # to delete the message.";
            }
            case 3 -> {
                return "Message successfully stored.";
            }
            default -> {
                return "Invalid option.";
            }
        }
    }

    public String printMessage() {
        return "Message ID: " + messageID +
                "\nHash: " + messageHash +
                "\nRecipient: " + recipient +
                "\nMessage: " + message;
    }

    public int returnTotalMessages() {
        return totalMessagesSent;
    }
    //method for JSON storage research requirement
    public void storeMessage(){
    }
    //testing validation
    public String getMessage() { return message; }
    public String getRecipient() { return recipient; }
    public String getMessageHash() { return messageHash; }

    void setMessageID(String messageID) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
    
