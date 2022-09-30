package com.example.mywechat;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Fragment tab01= new weixinFragment();
    private Fragment tab02= new friendsFragment();
    private Fragment tab03= new addressFragment();
    private Fragment tab04= new settingsFragment();
    private FragmentManager fm;

    private ImageButton weixinImg;
    private ImageButton friendsImg;
    private ImageButton addressImg;
    private ImageButton settingsImg;

    private LinearLayout TabWeixin;
    private LinearLayout TabFrd;
    private LinearLayout TabAddress;
    private LinearLayout TabSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initFragment();
        initView();
        initEvent();
        select(0);
    }
    private void initView(){
        TabWeixin =(LinearLayout)findViewById(R.id.tab_weixin);
        TabFrd = (LinearLayout)findViewById(R.id.tab_friends);
        TabAddress = (LinearLayout)findViewById(R.id.tab_contacts);
        TabSettings =(LinearLayout)findViewById(R.id.tab_settings);

        weixinImg = (ImageButton) findViewById(R.id.tab_weixin_img);
        friendsImg = (ImageButton) findViewById(R.id.tab_friends_img);
        addressImg =  (ImageButton) findViewById(R.id.tab_contacts_img);
        settingsImg = (ImageButton) findViewById(R.id.tab_settings_img);
    }

    private void initFragment(){
        fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.id_content,tab01);
        transaction.add(R.id.id_content,tab02);
        transaction.add(R.id.id_content,tab03);
        transaction.add(R.id.id_content,tab04);
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(tab01);
        transaction.hide(tab02);
        transaction.hide(tab03);
        transaction.hide(tab04);
    }

    private void select(int i){
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        resetImg();
        switch (i){
            case 0:
                transaction.show(tab01);
                weixinImg.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                transaction.show(tab02);
                friendsImg.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                transaction.show(tab03);
                addressImg.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                transaction.show(tab04);
                settingsImg.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void resetImg(){
        weixinImg.setImageResource(R.drawable.tab_weixin_normal);
        friendsImg.setImageResource(R.drawable.tab_find_frd_normal);
        addressImg.setImageResource(R.drawable.tab_address_normal);
        settingsImg.setImageResource(R.drawable.tab_settings_normal);
    }


    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId()){
            case R.id.tab_weixin:
                select(0);
                break;
            case R.id.tab_friends:
                select(1);
                break;
            case R.id.tab_contacts:
                select(2);
                break;
            case R.id.tab_settings:
                select(3);
                break;
        }
    }

    public void initEvent(){
        TabWeixin.setOnClickListener(this);
        TabFrd.setOnClickListener(this);
        TabAddress.setOnClickListener(this);
        TabSettings.setOnClickListener(this);
    }

}
