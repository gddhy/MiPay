package net.gddhy.mipay;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MiPaySetActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = getSharedPreferences("set",Context.MODE_PRIVATE);
        preferences.edit().putBoolean("TileStatus",!preferences.getBoolean("TileStatus",false)).apply();
        Toast.makeText(this, "磁贴改为"+(preferences.getBoolean("TileStatus",false)?"开":"关"), Toast.LENGTH_LONG).show();
        finish();
    }
}
