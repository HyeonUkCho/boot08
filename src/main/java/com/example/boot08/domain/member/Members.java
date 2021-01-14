package com.example.boot08.domain.member;

import com.example.boot08.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
//@Setter
// Setter를 사용하지 않고 해당 필드의 값의 변경이 필요할 경우, 명확히 목적과 의도를 나타낼 수 있는 메소드흫 추가해야만 한다.
// 이렇게 하지 않으면 차후 기능 변경 시 복잡해진다.
@NoArgsConstructor
@Table(name="tbl_member")
@EqualsAndHashCode(of="uid")
@ToString
@Entity
public class Members extends BaseTimeEntity {

    @Id
    private String uid;

    private String upw;

    private String uname;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="member")
    private List<MembersRole> roles;

    @Builder
    public Members(String uid, String upw, String uname, List<MembersRole> roles) {
        this.uid = uid;
        this.upw = upw;
        this.uname = uname;
        this.roles = roles;
    }

    public void updateEncryptPw(String upw) {
        this.upw = upw;
    }

}
