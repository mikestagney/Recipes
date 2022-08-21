package recipes;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RecipeController {

    Recipe recipe;
    Map<Integer, Recipe> recipeRepo;

    RecipeController() {
        recipeRepo = new HashMap<>();

    }
    @GetMapping("/api/recipe/{id}")
    public ResponseEntity<Recipe> getRecipeNoID(@PathVariable int id) {
        boolean isValid = recipeRepo.containsKey(id);

        if (isValid) {
            recipe = recipeRepo.get(id);
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/api/recipe/new")
    public ObjectNode postRecipe(@RequestBody Recipe newRecipe) {
        recipe = new Recipe(newRecipe.name, newRecipe.description, newRecipe.ingredients, newRecipe.directions);
        recipeRepo.put(recipe.id, recipe);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode idResponse = mapper.createObjectNode();
        idResponse.put("id", recipe.id);
        return idResponse;
    }
}
