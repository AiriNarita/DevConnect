CREATE TABLE articles (
    article_id INT PRIMARY KEY,
    user_id INT,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    image_url VARCHAR(255),
    is_draft BOOLEAN NOT NULL,
    is_public BOOLEAN NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    version INT NOT NULL,
    CONSTRAINT fk_user
      FOREIGN KEY (user_id) REFERENCES users(user_id)
);-- Migration script created on 2024/08/17 by airi
-- Description: create_articles_table
-- Please write your migration SQL below
