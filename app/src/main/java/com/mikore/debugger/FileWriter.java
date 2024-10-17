package com.mikore.debugger;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;

public class FileWriter
{
    public static void w(String filename, String data)
    {
        w(filename, data, false);
    }

    public static void w(String filename, String data, boolean append)
    {
        try {
            String fp = "/data/data/com.nathnetwork.xciptv/files/";
            File path = new File(fp + filename);

            File parent = path.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }

            FileOutputStream fos = new FileOutputStream(path, append);
            byte[] bytes = data.getBytes("UTF-8");
            fos.write(bytes);
            fos.close();
        } catch (Exception e) {
            Log.e("FWC_TAG", "Write To File Exception: " + Log.getStackTraceString(e), e);
        }
    }
}
