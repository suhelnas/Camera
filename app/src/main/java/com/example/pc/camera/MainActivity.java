package com.example.pc.camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button  b= (Button)findViewById(R.id.button);
         iv=(ImageView)findViewById(R.id.imageButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
    }
       protected void onActivityResult(int requestCode,int resultcode,Intent data){
           super.onActivityResult(requestCode,resultcode,data);
           Bitmap bm=(Bitmap)data.getExtras().get("data");
           iv.setImageBitmap(bm);
}
}