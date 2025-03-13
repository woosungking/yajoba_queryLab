package com.java.yajoba_querylab.domain.profile.entity;


import com.java.yajoba_querylab.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 프로필 ID (PK)

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 사용자의 외래키 (FK)

    private String intro; // 자기소개


}