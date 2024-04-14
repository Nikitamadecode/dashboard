package me.kiryakov.dashboard.service;

import me.kiryakov.dashboard.domain.Note;
import me.kiryakov.dashboard.dto.NoteDTO;
import me.kiryakov.dashboard.exception.NotFoundException;
import me.kiryakov.dashboard.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public NoteDTO addNote(NoteDTO noteDTO) {
        Note note = new Note();
        note.setNoteText(noteDTO.getNoteText());
        note.setNoteName(noteDTO.getNoteName());
        note = noteRepository.save(note);
        return new NoteDTO(note.getId(), note.getNoteName(), note.getNoteText());
    }

    public NoteDTO getById(Integer id) {
        Note note = noteRepository.getById(id);
        NoteDTO noteDTO = new NoteDTO(note.getId(), note.getNoteName(), note.getNoteText());
        return noteDTO;
    }

    public NoteDTO updateNote(Integer id, NoteDTO noteDTO) {
        Note note = noteRepository.getById(id);
        note.setNoteName(noteDTO.getNoteName());
        note.setNoteText(noteDTO.getNoteText());
        note = noteRepository.save(note);
        return new NoteDTO(note.getId(), note.getNoteName(), note.getNoteText());
    }

    public void deleteNote(Integer id) {
        Note note = noteRepository.getById(id);
        noteRepository.delete(note);
    }
}
