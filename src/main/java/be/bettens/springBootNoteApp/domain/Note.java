package be.bettens.springBootNoteApp.domain;

import javax.persistence.*;

@Entity
@Table(name = "NOTE")
public class Note {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;

    public Note() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
