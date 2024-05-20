CREATE DATABASE IF NOT EXISTS `secure_users_directory`;

USE `secure_users_directory`;

-- Disable foreign key checks
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS book_offers;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS requests;
DROP TABLE IF EXISTS book_requests;
DROP TABLE IF EXISTS notifications;

-- Enable foreign key checks
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE IF NOT EXISTS roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    full_name VARCHAR(100) ,
    address VARCHAR(255),  
    age INT,               
    phone_number VARCHAR(20),
    preferred_categories VARCHAR(255),
    favorite_authors VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS book_offers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    authors VARCHAR(255) NOT NULL,
    category VARCHAR(50) NOT NULL,
    summary TEXT NOT NULL,
    taken_by_user_id INT,
    given_by_user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (taken_by_user_id) REFERENCES users(id),
    FOREIGN KEY (given_by_user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS requests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    book_offer_id INT NOT NULL,
    user_id INT NOT NULL,
    message TEXT,
    FOREIGN KEY (book_offer_id) REFERENCES book_offers(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS book_requests (
    id INT AUTO_INCREMENT PRIMARY KEY,
    book_offer_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (book_offer_id) REFERENCES book_offers(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS notifications (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    message VARCHAR(255) NOT NULL,
    timestamp DATETIME NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

