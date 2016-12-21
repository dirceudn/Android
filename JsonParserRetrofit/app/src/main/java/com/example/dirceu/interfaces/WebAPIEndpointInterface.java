package com.example.dirceu.interfaces;

import com.example.dirceu.model.Album;
import com.example.dirceu.model.Photo;
import com.example.dirceu.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dirceu on 20/12/16.
 */

public interface WebAPIEndpointInterface {

    @GET("/users")
    Call<List<User>> getUsers();

    @GET("/users/{user_id}/albums")
    Call<List<Album>> getAlbuns(@Path("user_id") int userId);

    @GET("albums/{album_id}/photos")
    Call<List<Photo>> getPhotos(@Path("album_id") int albumId);




}
