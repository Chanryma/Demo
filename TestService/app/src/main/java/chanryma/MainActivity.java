package chanryma;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    private boolean isServiceStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isServiceStarted) {
                    InfiniteLoopService.stop();
                } else {
                    InfiniteLoopService.start(MainActivity.this);
                }
                isServiceStarted = !isServiceStarted;
            }
        });

        findViewById(R.id.btn_another).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Once service is started, the App won't respond to clicks on this button.
                // Because the main thread is blocked by the infinite loop in InfiniteLoopService.
                Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
