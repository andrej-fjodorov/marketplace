package ru.inno.market;

import org.junit.After;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.inno.market.model.Category;
import ru.inno.market.model.Client;
import ru.inno.market.model.Item;
import ru.inno.market.model.Order;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
     Client Client1 = new Client(1, "Иван Иванович Иванов");
     Item Item1 = new Item(8, "Microsoft Windows 11 Pro", Category.SOFTWARE, 5200);

    @Test
    @DisplayName("Создание заказа с корректной информацией")
    public void CreateOrder () {
        Order order1 = new Order(1, Client1);
        assertEquals(1, order1.getId());
    }

    @Test
    @DisplayName("Создание заказа с ошибкой")
    public void CreateOrderWithBug () {
        Order order1 = new Order(1, Client1);
        assertEquals(5, order1.getId());
    }

    @Test
    @DisplayName("Добавление товара в корзину")
    public void AddItemPositive() {
        Order order = new Order(1, Client1);
        order.addItem(Item1);
        assertEquals(5200, order.getTotalPrice());
    }

    @Test
    @DisplayName("Добавление товара в корзину с неправильным Id")
    public void AddItemNegative() {
        Order order = new Order(3, Client1);
        order.addItem(Item1);
        assertEquals(1, order.getId());
    }
    @After
    public  void shouldDelete(){
        Item1 = null;
        Client1 = null;
    }
}
