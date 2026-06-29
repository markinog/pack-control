CREATE TABLE morador (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    telefone VARCHAR(255) UNIQUE,
    email VARCHAR(255) UNIQUE,
    apartamento VARCHAR(100)
);