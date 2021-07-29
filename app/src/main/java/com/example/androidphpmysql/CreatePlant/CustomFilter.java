package com.example.androidphpmysql.CreatePlant;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter extends Filter {

    com.example.androidphpmysql.CreatePlant.Adapter adapter;
    ArrayList<com.example.androidphpmysql.CreatePlant.Plants> filterList;

    public CustomFilter(ArrayList<com.example.androidphpmysql.CreatePlant.Plants> filterList, com.example.androidphpmysql.CreatePlant.Adapter adapter)
    {
        this.adapter=adapter;
        this.filterList=filterList;

    }

    //FILTERING OCcURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();
        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<com.example.androidphpmysql.CreatePlant.Plants> filteredPlants=new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getName().toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredPlants.add(filterList.get(i));
                }
            }

            results.count=filteredPlants.size();
            results.values=filteredPlants;

        }else
        {
            results.count=filterList.size();
            results.values=filterList;
        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.plants= (ArrayList<com.example.androidphpmysql.CreatePlant.Plants>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();

    }
}