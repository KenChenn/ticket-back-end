CREATE DATABASE IF NOT EXISTS `ticket`;

CREATE TABLE IF NOT EXISTS `commodity` (
  `codename` varchar(20) NOT NULL,
  `name` varchar(60) NOT NULL,
  `introduction` text NOT NULL,
  `is_entity` tinyint NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `image` blob,
  `organizer` varchar(30) NOT NULL,
  PRIMARY KEY (`codename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `forum` (
  `commodity_codename` varchar(20) NOT NULL,
  `commenter` varchar(20) NOT NULL,
  `comments` text NOT NULL,
  `comment_date` date NOT NULL,
  PRIMARY KEY (`commodity_codename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `order` (
  `order_num` int NOT NULL,
  `commodity_num` int NOT NULL,
  `buy_account` varchar(20) NOT NULL,
  `buy_date` date NOT NULL,
  `total_price` int NOT NULL,
  `prompt` date NOT NULL,
  `is_payment` tinyint DEFAULT NULL,
  PRIMARY KEY (`order_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `organizer` (
  `name` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `address` varchar(40) NOT NULL,
  `url` varchar(100) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `seat` (
  `num` int NOT NULL,
  `area` varchar(10) NOT NULL,
  `seat_num` int NOT NULL,
  `price` int NOT NULL,
  `order_num` int DEFAULT NULL,
  PRIMARY KEY (`num`,`area`,`seat_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `sessions` (
  `num` int NOT NULL,
  `commodity_codename` varchar(20) NOT NULL,
  `showdate` date NOT NULL,
  `place` varchar(60) NOT NULL,
  `start_selldate` date NOT NULL,
  `end_selldate` date NOT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `tracking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tracker` varchar(20) NOT NULL,
  `commodity_codename` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `user` (
  `account` varchar(20) NOT NULL,
  `password` varchar(60) NOT NULL,
  `realname` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `born_date` date NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `creditcard_number` varchar(20) DEFAULT NULL,
  `is_admin` tinyint DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



