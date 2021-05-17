package com.thirtydays.roomdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
//    UserDao userDao;
//    UserDatabase userDatabase;
    private TextView tv;
    private UserViewModel userViewModel;
    //    LiveData<List<User>> allUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        userDatabase = Room.databaseBuilder(this, UserDatabase.class, "user_database")
////                .allowMainThreadQueries()
//                .build();
//        userDatabase = UserDatabase.getInstance(this);
//        userDao = userDatabase.getUserDao();
        userViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(UserViewModel.class);
        tv = findViewById(R.id.tv);
//        allUsers = userDao.getAllUsersLive();
//        userDao.deleteAllUsers();
//        updateView();
        userViewModel.getAllUserLive().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> allUsers) {
                StringBuilder text = new StringBuilder();
                for (int i = 0; i < allUsers.size(); i++) {
                    User user = allUsers.get(i);
                    text.append(user.getId()).append(":").append(user.getName()).append("-").append(user.getSex()).append("-").append(user.getAge()).append("\n");
                }
                tv.setText(text.toString());
            }
        });
    }


    public void insert(View view) {
        User user = new User("张三", "男", 18);
        User user2 = new User("李四", "男", 20);
//        userDao.insertUser(user, user2);
//        updateView();
//        new InsertAsyncTask(userDao).execute(user, user2);
        userViewModel.insertUser(user,user2);
    }

    public void delete(View view) {
        User user = new User("张三", "男", 18);
        user.setId(130);
//        userDao.deleteUser(user);
//        new DeleteAsyncTask(userDao).execute(user);
        userViewModel.deleteUser(user);
    }

    public void update(View view) {
        User user = new User("王五", "男", 30);
        user.setId(129);
//        userDao.updateUser(user);
//        new UpdateAsyncTask(userDao).execute(user);
//        updateView();
        userViewModel.updateUser(user);
    }

//    private void updateView() {
//        List<User> allUsers = userDao.getAllUsers();
//        String text = "";
//        for (int i = 0; i < allUsers.size(); i++) {
//            User user = allUsers.get(i);
//            text += user.getId() + ":" + user.getName() + "-" + user.getSex() + "-" + user.getAge() + "\n";
//        }
//        tv.setText(text);
//    }

    public void clear(View view) {
        userViewModel.deleteAllUsers();
//        new DeleteAllAsyncTask(userDao).execute();
//        userDao.deleteAllUsers();
//        updateView();
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