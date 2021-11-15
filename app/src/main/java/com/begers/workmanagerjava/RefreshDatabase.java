package com.begers.workmanagerjava;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class RefreshDatabase extends Worker {

    private Context myContext;

    public RefreshDatabase(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.myContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        refreshDatabase();
        return Result.success();
    }

    private void refreshDatabase(){
        SharedPreferences sharedPreferences = myContext.getSharedPreferences("com.begers.workmanagerjava", Context.MODE_PRIVATE);
        int mySaveNumber = sharedPreferences.getInt("myNumber", 0);
        mySaveNumber++;
        System.out.println(mySaveNumber);
        sharedPreferences.edit().putInt("myNumber", mySaveNumber).apply();
    }

}
