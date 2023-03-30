drop schema blood_bank;
CREATE DATABASE blood_bank;
USE blood_bank;

CREATE TABLE IF NOT EXISTS users (
  id INT(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  role ENUM('Admin', 'Doctor', 'Donator') NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS donators (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  blood_group VARCHAR(10) NOT NULL,
  PRIMARY KEY (id)
);

USE blood_bank;
INSERT INTO users (username, password, role) VALUES ('admin', 'pass', 'Admin');
INSERT INTO users (username, password, role) VALUES ('doctor', 'pass', 'Doctor');
INSERT INTO users (username, password, role) VALUES ('donator1', 'pass', 'Donator');
INSERT INTO users (username, password, role) VALUES ('donator2', 'pass', 'Donator');

INSERT INTO donators (name, email, blood_group) VALUES ('Alice', 'alice@example.com', 'A+');
INSERT INTO donators (name, email, blood_group) VALUES ('Bob', 'bob@example.com', 'B-');
INSERT INTO donators (name, email, blood_group) VALUES ('Charlie', 'charlie@example.com', 'O+');