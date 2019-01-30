package be.bettens.springBootNoteApp.controller;

import be.bettens.springBootNoteApp.domain.Note;
import be.bettens.springBootNoteApp.repository.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/note")
public class MainController {

    private NoteRepository noteRepository;
    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    public MainController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

 // test git flow add comment
    @GetMapping(path = "/add") // Map ONLY GET Requests
    Note addNewNote() {
        // @ResponseBody means the returned Object is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Note note = new Note();
        note.setTitle("myTitle");
        note.setDescription("myDescription");
// add another comment to test pull request

        return noteRepository.save(note);
    }

    @GetMapping(path = "/readAll")
    Iterable findAllNotes() {
        Iterable<Note> notes = noteRepository.findAll();
        return notes;
    }


    @GetMapping(path = "/readOne/{id}")
    Note findOneNoteByID(@PathVariable Integer id) {
        return noteRepository.findById(id) .orElseThrow(() -> new NoteNotFoundException(id));
    }

    @DeleteMapping("/deleteOne/{id}")
    void deleteNoteByID(@PathVariable Integer id) {
        noteRepository.deleteById(id);
    }

    @PutMapping("/employees/{id}")
    Note replaceNote(@RequestBody Note newNote, @PathVariable Integer id) {

        return noteRepository.findById(id)
                .map(note -> {
                    note.setTitle(newNote.getTitle());
                    note.setDescription(newNote.getDescription());
                    return noteRepository.save(note);
                })
                .orElseGet(() -> {
                    newNote.setId(id);
                    return noteRepository.save(newNote);
                });
    }

    @PostMapping("/createNote")
    Note newNote(@RequestBody Note newNote) {
        return noteRepository.save(newNote);
    }

}
