package praktikum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {

    @ParameterizedTest
    @CsvSource({
            "SAUCE, 'hot sauce', 100",
            "FILLING, 'cutlet', 200"
    })
    @DisplayName("Проверка создания ингредиента и работы геттеров (параметризованный тест)")
    public void testIngredientCreationAndGetters(IngredientType type, String name, float price) {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(type, ingredient.getType(), "Тип ингредиента должен совпадать");
        assertEquals(name, ingredient.getName(), "Название ингредиента должно совпадать");
        assertEquals(price, ingredient.getPrice(), "Цена ингредиента должна совпадать");
    }

    @Test
    @DisplayName("Проверка корректной работы equals и hashCode для ингредиентов")
    public void testIngredientEqualsAndHashCode() {
        Ingredient ing1 = new Ingredient(IngredientType.FILLING, "cutlet", 100f);
        Ingredient ing2 = new Ingredient(IngredientType.FILLING, "cutlet", 100f);
        Ingredient ing3 = new Ingredient(IngredientType.SAUCE, "cutlet", 100f);

        assertEquals(ing1, ing2, "Одинаковые ингредиенты должны быть равны");
        assertNotEquals(ing1, ing3, "Ингредиенты с разным типом не должны быть равны");
        assertEquals(ing1.hashCode(), ing2.hashCode(), "Хэш-коды одинаковых ингредиентов должны совпадать");
    }

    @Test
    @DisplayName("Проверка equals с null")
    public void testIngredientEqualsWithNull() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100f);
        assertNotEquals(null, ingredient, "Ingredient не должен быть равен null");
    }

    @Test
    @DisplayName("Проверка equals с объектом другого типа")
    public void testIngredientEqualsWithDifferentType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100f);
        String differentType = "строка";
        assertNotEquals(differentType, ingredient, "Ingredient не должен быть равен строке");
    }

    @Test
    @DisplayName("Проверка equals с самим собой")
    public void testIngredientEqualsWithItself() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100f);
        assertEquals(ingredient, ingredient, "Ingredient должен быть равен самому себе");
    }
}