package com.tinkerstudy;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.info);

//        Log.d(TAG,"此时程序会崩溃，因为布局文件中没有给textview设置id");
//
//        textView.setText("正常发布的版本");

        Log.d(TAG,"修改了布局文件，给textview设置了id,正常实例化控件");

        textView.setText("bug修复了");
    }
}
