package be.bettens.springBootNoteApp.controller;

class NoteNotFoundException extends RuntimeException {

    NoteNotFoundException(Integer id) {
        super("Could not find Note " + id);
    }
}