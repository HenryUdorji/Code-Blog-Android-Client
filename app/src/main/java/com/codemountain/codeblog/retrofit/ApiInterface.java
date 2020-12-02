package com.codemountain.codeblog.retrofit;

import com.codemountain.codeblog.dto.AuthResponse;
import com.codemountain.codeblog.dto.CategoryDto;
import com.codemountain.codeblog.dto.CommentsDto;
import com.codemountain.codeblog.dto.LoginDto;
import com.codemountain.codeblog.dto.PostDto;
import com.codemountain.codeblog.dto.RegisterDto;
import com.codemountain.codeblog.dto.TokenRefreshDto;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    /*************************************
     * Authentication and Authorization
     **************************************/

    @POST("/auth/signup")
    Call<ResponseBody> signUp(@Body RegisterDto registerDto);

    @POST("auth/login")
    Call<AuthResponse> loginUser(@Body LoginDto loginDto);

    @POST("auth/refresh/token")
    Call<AuthResponse> refreshAuth(@Body TokenRefreshDto tokenRefreshDto);

    @POST("auth/logout")
    Call<ResponseBody> logoutUser(@Body TokenRefreshDto tokenRefreshDto);


    /**************************************
     * Create, get, update and delete post
     **************************************/

    @GET("posts")
    Call<List<PostDto>> getPosts();

    @GET("posts/draft")
    Call<PostDto> getDraftPost();

    @GET("posts/{id}")
    Call<PostDto> getPost(@Path("id") Integer id);

    @GET("posts/category/{id}")
    Call<List<PostDto>> getPostByCategory(@Path("id") Integer id);

    @GET("posts/user/{id}")
    Call<List<PostDto>> getPostByUsername(@Path("id") String name);



    /*******************************************
     * Category
     ******************************************/

    @GET("category")
    Call<List<CategoryDto>> getCategories();

    @GET("category/{id}")
    Call<CategoryDto>getCategory();

    /********************************************
     * Comments
     *********************************************/

    @GET("comments/post/{postId}")
    Call<List<CommentsDto>> getPostComments(@Path("postId") Long id);

}
