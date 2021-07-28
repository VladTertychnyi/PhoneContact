DROP database IF EXISTS phone_contacts;
CREATE database phone_contacts;
USE phone_contacts;

CREATE TABLE IF NOT EXISTS USER
(
    id       INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    login     VARCHAR(50) UNIQUE,
    password VARCHAR(250)
);

CREATE TABLE IF NOT EXISTS CONTACT
(
    id     INT(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    login  VARCHAR(50),
    user_id INT(5),
    FOREIGN KEY (user_id) REFERENCES USER (id)
);

CREATE TABLE IF NOT EXISTS EMAILS
(
    id        INT(5) AUTO_INCREMENT NOT NULL,
    value     VARCHAR(50),
    contact_id INT(5),
    PRIMARY KEY (id),
    FOREIGN KEY (contact_id) REFERENCES CONTACT (id)
);

CREATE TABLE IF NOT EXISTS NUMBERS
(
    id        INT(5) AUTO_INCREMENT NOT NULL,
    value     VARCHAR(50),
    contact_id INT(5),
    PRIMARY KEY (id),
    FOREIGN KEY (contact_id) REFERENCES CONTACT (id)
);
