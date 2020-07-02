package com.luis.pereira.panquecasdafamilia.model;

import lombok.*;
import org.springframework.stereotype.Component;
import javax.persistence.*;

@Component

//Lombok
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString

// JPA
@Entity
@Table(name= "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private long id_client;

    @Column(name = "name")
    private String name;

    @Column(name = "street")
    private String street;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "house_number")
    private String houseNumber;

}

