package com.didactapp.android.cloudlibrary.data;

import android.support.annotation.NonNull;

import com.didactapp.android.cloudlibrary.data.network.RemoteGatewayCallback;

/**
 * Created by roman on 11/03/2018.
 */

public interface BookDataSource {

    void getBookList(@NonNull RemoteGatewayCallback callback);

}
