
package com.example.firebasedemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;import android.widget.Toast;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class ProgramingAdapter extends RecyclerView.Adapter<ProgramingAdapter.ProgramingViewHolder>{

   ArrayList<Info> profiles;
    public ProgramingAdapter(ArrayList<Info> profiles){

        this.profiles=profiles;
    }
    @Override
    public ProgramingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.data, parent,false);
        return new ProgramingViewHolder(listItem);

    }

    @Override
    public void onBindViewHolder(@NonNull ProgramingViewHolder programingViewHolder, int i) {
         final int position=i;
        programingViewHolder.name.setText(profiles.get(i).getName().toString());
        programingViewHolder.fname.setText(profiles.get(i).getFather_name().toString());
        programingViewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(view.getContext(),"click on item: "+profiles.get(position).getName(),Toast.LENGTH_LONG).show();
                Intent it = new Intent(view.getContext(), Second.class);
                it.putExtra("Name", profiles.get(position).getName());

                view.getContext().startActivity(it);
            }
        });
    }
    public int getItemCount() {
        return profiles.size();
    }
    public class ProgramingViewHolder extends RecyclerView.ViewHolder{

        TextView name,fname;
        LinearLayout layout;
        public ProgramingViewHolder(@NonNull View itemView){
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            fname=(TextView)itemView.findViewById(R.id.fname);
            layout=(LinearLayout)itemView.findViewById(R.id.linear);
        }
    }
}
