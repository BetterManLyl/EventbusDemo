package com.lyl.eventbusdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.btn_event)
    Button btnEvent;
    private int length = 4;

    private int[] fragments;

    private MyFragmentPageAdapter myFragmentPageAdapter;

    private String[] titles;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        getExtraValue();
        initView();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void getExtraValue() {
        fragments = new int[length];
        titles = new String[length];
    }


    public void initView() {
        myFragmentPageAdapter = new MyFragmentPageAdapter(getSupportFragmentManager(), this);
        for (int i = 0; i < fragments.length; i++) {
            myFragmentPageAdapter.addFragment(i);
        }
        viewpager.setAdapter(myFragmentPageAdapter);
        tablayout.setupWithViewPager(viewpager);

        tablayout.setTabGravity(Gravity.CENTER);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    /**
     * 发送事件
     */
    @OnClick(R.id.btn_event)
    public void onViewClicked() {
        EventBus.getDefault().post(new FragmentEvent());
    }
}
