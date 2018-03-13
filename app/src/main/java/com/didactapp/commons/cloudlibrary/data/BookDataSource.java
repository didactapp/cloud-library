package com.didactapp.commons.cloudlibrary.data;

import android.support.annotation.NonNull;

import com.didactapp.commons.cloudlibrary.data.network.RemoteGatewayCallback;

/**
 * Created by roman on 11/03/2018.
 */

public interface BookDataSource {

    void getBookList(@NonNull RemoteGatewayCallback callback);

}
