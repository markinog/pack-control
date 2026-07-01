package br.com.packcontrol.model;

import br.com.packcontrol.model.enums.DoormanShift;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "porteiro")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doorman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    private String cpf;

    @Column(name = "turno")
    @Enumerated(value = EnumType.STRING)
    private DoormanShift shift;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DoormanShift getShift() {
        return shift;
    }

    public void setShift(DoormanShift shift) {
        this.shift = shift;
    }
}
