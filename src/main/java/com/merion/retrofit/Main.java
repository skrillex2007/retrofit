package com.merion.retrofit;

import com.merion.retrofit.request.PostCreateRequest;
import com.merion.retrofit.request.PostUpdateRequest;
import com.merion.retrofit.response.postResponse;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello");

        JsonPlaceholderApi api = JsonPlaceHolderService.getInstance().api();

        System.out.println("/posts -----------");
        Response<List<postResponse>> postResponses = api.posts(null).execute();
        System.out.println(postResponses.isSuccessful());
        System.out.println(postResponses.code());
        System.out.println(postResponses.headers());
        List<postResponse> posts = postResponses.body();
        System.out.println(posts);

        System.out.println("/posts ----------");
        PostCreateRequest createRequest = new PostCreateRequest();
        createRequest.setBody("create");
        createRequest.setTitle("create");
        createRequest.setUserId(1);
        postResponse postResponseCreate = api.create(createRequest).execute().body();
        System.out.println(postResponseCreate);

        System.out.println("PUT:/posts -----------");
        PostUpdateRequest updateRequest = new PostUpdateRequest();
        updateRequest.setBody("update");
        updateRequest.setTitle("update");
        updateRequest.setUserId(1);
        updateRequest.setId(1);
        postResponse postResponseUpdate = api.update(1, updateRequest).execute().body();
        System.out.println(postResponseUpdate);

        System.out.println("DELETE:/posts -------");
        Integer code = api.delete(1).execute().code();
        System.out.println(code);
    }
}
