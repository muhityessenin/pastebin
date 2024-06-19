package pet.project.pastebin.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Table(name = "paste")
@Data
@Getter
@Setter
public class Paste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String author;
    public String title;
    public String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date expirationTime;
    @Column(unique = true, nullable = false)
    public String url;
}
