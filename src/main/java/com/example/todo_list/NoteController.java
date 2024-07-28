package com.example.todo_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/list")
    public String listNotes(Model model) {
        model.addAttribute("notes", noteService.listAll());
        return "note-list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public String editNoteForm(@RequestParam long id, Model model) {
        model.addAttribute("note", noteService.getById(id));
        return "note-edit";
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }
}