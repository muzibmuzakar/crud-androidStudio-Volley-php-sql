package com.muzibmuzakar.uasAndroidStudio;

import android.widget.Filter;

import java.util.ArrayList;

/*
 * Created by Ahmad Abu Hasan on 07/01/2021
 */

public class CustomFilter extends Filter {

    RecyclerViewAdapter adapter;
    ArrayList<ModelPelajaran> filterList;

    public CustomFilter(ArrayList<ModelPelajaran> filterList, RecyclerViewAdapter adapter) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        //CHECK CONSTRAINT VALIDITY
        if (constraint != null && constraint.length() > 0) {
            //CHANGE TO UPPER
            constraint = constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<ModelPelajaran> filteredData = new ArrayList<>();
            for (int i = 0; i < filterList.size(); i++) {
                //CHECK
                if (filterList.get(i).getPel_name().toUpperCase().contains(constraint)) {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredData.add(filterList.get(i));
                }
            }
            results.count = filteredData.size();
            results.values = filteredData;
        } else {
            results.count = filterList.size();
            results.values = filterList;
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.arrayModelPelajarans = (ArrayList<ModelPelajaran>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();
    }
}
