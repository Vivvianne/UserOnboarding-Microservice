package com.spa.useronboarding.entities.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Users")
public class Users {
    
    @Id
    @Column(name="email", nullable=true)
    private String email;

    @Column(name="first_name", nullable=true)
    private String first_name;

    @Column(name="last_name", nullable=true)
    private String last_name;

    @Column(name="contact_no", nullable=true)
    private String contact_no;

    @Column(name="status", nullable=true)
    private String status;

    @Column(name="password", nullable=true)
    private String password;


//    @Column(name= "created_on")
//    private String created_on;

//    @Column(name= "updated_on")
//    private String updated_on;

    // @Column(name= "permission_id")
    // private String permission_id;
}
