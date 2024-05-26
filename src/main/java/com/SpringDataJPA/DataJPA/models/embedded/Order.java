package com.SpringDataJPA.DataJPA.models.embedded;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_order")
public class Order {

    @EmbeddedId
    private OrderId orderId;

    private String orderInfo;

    private String anotherField;

    @Embedded
    private Address address;
}
