package com.chatapp.chat_backend.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    @JsonIgnore
    @Column(nullable = false)
    private String password;

//--------------------- Getters ----------------------------------
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    //---------------------- Setters ------------------------------
    public void setUsername(String username){
        this.username = username;
    }
    public  void setPassword(String password){
        this.password = password;
    }
}