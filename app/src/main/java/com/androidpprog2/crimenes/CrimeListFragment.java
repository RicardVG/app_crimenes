package com.androidpprog2.crimenes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CrimeListFragment extends RecyclerView.Adapter<CrimeListFragment.ViewHolder>{

    private ArrayList<Crime> crimeList;

    public CrimeListFragment(ArrayList<Crime> crimeList){
        this.crimeList = crimeList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTxt;
        private TextView dateTxt;

        public ViewHolder(final View view) {
            super(view);
            nameTxt = view.findViewById(R.id.crimeName);
            dateTxt = view.findViewById(R.id.crimeDate);
        }
    }

    @NonNull
    @Override
    public CrimeListFragment.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_crime,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CrimeListFragment.ViewHolder holder, int position) {
        String name = crimeList.get(position).getmTitle();
        holder.nameTxt.setText(name);
    }

    @Override
    public int getItemCount() {
        return crimeList.size();
    }
}
