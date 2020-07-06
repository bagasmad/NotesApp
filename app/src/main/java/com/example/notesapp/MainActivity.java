package com.example.notesapp;

import android.app.Activity;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<NoteItem> noteItemsArrayList = new ArrayList<>();
    public static boolean delete = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageview = findViewById(R.id.add);
        imageview.setVisibility(View.VISIBLE);
        ImageView imageview2 = findViewById(R.id.back);
        imageview2.setVisibility(View.GONE);
        ImageView imageview3 = findViewById(R.id.delete);
        imageview3.setVisibility(View.GONE);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
// Replace the contents of the container with the new fragment
        ft.replace(R.id.fragmentContainer, new RecyclerViewList());
// or ft.add(R.id.your_placeholder, new FooFragment());
// Complete the changes added above
        ft.commit();

    }

    public void AddNote(View view)
    {
        ImageView imageview = findViewById(R.id.add);
        imageview.setVisibility(View.GONE);
        ImageView imageview2 = findViewById(R.id.back);
        imageview2.setVisibility(View.VISIBLE);
        ImageView imageview3 = findViewById(R.id.delete);
        imageview3.setVisibility(View.VISIBLE);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer, new TypingActivity());
        ft.commit();
    }

    public void DeleteNote(View view)
    {
        delete = true;
        ImageView imageview = findViewById(R.id.add);
        imageview.setVisibility(View.VISIBLE);
        ImageView imageview2 = findViewById(R.id.back);
        imageview2.setVisibility(View.GONE);
        ImageView imageview3 = findViewById(R.id.delete);
        imageview3.setVisibility(View.GONE);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer, new RecyclerViewList());
        ft.commit();
    }

    public void Back(View view)
    {
        ImageView imageview = findViewById(R.id.add);
        imageview.setVisibility(View.VISIBLE);
        ImageView imageview2 = findViewById(R.id.back);
        imageview2.setVisibility(View.GONE);
        ImageView imageview3 = findViewById(R.id.delete);
        imageview3.setVisibility(View.GONE);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer, new RecyclerViewList());
        ft.commit();

    }




}
