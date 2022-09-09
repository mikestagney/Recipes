package recipes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "recipe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;

    @Column
    @NotBlank
    private String name;

    @Column
    @NotBlank
    private String description;

    //@OneToMany(mappedBy = "recipe")
    @Column
    @ElementCollection
    @NotEmpty
    private List<String> ingredients = new ArrayList<>();

    //@OneToMany(mappedBy = "recipe")
    @Column
    @ElementCollection
    @NotEmpty
    private List<String> directions = new ArrayList<>();

}

