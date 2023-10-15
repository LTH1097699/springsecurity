package io.springsecurity5_methodauthorization.entity;


import io.springsecurity5_methodauthorization.enums.UserRole;
import lombok.*;

import javax.persistence.*;

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


