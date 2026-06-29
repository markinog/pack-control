package br.com.packcontrol.model;

import br.com.packcontrol.model.enums.PackageSize;
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

import java.time.LocalDateTime;

@Entity
@Table(name = "encomenda")
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
    @JoinColumn(name = "id_recebedor_autorizado")
    private AuthorizedReceiver pickupAuthorizedReceiver;

    @Column(name = "horario_entrega", columnDefinition = "DATETIME(6)", nullable = false, updatable = false)
    private LocalDateTime deliveryTime;

    @Column(name = "horario_retirada", columnDefinition = "DATETIME(6)")
    private LocalDateTime receiveTime;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "tamanho")
    private PackageSize packageSize;

    @Column(name = "empresa")
    private String company;

}
