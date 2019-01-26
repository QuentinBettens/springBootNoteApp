package be.bettens.springBootNoteApp.repository;

import be.bettens.springBootNoteApp.domain.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {

}
