package com.kkaty.myprojprep.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kkaty.myprojprep.Model.Business;
import com.kkaty.myprojprep.R;

import java.util.List;

public class BusinessesAdapter extends Recyclerview.Adapter<BusinessesAdapter.BusinessViewHolder> {

    Context mCtx;
    List<Business> businessList;

    public BusinessesAdapter(Context mCtx, List<Business> businessList) {
        this.mCtx = mCtx;
        this.businessList = businessList;
    }

    @NonNull
    @Override
    public BusinessViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.activity_recyclerview, parent, false);
        return new BusinessViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BusinessViewHolder holder, int position) {
        Business business = businessList.get(position);

        Glide.with(mCtx)
                .load(business.getImage_url())
                .into(holder.imageView);

        holder.textView.setText(business.getName());
    }

    @Override
    public int getItemCount() {
        return businessList.size();
    }

    class BusinessViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public BusinessViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }



}
