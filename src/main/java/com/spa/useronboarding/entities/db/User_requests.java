package com.spa.useronboarding.entities.db;

import jakarta.persistence.Table;
import lombok.Data;

@Data
//@Table("spa.User_requests")
public class User_requests {
    private String request_id;
    private String operation_name;
    private String description;
    private String status;
//    private String created_on;
//    private String updated_on;
    private String service_id;
    private String permission_id;

}
