CREATE DATABASE  IF NOT EXISTS `secure_users_directory`;

-- Drop book_offers table if it exists
DROP TABLE IF EXISTS book_offers;

-- Drop users table if it exists
DROP TABLE IF EXISTS users;

-- Create users table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    full_name VARCHAR(255),
    address VARCHAR(255),
    age INT,
    phone_number VARCHAR(20),
    preferred_categories TEXT,
    favorite_authors TEXT
);

CREATE TABLE book_offers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    authors VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    summary TEXT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

    
