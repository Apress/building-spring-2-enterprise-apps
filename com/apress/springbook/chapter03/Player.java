package com.apress.springbook.chapter03;


/**
 * A person who plays tennis.
 */
public class Player {

    private String name;
    private Sex sex;
    private Integer id;
        
    private Player(Sex sex) {
        this.sex = sex;
    }
    
    public static Player malePlayer() {
        return new Player(Sex.MALE);
    }
    
    public static Player femalePlayer() {
        return new Player(Sex.FEMALE);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isMale() {
        return this.sex.getClass().equals(Male.class);
    }
    
    public boolean isFemale() {
        return this.sex.getClass().equals(Female.class);
    }

    protected Sex getSex() {
        return this.sex;
    }

    public Integer getId() {
        return id;
    }
    
}
