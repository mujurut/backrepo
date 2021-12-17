package com.example.getmeapi.model;

public class FirebaseUser {
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    private String uid;
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FirebaseUser(String uid, String name, String email){
        this.uid = uid;
        this.email = email;
        this.name = name;
    }
}
