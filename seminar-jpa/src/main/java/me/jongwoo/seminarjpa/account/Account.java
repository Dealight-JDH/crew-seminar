package me.jongwoo.seminarjpa.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@SuppressWarnings("ALL")
@Entity
@Getter @Setter
//@SequenceGenerator(name = "seq", sequenceName = "seq_id", initialValue = 1)
public class Account {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq") 시퀀스 명시적 설정
    @GeneratedValue
    private Long id;

    //Column 애노테이션 생략된 경우 필요한 옵션있으면 @Column 속성 설정
    /**
     * ex) username은 유니크 키, 널 허용x
     * @Column (unique = true, nullable = false)
     * @ColimnDefinition 직접 컬럼 정보 작성 할 경우
     */
    @Column(columnDefinition = "varchar(255) default 'jongwoo'")
    private String username;
    private String password;

    @Column(columnDefinition = "INT default 26")
    private Integer age;

    // 컬럼 스키마는 정의되어 있지만 account객체를 save시 디폴트 값이 아닌 null로 들어가는 현상 해결 방법
    // 하이버네이트가 null값을 저장하지 않도록 dynamic-insert방식 사용
    // 방법 1
    /**
     * @DynamicInsert (insert 시 null인 필드 제외)
     * @DynamicUpdate (update 시 null인 필드 제외)
     */
    // 방법 2
    /**
     * @PrePersist
     * @PostPersist
     * @PreRemove
     * @PostRemove
     * @PreUpdate
     * @PostUpdate
     * @PostLoad
     */
    @PrePersist
    public void prePersist(){
        if (this.username == null){ this.username = "jongwoo";}
        if (this.age == null){ this.age = new Integer(26);}
    }


    //Converter를 사용하지 않고 사용하는 경우
    @CreationTimestamp //하이버네이트 api
//    @CreatedDate //spring data Jpa api
    private LocalDateTime created = LocalDateTime.now();


    @Temporal(TemporalType.TIME) // Date, Calendar만 지원
    private Date updated = new Date();


    @Embedded
    @AttributeOverrides({
            //Address의 street 컬럼 이름을 home_street로 재정의 한다
            @AttributeOverride(name = "street", column = @Column(name = "home_street"))
    })
    private Address address;

    @Embedded
    @AttributeOverrides({
            //컬럼 이름 재정의 컬럼이름이 중복되면 안된다
            @AttributeOverride(name="city", column=@Column(name="company_city")),
            @AttributeOverride(name="street", column=@Column(name="company_street")),
            @AttributeOverride(name="state", column=@Column(name="company_state")),
            @AttributeOverride(name="zipCode", column=@Column(name="company_zipcode"))
    })
    private Address companyAddress;

    @Transient //컬럼 매핑 x
    private String nob;


}
