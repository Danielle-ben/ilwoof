package com.example.ilwoof;

public class Link {

    private int Image;
    private String Name;
    private String Description;
    private String Url;

    public Link(int image, String name, String description, String url) {
        Image = image;
        Name = name;
        Description = description;
        Url = url;
    }

    public String getName() {
        return Name;
    }

    public String getUrl() {
        return Url;
    }

    public String getDescription() {
        return Description;
    }

    public int getImage() {
        return Image;
    }
}
