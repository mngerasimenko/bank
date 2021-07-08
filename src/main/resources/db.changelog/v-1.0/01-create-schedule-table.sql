CREATE TABLE IF NOT EXISTS bk_schedule
(
    schedule_id UUID     not null,
    date        DATETIME not null,
    offer_id    UUID     not null,
    payment_am  DOUBLE,
    body_am     DOUBLE,
    percent_am  DOUBLE,
    PRIMARY KEY (schedule_id),
    FOREIGN KEY (offer_id) REFERENCES bk_offer (offer_id) ON DELETE RESTRICT
);