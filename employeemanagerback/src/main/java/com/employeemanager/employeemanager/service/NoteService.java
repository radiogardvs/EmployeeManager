package com.employeemanager.employeemanager.service;

import com.employeemanager.employeemanager.dto.NoteDTO;
import com.employeemanager.employeemanager.exception.NoteNotFoundException;
import com.employeemanager.employeemanager.mapper.NoteMapper;
import com.employeemanager.employeemanager.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    @Autowired
    public NoteService(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    public NoteDTO addNote(NoteDTO noteDTO) {
        return noteMapper.toDTO(noteRepository.save(noteMapper.toEntity(noteDTO)));
    }

    public List<NoteDTO> findAllNotes() {
        return noteRepository.findAll().stream().map(noteMapper::toDTO).collect(Collectors.toList());
    }

    public NoteDTO updateNote(NoteDTO noteDTO) {
        return noteMapper.toDTO(noteRepository.save(noteMapper.updateEntity(noteDTO)));
    }

    public NoteDTO findNoteById(Long id) {
        return noteMapper.toDTO(noteRepository.findById(id).orElseThrow(()-> new NoteNotFoundException(id)));
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
