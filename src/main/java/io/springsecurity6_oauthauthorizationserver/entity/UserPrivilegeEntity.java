package io.springsecurity6_oauthauthorizationserver.entity;


import io.springsecurity6_oauthauthorizationserver.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "user_privilege", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPrivilegeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Builder.Default
    @Column(name = "name")
    private UserRole role = UserRole.USER;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}


