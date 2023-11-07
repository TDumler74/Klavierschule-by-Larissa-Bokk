package de.ait.ksdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;
}
