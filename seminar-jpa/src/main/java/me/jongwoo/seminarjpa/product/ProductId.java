package me.jongwoo.seminarjpa.product;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 1.EmbeedId를 사용하려려면 @Embeddable 애노테이션 추가
 * 2.IdClass는 엔티티 매핑 컬럼 이름과 동일하게 명시해야 한다
 * Serializable 구현
 */
//@Embeddable
@Getter @Setter
public class ProductId implements Serializable {

    private Long id;
    private String name;

}
