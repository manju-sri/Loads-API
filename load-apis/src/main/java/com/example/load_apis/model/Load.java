package com.example.load_apis.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;


@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "load_details")
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String loadingPoint;

    private String unloadingPoint;

    private String productType;

    private String truckType;

    private String noOfTrucks;

    private String weight;

    private String shipperId;

    private Date date;

}
