package com.example.notesapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class TypingActivity extends Fragment {
    private static View rootView;
    public static TextView textViewSelected;
    public static TextView titleViewSelected;
    public static boolean edit = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TypingActivity.rootView = inflater.inflate(R.layout.typinglayout, container, false);
        if (edit)
        {
        TextView textView = rootView.findViewById(R.id.editText);
        TextView titleView = rootView.findViewById(R.id.titleText);
        textView.setText(textViewSelected.getText());
        titleView.setText(titleViewSelected.getText());
        }
        return rootView;
    }

    @Override
    public void onDetach() {
        TextView textView = rootView.findViewById(R.id.editText);
        TextView titleView = rootView.findViewById(R.id.titleText);
        if(edit)  //edit
        {
            if(MainActivity.delete) //jika edit dan delete
                {
                    MainActivity.noteItemsArrayList.remove(NoteAdapter.selectedPosition);
                }
            else   //hanya edit saja
                {
                    MainActivity.noteItemsArrayList.set(NoteAdapter.selectedPosition,new NoteItem(R.drawable.book,titleView.getText().toString(),textView.getText().toString()));
                }
        }
        else  //bukan edit
            {
               if(!MainActivity.delete)  //jadi add
                    {
                        if(titleView.getText().toString().equals(""))
                            {
                                MainActivity.noteItemsArrayList.add(new NoteItem(R.drawable.book,"Untitled Text",textView.getText().toString()));
                            }
                        else
                            {
                                MainActivity.noteItemsArrayList.add(new NoteItem(R.drawable.book, titleView.getText().toString(), textView.getText().toString()));
                            }
                    }
            }

        MainActivity.delete=false;
        edit=false;
        super.onDetach();

    }
}
