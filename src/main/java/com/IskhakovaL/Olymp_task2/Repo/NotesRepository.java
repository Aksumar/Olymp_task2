package com.IskhakovaL.Olymp_task2.Repo;

import com.IskhakovaL.Olymp_task2.Entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Note, Long> {
}
