package com.myapplication.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myapplication.R;

public class AddProductFragment extends Fragment {

    private View view;

    public AddProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_add_products, container, false);
        initViews();
        initViewsWithData();


        return view;
    }

    private void initViews() {

    }

    private void initViewsWithData() {

    }

}
