-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2021 at 04:07 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `customer_management`
--
CREATE DATABASE IF NOT EXISTS `customer_management` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `customer_management`;

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` bigint(20) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `date_closed` varchar(255) DEFAULT NULL,
  `date_open` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `status` varchar(255) DEFAULT NULL,
  `yield` int(11) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `repayment_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `amount`, `created_by`, `currency`, `date_closed`, `date_open`, `status`, `yield`, `account_id`, `customer_id`, `repayment_id`) VALUES
(1, 500, 'zareefsoeto', 'USD', NULL, '2021-04-17 05:03:27', 'approved', 25, 110201, 7, 1),
(5, 233, 'zareefsoeto', 'SRD', NULL, '2021-04-17 12:17:27', 'open', 20, 110201, 7, 1);

-- --------------------------------------------------------

--
-- Table structure for table `account_type`
--

CREATE TABLE `account_type` (
  `id` bigint(20) NOT NULL,
  `arab_name` varchar(255) DEFAULT NULL,
  `created_on` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `name` varchar(255) DEFAULT NULL,
  `occupation` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account_type`
--

INSERT INTO `account_type` (`id`, `arab_name`, `created_on`, `name`, `occupation`) VALUES
(110201, 'Reverse Murabaha', '2021-04-25 01:59:15', 'Tawaruq', 'Car Loan');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `company` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `id_number` varchar(225) NOT NULL,
  `created_on` date NOT NULL DEFAULT current_timestamp(),
  `last_updated` date DEFAULT NULL,
  `type` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `company`, `email`, `name`, `phone`, `sexe`, `id_number`, `created_on`, `last_updated`, `type`) VALUES
(2, 'ABC', 'hi@mail.com', 'Zareef', '115', 'Male', 'FP010211', '2021-04-16', '2021-04-16', 0),
(3, 'ABC', 'hi@mail.com', 'Zareef', '115', 'Male', 'FP990011', '2021-04-16', '2021-04-16', 0),
(7, 'ABC', 'fincance@mail.com', 'Zareef', '+597723341', 'male', 'FP001112', '2021-04-17', NULL, 0),
(8, 'ABC', 'hi@mail.com', 'Zareef', '115', 'Male', 'FP001123', '2021-04-17', NULL, 1),
(9, 'ABC', 'cho@mail.com', 'ALIB', '2234', 'Male', 'FP001123', '2021-04-17', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `repayment_plan`
--

CREATE TABLE `repayment_plan` (
  `id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `maturity_date` varchar(255) DEFAULT NULL,
  `paid_date` varchar(255) DEFAULT NULL,
  `plan_nbr` bigint(20) DEFAULT NULL,
  `profit_amount` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `value_date` varchar(255) DEFAULT NULL,
  `gl_code` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `repayment_plan`
--

INSERT INTO `repayment_plan` (`id`, `amount`, `currency`, `maturity_date`, `paid_date`, `plan_nbr`, `profit_amount`, `status`, `value_date`, `gl_code`) VALUES
(1, 500, 'SRD', '2022-04-16', NULL, 1, 125, 'Pending', '2021-04-16', 110201);

-- --------------------------------------------------------

--
-- Table structure for table `transfer`
--

CREATE TABLE `transfer` (
  `id` bigint(20) NOT NULL,
  `amount` int(11) NOT NULL,
  `created_on` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `description` varchar(255) DEFAULT NULL,
  `value_date` varchar(255) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  `repayment_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transfer`
--

INSERT INTO `transfer` (`id`, `amount`, `created_on`, `description`, `value_date`, `customer_id`, `repayment_id`) VALUES
(1, 300, '2021-04-27 01:47:33', 'Hello', '2021-09-31', 7, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `level_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `password`, `username`, `level_id`) VALUES
(1, 'Zareef Soetodrono', '1234', 'zsoeto', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_level`
--

CREATE TABLE `user_level` (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_level`
--

INSERT INTO `user_level` (`id`, `role`) VALUES
(1, 'Administrator'),
(2, 'Administrator');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKB9D38A2D9A63FD72` (`account_id`),
  ADD KEY `FKB9D38A2DA5243BBC` (`customer_id`),
  ADD KEY `FKB9D38A2DF1367121` (`repayment_id`);

--
-- Indexes for table `account_type`
--
ALTER TABLE `account_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `repayment_plan`
--
ALTER TABLE `repayment_plan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK90D4BF75D09C820C` (`gl_code`);

--
-- Indexes for table `transfer`
--
ALTER TABLE `transfer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4C58B7EBA5243BBC` (`customer_id`),
  ADD KEY `FK4C58B7EBF1367121` (`repayment_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`,`username`),
  ADD KEY `FK36EBCBFDC1F7AD` (`level_id`);

--
-- Indexes for table `user_level`
--
ALTER TABLE `user_level`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `repayment_plan`
--
ALTER TABLE `repayment_plan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `transfer`
--
ALTER TABLE `transfer`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user_level`
--
ALTER TABLE `user_level`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `FKB9D38A2D9A63FD72` FOREIGN KEY (`account_id`) REFERENCES `account_type` (`id`),
  ADD CONSTRAINT `FKB9D38A2DA5243BBC` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `FKB9D38A2DF1367121` FOREIGN KEY (`repayment_id`) REFERENCES `repayment_plan` (`id`);

--
-- Constraints for table `repayment_plan`
--
ALTER TABLE `repayment_plan`
  ADD CONSTRAINT `FK90D4BF75D09C820C` FOREIGN KEY (`gl_code`) REFERENCES `account_type` (`id`);

--
-- Constraints for table `transfer`
--
ALTER TABLE `transfer`
  ADD CONSTRAINT `FK4C58B7EBA5243BBC` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `FK4C58B7EBF1367121` FOREIGN KEY (`repayment_id`) REFERENCES `repayment_plan` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK36EBCBFDC1F7AD` FOREIGN KEY (`level_id`) REFERENCES `user_level` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
