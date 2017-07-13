package chanryma;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/**
 * Start an infinite loop when started, to verify that service is also running in main thread.
 */
public class InfiniteLoopService extends Service {
    private static InfiniteLoopService instance;

    public InfiniteLoopService() {
        instance = this;
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, InfiniteLoopService.class);
        context.startService(intent);
    }

    public static void stop() {
        if (instance != null) {
            instance.stopSelf();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int a = 0;
        int b = 1;
        while (a < b) {
            a--;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
