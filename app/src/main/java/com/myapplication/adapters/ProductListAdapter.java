package com.myapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myapplication.R;
import com.myapplication.interfaces.OnItemClickListener;
import com.myapplication.models.ProductsData;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> implements OnItemClickListener {

    private ArrayList<ProductsData> productsDataArrayList;
    private OnItemClickListener onItemClickListener;
    private Context mContext;



    public ProductListAdapter(Context mContext, ArrayList<ProductsData> productsDataArrayList, OnItemClickListener onItemClickListener) {
        this.mContext = mContext;
        this.productsDataArrayList = productsDataArrayList;
        this.onItemClickListener = onItemClickListener;
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_products_list, parent, false);
        return new ViewHolder(v);
    }


    public void updateData(ArrayList<ProductsData> productsData) {
        productsDataArrayList.clear();
        productsDataArrayList.addAll(productsData);
        notifyDataSetChanged();
    }

    public void addItem(int position, ProductsData productsData) {
        productsDataArrayList.add(position, productsData);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        productsDataArrayList.remove(position);
        notifyItemRemoved(position);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProductsData productsData = productsDataArrayList.get(position);


        holder.tvProductId.setText(String.valueOf(productsData.getProductId()));
        holder.tvProductName.setText(productsData.getProductName());
        holder.tvProductBrand.setText(productsData.getProductBrand());
        holder.tvProductQuantity.setText(productsData.getProductQuantity());
        holder.tvProductCyclendricalPower.setText(productsData.getProductCyclendricalPower());
        holder.tvProductSphericalPower.setText(productsData.getProductSphericalPower());
        holder.tvProductMinQuantity.setText(String.valueOf(productsData.getProductMinQuantity()));
        holder.layoutProductRow.setOnClickListener(view ->
                onItemClickListener.onItemClick(view, productsData));
    }

    @Override
    public int getItemCount() {
        return productsDataArrayList.size();
    }

    @Override
    public void onItemClick(View view, ProductsData productsData) {

    }


    protected class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvProductId, tvProductName, tvProductBrand, tvProductQuantity,
                tvProductSphericalPower, tvProductCyclendricalPower, tvProductMinQuantity;
        public RelativeLayout layoutProductRow;

        public ViewHolder(View itemView) {
            super(itemView);
            tvProductId = itemView.findViewById(R.id.tv_product_id);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductBrand = itemView.findViewById(R.id.tv_product_brand);
            tvProductQuantity = itemView.findViewById(R.id.tv_product_quantity);
            tvProductSphericalPower = itemView.findViewById(R.id.tv_product_spherical_power);
            tvProductCyclendricalPower = itemView.findViewById(R.id.tv_product_cyclindrical_power);
            tvProductMinQuantity = itemView.findViewById(R.id.tv_product_min_quantity);
            layoutProductRow = itemView.findViewById(R.id.layout_product_row);
        }
    }
}