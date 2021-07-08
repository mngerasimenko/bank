CREATE TABLE IF NOT EXISTS bk_credit
(
    credit_id  UUID not null,
    limit_am   DOUBLE,
    percent_am DOUBLE,
    PRIMARY KEY (credit_id)
);