package com.example.senzura.proactivity;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class LockoutOverlay extends Service {
    LinearLayout oView;

    @Override
    public IBinder onBind(Intent i) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        oView = new LinearLayout(this);
        oView.setBackgroundColor(0x00000000);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                0 | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.OPAQUE);
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        wm.addView(oView, params);
    }

    public void onDestroy() {
        super.onDestroy();
        if(oView != null) {
            WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
            wm.removeView(oView);
        }
    }
}
