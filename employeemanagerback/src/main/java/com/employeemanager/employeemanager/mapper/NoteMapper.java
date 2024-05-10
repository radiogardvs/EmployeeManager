package com.employeemanager.employeemanager.mapper;

import com.employeemanager.employeemanager.dao.Note;
import com.employeemanager.employeemanager.dto.NoteDTO;
import com.employeemanager.employeemanager.exception.NoteNotFoundException;
import com.employeemanager.employeemanager.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteMapper(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public NoteDTO toDTO(Note note) {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(note.getId());
        noteDTO.setName(note.getName());
        return noteDTO;
    }

    public Note findEntity(NoteDTO noteDTO) {
        return noteRepository.findById(noteDTO.getId()).orElseThrow(() ->
                new NoteNotFoundException(noteDTO.getId()));
    }

    public Note toEntity(NoteDTO noteDTO) {
        Note note = new Note();
        note.setName(noteDTO.getName());
        return note;
    }

    public Note updateEntity(NoteDTO noteDTO) {
        Note note = noteRepository.findById(noteDTO.getId()).orElseThrow(() ->
                new NoteNotFoundException(noteDTO.getId()));
        note.setName(noteDTO.getName());
        return note;
    }
}
