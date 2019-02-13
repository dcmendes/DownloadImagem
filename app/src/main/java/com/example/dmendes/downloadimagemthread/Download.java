package com.example.dmendes.downloadimagemthread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Download {

    public static Bitmap downloadBitmap(String url) throws IOException{

        Bitmap bitmap = null;
        InputStream in = new URL(url).openStream();

        bitmap = BitmapFactory.decodeStream(in);
        in.close();
        return bitmap;
    }
}
