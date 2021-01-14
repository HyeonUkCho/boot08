package com.example.boot08.domain.members;

import com.example.boot08.domain.member.Members;
import com.example.boot08.domain.member.MembersRepository;
import com.example.boot08.domain.member.MembersRole;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class MembersRepositoryTest {

    @Autowired
    private MembersRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testInsert() {
        for(int i=0; i <= 100; i++) {
            MembersRole role;
            if(i<80) {
                role = MembersRole.builder().roleName("BASIC").build();
            } else if (i<90 && i >=80) {
                role = MembersRole.builder().roleName("MANAGER").build();
            } else {
                role = MembersRole.builder().roleName("ADMIN").build();
            }
            Members member = Members.builder()
                    .uid("user" + i)
                    .upw(passwordEncoder.encode("pw" + i))
                    .uname("사용자" + i)
                    .roles(Arrays.asList(role))
                    .build();
            repo.save(member);
        }
    }

    @Test
    public void testRead() {
        Optional<Members> result = repo.findById("user85");
        result.ifPresent(member -> log.info("member" + member));
    }

    @Test
    public void testUpdate() {
        List<String> ids = new ArrayList<>();
        for (int i=0; i<=100; i++) {
            ids.add("user"+i);
        }
        repo.findAllById(ids).forEach(member -> {
            member.updateEncryptPw(passwordEncoder.encode(member.getUpw()));
            repo.save(member);
        });
    }
}
