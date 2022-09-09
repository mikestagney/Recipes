package recipes;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "directions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direction {
    // This class does nothing.  I could not get the jpa many to one relationship to work.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "direction_id")
    @JsonIgnore
    private Long id;

    @Column(name = "direction_name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}
