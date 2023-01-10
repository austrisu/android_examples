package com.austris.scree_recorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private Button captureButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        captureButton = findViewById(R.id.capture);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }

        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the root view of the activity
                View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
                //create a bitmap with the same size as the view
                Bitmap bitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap.Config.ARGB_8888);
                //create a canvas with the bitmap
                Canvas canvas = new Canvas(bitmap);
                //draw the view on the canvas
                rootView.draw(canvas);

                //String filePath = Environment.getExternalStorageDirectory() + "/screenshot.png";
                String filePath = "/data/local/tmp/screenshot.png";
                File file = new File(filePath);
                FileOutputStream fos;
                try {
                    fos = new FileOutputStream(file);
                    //compress the bitmap with JPEG format
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    fos.flush();
                    fos.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "Screenshot Captured in - " + filePath, Toast.LENGTH_LONG).show();
            }
        });
    }
}