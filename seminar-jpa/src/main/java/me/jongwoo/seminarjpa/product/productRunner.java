package me.jongwoo.seminarjpa.product;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class productRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //복합 ID
        ProductId productId = new ProductId();

        //EmbeddId 이용한 경우
//        productId.setId(1L);
//        productId.setName("prod 1");
//        product.setId(productId);

        //IdClass 이용한 경우 Id는 시퀀스 사용
        Product product = new Product();
        product.setName("pk 1");
        product.setDescription("상품 설명......");

        //영속화
        entityManager.persist(product);


    }
}
