package com.example.covider;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Map;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Map<String, String> freq_visited ;
    private Map<String, String> should_visit ;
    private ArrayList<String> health_history ;
    private ArrayList<User> closeContacts ;
    private boolean haveCovid;
    private boolean isInstructor;



    public User(String firstName, String lastName, String email, String password, boolean isInstructor,
                Map<String, String>  freq_visited, Map<String, String>  should_visit, ArrayList<String> health_history,
                ArrayList<User> closeContacts, boolean haveCovid){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isInstructor = isInstructor;
        this.freq_visited = freq_visited;
        this.should_visit = should_visit;
        this.health_history = health_history;
        this.closeContacts = closeContacts;
        this.haveCovid = haveCovid;

    }

    public User(){}

    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<User> getCloseContacts() {
        return closeContacts;
    }

    public void setCloseContacts(ArrayList<User> closeContacts) {
        this.closeContacts = closeContacts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, String> getFreq_visited() {
        return freq_visited;
    }

    public void setFreq_visited(Map<String, String> freq_visited) {
        this.freq_visited = freq_visited;
    }

    public Map<String, String> getShould_visit() {
        return should_visit;
    }

    public void setShould_visit(Map<String, String> should_visit) {
        this.should_visit = should_visit;
    }

    public ArrayList<String> getHealth_history() {
        return health_history;
    }

    public void setHealth_history(ArrayList<String> health_history) {
        this.health_history = health_history;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isHaveCovid() {
        return haveCovid;
    }

    public void setHaveCovid(boolean haveCovid) {
        this.haveCovid = haveCovid;
    }

    public boolean isInstructor() {
        return isInstructor;
    }

    public void setInstructor(boolean instructor) {
        isInstructor = instructor;
    }
}
