package com.project.crudemp.model;


import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity

@Table(name="user",uniqueConstraints=@UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinTable(
        name="users_roles",
        joinColumns=@JoinColumn(
            name="user_id",referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName="id")
        )
private Collection<Role>roles;
    public User(){

    }
    public User(String name, String email,String phone,Collection<Role> roles) {

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.roles=roles;
    }

    // Getter and Setter for id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    // Getter and Setter for phone
    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
        this.phone = phone;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

}
