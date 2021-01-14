package com.example.boot08.security;

import com.example.boot08.domain.member.Members;
import com.example.boot08.domain.member.MembersRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Boot08SecurityUser extends User {

    private static final String ROLE_PREFIX = "ROLE_";

    private Members member;

    public Boot08SecurityUser (Members member) {
        super(member.getUid(), member.getUpw(), makeGrantedAuthority(member.getRoles()) );
        this.member = member;
    }

    private static List<GrantedAuthority> makeGrantedAuthority(List<MembersRole> roles) {
        List<GrantedAuthority> list = new ArrayList<>();
        roles.forEach(
                role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX+role.getRoleName()))
        );
        return list;
    }
}
