package repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "fitness")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fitness {
    private String status;
    private int number;
}
