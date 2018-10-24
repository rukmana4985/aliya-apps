package com.project.aliya.connection.service;

import com.project.aliya.model.content.ModelInfo;
import com.project.aliya.model.request.RequestLogin;
import com.project.aliya.model.request.RequestSearchProduct;
import com.project.aliya.model.request.RequestUpdatePassword;
import com.project.aliya.model.response.ResponseChapter;
import com.project.aliya.model.response.ResponseDetailEbook;
import com.project.aliya.model.response.ResponseDetailInfo;
import com.project.aliya.model.response.ResponseDetailProduct;
import com.project.aliya.model.response.ResponseListBonus;
import com.project.aliya.model.response.ResponseListCategory;
import com.project.aliya.model.response.ResponseListInfo;
import com.project.aliya.model.response.ResponseListProduct;
import com.project.aliya.model.response.ResponseListVideo;
import com.project.aliya.model.response.ResponseLogin;
import com.project.aliya.model.response.ResponseUpdatePassword;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiConfig {

    @GET("product/{brand_id}")
    Call<ResponseListProduct> getListProduct(
            @Path("brand_id") Integer id
    );

    @GET("category_products")
    Call<ResponseListCategory> getCategory();

    @GET("ebook/detail/{page}")
    Call<ResponseDetailEbook> getDetailEbook(@Path("page") Integer page);

    @GET("bonus/member")
    Call<ResponseListBonus> getListBonus();

    @GET("info-paginate")
    Call<ResponseListInfo> getPagingInfo(@Query("page") int page);

    @POST("ebook-premium/login")
    Call<ResponseLogin> doLogin(@Body RequestLogin requestLogin);

    @POST("ebook-premium/change-password")
    Call<ResponseUpdatePassword> doUpdatePassword(@Body RequestUpdatePassword responseUpdatePassword);

    @POST("products/search")
    Call<ResponseListProduct> getPagingProduct(@Body RequestSearchProduct requestSearchProduct, @Query("page") int page);

    @GET("info/read/{id}")
    Call<ResponseDetailInfo> getDetailInfo(@Path("id") Integer id);

    @GET("products/detail/1")
    Call<ResponseDetailProduct> getDetailProduct(@Path("id") Integer id);
}
