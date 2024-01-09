
CREATE TABLE `commodity` (
  `codename` varchar(20) NOT NULL,
  `name` varchar(60) NOT NULL,
  `introduction` text NOT NULL,
  `is_entity` tinyint NOT NULL DEFAULT '0',
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `place` varchar(60) NOT NULL,
  `keyvisual_img` blob,
  `introduce_img1` blob,
  `introduce_img2` blob,
  `organizer` varchar(30) NOT NULL,
  PRIMARY KEY (`codename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `forum` (
  `commodity_codename` varchar(20) NOT NULL,
  `commenter` varchar(20) NOT NULL,
  `comments` text NOT NULL,
  `comment_date` date NOT NULL,
  PRIMARY KEY (`commodity_codename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `order` (
  `order_num` int NOT NULL,
  `commodity_num` int NOT NULL,
  `buy_account` varchar(20) NOT NULL,
  `buy_date` date NOT NULL,
  `total_price` int NOT NULL,
  `payfinal_date` date NOT NULL,
  `is_payment` tinyint DEFAULT '0',
  PRIMARY KEY (`order_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `organizer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `address` varchar(40) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `sns` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `seat` (
  `num` int NOT NULL,
  `area` varchar(10) NOT NULL,
  `seat_num` int NOT NULL,
  `price` int NOT NULL,
  `order_num` int DEFAULT NULL,
  PRIMARY KEY (`num`,`area`,`seat_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sessions` (
  `num` int NOT NULL,
  `commodity_codename` varchar(20) NOT NULL,
  `show_date` date NOT NULL,
  `start_selldate` date NOT NULL,
  `end_selldate` date NOT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `tracking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tracker` varchar(20) NOT NULL,
  `commodity_codename` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `account` varchar(20) NOT NULL,
  `password` varchar(60) NOT NULL,
  `realname` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `born_date` date NOT NULL,
  `phone` varchar(15) NOT NULL,
  `creditcard_number` varchar(20) DEFAULT NULL,
  `is_admin` tinyint DEFAULT '0',
  PRIMARY KEY (`account`),
  UNIQUE KEY `account_UNIQUE` (`account`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




