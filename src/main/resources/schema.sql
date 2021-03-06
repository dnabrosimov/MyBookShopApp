DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

CREATE TABLE authors(
id INT PRIMARY KEY,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL
);

CREATE TABLE books(
id INT AUTO_INCREMENT PRIMARY KEY,
--author VARCHAR(250) NOT NULL,
title VARCHAR(250) NOT NULL,
price_old VARCHAR(250) DEFAULT NULL,
price VARCHAR(250) DEFAULT NULL,
author_id INT NOT NULL
);