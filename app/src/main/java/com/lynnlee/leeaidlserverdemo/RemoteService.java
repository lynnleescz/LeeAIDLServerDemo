package com.lynnlee.leeaidlserverdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class RemoteService extends Service {
    private static final String TAG = "Lee-Server";
    private List<Book> mBookList;

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind");
        return new LocalBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
        mBookList = new ArrayList<>();
    }

    private class LocalBinder extends IBookManager.Stub {
        @Override
        public List<Book> getBookList() throws RemoteException {
            Log.e(TAG, "getBookList");
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            Log.e(TAG, "addBook");
            mBookList.add(book);
        }
    }
}
