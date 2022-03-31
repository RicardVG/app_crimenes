package com.androidpprog2.crimenes.api;

import com.androidpprog2.crimenes.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonplaceholderAPI {
    @GET("todos/{todoID}")
    Call<Task> getTodo(@Path("todoID") String todoID);

    @GET("todos")
    Call<List<Task>> getTodos();

}
