CREATE TABLE IF NOT EXISTS bk_bank
(
    bank_id   UUID not null,
    client_id UUID not null,
    credit_id UUID not null,
    PRIMARY KEY (bank_id),
    FOREIGN KEY (client_id) REFERENCES bk_client (client_id) ON DELETE RESTRICT,
    FOREIGN KEY (credit_id) REFERENCES bk_credit (credit_id) ON DELETE RESTRICT
);