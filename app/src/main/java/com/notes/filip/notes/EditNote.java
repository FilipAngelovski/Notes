package com.notes.filip.notes;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        FloatingActionButton fab = findViewById(R.id.fabSaveNote);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveNote((EditText) findViewById(R.id.editNote));
            }
        });

    }

    public void SaveNote(EditText noteText){
        try{
            if(noteText.getText().toString().length()==0){
                Toast.makeText(this, "Note empty!", Toast.LENGTH_SHORT).show();
            }
            else {
                final DateFormat dateFormat = new SimpleDateFormat("yy-MM-DD_HH-mm-ss");
                String fileSaveTime = dateFormat.format(new Date().getTime());

                OutputStreamWriter out = new OutputStreamWriter(openFileOutput("Note_" + fileSaveTime + ".txt", 0));
                out.write(noteText.getText().toString());
                out.close();
                Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Throwable t){
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
