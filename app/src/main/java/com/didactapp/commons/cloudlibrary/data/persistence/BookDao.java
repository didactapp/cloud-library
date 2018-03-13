package com.didactapp.commons.cloudlibrary.data.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.didactapp.commons.cloudlibrary.entities.Book;

import java.util.List;

/**
 * Created by roman on 06/03/2018.
 */

@Dao
public interface BookDao {
    @Query("SELECT * FROM Book")
    List<Book> getAll();

    @Insert
    void insert(Book book);

    @Insert
    void insertAll(Book... books);

    @Delete
    void delete(Book book);

}
