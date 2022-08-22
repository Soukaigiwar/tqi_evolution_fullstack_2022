package com.tqi.evolutionfullstack.livrariabackend.model;

import com.tqi.evolutionfullstack.livrariabackend.model.enums.OrderTypeEnum;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_order")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer amount;
    @Column
    private OrderTypeEnum orderType;
    @Column
    private Double costPrice;

    private Double sellPrice;

    private Book book;
}
