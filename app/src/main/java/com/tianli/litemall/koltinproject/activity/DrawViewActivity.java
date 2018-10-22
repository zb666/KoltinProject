package com.tianli.litemall.koltinproject.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.tianli.litemall.koltinproject.MainActivity;
import com.tianli.litemall.koltinproject.R;
import com.tianli.litemall.koltinproject.kotlinview.BeizerWaveView;

import java.lang.ref.WeakReference;

import okhttp3.Dispatcher;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

public class DrawViewActivity extends AppCompatActivity {

//    private static final int CHOOSE_PHONE = 0x12;

    private static final int TAKE_PHONE = 1;

    private static final int CHOOSE_PHONE = 2;
    private ImageView imageView;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawview);
        imageView = findViewById(R.id.imageview);

        findViewById(R.id.textview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAdd();
            }
        });
        TextView textView = findViewById(R.id.textview);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layoutParams.bottomMargin = 300;

        textView.setLayoutParams(layoutParams);


    }

    private void startAdd() {
        BeizerWaveView beizerWaveView = new BeizerWaveView(this);
        LinearLayout linearLayout = findViewById(R.id.llContainer);
        linearLayout.addView(beizerWaveView);
        beizerWaveView.setWaveColor();
        beizerWaveView.startAnim();
    }

    private void startJump() {
        autoObtainCameraPermission();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PHONE:
                if (resultCode == RESULT_OK) {

                }
                break;
        }
    }


    /**
     * 自动获取相机权限
     */
    private void autoObtainCameraPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {   //权限还没有授予，需要在这里写申请权限的代码
            // 第二个参数是一个字符串数组，里面是你需要申请的权限 可以设置申请多个权限
            // 最后一个参数是标志你这次申请的权限，该常量在onRequestPermissionsResult中使用到
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    TAKE_PHONE);
        } else { //权限已经被授予，在这里直接写要执行的相应方法即可
            takePhoto();
        }
    }

    private void takePhoto() {
        Intent intentToTakePhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intentToTakePhoto);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

}
