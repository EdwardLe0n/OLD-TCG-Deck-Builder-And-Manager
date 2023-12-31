package com.example.tcgdeckbuilderandmanager;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class CardRepository {

    private CardDao mCardDao;
    private LiveData<List<Card>> mAllCards;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    CardRepository(Application application) {
        CardRoomDatabase db = CardRoomDatabase.getDatabase(application);
        mCardDao = db.cardDao();
        mAllCards = mCardDao.getAlphabetizedWords();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Card>> getAllCards() {
        return mAllCards;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Card card) {
        CardRoomDatabase.databaseWriteExecutor.execute(() -> {
            mCardDao.insert(card);
        });
    }
}