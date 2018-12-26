package com.example.pritesh.pr6_flashlight;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
public class MainActivity extends AppCompatActivity {

    Button onBtn,offBtn;
    Camera cam;
    Parameters p;
    boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onBtn=(Button)findViewById(R.id.onBtn);
        offBtn=(Button)findViewById(R.id.offBtn);

        onBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!status)
                {
                    cam = Camera.open();
                    p = cam.getParameters();
                    p.setFlashMode(Parameters.FLASH_MODE_TORCH);
                    cam.setParameters(p);
                    cam.startPreview();
                    status=true;
                }
            }
        });

        offBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(status) {
                    cam.stopPreview();
                    cam.release();
                    status=false;
                }
            }
        });
    }
}
