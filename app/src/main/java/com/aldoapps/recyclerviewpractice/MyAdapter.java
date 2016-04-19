package com.aldoapps.recyclerviewpractice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aldokelvianto on 17/04/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Cat> catList;

    public interface MyInterface {
        void OnCatClicked(Cat cat);
    }

    public MyInterface mListener;

    public MyAdapter(ArrayList<Cat> catList) {
        this.catList = catList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        try{
            mListener = (MyInterface) parent.getContext();
        }catch (ClassCastException e){
            throw new ClassCastException("Must implement MyInterface");
        }

        MyViewHolder viewHolder = new MyViewHolder(mListener, view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Cat cat = catList.get(position);
        holder.name.setText(cat.getName());
        holder.age.setText(String.valueOf(cat.getAge()));
        holder.setCat(cat);
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView age;
        private Cat cat;

        public MyViewHolder(final MyInterface listener, View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.cat_name);
            age = (TextView) itemView.findViewById(R.id.cat_age);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cat != null && listener != null){
                        listener.OnCatClicked(cat);
                    }
                }
            });
        }

        public void setCat(Cat cat) {
            this.cat = cat;
        }
    }
}
