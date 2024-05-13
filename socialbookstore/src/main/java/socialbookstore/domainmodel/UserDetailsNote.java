package socialbookstore.domainmodel;

import java.time.LocalDateTime;

public class UserDetailsNote {
    private int noteId;
    private String username; // Username of the note creator
    private String noteContent;
    private LocalDateTime createdDate;

    // Constructor, getters, and setters
    public UserDetailsNote(int noteId, String username, String noteContent, LocalDateTime createdDate) {
        this.noteId = noteId;
        this.username = username;
        this.noteContent = noteContent;
        this.createdDate = createdDate;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
