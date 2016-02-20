package rocky.flicgame;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import io.flic.lib.FlicAppNotInstalledException;
import io.flic.lib.FlicBroadcastReceiver;
import io.flic.lib.FlicButton;
import io.flic.lib.FlicManager;
import io.flic.lib.FlicManagerInitializedCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FlicManager.setAppCredentials("7a2b9f70-442b-4a73-ae8e-2bdbf010c439","566cd1c2-a50b-4d70-aca7-2e2f4b09d339","FlicGame");
        try {
            FlicManager.getInstance(this, new FlicManagerInitializedCallback() {
                @Override
                public void onInitialized(FlicManager manager) {
                    manager.initiateGrabButton(MainActivity.this);
                }
            });
        } catch (FlicAppNotInstalledException err) {
            Toast.makeText(this, "Flic App is not installed", Toast.LENGTH_SHORT).show();
        }
    }
}

