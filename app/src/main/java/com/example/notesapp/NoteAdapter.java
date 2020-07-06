package com.example.notesapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private ArrayList<NoteItem> adapterArrayList;
    public static int selectedPosition;

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imageView;
        private TextView textTitleView;
        private TextView textView;

        public ViewHolder(View itemView)
        {
            super(itemView);
            imageView = itemView.findViewById(R.id.noteImage);
            textTitleView = itemView.findViewById(R.id.titleText);
            textView = itemView.findViewById(R.id.noteText);
        }

    }

    public NoteAdapter(ArrayList<NoteItem> noteItemArrayList)
    {
        adapterArrayList=noteItemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout,parent,false);
        ViewHolder inflatedViewHolder = new ViewHolder(v);
        return inflatedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        NoteItem currentItem = adapterArrayList.get(position);
        viewHolder.imageView.setImageResource(currentItem.getNoteImageId());
        viewHolder.textTitleView.setText(currentItem.getNoteTitleText());
        viewHolder.textView.setText(currentItem.getNoteText());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition=viewHolder.getAdapterPosition();
                TypingActivity.edit=true;
                v.findViewById(R.id.titleText);
                ImageView imageview = v.getRootView().findViewById(R.id.add);
                imageview.setVisibility(View.GONE);
                ImageView imageview2 = v.getRootView().findViewById(R.id.back);
                imageview2.setVisibility(View.VISIBLE);
                ImageView imageview3 = v.getRootView().findViewById(R.id.delete);
                imageview3.setVisibility(View.VISIBLE);
                FragmentActivity activity = (FragmentActivity)v.getContext();
                TypingActivity.textViewSelected=v.findViewById(R.id.noteText);
                TypingActivity.titleViewSelected=v.findViewById(R.id.titleText);
                FragmentManager manager = activity.getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.fragmentContainer,new TypingActivity()).commit();

            }
        });


    }

    @Override
    public int getItemCount() {
        return adapterArrayList.size();
    }
}
