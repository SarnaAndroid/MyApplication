package com.myapplication.interfaces;

import android.view.View;

import com.myapplication.models.ProductsData;

/**
 * Created by root on 9/7/18.
 */

public interface OnItemClickListener {

    void onItemClick(View view, ProductsData productsData);


}