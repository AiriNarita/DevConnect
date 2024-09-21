ALTER TABLE articles ADD COLUMN article_category Enum('TECHNOLOGY', 'DAIRY', 'TWEET', 'OTHERS') NOT NULL DEFAULT 'OTHERS';
-- Migration script created on 2024/09/21 by airi
-- Description: insert_article_category
-- Please write your migration SQL below
