package com.awaisraza.menudrawer;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private View.OnClickListener mOnItemClickListener;
    private List<Items> mTestItemList;
    Context context;
    public MyAdapter(Context context,List<Items> mTestItemList) {
        this.context= context;
        this.mTestItemList=mTestItemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new MyViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.fName.setText(mTestItemList.get(position).getFname());
        holder.lName.setText(mTestItemList.get(position).getLname());
        Picasso.get().load(mTestItemList.get(position).getPicurl()).into(holder.picProfile);

    }

    @Override
    public int getItemCount() {
        return mTestItemList.size();


    }
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;}

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView lName,fName;
        CircleImageView picProfile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(mOnItemClickListener);
            fName= itemView.findViewById(R.id.textfname);
            lName=itemView.findViewById(R.id.textlname);
            picProfile=itemView.findViewById(R.id.picprofile);
            itemView.setTag(this);


        }
    }
}
