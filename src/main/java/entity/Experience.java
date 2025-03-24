package entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Table(name="experiences")
public class Experience {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

}
