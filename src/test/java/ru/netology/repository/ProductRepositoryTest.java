package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Product first = new Book(1, "Дракула", 799, "Стокер", 666, 2000);
    Product second = new Book(2, "Франкенштейн", 759, "Шелли", 566, 2001);
    Product third = new TShirt(3, "Nike", 1500, "Blue", "l");
    Product fourth = new TShirt(4, "Adidas", 1300, "Red", "XL");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
    }

    @Test
    void removeById() {
        int id = 4;
        repository.removeById(id);
        Product[] expected = {first, second, third};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void whenIdNotFind() {
        assertThrows(NotFoundException.class, () -> repository.removeById(8));
    }


}