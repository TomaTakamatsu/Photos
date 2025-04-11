package app.model;

import java.io.Serializable;
import java.util.*;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private List<Album> allAlbums;
    private List<Photo> allPhotos;
    private Map<String, Boolean> tagTypeRules; // true = multiple allowed, false = unique

    public User(String username) {
        this.username = username;
        this.allAlbums = new ArrayList<>();
        this.allPhotos = new ArrayList<>();
        this.tagTypeRules = new HashMap<>();

        // Default tags
        tagTypeRules.put("person", true);
        tagTypeRules.put("location", false);
    }

    public String getUsername() {
        return username;
    }

    public List<Album> getAllAlbums() {
        return allAlbums;
    }

    public List<Photo> getAllPhotos() {
        return allPhotos;
    }

    public Map<String, Boolean> getTagTypeRules(){
        return tagTypeRules;
    }

    private void refreshPhotoList(){
        // Iterates through all albums and adds each one to the list
        allPhotos = new ArrayList<>();
        for (Album a : allAlbums){
            for (Photo p : a.getPhotos()){
                allPhotos.add(p);
            }
        }
    }

    public boolean createAlbum(String albumName){
        albumName = albumName.trim();
        if (getAlbumByName(albumName) != null) return false; // Album name exists already

        Album newAlbum = new Album(albumName);
        allAlbums.add(newAlbum);
        return true;
    }

    public boolean createAlbumWithPhotos(String albumName, List<Photo> photosToAdd){
        albumName = albumName.trim();
        if (getAlbumByName(albumName) != null) return false; // Album name exists already

        Album newAlbum = new Album(albumName);
        for (Photo p : photosToAdd){
            newAlbum.addPhoto(p); // Adding each photo to new album
            if (!allPhotos.contains(p)) allPhotos.add(p); // Adding photo to photo list if it is new
        }
        allAlbums.add(newAlbum);
        return true;
    }

    public void deleteAlbum(Album album){
        allAlbums.remove(album);
        refreshPhotoList();
    }

    public void renameAlbum(Album album, String newAlbumName){
        album.setName(newAlbumName);
    }

    public Album getAlbumByName(String albumName){
        albumName = albumName.trim();
        for (Album a : allAlbums){
            if (a.getName().equals(albumName)){
                return a;
            }
        }
        return null; // Album with name not found
    }
    
    public boolean addPhotoToAlbum(Album album, Photo photo){
        boolean added = album.addPhoto(photo); // Adding to album, false if photo already existed in album
        if (added && !allPhotos.contains(photo)){
            allPhotos.add(photo); // Adding to photo list if it is new
        }
        return added;
    }

    

}
