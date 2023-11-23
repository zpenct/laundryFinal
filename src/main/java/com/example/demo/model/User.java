//package com.example.demo.model;
//
//import jakarta.persistence.*;
////import org.springframework.security.core.GrantedAuthority;
////import org.springframework.security.core.authority.SimpleGrantedAuthority;
////import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "user")
//
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String username;
//
//    private String password;
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(  name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();
//
//    public User() {
//    }
//
//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//}
//
////@Entity
////@Table(name = "user")
////public class User {
////    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
////    private Long id;
////    private String username;
////    private String password;
////    @Enumerated(EnumType.STRING)
////    private Role role;
////
////    public User(Long id, String username, String password) {
////        this.id = id;
////        this.username = username;
////        this.password = password;
////    }
////
////    public String getUsername() {
////        return username;
////    }
//////
//////    @Override
//////    public boolean isAccountNonExpired() {
//////        return true;
//////    }
//////
//////    @Override
//////    public boolean isAccountNonLocked() {
//////        return true;
//////    }
//////
//////    @Override
//////    public boolean isCredentialsNonExpired() {
//////        return true;
//////    }
//////
//////    @Override
//////    public boolean isEnabled() {
//////        return true;
//////    }
////
////    public void setUsername(String username) {
////        this.username = username;
////    }
////
//////    @Override
//////    public Collection<? extends GrantedAuthority> getAuthorities() {
//////        return List.of(new SimpleGrantedAuthority(role.name()));
//////    }
////
////    public String getPassword() {
////        return password;
////    }
////
////    public void setPassword(String password) {
////        this.password = password;
////    }
////}
