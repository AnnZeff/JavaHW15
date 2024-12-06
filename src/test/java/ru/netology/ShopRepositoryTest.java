package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void testRemoveIfProductExist() {
        ShopRepository repository = new ShopRepository();

        Product product1 = new Product(1, "молоко", 150);
        Product product2 = new Product(2, "спагетти", 80);
        Product product3 = new Product(3, "курица", 400);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        repository.remove(2);

        Product[] expected = {product1, product3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testRemoveIfProductNotExist() {
        ShopRepository repository = new ShopRepository();

        Product product1 = new Product(1, "молоко", 150);
        Product product2 = new Product(2, "спагетти", 80);
        Product product3 = new Product(3, "курица", 400);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () ->  repository.remove(2325)
                );
    }
}

