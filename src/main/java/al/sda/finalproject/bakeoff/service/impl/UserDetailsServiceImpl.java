package al.sda.finalproject.bakeoff.service.impl;

import al.sda.finalproject.bakeoff.entity.UserEntity;
import al.sda.finalproject.bakeoff.repository.UserRepository;
import al.sda.finalproject.bakeoff.security.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = this.userRepository.findUserEntityByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("Username not found");
        }
        return new UserDetailsImpl(user);
    }
}
