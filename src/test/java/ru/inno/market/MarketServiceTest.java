package ru.inno.market;


import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.inno.market.core.MarketService;
import ru.inno.market.model.Client;
import ru.inno.market.model.Item;
import ru.inno.market.model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarketServiceTest {
    MarketService service;
    Client Client1;

    Item Item1 = new Item(8, "Microsoft Windows 11 Pro", Category.SOFTWARE, 5200);
    @BeforeEach
    public void setUp() {
        service = new MarketService();
    }

    @Test
    @DisplayName("Создание заказа")
    public void CreateOrderFor() {
        int Id = service.createOrderFor(Client1);
        assertEquals(0, Id);
    }

    @Test
    @DisplayName("Добавление товара к заказу")
    public void AddItemToOrder() {
        int newId = service.createOrderFor(Client1);
        service.addItemToOrder(Item1,newId);
        assertEquals(5200, service.getOrderInfo(newId).getTotalPrice());
    }

    @After
    public  void Delete(){
        service = null;
        Item1 = null;
        Client1 = null;
    }

}
