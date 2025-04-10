package app.model;

import java.io.Serializable;
import java.io.File;
import java.time.*;
import java.util.*;

public class Photo implements Serializable{
    private String filePath;
    private String caption;
    private LocalDateTime dateModified;
    private List<Tag> tags;

    public Photo(String filePath){
        // Setting default values of the Photo object
        this.filePath = filePath;
        this.caption = "";
        this.tags = new ArrayList<>();

        // Getting the last modified date
        File file = new File(filePath);
        this.dateModified = LocalDateTime.ofInstant(Instant.ofEpochMilli(file.lastModified()), ZoneId.systemDefault());
    }

    public String getFilePath(){
        return filePath;
    }

    public String getCaption(){
        return caption;
    }

    public void setCaption(String caption){
        this.caption = caption;
    }

    public LocalDateTime getDateModified(){
        return dateModified;
    }

    public List<Tag> getTags(){
        return tags;
    }

    public boolean addTag(Tag tag, boolean allowsMultiple){
        String type = tag.getType();
        type = type.toLowerCase();

        if (!allowsMultiple){
            for (Tag t : tags){
                if (t.getType().equals(type)){
                    return false; // Only one of this tag type is allowed
                }
            }
        }

        if (!tags.contains(tag)){
            tags.add(tag);
            return true; // Successfully added the new tag
        }

        return false; // Tag already exists
    }

    public boolean removeTag(Tag tag){
        return tags.remove(tag); // Returns true if successfully removed, false if it didn't exist
    }

    public List<Tag> getTagsByType(String type){
        List<Tag> result = new ArrayList<>();
        for (Tag t : tags){
            if (t.getType().equals(type.trim().toLowerCase())){
                result.add(t); // Adding tag to result if tag matches the type
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;
        Photo photo = (Photo) o;
        return filePath.equals(photo.filePath); // Comparing filepath to check if the photo is the same
    }

    @Override
    public int hashCode(){
        return Objects.hash(filePath);
    }
    
}
