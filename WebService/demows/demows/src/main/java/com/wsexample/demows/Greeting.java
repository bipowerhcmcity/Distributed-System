package com.wsexample.demows;

public class Greeting {
    private int id;
    private String content;

    public Greeting (int id, String content){
        this.id= id;
        this.content = content;

    }

    // The Spring boot will automatically call the get method to create the JSON and response back to Client.

    public int getId(){
        return id;
    }
    public String getContent(){
        return content;
    }
}
