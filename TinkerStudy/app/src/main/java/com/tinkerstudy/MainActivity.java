package com.tinkerstudy;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.info);

        textView.setText("fix......");

        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/patch_signed_7zip.apk");

        if(file.exists()){
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),file.getAbsolutePath());
        }

    }
}
