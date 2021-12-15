package com.example.postservicecars;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    String Base_Url="https://kuwycredit.in/servlet/rest/ltv/forecast/";
    @POST("ltvMakes")
    Call<ResponseMake> postCars(@Body Make make);


    @POST("ltvModels")
    Call<ResponseModel> postModels(@Body Model model);


    @POST("ltvVariants")
    Call<ResponseVariant> postVariant(@Body Variant variant);

    @POST("ltvLoc")
    Call<ResponseLocation> postLocation(@Body Location location);


}
