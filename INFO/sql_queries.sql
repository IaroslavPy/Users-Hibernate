
-- С ЦЕЛЬЮ ИЗБЕЖАНИЯ последствий неквалифицированных
-- действий, создание БД, таблиц лучше оставить за разработчиком.
-- Поэтому, такой функционал в приложении не прописываем.
-- БД, талицу(ы) можем создать через визуальный инструмент, 
-- например, MySQL Workbench.

-- База данных
CREATE DATABASE contacts_hibernate_db;

-- ПРИ НЕОБХОДИМОСТИ для работы с данной БД, можем 
-- создать или поручить (если уже есть) новому пользователю MySQL.
-- БД, предварительно, создается через root-пользователя.

-- Права нового пользователя 
-- (создание, изменение, удаление таблиц).
GRANT CREATE, ALTER, DROP
ON contacts_hibernate_db.*
TO 'dev'@'localhost';

-- Права нового пользователя 
-- (манипуляции с данными таблиц).
GRANT INSERT, SELECT, UPDATE, DELETE
ON contacts_hibernate_db.*
TO 'dev'@'localhost';

-- Далее, ЕСЛИ новый пользователь создается ВПЕРВЫЕ, то
-- Выходим из Workbench.
-- Создаем новое соединение (+ в кружечке).
-- В модальном окне прописываем для соответствующих полей
--	Connection Name: Local dev
--	Username: dev
-- Кликаем Test Connection.
-- В модальном окне вводим пароль нового пользователя.
-- Кликаем OK. Должны зайти в соответствующую БД.
-- Можем создавать таблицу(ы), манипулировать данными.


-- Таблица контактов
CREATE TABLE IF NOT EXISTS contacts
( id INTEGER NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(128) NOT NULL,
  last_name VARCHAR(128) NOT NULL,
  phone VARCHAR(56) NOT NULL,
  email VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);

-- ВНИМАНИЕ.
-- Применен HQL (Hibernate Query Language).
-- HQL – объектно-ориентированный язык запросов, который очень похож на SQL.
-- https://docs.jboss.org/hibernate/orm/6.2/userguide/html_single/Hibernate_User_Guide.html#hql
-- https://docs.jboss.org/hibernate/orm/6.2/userguide/html_single/Hibernate_User_Guide.html#query-language

-- Внесение данных в таблицу contacts
-- HQL
INSERT INTO Contact (firstName, lastName, phone, email) VALUES (:firstName, :lastName, :phone, :email)
-- SQL
INSERT INTO contacts (first_name, last_name, phone, email) VALUES (:first_name, :last_name, :phone, :email)


-- Выборка данных из таблицы contacts
-- HQL
FROM Contact
-- SQL
SELECT * FROM contacts


-- Обновление данных в таблице contacts
-- HQL
UPDATE Contact SET phone = :phone WHERE id = :id
-- SQL
UPDATE contacts SET phone = :phone WHERE id = :id


-- Удаление данных в таблице contacts
-- HQL
DELETE FROM Contact WHERE id = :id
-- SQL
DELETE FROM contacts WHERE id = :id;
