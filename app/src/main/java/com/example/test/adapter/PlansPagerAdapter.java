package com.example.test.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.test.frgment.DynamicFragment;

import java.util.ArrayList;
import java.util.HashMap;


public class PlansPagerAdapter extends FragmentStatePagerAdapter
{
    int mNumOfTabs;
    ArrayList<String> tabTitle;
    ArrayList<HashMap<String,String>> cat_list;

    public PlansPagerAdapter(FragmentManager fm, int NumOfTabs, ArrayList<String> tabTitle,ArrayList<HashMap<String,String>> cat_list)
    {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.tabTitle = tabTitle;
        this.cat_list = cat_list;
    }

    @Override
    public Fragment getItem(int position)
    {
        return new DynamicFragment().newInstance(tabTitle.get(position),cat_list.get(position).get("id"));
    }

    @Override
    public int getCount()
    {
        return mNumOfTabs;
    }
}