package umc.spring2.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring2.domain.common.BaseEntity;

@Entity
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class TripPlace extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 회원 연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(length = 255, nullable = false)
    private String country;

    @Column(length = 255, nullable = false)
    private String city;

    @Column(nullable = false)
    private Boolean completed;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @OneToOne(mappedBy = "tripPlace", cascade = CascadeType.ALL, orphanRemoval = true)
    private TripRecord tripRecord;

}