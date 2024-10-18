package com.merion.retrofit;

import com.merion.retrofit.request.PostCreateRequest;
import com.merion.retrofit.request.PostUpdateRequest;
import com.merion.retrofit.response.postResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface JsonPlaceholderApi {


    @GET("/posts")
    Call<List<postResponse>> posts(@Query("userId") Integer userId);


    @POST("/posts")
    Call<postResponse> create(@Body PostCreateRequest postCreateRequest);

    @PUT("/posts/{id}")
    Call<postResponse> update(@Path("id") Integer id, @Body PostUpdateRequest postUpdateRequest);

    @DELETE("/posts/{id}")
    Call<Void> delete(@Path("id") Integer id);
}
