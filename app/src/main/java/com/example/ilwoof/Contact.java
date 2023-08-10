package com.example.ilwoof;

public class Contact {

    private int Image;
    private String Name;
    private String Email;

    public Contact(int image, String name, String email) {
        Image = image;
        Name = name;
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public int getImage() {
        return Image;
    }
}
