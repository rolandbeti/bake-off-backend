package al.sda.finalproject.bakeoff.security.impl;

import al.sda.finalproject.bakeoff.entity.RoleEntity;
import org.springframework.security.core.GrantedAuthority;

public class AuthorityImpl implements GrantedAuthority {
    private RoleEntity role;
    public AuthorityImpl(RoleEntity role){
        this.role = role;
    }
    @Override
    public String getAuthority() {
        return role.getRoleName();
    }
}
