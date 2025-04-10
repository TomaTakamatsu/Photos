package app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private List<Album> allAlbums;
    private List<Photo> allPhotos;

    public User(String username) {
        this.username = username;
        this.allAlbums = new ArrayList<>();
        this.allPhotos = new ArrayList<>();
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

    public void createAlbum(Album album) {
        allAlbums.add(album);
    }

    public void deleteAlbum(Album album) {
        allAlbums.remove(album);
    }

    public void addPhoto(Photo photo) {
        if (!allPhotos.contains(photo)) {
            allPhotos.add(photo);
        }
    }

    public void removePhoto(Photo photo) {
        allPhotos.remove(photo);
        // Should make sure to delete from all albums also
        for (Album album : allAlbums) {
            // album.getPhotos().remove(photo);
        }
    }
}
