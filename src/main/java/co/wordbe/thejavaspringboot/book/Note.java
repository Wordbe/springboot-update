package co.wordbe.thejavaspringboot.book;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Getter @Setter
@Entity
public class Note {

    @Id @GeneratedValue
    private Integer id;

    private String title;

}
