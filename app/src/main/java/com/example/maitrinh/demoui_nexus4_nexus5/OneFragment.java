package com.example.maitrinh.demoui_nexus4_nexus5;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maitrinh.demoui_nexus4_nexus5.models.WashService;

import java.util.ArrayList;
import java.util.List;


public class OneFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    List<WashService> serviceList = new ArrayList<>();
    RecyclerView recyclerView;
    CustomAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        serviceList.add(new WashService("normal wash","10000",false));
        serviceList.add(new WashService("normal wash 1","11000",true));
        serviceList.add(new WashService("normal wash 2","12000",false));
        serviceList.add(new WashService("normal wash 3","13000",true));
        serviceList.add(new WashService("normal wash 4","14000",false));
        serviceList.add(new WashService("normal wash 5","15000",true));
        serviceList.add(new WashService("normal wash 6","16000",false));
        serviceList.add(new WashService("normal wash 7","17000",true));
        serviceList.add(new WashService("normal wash 8","18000",false));
        serviceList.add(new WashService("normal wash 9","19000",true));
        serviceList.add(new WashService("normal wash 10","20000",false));
        serviceList.add(new WashService("normal wash 11","21000",true));
        serviceList.add(new WashService("normal wash 12","22000",false));
        serviceList.add(new WashService("normal wash 13","23000",true));
        Log.d("fragment 1","check list size : " + serviceList.size());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_one, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
//        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
        adapter = new CustomAdapter(getContext(),serviceList);
        recyclerView.setAdapter(adapter);
        return v;
    }

}
