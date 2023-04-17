
-- База данных
CREATE DATABASE users_hibernate_db;

-- Таблица юзеров
CREATE TABLE IF NOT EXISTS users
( id INTEGER NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(128) NOT NULL,
  last_name VARCHAR(128) NOT NULL,
  nick_name VARCHAR(128) NOT NULL,
  phone VARCHAR(56) NOT NULL,
  email VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);

-- Внесение данных в таблицу users
-- HQL
INSERT INTO User (firstName, lastName, nickname, phone, email)
VALUES (:firstName, :lastName, :nickName, :phone, :email)
-- SQL
INSERT INTO contacts (first_name, last_name, nick_name, phone, email)
VALUES (:first_name, :last_name, :nick_name, :phone, :email)


-- Выборка данных из таблицы contacts
-- HQL
FROM User
-- SQL
SELECT * FROM users


-- Обновление данных в таблице contacts
-- HQL
UPDATE User SET phone = :phone WHERE id = :id
-- SQL
UPDATE users SET phone = :phone WHERE id = :id


-- Удаление данных в таблице contacts
-- HQL
DELETE FROM User WHERE id = :id
-- SQL
DELETE FROM users WHERE id = :id;
