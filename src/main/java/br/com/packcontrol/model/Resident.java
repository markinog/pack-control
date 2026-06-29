package br.com.packcontrol.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "morador")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "cpf", length = 14, unique = true, nullable = false)
    private String cpf;

    @Column(name = "telefone", unique = true)
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "apartamento", length = 100)
    private String apartment;

    @OneToMany(mappedBy = "resident", cascade = CascadeType.ALL)
    private List<AuthorizedReceiver> authorizedReceivers = new ArrayList<>();

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartament) {
        this.apartment = apartament;
    }

    public List<AuthorizedReceiver> getAuthorizedReceivers() {
        return authorizedReceivers;
    }

    public void setAuthorizedReceivers(List<AuthorizedReceiver> authorizedReceivers) {
        this.authorizedReceivers = authorizedReceivers;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
