package com.notes.filip.notes;

public class Note {
    private String content, lastModified;

    public Note(){
    }

    public Note(String content, String lastModified){
        this.content = content;
        this.lastModified = lastModified;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }
}
