CREATE DATABASE  IF NOT EXISTS `secure_users_directory`;
-- Drop existing users table
DROP TABLE IF EXISTS users;

-- Create new users table with additional profile information
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(255) DEFAULT NULL,
  password VARCHAR(255) DEFAULT NULL,
  role VARCHAR(255) DEFAULT NULL,
  full_name VARCHAR(255) DEFAULT NULL,
  address TEXT DEFAULT NULL,
  age INT DEFAULT NULL,
  phone_number VARCHAR(20) DEFAULT NULL,
  preferred_categories VARCHAR(50) DEFAULT NULL,
  favorite_authors VARCHAR(255) DEFAULT NULL
);


    
