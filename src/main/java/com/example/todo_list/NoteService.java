package com.example.todo_list;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final List<Note> notes = new ArrayList<>();
    private long nextId = 1;

    public List<Note> listAll() {
        return new ArrayList<>(notes);
    }

    public Note add(Note note) {
        note.setId(nextId++);
        notes.add(note);
        return note;
    }

    public void deleteById(long id) {
        notes.removeIf(note -> note.getId() == id);
    }

    public void update(Note note) {
        Optional<Note> existingNote = notes.stream()
                .filter(n -> n.getId().equals(note.getId()))
                .findFirst();

        if (existingNote.isPresent()) {
            Note n = existingNote.get();
            n.setTitle(note.getTitle());
            n.setContent(note.getContent());
        } else {
            throw new IllegalArgumentException("Note not found");
        }
    }

    public Note getById(long id) {
        return notes.stream()
                .filter(note -> note.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Note not found"));
    }
}
