package ru.gb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.model.Item;
import ru.gb.repository.ItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> findAll(){
        return itemRepository.findAll();
    }
    public Item findById(Long id) {
        return itemRepository.findById(id);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Item edit(Item item) {
        return itemRepository.edit(item);
    }

    public void delete(Item item){
         itemRepository.delete(item);
    }
}
