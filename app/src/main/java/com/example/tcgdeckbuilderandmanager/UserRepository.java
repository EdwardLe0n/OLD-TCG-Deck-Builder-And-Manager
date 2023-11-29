package com.example.tcgdeckbuilderandmanager;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class UserRepository {

    private UserDao mUserDao;
    private LiveData<List<Users>> mAllUsers;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    UserRepository(Application application) {
        UserRoomDatabase db = UserRoomDatabase.getDatabase(application);
        mUserDao = db.userDao();
        mAllUsers = mUserDao.getAlphabetizedWords();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Users>> getAllUsers() {
        return mAllUsers;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Users user) {
        UserRoomDatabase.databaseWriteExecutor.execute(() -> {
            mUserDao.insert(user);
        });
    }
}