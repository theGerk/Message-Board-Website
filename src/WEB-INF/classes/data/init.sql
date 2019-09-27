
CREATE DATABASE message_board_website;

use message_board_website;

CREATE TABLE users (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	date TIMESTAMP,
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL
);

CREATE TABLE threads (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	date TIMESTAMP,
	num_replies int NOT NULL DEFAULT '0',
	num_up_votes int NOT NULL DEFAULT '0',
	num_down_votes int NOT NULL DEFAULT '0',
	user_id int NOT NULL,
	attachment_type VARCHAR(5) NOT NULL,
	attachment_name VARCHAR(20) NOT NULL,
	title VARCHAR(100) NOT NULL,
	body VARCHAR(500) NOT NULL
);

CREATE TABLE replies (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	date TIMESTAMP,
	thread_id int NOT NULL,
	num_replies int NOT NULL DEFAULT '0',
	num_up_votes int NOT NULL DEFAULT '0',
	num_down_votes int NOT NULL DEFAULT '0',
	user_id int NOT NULL,
	reply_id int NOT NULL,
	attachment_type VARCHAR(5) NOT NULL,
	attachment_name VARCHAR(20) NOT NULL,
	body VARCHAR(500) NOT NULL
);

