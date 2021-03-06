package com.notes.filip.notes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private List<Note> notesList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView content, lastModified;

        public MyViewHolder(View view){
            super(view);
            content = (TextView) view.findViewById(R.id.content);
            lastModified = (TextView) view.findViewById(R.id.lastModified);
        }
    }

    public NotesAdapter(List<Note> notesList){
        this.notesList = notesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        Note note = notesList.get(position);
        holder.content.setText(note.getContent());
        holder.lastModified.setText(note.getLastModified());
    }

    @Override
    public int getItemCount(){
        return notesList.size();
    }

}
