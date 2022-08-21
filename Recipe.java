package recipes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @JsonIgnore
    int id;

    @Column
    String name;

    @Column
    String description;

    @OneToMany
    @JoinColumn(name = "recipe_id", nullable = false)
    public List<Ingredient> ingredients = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "recipe_id")
    public List<Direction> directions = new ArrayList<>();

    static int idCounter = 0;

    Recipe(String name, String description, List<Ingredient> ingredients, List<Direction> directions) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
        idCounter++;
        id = idCounter;
    }


}
