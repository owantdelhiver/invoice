package fr.owen.facturier.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class Admin implements UserDetails {
    @Id
    private int id;
    private String mail;
    private String password;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "admin_role",
            joinColumns = @JoinColumn(name="id_admin"),
            inverseJoinColumns = @JoinColumn(name="id_role")
    )
    private List<Role> rolelist;

    public Admin() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRolelist() {
        return rolelist;
    }

    public void setRolelist(List<Role> rolelist) {
        this.rolelist = rolelist;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.rolelist
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return mail;
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
