package me.jongwoo.seminarjpa.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void saveAccount(){

        Account account = new Account();
        final Account savedAccount = accountRepository.save(account);

        assertThat(savedAccount.getAge()).isEqualTo(26);

    }

    @Test
    public void repositoryTest(){

        System.out.println(accountRepository);
    }
}