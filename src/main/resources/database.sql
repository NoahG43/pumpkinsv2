CREATE DATABASE springbootapi;
USE pumpkinsapi;
CREATE TABLE tour_sequence (
    id INT(6) UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    start_date VARCHAR(500) NOT NULL,
    end_date VARCHAR(500) NOT NULL,
    location VARCHAR(500) NOT NULL,
    entry_fee VARCHAR(500) NOT NULL,
    cash_prize VARCHAR(500) NOT NULL
);