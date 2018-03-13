package com.didactapp.commons.cloudlibrary.data.persistence;

import android.support.annotation.NonNull;

import com.apkfuns.logutils.LogUtils;
import com.didactapp.commons.cloudlibrary.data.BookDataSource;
import com.didactapp.commons.cloudlibrary.data.network.ApiClient;
import com.didactapp.commons.cloudlibrary.data.network.ApiInterface;
import com.didactapp.commons.cloudlibrary.data.network.RemoteGatewayCallback;
import com.didactapp.commons.cloudlibrary.entities.Book;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by roman on 12/03/2018.
 */

public class LocalGateway implements BookDataSource, Callback<List<Book>> {

    private static LocalGateway INSTANCE = null;

    private WeakReference<RemoteGatewayCallback> callback = null;

    private LocalGateway() {
    }


    public static LocalGateway getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LocalGateway();
        }
        return INSTANCE;
    }


    @Override
    public void getBookList(@NonNull RemoteGatewayCallback callback) {

        this.callback = new WeakReference<>(callback);
        Call<List<Book>> call;
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        call = apiInterface.getBookList();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
//        TODO: should check callback.get() != null before every call to it
        if (callback != null && callback.get() != null) {
            // response.isSuccessful() is true if the response code is 2xx
            if (response.isSuccessful()) {
                List<Book> bookList = response.body();
                callback.get().onLoadSuccess(bookList);

            } else if (response.body() == null || response.body().isEmpty()) {
                callback.get().onDataNotAvailable();
            }
        } else {
            // TODO: handle error cases
            LogUtils.d("error status code returned");
            callback.get().onLoadFailed();
        }
    }

    @Override
    public void onFailure(Call<List<Book>> call, Throwable t) {
        RemoteGatewayCallback req = null;
        if (callback != null) {
            req = callback.get();
        }
        if (req != null) {
            req.onLoadFailed();
        }
    }

}
