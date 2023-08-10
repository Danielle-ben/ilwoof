package com.example.ilwoof;

public class MenuOption {

    private int Image;
    private String Name;
    private String Description;
    private Class Clazz;

    public MenuOption(int image, String name, String description, Class clazz) {
        Image = image;
        Name = name;
        Description = description;
        Clazz = clazz;
    }

    public String getName() {
        return Name;
    }

    public Class getClazz() {
        return Clazz;
    }

    public String getDescription() {
        return Description;
    }

    public int getImage() {
        return Image;
    }
}
