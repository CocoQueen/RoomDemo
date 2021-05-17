package com.thirtydays.roomdemo;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/**
 * Description :
 *
 * @author Coco
 * @date 2021/5/17
 */
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();

    private static UserDatabase INSTANCE;

    static synchronized UserDatabase getInstance(Context context) {
        if (null == INSTANCE) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "user_database")
                    .build();
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
