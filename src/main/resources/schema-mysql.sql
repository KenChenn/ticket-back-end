
CREATE TABLE `commodity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codename` varchar(20) NOT NULL,
  `name` varchar(60) NOT NULL,
  `introduction` text NOT NULL,
  `is_entity` tinyint NOT NULL DEFAULT '0',
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `place` varchar(60) NOT NULL,
  `keyvisual_img` mediumtext,
  `introduce_img1` mediumtext,
  `introduce_img2` mediumtext,
  `organizer` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codename_UNIQUE` (`codename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





CREATE TABLE `forum` (
  `id` int NOT NULL AUTO_INCREMENT,
  `commodity_codename` varchar(20) NOT NULL,
  `commenter` varchar(20) NOT NULL,
  `comments` text NOT NULL,
  `comment_datetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




CREATE TABLE `buy` (
  `buy_num` varchar(20) NOT NULL,
  `sessions_num` int NOT NULL,
  `buy_account` varchar(20) NOT NULL,
  `buy_date_time` datetime NOT NULL,
  `total_price` int NOT NULL,
  `payfinal_date` datetime NOT NULL,
  `is_payment` tinyint DEFAULT '0',
  PRIMARY KEY (`buy_num`)
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `seat` (
  `num` int NOT NULL,
  `area` varchar(10) NOT NULL,
  `seat_num` int NOT NULL,
  `price` int NOT NULL,
  `buy_num` varchar(20) DEFAULT NULL,
  `version` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`num`,`area`,`seat_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `sessions` (
  `num` int NOT NULL AUTO_INCREMENT,
  `commodity_codename` varchar(20) NOT NULL,
  `show_datetime` datetime NOT NULL,
  `start_sell_datetime` datetime NOT NULL,
  `end_sell_datetime` datetime NOT NULL,
  PRIMARY KEY (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





CREATE TABLE `tracking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tracker` varchar(20) NOT NULL,
  `commodity_codename` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


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





