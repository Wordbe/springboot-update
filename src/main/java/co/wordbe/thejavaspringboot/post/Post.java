package co.wordbe.thejavaspringboot.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {

    @Id @GeneratedValue
    private Integer id;

    private String name;
}
