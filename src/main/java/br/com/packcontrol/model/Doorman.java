package br.com.packcontrol.model;

import br.com.packcontrol.model.enums.DoormanShift;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "porteiro")
public class Doorman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    private String cpf;

    @Column(name = "turno")
    private DoormanShift shift;

}
