package praktikum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    @Test
    @DisplayName("Проверка доступных булочек из базы данных")
    public void testAvailableBuns() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();

        assertNotNull(buns, "Список булочек не должен быть null");
        assertEquals(3, buns.size(), "Должно быть 3 булочки");

        assertEquals("black bun", buns.get(0).getName());
        assertEquals(100f, buns.get(0).getPrice());

        assertEquals("white bun", buns.get(1).getName());
        assertEquals(200f, buns.get(1).getPrice());

        assertEquals("red bun", buns.get(2).getName());
        assertEquals(300f, buns.get(2).getPrice());
    }

    @Test
    @DisplayName("Проверка доступных ингредиентов из базы данных")
    public void testAvailableIngredients() {
        Database database = new Database();
        List<Ingredient> ingredients = database.availableIngredients();

        assertNotNull(ingredients, "Список ингредиентов не должен быть null");
        assertEquals(6, ingredients.size(), "Должно быть 6 ингредиентов");

        // Проверяем соусы
        assertEquals(IngredientType.SAUCE, ingredients.get(0).getType());
        assertEquals("hot sauce", ingredients.get(0).getName());
        assertEquals(100f, ingredients.get(0).getPrice());

        assertEquals(IngredientType.SAUCE, ingredients.get(1).getType());
        assertEquals("sour cream", ingredients.get(1).getName());

        assertEquals(IngredientType.SAUCE, ingredients.get(2).getType());
        assertEquals("chili sauce", ingredients.get(2).getName());

        // Проверяем начинки
        assertEquals(IngredientType.FILLING, ingredients.get(3).getType());
        assertEquals("cutlet", ingredients.get(3).getName());

        assertEquals(IngredientType.FILLING, ingredients.get(4).getType());
        assertEquals("dinosaur", ingredients.get(4).getName());

        assertEquals(IngredientType.FILLING, ingredients.get(5).getType());
        assertEquals("sausage", ingredients.get(5).getName());
    }
}