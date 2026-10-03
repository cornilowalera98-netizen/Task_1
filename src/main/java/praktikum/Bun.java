package praktikum;

import java.util.Objects;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить цену.
 */
public class Bun {

    private String name;
    private float price;

    // Конструктор
    public Bun(String name, float price) {
        this.name = name;
        this.price = price;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    // Методы equals и hashCode (Сравнение)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Сравнение с собой
        if (o == null || getClass() != o.getClass()) return false; // Проверка на null и тип
        Bun bun = (Bun) o; // Приведение типа
        return Float.compare(bun.price, price) == 0 && Objects.equals(name, bun.name); // Сравнение полей
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}