package br.com.packcontrol.model;

import br.com.packcontrol.model.enums.PackageSize;
import br.com.packcontrol.model.enums.PickedBy;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "encomenda")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_porteiro", nullable = false)
    private Doorman doorman;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_morador_destinatario", nullable = false)
    private Resident destinationResident;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_morador_retirada")
    private Resident pickupResident;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_terceiro_retirada")
    private AuthorizedReceiver pickupAuthorizedReceiver;

    @Column(name = "retirado_por", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PickedBy pickedBy;

    @Column(name = "horario_entrega", columnDefinition = "DATETIME(6)", nullable = false, updatable = false)
    private LocalDateTime deliveryTime;

    @Column(name = "horario_retirada", columnDefinition = "DATETIME(6)")
    private LocalDateTime receiveTime;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "tamanho")
    private PackageSize packageSize;

    @Column(name = "empresa")
    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Resident getDestinationResident() {
        return destinationResident;
    }

    public void setDestinationResident(Resident destinationResident) {
        this.destinationResident = destinationResident;
    }

    public Doorman getDoorman() {
        return doorman;
    }

    public void setDoorman(Doorman doorman) {
        this.doorman = doorman;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PackageSize getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(PackageSize packageSize) {
        this.packageSize = packageSize;
    }

    public AuthorizedReceiver getPickupAuthorizedReceiver() {
        return pickupAuthorizedReceiver;
    }

    public void setPickupAuthorizedReceiver(AuthorizedReceiver pickupAuthorizedReceiver) {
        this.pickupAuthorizedReceiver = pickupAuthorizedReceiver;
    }

    public Resident getPickupResident() {
        return pickupResident;
    }

    public void setPickupResident(Resident pickupResident) {
        this.pickupResident = pickupResident;
    }

    public LocalDateTime getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(LocalDateTime receiveTime) {
        this.receiveTime = receiveTime;
    }

    public PickedBy getPickedBy() {
        return pickedBy;
    }

    public void setPickedBy(PickedBy pickedBy) {
        this.pickedBy = pickedBy;
    }
}
