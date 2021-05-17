package com.thirtydays.roomdemo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * Description :
 *
 * @author Coco
 * @date 2021/5/17
 */
public class UserViewModel extends AndroidViewModel {
    private final UserRepository userRepository;

    public LiveData<List<User>> getAllUserLive() {
        return userRepository.getAllUserLive();
    }


    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    void insertUser(User... users) {
//        new InsertAsyncTask(userDao).execute(users);
        userRepository.insertUser(users);
    }

    void updateUser(User... users) {
//        new UpdateAsyncTask(userDao).execute(users);
        userRepository.updateUser(users);
    }

    void deleteUser(User... users) {
//        new DeleteAsyncTask(userDao).execute(users);
        userRepository.deleteUser(users);
    }

    void deleteAllUsers() {
//        new DeleteAllAsyncTask(userDao).execute();
        userRepository.deleteAllUsers();
    }

//    static class InsertAsyncTask extends AsyncTask<User, Void, Void> {
//        private UserDao userDao;
//
//        public InsertAsyncTask(UserDao userDao) {
//            this.userDao = userDao;
//        }
//
//        @Override
//        protected Void doInBackground(User... users) {
//            //在后台执行此操作
//            userDao.insertUser(users);
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            //将结果带回到主线程
//        }
//
//        @Override
//        protected void onProgressUpdate(Void... values) {
//            super.onProgressUpdate(values);
//            //进度更新时执行
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            //后台任务执行前执行
//        }
//    }
//
//    static class DeleteAsyncTask extends AsyncTask<User, Void, Void> {
//        private UserDao userDao;
//
//        public DeleteAsyncTask(UserDao userDao) {
//            this.userDao = userDao;
//        }
//
//        @Override
//        protected Void doInBackground(User... users) {
//            userDao.deleteUser(users);
//            return null;
//        }
//    }
//
//    static class UpdateAsyncTask extends AsyncTask<User, Void, Void> {
//        private UserDao userDao;
//
//        public UpdateAsyncTask(UserDao userDao) {
//            this.userDao = userDao;
//        }
//
//        @Override
//        protected Void doInBackground(User... users) {
//            userDao.updateUser(users);
//            return null;
//        }
//    }
//
//    static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
//        private UserDao userDao;
//
//        public DeleteAllAsyncTask(UserDao userDao) {
//            this.userDao = userDao;
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            userDao.deleteAllUsers();
//            return null;
//        }
//    }
}
