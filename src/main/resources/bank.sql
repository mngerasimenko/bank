DROP TABLE IF EXISTS bk_schedule;
DROP TABLE IF EXISTS bk_offer;
DROP TABLE IF EXISTS bk_bank;
DROP TABLE IF EXISTS bk_credit;
DROP TABLE IF EXISTS kredit;
DROP TABLE IF EXISTS bk_client;

CREATE TABLE IF NOT EXISTS bk_client
(
    client_id UUID not null,
    fio       VARCHAR(100) not null,
    telephone VARCHAR(15),
    email     VARCHAR(50)  not null,
    passport  VARCHAR(100) not null,
    PRIMARY KEY (client_id)
);

CREATE TABLE IF NOT EXISTS bk_credit
(
    credit_id  UUID not null,
    limit_am   DOUBLE,
    percent_am DOUBLE,
    PRIMARY KEY (credit_id)
);

CREATE TABLE IF NOT EXISTS bk_bank
(
    bank_id   UUID not null,
    client_id UUID not null,
    credit_id UUID not null,
    PRIMARY KEY (bank_id),
    FOREIGN KEY (client_id) REFERENCES bk_client (client_id) ON DELETE RESTRICT,
    FOREIGN KEY (credit_id) REFERENCES bk_credit (credit_id) ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS bk_offer
(
    offer_id  UUID not null,
    client_id UUID   not null,
    credit_id UUID   not null,
    amount    DOUBLE not null,
    PRIMARY KEY (offer_id),
    FOREIGN KEY (client_id) REFERENCES bk_client (client_id) ON DELETE RESTRICT,
    FOREIGN KEY (credit_id) REFERENCES bk_credit (credit_id) ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS bk_schedule
(
    schedule_id UUID not null,
    date        DATETIME not null,
    offer_id    UUID     not null,
    payment_am  DOUBLE,
    body_am     DOUBLE,
    percent_am  DOUBLE,
    PRIMARY KEY (schedule_id),
    FOREIGN KEY (offer_id) REFERENCES bk_offer (offer_id) ON DELETE RESTRICT
);

INSERT INTO bk_client (client_id, fio, telephone, email, passport)
VALUES ('84f19c8d-6a48-4a77-b5ac-b680bd0fa46f', 'Ivanov I.I.', '+78479758833', 'email@kuku.ru', '2329 2909033'),
       ('c3b78e7a-e467-4135-a979-0b0995cec4aa', 'Petrov P.P.', '+73434567823', 'rtegt@kuku.ru', '2329 4565533'),
       ('8aa5f341-d383-11eb-996f-d3e6b34c3e20', 'Sidorov S.S.', '+73545665353', 'sidor@kuku.ru', '2329 5544332');

INSERT INTO bk_credit (credit_id, limit_am, percent_am)
VALUES ('5c8664cc-3d0c-4fcb-9aa4-23e4fbe8e6be', 12000000.0, 10.0),
       ('670be1eb-f28f-4cef-94c4-766bdc583d4d', 100000.0, 19.5),
       ('3acffd6f-d9b0-4c25-a9db-0c6d5b7b997b', 999000.0, 5.9);

INSERT INTO bk_bank (bank_id, client_id, credit_id)
VALUES ('9e4d3b04-4001-4408-923e-6fa6bc0364bd', '84f19c8d-6a48-4a77-b5ac-b680bd0fa46f',
        '5c8664cc-3d0c-4fcb-9aa4-23e4fbe8e6be'),
       ('7500e9d0-191c-44ec-8a4b-f0add7b153d8', '84f19c8d-6a48-4a77-b5ac-b680bd0fa46f',
        '670be1eb-f28f-4cef-94c4-766bdc583d4d'),
       ('04dfc77f-1ae2-4212-82e3-22a9aa87fa52', '8aa5f341-d383-11eb-996f-d3e6b34c3e20',
        '3acffd6f-d9b0-4c25-a9db-0c6d5b7b997b');

INSERT INTO bk_offer (offer_id, client_id, credit_id, amount)
VALUES ('7bec9d45-d898-4046-b813-bafbf2492671', '84f19c8d-6a48-4a77-b5ac-b680bd0fa46f',
        '5c8664cc-3d0c-4fcb-9aa4-23e4fbe8e6be', 100000),
       ('7da3f4d9-5331-4506-920b-85261da4d808', 'c3b78e7a-e467-4135-a979-0b0995cec4aa',
        '3acffd6f-d9b0-4c25-a9db-0c6d5b7b997b', 999000);

INSERT INTO bk_schedule (schedule_id, date, offer_id, payment_am, body_am, percent_am)
VALUES ('0e29d589-0e00-48da-a4c1-b6e6fbe997b4', '2021-06-21', '7bec9d45-d898-4046-b813-bafbf2492671', 50000, 100000, 0),
       ('44d7a166-f701-4b77-a10f-385422afbc17', '2021-07-21', '7bec9d45-d898-4046-b813-bafbf2492671', 50000, 50000, 0);