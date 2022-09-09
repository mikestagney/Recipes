ackage recipes;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import javax.validation.*;
import org.springframework.validation.annotation.Validated;

@RestController
@Validated
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/api/recipe/{id}")
    public ResponseEntity<Recipe> getRecipeNoID(@PathVariable Long id) {
        Optional<Recipe> recipeOptional = recipeService.findById(id);

        if (recipeOptional.isPresent()) {
            Recipe recipe = recipeOptional.get();
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/api/recipe/new")
    public ObjectNode postRecipe(@Valid @RequestBody Recipe newRecipe) {
        Long id = recipeService.saveAndReturnId(newRecipe);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode idResponse = mapper.createObjectNode();
        idResponse.put("id", id);
        return idResponse;
    }

    @DeleteMapping("/api/recipe/{id}")
    public ResponseEntity<Object> deleteRecipeByID(@PathVariable Long id) {
        boolean recipeExists = recipeService.existsById(id);

        if (recipeExists) {
            recipeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
