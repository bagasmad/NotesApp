package com.example.notesapp;

public class NoteItem {
    private int noteImageId;
    private String noteTitleText;
    private String noteText;

    public NoteItem(int imageView, String titleText, String text)
    {
        noteImageId = imageView;
        noteTitleText = titleText;
        noteText = text;
    }

    public int getNoteImageId() {
        return noteImageId;
    }

    public String getNoteText() {
        return noteText;
    }

    public String getNoteTitleText() {
        return noteTitleText;
    }
}

