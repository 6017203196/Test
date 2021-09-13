package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.baidu.safekeyboard.SafeEditText;
import com.baidu.safekeyboard.SafeKeyboard;

public class MainActivity extends AppCompatActivity {
    private SafeKeyboard keyboard;
    private SafeEditText et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout container = findViewById(R.id.keyboardContainer); // 键盘占位布局
        View root = findViewById(R.id.fubuju);                       // 安全键盘所在activity根布局
        View parent = findViewById(R.id.fubuju);             // 安全键盘所在文件所有安全键盘的共同父布局
        keyboard = new SafeKeyboard(this, container, root, parent);   // 初始化安全键盘对象
        keyboard.setForbidPreview(true);                        // 禁止安全键盘预览功能
        et = findViewById(R.id.phone_et);                              // 获取输入框控件
        keyboard.putEditText(et);                              //安全键盘对象新增输入框，一个activity可对多个输入框组件

    }

    @Override
    public void onBackPressed() {
        if (keyboard.stillNeedOptManually(false)) {
            keyboard.hideKeyboard();
            return;
        }
        super.onBackPressed();
    }







}