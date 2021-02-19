package com.example.boundservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.FileDescriptor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    private final IBinder myBinder = new MyLocalBinder();

    public MyService() {
    }

    public class MyLocalBinder extends Binder {
        MyService getService(){
            return MyService.this;
        }
    }

    public String getCurrentTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return (dateFormat.format(new Date()));
    }

    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }
}
