package me.kiryakov.dashboard.controller;

import me.kiryakov.dashboard.dto.NoteDTO;
import me.kiryakov.dashboard.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @PostMapping("/")
    public ResponseEntity<NoteDTO> add(@RequestBody NoteDTO noteDTO){
        NoteDTO dto = noteService.addNote(noteDTO);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<NoteDTO> get(@PathVariable Integer id){
        NoteDTO noteDTO = noteService.getById(id);
        return ResponseEntity.ok(noteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteDTO> update(@PathVariable Integer id, @RequestBody NoteDTO noteDTO){
        NoteDTO dto = noteService.updateNote(id, noteDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
