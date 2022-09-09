package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Long saveAndReturnId(Recipe recipe) {
        recipeRepository.save(recipe);
        return recipe.getId();
    }

    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    public boolean existsById(Long id) { return recipeRepository.existsById(id); }

    public void deleteById(Long id) { recipeRepository.deleteById(id); }

}
