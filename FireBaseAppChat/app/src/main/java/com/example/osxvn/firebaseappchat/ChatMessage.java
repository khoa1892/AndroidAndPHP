package com.example.osxvn.firebaseappchat;

/**
 * Created by osxvn on 4/5/16.
 */
public class ChatMessage {

    private String name;
    private String text;

    public ChatMessage() {
        // necessary for Firebase's deserializer
    }
    public ChatMessage(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

}
