package com.IskhakovaL.Olymp_task2.Controller;

import com.IskhakovaL.Olymp_task2.Entities.Note;
import com.IskhakovaL.Olymp_task2.Repo.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
public class NoteController {
    @Autowired
    NotesRepository repository;

    @GetMapping("/notes")
    ResponseEntity all() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/notes/{id}")
    ResponseEntity noteById(@PathVariable Long id) {
        Optional<Note> noteOptional = repository.findById(id);
        return noteOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity
                .status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/notes")
    ResponseEntity newNote(@RequestBody Note newNote) {
        if (Objects.isNull(newNote.getContent()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Отсутствует тело заметки.");
        Note createdNote = repository.save(newNote);

        return ResponseEntity.status(HttpStatus.OK).body(createdNote);
    }


}
