CREATE TABLE IF NOT EXISTS bk_client
(
    client_id UUID         not null,
    fio       VARCHAR(100) not null,
    telephone VARCHAR(15)  not null,
    email     VARCHAR(50)  not null,
    passport  VARCHAR(100) not null,
    PRIMARY KEY (client_id)
);