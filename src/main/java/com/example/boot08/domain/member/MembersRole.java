package com.example.boot08.domain.member;

import lombok.*;

import javax.persistence.*;

@Getter
// Setter를 사용하지 않고 해당 필드의 값의 변경이 필요할 경우, 명확히 목적과 의도를 나타낼 수 있는 메소드흫 추가해야만 한다.
// 이렇게 하지 않으면 차후 기능 변경 시 복잡해진다.
@NoArgsConstructor
@Entity
@Table(name="tbl_member_roles")
@EqualsAndHashCode(of="fno")
@ToString
public class MembersRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;

    private String roleName;

    @Builder
    public MembersRole(Long fno, String roleName) {
        this.fno = fno;
        this.roleName = roleName;
    }
}
