package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView mAnimationView;
    private ListView mListView;
    private ArrayAdapter<Item> adapterItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        ArrayList<Item> items = Item.getItems();
        adapterItems = new ArrayAdapter<Item>(getActivity(), android.R.layout.simple_list_item_1, items);
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        mListView = view.findViewById(R.id.list_view);
        mListView.setAdapter(adapterItems);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                mAnimationView = getView().findViewById(R.id.ex3_animation_view);

                ObjectAnimator animationAlphaAnimator = ObjectAnimator.ofFloat(mAnimationView,
                        "Alpha", 1.0f, 0f);
                animationAlphaAnimator.setDuration(500);

                mListView = getView().findViewById(R.id.list_view);
                ObjectAnimator listViewAlphaAnimator = ObjectAnimator.ofFloat(mListView,
                        "Alpha", 0f, 1.0f);
                listViewAlphaAnimator.setDuration(500);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animationAlphaAnimator, listViewAlphaAnimator);
                animatorSet.start();
            }
        }, 2000);
    }
}
