package com.thirtydays.roomdemo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Description : database access object
 *
 * @author Coco
 * @date 2021/5/17
 */
@Dao
public interface UserDao {
    @Insert
    void insertUser(User user);

    @Insert
    void insertUser(User... users);

    @Update
    void updateUser(User user);

    @Update
    void updateUser(User... user);

    @Delete
    void deleteUser(User user);

    @Delete
    void deleteUser(User... user);

    @Query("DELETE FROM USER")
    void deleteAllUsers();

    @Query("SELECT * FROM USER ORDER BY ID DESC")
    List<User> getAllUsers();

    @Query("SELECT * FROM USER ORDER BY ID DESC")
    LiveData<List<User>> getAllUsersLive();
}
