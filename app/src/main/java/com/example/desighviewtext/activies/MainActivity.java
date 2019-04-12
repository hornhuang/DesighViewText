package com.example.desighviewtext.activies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.desighviewtext.R;
import com.example.desighviewtext.views.TopBar;
import com.example.desighviewtext.views.TopBarOnClickListener;

public class MainActivity extends BaseActivity {

    //创建自定义控件
    private TopBar topBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
////        topBar = (TopBar) layoutInflater.inflat
//        topBar.setButtonVisable(0, true);
//        topBar.setButtonVisable(1, false);
//        topBar.setOnTopBarClickListner(new TopBarOnClickListener() {
//            @Override
//            public void LeftClick() {
//                Toast.makeText(MainActivity.this, "you click left!", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void RightClick() {
//                Toast.makeText(MainActivity.this, "you click right!", Toast.LENGTH_SHORT).show();
//            }
//        });

//        //初始化自定义控件
//        topBar = (TopBar) findViewById(R.id.topbar);
//        //为自定义控件添加按钮的监听事件
//        topBar.setOnTopBarBtnsClick(new TopBar.TopBarBtnsOnClickListener() {
//            @Override
//            public void leftBtnOnClick() {
//                Toast.makeText(MainActivity.this,"LEFT",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void rightBtnOnClick() {
//                Toast.makeText(MainActivity.this,"RIGHT",Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
