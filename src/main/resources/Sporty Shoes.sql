CREATE DATABASE `ecommerce` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

use ecommerce;

CREATE TABLE `authorities` (
  `authorities` varchar(255) DEFAULT NULL,
  `authorityId` int NOT NULL AUTO_INCREMENT,
  `emailId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`authorityId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `billingaddress` (
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  `billingAddressId` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`billingAddressId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cart` (
  `cartId` int NOT NULL AUTO_INCREMENT,
  `totalPrice` double NOT NULL,
  `customerId` int DEFAULT NULL,
  PRIMARY KEY (`cartId`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cartitem` (
  `cartItemId` int NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  `cartId` int NOT NULL,
  `productId` int NOT NULL,
  `quality` int NOT NULL,
  PRIMARY KEY (`cartItemId`),
  KEY `cartId` (`cartId`),
  KEY `productId` (`productId`),
  CONSTRAINT `cartitem_ibfk_1` FOREIGN KEY (`cartId`) REFERENCES `cart` (`cartId`),
  CONSTRAINT `cartitem_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `item` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customer` (
  `customerId` int NOT NULL AUTO_INCREMENT,
  `customerPhone` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `billingAddressId` int NOT NULL,
  `cartId` varchar(255) DEFAULT NULL,
  `shippingAddressId` int NOT NULL,
  `userId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customerId`),
  KEY `shippingAddressId` (`shippingAddressId`),
  KEY `billingAddressId` (`billingAddressId`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`shippingAddressId`) REFERENCES `shippingaddress` (`shippingAddressId`),
  CONSTRAINT `customer_ibfk_2` FOREIGN KEY (`billingAddressId`) REFERENCES `billingaddress` (`billingAddressId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customerorder` (
  `customerOrderId` int NOT NULL AUTO_INCREMENT,
  `billingAddressId` int NOT NULL,
  `cartId` int NOT NULL,
  `customerId` int NOT NULL,
  `shippingAddressId` int NOT NULL,
  PRIMARY KEY (`customerOrderId`),
  KEY `bill_idx` (`billingAddressId`),
  KEY `cartId` (`cartId`),
  KEY `customerId` (`customerId`),
  KEY `shippingAddressId` (`shippingAddressId`),
  KEY `FK811B4230900DACBF` (`billingAddressId`),
  CONSTRAINT `customerorder_ibfk_1` FOREIGN KEY (`cartId`) REFERENCES `cart` (`cartId`),
  CONSTRAINT `customerorder_ibfk_2` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`),
  CONSTRAINT `customerorder_ibfk_3` FOREIGN KEY (`shippingAddressId`) REFERENCES `shippingaddress` (`shippingAddressId`),
  CONSTRAINT `FK811B4230900DACBF` FOREIGN KEY (`billingAddressId`) REFERENCES `billingaddress` (`billingAddressId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `item` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `unit` int DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `ecommerce`.`item`
(`Id`,
`category`,
`description`,
`manufacturer`,
`name`,
`price`,
`unit`)
VALUES
(101,'Running','Nike AZP','Nike','Nike AZP',4000,20),
(104,'Cricket','Addidas Adipower AZ','Adidas','ADD ADP1',2440,30),
(105,'Soccer','Asics Menace','Asics','Asics',2000,40),
(102,'Climbing','Climb X Apex','Decathlon','Decathlon CXA',2300,50);


CREATE TABLE `query` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `shippingaddress` (
  `shippingAddressId` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`shippingAddressId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `emailId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_0900_as_cs DEFAULT NULL,
  `roleType` varchar(255) COLLATE utf8mb4_0900_as_cs DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_cs;

-----Insert for admin and users------
INSERT INTO `ecommerce`.`users`
(`userId`,
`emailId`,
`password`,
`roleType`,
`enabled`)
VALUES
(1,'admin@123','admin123','ROLE_ADMIN',1),(2,'mayur@123','mayur123','ROLE_USER',1);



