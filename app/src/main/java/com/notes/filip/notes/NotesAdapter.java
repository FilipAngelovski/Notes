package com.notes.filip.notes;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class NotesAdapter extends BaseAdapter {

    private List<Note> notesList;

    @Override
    public int getCount() {
        return notesList.size();
    }

    @Override
    public Object getItem(int position) {
        return notesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

            TextView one = convertView.findViewById(R.id.content);
            TextView two = convertView.findViewById(R.id.lastModified);
            Note n = notesList.get(position);
            Log.d("asd",n.getContent());
            Log.d("asd",n.getLastModified());
            one.setText(n.getContent());
            two.setText(n.getLastModified());
        }
        return convertView;
    }

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

//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.note_list_row, parent, false);
//
//        return new MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position){
//        Note note = notesList.get(position);
//        holder.content.setText(note.getContent());
//        holder.lastModified.setText(note.getLastModified());
//    }
//
//    @Override
//    public int getItemCount(){
//        return notesList.size();
//    }

}
