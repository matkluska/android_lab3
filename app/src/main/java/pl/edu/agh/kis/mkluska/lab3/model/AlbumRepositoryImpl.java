package pl.edu.agh.kis.mkluska.lab3.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlbumRepositoryImpl {

    private Map<String, Album> albumMap = new HashMap<>();

    private static AlbumRepositoryImpl instance;

    private AlbumRepositoryImpl() {
    }

    public static synchronized AlbumRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new AlbumRepositoryImpl();
        }
        return instance;
    }

    public List<Album> getAllAlbums() {
        return new ArrayList<>(albumMap.values());
    }

    public Album findById(@NonNull String albumId) {
        return albumMap.get(albumId);
    }

    public void addAlbums(List<Album> albums) {
        for (Album album : albums) {
            albumMap.put(album.getId(), album);
        }
    }
}
