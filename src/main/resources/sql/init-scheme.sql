(
    id           VARCHAR(10) PRIMARY KEY,
    type         VARCHAR(20),
    name         VARCHAR(100),
    code         VARCHAR(20),
    ticker       VARCHAR(20),
    updated_date DATETIME,
    created_date DATETIME,
    index idx_name (name),
    index idx_code (code),
    index idx_ticker (ticker)
);