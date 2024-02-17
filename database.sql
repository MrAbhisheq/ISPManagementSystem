-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 15, 2023 at 05:25 PM
-- Server version: 8.0.31
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ak_isp`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', 'password');

-- --------------------------------------------------------

--
-- Table structure for table `billing_period`
--

DROP TABLE IF EXISTS `billing_period`;
CREATE TABLE IF NOT EXISTS `billing_period` (
  `period` varchar(30) NOT NULL,
  `days` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `billing_period`
--

INSERT INTO `billing_period` (`period`, `days`) VALUES
('1 Month', 30),
('2 Month', 60),
('6 Months', 180),
('3 Months', 90);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE IF NOT EXISTS `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `plan` varchar(30) DEFAULT NULL,
  `billing_cycle` varchar(30) NOT NULL,
  `days` int NOT NULL,
  `rental` int NOT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `purpose` varchar(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `payStatus` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `name`, `plan`, `billing_cycle`, `days`, `rental`, `phone`, `email`, `gender`, `address`, `purpose`, `status`, `payStatus`) VALUES
(3, 'hgjhg', '500Mbps', '', 0, 0, 'jhjhf', 'hdh', 'MALE', 'nkjiug	', 'HOME', NULL, NULL),
(4, 'Abhi', '200Mbps', '', 0, 0, '9999999999', 'sdhasu', 'MALE', 'sdffdsf', 'HOME', NULL, NULL),
(5, 'fdsdfjhsidhufsduh', '1Gbps', '', 0, 0, '82346687', 'dbgfjhsgfy', 'MALE', 'rfgdgdfg', 'HOME', NULL, NULL),
(6, 'GTA', '1Gbps', '', 0, 0, '123', 'gta@rockstargames.com', 'MALE', 'sdgfdsgdfsg', 'BUSINESS', NULL, NULL),
(7, 'Neha', '200Mbps', '', 0, 0, '4546468', 'yutyuyt', 'FEMALE', 'tuyutyu', 'HOME', NULL, NULL),
(8, 'Anjali', '300Mbps', '', 0, 0, '546', 'anjaligmail.com', 'FEMALE', 'tdfght', 'HOME', NULL, NULL),
(9, 'hgjhghj', '150Mbps', '', 0, 0, '65765', 'yuyyf', 'MALE', 'vhnjv', 'HOME', NULL, NULL),
(10, 'Abhishek', '200 Mbps', '2 Month - 60 Days', 60, 1000, '9010101010', 'abhishek@gmail.com', 'MALE', 'India', 'HOME', 'Active', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE IF NOT EXISTS `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(40) DEFAULT NULL,
  `emp_username` varchar(30) DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `emp_password` varchar(30) DEFAULT NULL,
  `SQ_Ans1` varchar(50) DEFAULT NULL,
  `SQ_Ans2` varchar(50) DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `emp_name`, `emp_username`, `email`, `emp_password`, `SQ_Ans1`, `SQ_Ans2`, `status`) VALUES
(1, 'Ajay Kumar', 'ajayk', 'ajaykumar123@gmail.com', 'ajay123', NULL, NULL, 'Enabled'),
(2, 'Gautam Yadav', 'gautam', 'gautamyadav123@gmail.com', 'gautam123', NULL, NULL, 'Disabled'),
(3, 'Abhishek', 'abhisheq', 'abhishekk@gmail.com', '101010', NULL, 'Samsung', 'Enabled'),
(4, 'Anushka Mathur', 'anushka', 'anushka68573@gmail.com', 'anu@567', 'A', 'Redmi', 'Enabled');

-- --------------------------------------------------------

--
-- Table structure for table `plans`
--

DROP TABLE IF EXISTS `plans`;
CREATE TABLE IF NOT EXISTS `plans` (
  `bandwidth` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price` int NOT NULL,
  `perDay_cost` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `plans`
--

INSERT INTO `plans` (`bandwidth`, `price`, `perDay_cost`) VALUES
('100 Mbps', 299, 9.97),
('200 Mbps', 500, 16.67),
('1 Gbps', 2000, 66.67),
('300 Mbps', 699, 23.3);

-- --------------------------------------------------------

--
-- Table structure for table `support_tickets`
--

DROP TABLE IF EXISTS `support_tickets`;
CREATE TABLE IF NOT EXISTS `support_tickets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `category` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `support_tickets`
--

INSERT INTO `support_tickets` (`id`, `customer_id`, `category`, `description`, `status`) VALUES
(1, 10, 'Internet Problem', 'My Internet is not working.', 'Open');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
