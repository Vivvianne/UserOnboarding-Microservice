package com.spa.useronboarding.entities.db;

import jakarta.persistence.Table;
import lombok.Data;

@Data
//@Table("spa.Bookings")
public class Bookings {
    private String booking_id;
    private String status;
    private String description;
//    private String created_on;
//    private String updated_on;
    private String service_id;
}
