package com.spa.useronboarding.entities.db;

import jakarta.persistence.Table;
import lombok.Data;

@Data
//@Table("spa.Permissions")
public class Permissions {
    private String permission_id;
    private String name;
    private String status;
    private String description;
//    private String created_on;
//    private String updated_on;
}
