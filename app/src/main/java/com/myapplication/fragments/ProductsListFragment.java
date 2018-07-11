package com.myapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.myapplication.R;
import com.myapplication.adapters.ProductListAdapter;
import com.myapplication.interfaces.OnItemClickListener;
import com.myapplication.models.ProductsData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsListFragment extends Fragment implements OnItemClickListener {


    private RecyclerView rvProductList;
    private View view;
    private LinearLayoutManager rvLayoutManagar;

    private ProductListAdapter productListAdapter;

    private ArrayList<ProductsData> productsDataArrayList;
    private ProductsData productsData;


    public ProductsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_products_list, container, false);
        initViews();
        addDataToProductArray();
        initViewWithData();
        return view;
    }

    private void addDataToProductArray() {

        for (int i = 0; i < 10; i++) {
            productsData = new ProductsData(1,"Name"+i,"q"+i+4,"Bs"+i,
                    ".45"+i,".55"+i, i+2);
            productsDataArrayList.add(productsData);
        }
    }

    private void initViews() {

        rvProductList = view.findViewById(R.id.rv_product_list);
        productsDataArrayList = new ArrayList<ProductsData>();

    }

    private void initViewWithData() {

        rvProductList.setHasFixedSize(true);

        // use a linear layout manager
        rvLayoutManagar = new LinearLayoutManager(view.getContext());
        rvProductList.setLayoutManager(rvLayoutManagar);

        // specify an adapter (see also next example)
        productListAdapter = new ProductListAdapter(getContext(), productsDataArrayList, this);
        rvProductList.setAdapter(productListAdapter);
    }

    @Override
    public void onItemClick(View view, ProductsData productsData) {

        switch(view.getId()){
            case R.id.layout_product_row:
                Toast.makeText(getContext(), productsData.getProductName()+"    "+productsData.getProductBrand(),Toast.LENGTH_LONG).show();
                break;
        }

    }
}
