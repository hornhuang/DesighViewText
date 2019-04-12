package com.example.desighviewtext.activies;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.desighviewtext.R;
import com.example.desighviewtext.views.TopBar;
import com.example.desighviewtext.views.TopBarOnClickListener;
import com.example.desighviewtext.views.UI3_6_3_1;
import com.example.desighviewtext.views.UI_3_6_3_2;

public class MainActivity extends BaseActivity {

    //创建自定义控件
    private TopBar topBar;
    private UI3_6_3_1 ui3_6_3_1;
    private UI_3_6_3_2 ui_3_6_3_2;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ui3_6_3_1.setProgress(msg.arg1);
        }
    };

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

//        ui3_6_3_1 = (UI3_6_3_1) findViewById(R.id.ui_3_6_3_1);
//        new Thread(){
//            @Override
//            public void run() {
//                int i = 0 ;
//                while (i++ < 100){
//                    try {
//                        sleep(100);
//                        Message msg = new Message();
//                        msg.arg1 = i;
//                        handler.sendMessage(msg);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    Log.d("123123", "123123");
//                }
//            }
//        }.start();

        ui_3_6_3_2 = (UI_3_6_3_2)findViewById(R.id.ui_3_6_3_2);
    }
}
