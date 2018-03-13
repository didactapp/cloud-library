package com.didactapp.commons.cloudlibrary.data.network;

import com.didactapp.commons.cloudlibrary.entities.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("books.json")
    Call<List<Book>> getBookList();
}