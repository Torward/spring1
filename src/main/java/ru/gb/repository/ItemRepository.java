package ru.gb.repository;

import ru.gb.model.Item;

import java.util.List;

public interface ItemRepository {
    List<Item> findAll();

    Item findById(Long id);

    Item save(Item product);

    Item edit(Item product);

    void delete(Item product);
}
