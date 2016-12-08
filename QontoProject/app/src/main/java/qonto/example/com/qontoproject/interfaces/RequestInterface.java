package qonto.example.com.qontoproject.interfaces;

import java.util.ArrayList;

import qonto.example.com.qontoproject.model.Album;
import qonto.example.com.qontoproject.model.Photo;
import qonto.example.com.qontoproject.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dirceu on 12/8/2016.
 */

public interface RequestInterface {

    @GET("/users")
    Call<ArrayList<User>> getUser();

    @GET("/photos")
    Call<ArrayList<Photo>> getPhotos();


    @GET("/albums")
    Call<ArrayList<Album>> getALbums();


}
