//package com.didactapp.android.cloudlibrary.data.persistence;
//
///**
// * Created by roman on 11/03/2018.
// */
//
///*
// * Copyright 2016, The Android Open Source Project
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//import android.support.annotation.NonNull;
//import android.support.annotation.VisibleForTesting;
//
//import com.didactapp.android.cloudlibrary.data.BookDataSource;
//import com.didactapp.android.cloudlibrary.models.Book;
//import com.didactapp.android.cloudlibrary.util.AppExecutor;
//
//import java.util.List;
//
//import static android.support.v4.util.Preconditions.checkNotNull;
//
//
///**
// * Concrete implementation of a data source as a db.
// */
//public class BookLocalDataSource implements BookDataSource {
//
//    private static volatile BookLocalDataSource INSTANCE;
//
//    private BookDao bookDao;
//
//    private AppExecutor appExecutor;
//
//    // Prevent direct instantiation.
//    private BookLocalDataSource(@NonNull AppExecutor appExecutor,
//                                @NonNull BookDao bookDao) {
//        this.appExecutor = appExecutor;
//        bookDao = bookDao;
//    }
//
//    public static BookLocalDataSource getInstance(@NonNull AppExecutor appExecutors,
//                                                   @NonNull BookDao bookDao) {
//        if (INSTANCE == null) {
//            synchronized (BookDataSource.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = new BookLocalDataSource(appExecutors, bookDao);
//                }
//            }
//        }
//        return INSTANCE;
//    }
//
//    /**
//     * Note: onDataNotAvailable() is fired if the database doesn't exist
//     * or the table is empty.
//     */
//    @Override
//    public void getBookList(@NonNull final LoadTasksCallback callback) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                final List<Task> tasks = bookDao.getTasks();
//                appExecutor.mainThread().execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (tasks.isEmpty()) {
//                            // This will be called if the table is new or just empty.
//                            callback.onDataNotAvailable();
//                        } else {
//                            callback.onTasksLoaded(tasks);
//                        }
//                    }
//                });
//            }
//        };
//
//        appExecutor.diskIO().execute(runnable);
//    }
//
//
//    @Override
//    public void saveBook(@NonNull final Book book) {
//        checkNotNull(book);
//        Runnable saveRunnable = new Runnable() {
//            @Override
//            public void run() {
//                bookDao.insert(book);
//            }
//        };
//        appExecutor.diskIO().execute(saveRunnable);
//    }
//
//    @VisibleForTesting
//    static void clearInstance() {
//        INSTANCE = null;
//    }
//}
