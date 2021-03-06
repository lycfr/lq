package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.smtt.sdk.TbsConfig;
import java.io.File;

public class aa {
    private static File a = null;

    public static long a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    @TargetApi(9)
    public static boolean a(Context context) {
        File dir;
        if (context == null) {
            return false;
        }
        if (a == null) {
            try {
                if (!context.getApplicationInfo().processName.contains(TbsConfig.APP_WX) || (dir = context.getDir("tbs", 0)) == null || !dir.isDirectory()) {
                    return false;
                }
                File file = new File(dir, "share");
                if (file != null) {
                    if (!file.isDirectory() && !file.mkdir()) {
                        return false;
                    }
                    a = file;
                    file.setExecutable(true, false);
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
