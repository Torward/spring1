package ru.gb.repository;

import org.springframework.stereotype.Repository;
import ru.gb.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class ItemRepository {

   private final List<Item>products = new ArrayList<>();
   private Long count;

    public Item save(Item item) {
        count=0L;
        item.setId(count++);
        products.add(item);
        return Item.builder()
                .id(item.getId())
                .title(item.getTitle())
                .cost(item.getCost())
                .build();
    }
    public Optional<Item> findById(Integer id) {
        if (id < products.size()) {
            return Optional.of(products.get(id));
        } else {
            return Optional.empty();
        }
    }

    public List<Item> findAll() {
        return new ArrayList<>(products);
    }

    public Item edit(Item item) {
        return products.set(Math.toIntExact(item.getId()), item);
    }
}
