package app.model;

import java.io.Serializable;
import java.util.Objects;

public class Tag implements Serializable{
    private static final long serialVersionUID = 1L;

    private String name;
    private String value;

    public Tag(String name, String value){
        this.name = name.trim().toLowerCase();
        this.value = value.trim().toLowerCase();
    }

    public String getName(){
        return name;
    }

    public String getValue(){
        return value;
    }

    @Override
    public boolean equals(Object o){ // Method to check if two tags are equal
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        Tag tag = (Tag) o;
        return name.equals(tag.getName()) && value.equals(tag.getValue());
    }

    @Override
    public String toString(){ // Making a string converter in case we need to print
        return name + "=" + value;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, value);
    }
}
