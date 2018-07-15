package runa.mylibrary;

import android.content.Context;
import android.widget.Toast;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lyl
 * @date 2017/12/15.
 */

public class Utils {
    public static void toast(Context context) {
        Toast.makeText(context, "123456", Toast.LENGTH_SHORT).show();
        ExecutorService executorService1=new ThreadPoolExecutor(Integer.MAX_VALUE,10,10, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(12));
        ScheduledExecutorService scheduledExecutorService=new ScheduledThreadPoolExecutor(10);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
