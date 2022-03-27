package com.example.travelbug;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.security.AccessControlContext;
import java.util.List;

public class cityadapter extends RecyclerView.Adapter<cityadapter.city_ViewHolder>{

    LayoutInflater inflater;
    List<citydetails> ci_details;
    static RecyclerViewClickListener listener;

    public cityadapter(Context ctx, List<citydetails> ci_details,RecyclerViewClickListener listener){
        this.inflater = LayoutInflater.from(ctx);
        this.ci_details = ci_details;
        this.listener = listener;
    }

    @NonNull
    @Override
    public city_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.insidecitycard,parent,false);
        return new cityadapter.city_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull city_ViewHolder holder, int position) {
        Picasso.get().load(ci_details.get(position).getImage_url()).into(holder._place_img);
        holder._place_name.setText(ci_details.get(position).getPlace_name());
    }

    @Override
    public int getItemCount() {
        return ci_details.size();
    }


    public static class city_ViewHolder extends RecyclerView.ViewHolder{

        ImageView _place_img;
        TextView _place_name;
        Button b;
        public city_ViewHolder(@NonNull View itemView) {
            super(itemView);
            _place_img = itemView.findViewById(R.id.place_image);
            _place_name = itemView.findViewById(R.id.place_name);
            b = itemView.findViewById(R.id.place_viewbtn);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v,getAdapterPosition());
                }
            });

        }

    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int poition);
    }

}
