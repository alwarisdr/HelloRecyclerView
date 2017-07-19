package com.waris.hellorecyclerview;

/**
 * Created by alwaris on 7/17/17.
 */

public class Player {
    private String name;
    private String club;


    //Constructor
    public Player(String name,String club) {
        this.name = name;
        this.club = club;
    }

    public String getName(){
        return  name;
    }

    public String getClub(){
        return club;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setClub(String club){
        this.club = club;
    }
}
