package umc.spring2.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring2.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@DynamicUpdate
@DynamicInsert
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String user_id;

    @Column(nullable = false, length = 255)
    private String user_pwd;

    @Column(length = 20)
    private String phone_num;

    @Column(nullable = false, length = 255)
    private String nickname;

    // 여행지(Trip)와의 연결 - 양방향 관계로 만들고 싶을 때 사용
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripPlace> trips = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripRecord> tourRecords = new ArrayList<>();


    public void encodePassword(String password) {
        this.user_pwd = password;
    }
}
