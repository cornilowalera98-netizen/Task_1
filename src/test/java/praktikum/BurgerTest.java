package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @BeforeEach
    public void setUp() {
        burger = new Burger();

        lenient().when(bun.getName()).thenReturn("Краторная булка N-200i");
        lenient().when(bun.getPrice()).thenReturn(100f);

        lenient().when(ingredient1.getName()).thenReturn("cutlet");
        lenient().when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        lenient().when(ingredient1.getPrice()).thenReturn(50f);

        lenient().when(ingredient2.getName()).thenReturn("hot sauce");
        lenient().when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        lenient().when(ingredient2.getPrice()).thenReturn(30f);
    }

    @Test
    @DisplayName("Проверка расчета цены бургера с использованием моков")
    public void testGetPriceWithMocks() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(280f, burger.getPrice());
    }

    @Test
    @DisplayName("Проверка формирования чека с использованием моков")
    public void testGetReceiptWithMocks() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        // ДОБАВЛЕНА закрывающая скобка ) после ====
        String expectedReceipt = "(==== Краторная булка N-200i ====)\n" +
                "= filling cutlet =\n" +
                "(==== Краторная булка N-200i ====)\n" +
                "\nPrice: 250.000000\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    @DisplayName("Проверка перемещения ингредиента (moveIngredient)")
    public void testMoveIngredient() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(1, 0);

        // ДОБАВЛЕНА закрывающая скобка ) после ====
        String expectedReceiptAfterMove = "(==== Краторная булка N-200i ====)\n" +
                "= sauce hot sauce =\n" +
                "= filling cutlet =\n" +
                "(==== Краторная булка N-200i ====)\n" +
                "\nPrice: 280.000000\n";

        assertEquals(expectedReceiptAfterMove, burger.getReceipt());
    }

    @Test
    @DisplayName("Проверка удаления ингредиента (removeIngredient)")
    public void testRemoveIngredient() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0);
        assertEquals(230f, burger.getPrice());
    }
}