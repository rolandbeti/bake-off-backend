package al.sda.finalproject.bakeoff.security.impl;
import al.sda.finalproject.bakeoff.entity.RoleEntity;
import al.sda.finalproject.bakeoff.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    UserEntity user;
    public UserDetailsImpl(UserEntity user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<RoleEntity> roles = new ArrayList<>();
//        roles.add(user.getRole());
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new AuthorityImpl(user.getRole()))
//        for (RoleEntity theRole : roles) {
//            authorities.add(new SimpleGrantedAuthority(theRole.getRoleName()));
//        }
        List<AuthorityImpl>authorities = new ArrayList<>();
        authorities.add(new AuthorityImpl(user.getRole()));
        return authorities;
//        return user.getRoles().stream().map(AuthorityImpl::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
