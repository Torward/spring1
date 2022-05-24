package ru.gb.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.model.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class EntityManagerItemRepository implements ItemRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Item> findAll() {
        return entityManager.createQuery("select i from Item i").getResultList();
    }


    @Override
    public Item findById(Long id) {
        TypedQuery<Item> namedQuery = entityManager.createNamedQuery("Item.findById", Item.class);
        namedQuery.setParameter("id", id);
        return namedQuery.getSingleResult();
    }

    @Override
    public Item save(Item item) {
        if (item.getId() == null) {
            entityManager.persist(item);
        } else {
            entityManager.merge(item);
        }
        return item;
    }

    @Override
    public Item edit(Item product) {
        entityManager.merge(product);
        return product;
    }


    public void delete(Item item) {
        Item mergedItem = entityManager.merge(item);
        entityManager.remove(mergedItem);
    }
}
