package app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private List<Album> albums;
    private List<Photo> allPhotos;

    public User(String username) {
        this.username = username;
        this.albums = new ArrayList<>();
        this.allPhotos = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public List<Album> getAllAlbums() {
        return albums;
    }

    public List<Photo> getAllPhotos() {
        return allPhotos;
    }

    public void createAlbum(Album album) {
        albums.add(album);
    }

    public void deleteAlbum(Album album) {
        albums.remove(album);
    }

    public void addPhoto(Photo photo) {
        if (!allPhotos.contains(photo)) {
            allPhotos.add(photo);
        }
    }

    public void removePhoto(Photo photo) {
        allPhotos.remove(photo);

        // Should make sure to delete from all albums also
        for (Album album : albums) {
            
        }
    }
}
