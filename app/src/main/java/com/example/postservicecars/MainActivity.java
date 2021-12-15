package com.example.postservicecars;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<String> makeList;
    List<String> modelList;
    private RecyclerView recyclerView;
    private MakeAdapter makeAdapter;
    private RadioGroup radioGroup;
    private RadioButton radioMake;
    private RadioButton radioModel;
    private RadioButton radioVariant;
    private RadioButton radioLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.rgCars);
        radioMake = findViewById(R.id.btnMake);
        radioModel = findViewById(R.id.btnModel);
        radioVariant = findViewById(R.id.btnVariant);
        radioLocation = findViewById(R.id.btnLocation);
        recyclerView = findViewById(R.id.rvRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        radioMake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getMakeResponse();


            }
        });
        radioModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getModelResponse();
            }
        });


        radioVariant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVariantResponse();
            }
        });
        radioLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocationResponse();
            }
        });

    }

    private void getLocationResponse() {
        Location location = new Location();
        location.setYear("2020");
        location.setMake("RENAULT");
        location.setModel("KWID");
        location.setVariant("1.0 RXL");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<ResponseLocation> call = api.postLocation(location);
        call.enqueue(new Callback<ResponseLocation>() {
            @Override
            public void onResponse(Call<ResponseLocation> call, Response<ResponseLocation> response) {
                makeAdapter = new MakeAdapter((Context) MainActivity.this, response.body().getLocationList());
                recyclerView.setAdapter(makeAdapter);


                if (response.body().getStatus().equals("Success")) {
                    Toast.makeText(MainActivity.this, "successfully posted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "failed posted", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLocation> call, Throwable t) {
                Log.e("fail", t.getMessage());

            }
        });

    }

    private void getVariantResponse() {
        Variant variant = new Variant();
        variant.setYear("2020");
        variant.setMake("RENAULT");
        variant.setModel("KWID");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<ResponseVariant> call = api.postVariant(variant);
        call.enqueue(new Callback<ResponseVariant>() {
            @Override
            public void onResponse(Call<ResponseVariant> call, Response<ResponseVariant> response) {
                makeAdapter = new MakeAdapter((Context) MainActivity.this, response.body().getVariantList());
                recyclerView.setAdapter(makeAdapter);
                Log.e("varSt", "onResponse: " + response.body().getStatus());
                Log.e("var", "onResponse: " + response.body().getVariantList());
                Log.e("va", "onResponse: " + response.body().getVehicleInfo());


                if (response.body().getStatus().equals("Success")) {
                    Toast.makeText(MainActivity.this, "successfully posted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "failed posted", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseVariant> call, Throwable t) {

            }
        });


    }

    private void getModelResponse() {
        Model model = new Model();
        model.setYear("2020");
        model.setMake("RENAULT");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_Url).addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<ResponseModel> call = api.postModels(model);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                List<String> modelList = response.body().getModelList();
                makeAdapter = new MakeAdapter(MainActivity.this, modelList);
                recyclerView.setAdapter(makeAdapter);
                Log.e("Name", "onResponse: " + response.body().getStatus());
                Log.e("Model", "onResponse: " + response.body().getModelList());


                if (response.body().getStatus().equals("Success")) {
                    Toast.makeText(MainActivity.this, "successfully posted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "failed posted", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }

    private void getMakeResponse() {
        Make make = new Make();
        make.setYear("2020");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.Base_Url).addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<ResponseMake> call = api.postCars(make);
        call.enqueue(new Callback<ResponseMake>() {
            @Override
            public void onResponse(Call<ResponseMake> call, Response<ResponseMake> response) {
                Log.e("TAG", "onResponse: " + response.body().getStatus());
                List<String> list = response.body().getMakeList();
                makeAdapter = new MakeAdapter(MainActivity.this,list);
                recyclerView.setAdapter(makeAdapter);

            }

            @Override
            public void onFailure(Call<ResponseMake> call, Throwable t) {

            }
        });


    }
}