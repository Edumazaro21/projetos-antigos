package br.com.dextra.dextrachallenge.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "character")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", length=80, nullable=false)
    private String name;

    @Column(name="role", length=40, nullable=false)
    private String role;

    @Column(name="school", length=80, nullable=false)
    private String school;

    @Column(name="id_house", length=80, nullable=false)
    private String idHouse;

    @Column(name="patronus", length=40, nullable=false)
    private String patronus;
}
