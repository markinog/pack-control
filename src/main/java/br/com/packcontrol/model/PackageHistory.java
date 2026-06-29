package br.com.packcontrol.model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "packcontrol")
public class PackageHistory {

    @Id
    private String id;
    private String nomeMorador;
    private String nomeRecebedorAutorizado;
    private LocalDateTime horarioRetirada;
    private LocalDateTime horarioEntrega;

}
