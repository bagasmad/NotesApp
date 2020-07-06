package com.example.notesapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerViewList extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.ViewHolder viewHolder;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
 public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View rootView = inflater.inflate(R.layout.recyclerviewlist,container,false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        try{
            ArrayList<NoteItem> noteItemsArrayListX = MainActivity.noteItemsArrayList;
            adapter = new NoteAdapter(noteItemsArrayListX);
        }
        catch (Exception e)
        {
            Log.i("Error","Null object reference, that means the ArrayList is empty");

        }
        recyclerView = rootView.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        return rootView;
 }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
