package org.example.api.models;

public class Unicorn {
    private String name;
    private String tailColor;

    public String getName(){
        return this.name;
    }
    public String getTailColor(){
        return this.tailColor;
    }

    public Unicorn(String name, String tailColor){
        this.name = name;
        this.tailColor = tailColor;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"name\":\"" + name + "\",\n" +
                "  \"tailColor\":" + tailColor + "\"\n" +
                "}";
    }

    public String toJSON(){
        return "{\n" +
                "  \"name\":\"" + name + "\",\n" +
                "  \"tailColor\":\"" + tailColor + "\"\n" +
                "}";
    }
}
