package com.lyl.eventbusdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author lyl
 * @date 2017/12/8.
 * MyFragment
 */

public class MyFragment extends Fragment {
    @BindView(R.id.tv_fragment)
    TextView tvFragment;
    Unbinder unbinder;
    private int position;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.lazy_fragment, container,
                false);
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initView(View view) {
        Bundle bundle = this.getArguments();
        position = bundle.getInt("position", 0);
        tvFragment.setText("第" + position + "个");
    }

    /**
     * 接收activity发出的事件
     * @param event
     */
    @Subscribe
    public void onEvent(FragmentEvent event) {
        Log.e("lyl", "onEvent: " +tvFragment.getText().toString());
        Toast.makeText(getActivity(), "接收到发出的事件"+tvFragment.getText().toString(),
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        unbinder.unbind();
    }

    public static MyFragment _instanceMyFragment(int position) {
        MyFragment myFragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @OnClick(R.id.tv_fragment)
    public void onViewClicked() {
    }
}
