package com.example.dirceu.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.dirceu.adapters.UserAdapter;
import com.example.dirceu.interfaces.WebAPIEndpointInterface;
import com.example.dirceu.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    private RecyclerView recyclerView;
    private List<User> data;
    private UserAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        loadRetrofit();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                User user = data.get(position);
                Toast.makeText(getApplicationContext(), user.getName() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));





    }


    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);



    }



    public void loadRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        WebAPIEndpointInterface apiService = retrofit.create(WebAPIEndpointInterface.class);
        Call<List<User>> users = apiService.getUsers();

        users.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                data = response.body();
                adapter = new UserAdapter(data);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("Error",t.getMessage());

            }
        });
    }
}
