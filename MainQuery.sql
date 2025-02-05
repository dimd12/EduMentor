/*CREATE DATABASE EduMentor;

USE EduMentor;

-- 1. Roles Table
CREATE TABLE roles (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(50) NOT NULL UNIQUE
);

-- 2. Users Table
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    profile_picture_url VARCHAR(255),
    bio TEXT,
    role_id INT NOT NULL,
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES roles(role_id)
);*/

CREATE TABLE categories (
	category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(45) NOT NULL UNIQUE
);

-- 3. Lessons Table
CREATE TABLE posts (
    post_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    video_url VARCHAR(255) NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    category_id INT,
    CONSTRAINT fk_user_post FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_category_post FOREIGN KEY (category_id) REFERENCES categories(category_id)
);
/*
-- 4. Direct Messages Table
CREATE TABLE messages (
    message_id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT NOT NULL,
    receiver_id INT NOT NULL,
    message TEXT NOT NULL,
    date_sent TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (sender_id) REFERENCES users(user_id),
    FOREIGN KEY (receiver_id) REFERENCES users(user_id)
);

-- 5. Reviews
CREATE TABLE reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    rating INT NOT NULL,
    review_sender_id INT NOT NULL,
    review_receiver_id INT NOT NULL,
    review_message TEXT,
    date_sent TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (review_sender_id) REFERENCES users(user_id),
    FOREIGN KEY (review_receiver_id) REFERENCES users(user_id)
);*/

-- 6. Homework
CREATE TABLE questions (
    question_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    title VARCHAR(255) NOT NULL,
    details TEXT,
    image_url TEXT,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    category_id INT,
    CONSTRAINT fk_user_question FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_category_question FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

CREATE TABLE answers (
    answer_id INT AUTO_INCREMENT PRIMARY KEY,
    question_id INT NOT NULL,
    user_id INT NOT NULL,
    response TEXT NOT NULL,
    image_url TEXT,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_answer FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT fk_question_answer FOREIGN KEY (question_id) REFERENCES questions(question_id)
);