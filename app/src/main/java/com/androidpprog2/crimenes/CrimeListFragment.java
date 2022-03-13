package com.androidpprog2.crimenes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/*
public class CrimeListFragment extends Fragment {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTxt;

        public ViewHolder(final View view) {
            super(view);
            nameTxt = view.findViewById(R.id.crimeName);
        }
    }

    public class CrimeAdapter extends RecyclerView.Adapter<CrimeListFragment.ViewHolder>{

        private ArrayList<Crime> crimeList;

        public CrimeAdapter(ArrayList<Crime> crimes){
            this.crimeList = crimes;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crime_list, container, false);
    }
}

 */

public class CrimeListFragment extends Fragment {

    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;

    public void updateUI() {
        CrimeLab crimeLab = CrimeLab.getInstance(this.getContext());
        List<Crime> crimes = crimeLab.getCrimeList();

        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }

    //Adapter
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes){ mCrimes = crimes; }

        @Override
        public int getItemCount() { return mCrimes.size(); }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            return new CrimeHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder holder, int position) {
            Crime crime = mCrimes.get(position);
            holder.bind(crime);
        }
    }

    //ViewHolder
    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Crime mCrime;

        private TextView mTitleTextView;

        public CrimeHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_crime, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = itemView.findViewById(R.id.crime_title);
        }

        public void bind(Crime crime) {
            mCrime = crime;
            mTitleTextView.setText(mCrime.getmTitle());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getContext(),
                    mCrime.getmTitle() + " clicked!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}

