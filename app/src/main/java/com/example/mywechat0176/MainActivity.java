package com.example.mywechat0176;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Fragment fragment1,fragment2,fragment3,fragment4;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout1=findViewById(R.id.linearLayout1);
        linearLayout2=findViewById(R.id.linearLayout2);
        linearLayout3=findViewById(R.id.linearLayout3);
        linearLayout4=findViewById(R.id.linearLayout4);

        fragment1=new BlankFragment1();//父子两类方法函数都可用
        fragment2=new BlankFragment2();
        fragment3=new BlankFragment3();
        fragment4=new BlankFragment4();

        manager=getSupportFragmentManager();

        initial();
        hide();

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
    }

    private void initial() {
        FragmentTransaction transaction=manager.beginTransaction()
                .add(R.id.framelayout,fragment1)
                .add(R.id.framelayout,fragment2)
                .add(R.id.framelayout,fragment3)
                .add(R.id.framelayout,fragment4);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        int i=0;
        switch(view.getId()){
            case R.id.linearLayout1:select(1);
                break;
            case R.id.linearLayout2:select(2);
                break;
            case R.id.linearLayout3:select(3);
                break;
            case R.id.linearLayout4:select(4);
                break;
        }

    }
    public void select(int i){
        hide();
        switch (i){
            case 1:showFrament(fragment1);
                break;
            case 2:showFrament(fragment2);
                break;
            case 3:showFrament(fragment3);
                break;
            case 4:showFrament(fragment4);
                break;
            default:
                break;
        }
    }

    private void showFrament(Fragment fragment) {
        transaction.show(fragment);
    }

    private void hide(){
        transaction=manager.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4);
        transaction.commit();
    }
}
