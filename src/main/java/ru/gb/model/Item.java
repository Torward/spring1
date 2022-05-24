package ru.gb.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "Item.findNameById",
                query = "select i.title from Item i where i.id = :id"),
        @NamedQuery(name = "Item.findById",
                query = "select i from Item i where i.id = :id")
})
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "manufacture_date")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "cart_product",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "cart_id"))
//    private Set<Cart> carts;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", date=" + date +
//                ", manufacturer=" + manufacturer.getName() +
                '}';
    }
}
