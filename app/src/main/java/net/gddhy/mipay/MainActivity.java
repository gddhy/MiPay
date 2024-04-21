package net.gddhy.mipay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openMiPay(this);
        finish();
    }

    public static void openMiPay(Context context){
        if(isInstallApp(context,"com.miui.tsmclient")) {
            Intent i = new Intent();
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.setClassName("com.miui.tsmclient", "com.miui.tsmclient.ui.quick.DoubleClickActivity");
            context.startActivity(i);
        } else {
            Toast.makeText(context,"您的设备不支持MiPay",Toast.LENGTH_LONG).show();
        }

    }

    public static boolean isInstallApp(Context context, String packageName) {
        final PackageManager packageManager = context.getPackageManager();// 获取package manager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName.toLowerCase(Locale.ENGLISH);
                if (pn.equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }
}