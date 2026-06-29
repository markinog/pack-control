CREATE TABLE recebedor_autorizado (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    cpf VARCHAR(255) UNIQUE,
    apartamento VARCHAR(100),
    autorizado BOOLEAN,
    morador_id BIGINT,
    FOREIGN KEY (morador_id) REFERENCES morador(id)
);