package com.example.boot08.security;

import com.example.boot08.domain.member.MembersRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log
public class Boot08UserService implements UserDetailsService {

    @Autowired
    MembersRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findById(username).filter(member -> member != null)
                                        .map(member -> new Boot08SecurityUser(member)).get();
    }
}
