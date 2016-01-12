package edu.waa.classified.model;

import javax.persistence.*;

@Entity
@Table(name = "IMAGE")
public class CImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public CImage() {

    }
}
