package co.wordbe.thejavaspringboot.book;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter @Setter
@Entity
public class Book {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @OneToMany
    private List<Note> notes;
}
