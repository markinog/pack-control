CREATE TABLE encomenda (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_porteiro BIGINT NOT NULL,
    id_morador_destinatario BIGINT NOT NULL,
    id_morador_retirada BIGINT,
    id_terceiro_retirada BIGINT,
    retirado_por VARCHAR(255),
    horario_entrega DATETIME(6) NOT NULL,
    horario_retirada DATETIME(6),
    tamanho VARCHAR(255),
    empresa VARCHAR(255),
    FOREIGN KEY (id_porteiro) REFERENCES porteiro(id),
    FOREIGN KEY (id_morador_destinatario) REFERENCES morador(id),
    FOREIGN KEY (id_morador_retirada) REFERENCES morador(id),
    FOREIGN KEY (id_terceiro_retirada) REFERENCES recebedor_autorizado(id)
);

