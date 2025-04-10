package app.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
public class Album implements Serializable{
    private static final long serialVersionUID = 1L;

    private String name;
    private List<Photo> photos;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Album(String name){
        this.name = name.trim();
        this.photos = new ArrayList<>();
        this.startDate = null;
        this.endDate = null;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName.trim();
    }

    public List<Photo> getPhotos(){
        return photos;
    }

    public boolean addPhoto(Photo photo){
        if (photos.contains(photo)) return false; // Photo already in album

        photos.add(photo);
        updateDateRangeOnAdd(photo); // Updating start/end dates
        return true;
    }

    public boolean removePhoto(Photo photo){
        if (!photos.remove(photo)) return false; // Photo not in album

        updateDateRangeOnRemoval(photo); // Updating start/end dates
        return true;
    }

    public int getPhotoCount(){
        return photos.size();
    }

    public LocalDateTime getStartDate(){
        return startDate;
    }

    public LocalDateTime getEndDate(){
        return endDate;
    }

    public String getDateRange(){
        if (startDate == null || endDate == null) return "Album is empty"; 
        return startDate.toLocalDate() + " to " + endDate.toLocalDate(); // Returning string for display
    }

    private void updateDateRangeOnAdd(Photo photo){
        LocalDateTime date = photo.getDateModified(); // Updating if photo would be the new start/end date

        if (startDate == null || date.isBefore(startDate)){
            startDate = date;
        }
        if (endDate == null || date.isAfter(endDate)){
            endDate = date;
        }
    }

    private void updateDateRangeOnRemoval(Photo photo){
        LocalDateTime date = photo.getDateModified();
        if (startDate.equals(date) || endDate.equals(date)){ // Checking if photo is the start/end date
            recalculateDateRange();
        }
    }

    private void recalculateDateRange(){
        startDate = null;
        endDate = null;
        for (Photo p : photos){
            updateDateRangeOnAdd(p);
        }
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Album)) return false;
        Album album = (Album) o;
        return name.equals(album.getName()); // Not going to ignore cases since albums could mean different things depending on case
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }

    @Override
    public String toString(){
        return name;
    }

}
