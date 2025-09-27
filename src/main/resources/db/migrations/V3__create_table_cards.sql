CREATE TABLE cards (
  id              INT            AUTO_INCREMENT PRIMARY KEY,
  number          VARCHAR(20)    NOT NULL UNIQUE,
  flag            VARCHAR(20)    NOT NULL,
  total_limit     DECIMAL(10, 2) NOT NULL,
  available_limit DECIMAL(10, 2) NOT NULL,
  client_id       INT            NOT NULL,
  FOREIGN KEY (client_id) REFERENCES clients(id)
);