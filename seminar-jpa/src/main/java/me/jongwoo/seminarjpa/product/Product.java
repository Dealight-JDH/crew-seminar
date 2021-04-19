package me.jongwoo.seminarjpa.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 복합키 설정 2가지
 * 1. EmbeddId
 * 2. IdClass
 */
@Entity
@Getter
@Setter
@IdClass(ProductId.class)
public class Product {

//    @EmbeddedId
//    private ProductId id;

    @Id @GeneratedValue
    private Long id;
    private String name;

    private String description;
    private int basePrice;
}
