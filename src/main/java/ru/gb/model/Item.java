package ru.gb.model;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id;
    private String title;
    private BigDecimal cost;
}
