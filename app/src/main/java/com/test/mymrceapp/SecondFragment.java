package com.test.mymrceapp;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


public class SecondFragment extends Fragment {
    TextView next, back, tv3, tv5;
    ViewPager viewpager;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        next = view.findViewById(R.id.slidetwonext);
        tv3 = view.findViewById(R.id.textView3);
        tv5 = view.findViewById(R.id.textView5);

        tv3.setMovementMethod(new ScrollingMovementMethod());
        tv5.setMovementMethod(new ScrollingMovementMethod());
        viewpager = getActivity().findViewById(R.id.viewpager);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpager.setCurrentItem(2);
            }
        });
        back = view.findViewById(R.id.slidetwoback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpager.setCurrentItem(0);
            }
        });


        return view;
    }
}
