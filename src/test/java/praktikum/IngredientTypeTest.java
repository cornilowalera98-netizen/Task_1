package praktikum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTypeTest {

    @Test
    @DisplayName("Проверка существования значений перечисления IngredientType")
    public void testIngredientTypeValues() {
        assertNotNull(IngredientType.SAUCE);
        assertNotNull(IngredientType.FILLING);
        assertEquals(2, IngredientType.values().length, "Должно быть ровно 2 типа ингредиентов");
    }
}