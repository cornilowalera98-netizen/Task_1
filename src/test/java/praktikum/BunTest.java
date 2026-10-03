package praktikum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class BunTest {

    @ParameterizedTest
    @CsvSource({
            "'Краторная булка N-200i', 1255",
            "'Флюоресцентная булка R2-D3', 988"
    })
    @DisplayName("Проверка создания булочки и работы геттеров (параметризованный тест)")
    public void testBunCreationAndGetters(String name, float price) {
        Bun bun = new Bun(name, price);

        assertEquals(name, bun.getName(), "Название булочки должно совпадать");
        assertEquals(price, bun.getPrice(), "Цена булочки должна совпадать");
    }

    @Test
    @DisplayName("Проверка корректной работы equals и hashCode для булочек")
    public void testBunEqualsAndHashCode() {
        Bun bun1 = new Bun("Краторная булка N-200i", 1255f);
        Bun bun2 = new Bun("Краторная булка N-200i", 1255f);
        Bun bun3 = new Bun("Флюоресцентная булка R2-D3", 988f);

        assertEquals(bun1, bun2, "Одинаковые булочки должны быть равны");
        assertNotEquals(bun1, bun3, "Разные булочки не должны быть равны");
        assertEquals(bun1.hashCode(), bun2.hashCode(), "Хэш-коды одинаковых булок должны совпадать");
    }
    @Test
    @DisplayName("Проверка equals с null")
    public void testBunEqualsWithNull() {
        Bun bun = new Bun("Краторная булка N-200i", 1255f);
        assertNotEquals(null, bun, "Bun не должен быть равен null");
    }

    @Test
    @DisplayName("Проверка equals с объектом другого типа")
    public void testBunEqualsWithDifferentType() {
        Bun bun = new Bun("Краторная булка N-200i", 1255f);
        String differentType = "строка";
        assertNotEquals(differentType, bun, "Bun не должен быть равен строке");
    }

    @Test
    @DisplayName("Проверка equals с самим собой")
    public void testBunEqualsWithItself() {
        Bun bun = new Bun("Краторная булка N-200i", 1255f);
        assertEquals(bun, bun, "Bun должен быть равен самому себе");
    }
}