package com.spa.useronboarding.entities.db;

import jakarta.persistence.Table;
import lombok.Data;

@Data
//@Table("spa.Services")
public class Services {
    private String service_id;
    private String name;
    private String description;
    private String status;
    private String price;
//    private String created_on;
//    private String updated_on;
}
