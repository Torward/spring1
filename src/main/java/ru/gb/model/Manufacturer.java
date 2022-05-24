package ru.gb.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "MANUFACTURER")
@NamedQueries({
        @NamedQuery(name = "Manufacturer.findNameById",
        query = "select m.name from Manufacturer m where m.id = :id"),
        @NamedQuery(name = "Manufacturer.findById",
        query = "select m from Manufacturer m where m.id = :id")
})
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private  Set<Item> products;


//    public boolean addProduct(Item product) {
//        if (products == null) {
//            products = new HashSet<>();
//        }
//        return products.add(product);
//    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}