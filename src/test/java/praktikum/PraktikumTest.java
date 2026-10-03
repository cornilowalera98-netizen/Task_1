package praktikum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PraktikumTest {

    @Test
    @DisplayName("Проверка запуска главного метода программы")
    public void testMainMethod() {
        // Проверяем, что main() метод выполняется без ошибок
        assertDoesNotThrow(() -> Praktikum.main(new String[]{}),
                "Метод main должен выполняться без исключений");
    }
}