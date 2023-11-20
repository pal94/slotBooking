CREATE TABLE `appointment` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `emp_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `booked_date_time` datetime(6) DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `emp_id` (`emp_id`),
  KEY `user_id` (`user_id`),
  KEY `FK9daqcqq2nrtbcr5xqeivvkorq` (`employee_id`),
  CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`ID`),
  CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`ID`),
  CONSTRAINT `FK9daqcqq2nrtbcr5xqeivvkorq` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `appointmentList` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `emp_id` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `emp_id` (`emp_id`),
  CONSTRAINT `appointmentlist_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `appointment_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `employee` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `emp_first_name` varchar(50) DEFAULT NULL,
  `emp_last_name` varchar(50) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `is_active` varchar(2) DEFAULT NULL,
  `start_time` int DEFAULT NULL,
  `end_time` int DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `employee_employees_appointments` (
  `employee_id` int NOT NULL,
  `employees_appointments_id` int NOT NULL,
  UNIQUE KEY `UK_ixxrwn5dd43bonsy5u76oo3ih` (`employees_appointments_id`),
  KEY `FKomoy7lv3mob2s1du35wumeg28` (`employee_id`),
  CONSTRAINT `FKh9yinybf1cm5f27uj3ueni22b` FOREIGN KEY (`employees_appointments_id`) REFERENCES `appointment` (`ID`),
  CONSTRAINT `FKomoy7lv3mob2s1du35wumeg28` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `employee_hours` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `employee_id` int DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `employee_hours_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `employee_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `usr_firstName` varchar(50) DEFAULT NULL,
  `usr_lastName` varchar(50) DEFAULT NULL,
  `usr_email` varchar(60) DEFAULT NULL,
  `usr_phone` varchar(14) DEFAULT NULL,
  `usr_first_name` varchar(255) DEFAULT NULL,
  `usr_last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
