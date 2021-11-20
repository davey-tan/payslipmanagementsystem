-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 26, 2020 at 05:45 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `payrollmanagementsystem`
--
CREATE DATABASE IF NOT EXISTS `payrollmanagementsystem` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `payrollmanagementsystem`;

-- --------------------------------------------------------

--
-- Table structure for table `pms_log`
--

CREATE TABLE `pms_log` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `email` varchar(256) DEFAULT NULL,
  `timestamp` timestamp NULL DEFAULT NULL,
  `activity` varchar(256) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pms_messages`
--

CREATE TABLE `pms_messages` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `sender` text DEFAULT NULL,
  `receiver` text DEFAULT NULL,
  `subject` mediumtext DEFAULT NULL,
  `timestamp` timestamp NULL DEFAULT NULL,
  `message` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pms_payslips`
--

CREATE TABLE `pms_payslips` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `email` varchar(256) DEFAULT NULL,
  `timestamp` timestamp NULL DEFAULT NULL,
  `workdays` varchar(256) DEFAULT NULL,
  `leaves` varchar(256) DEFAULT NULL,
  `salary_basic` varchar(256) DEFAULT NULL,
  `salary_perday` varchar(256) DEFAULT NULL,
  `salary_deduction` varchar(256) DEFAULT NULL,
  `salary_net` varchar(256) DEFAULT NULL,
  `description` longtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pms_settings`
--

CREATE TABLE `pms_settings` (
  `settings` varchar(256) NOT NULL,
  `value` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `pms_user`
--

CREATE TABLE `pms_user` (
  `email` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL DEFAULT 'password',
  `rights` enum('employee','manager','admin') NOT NULL DEFAULT 'employee' COMMENT 'employee, manager, admin',
  `name` varchar(256) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `role` varchar(128) DEFAULT NULL,
  `level` int(128) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pms_log`
--
ALTER TABLE `pms_log`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `pms_messages`
--
ALTER TABLE `pms_messages`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `pms_payslips`
--
ALTER TABLE `pms_payslips`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `pms_settings`
--
ALTER TABLE `pms_settings`
  ADD PRIMARY KEY (`settings`);

--
-- Indexes for table `pms_user`
--
ALTER TABLE `pms_user`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pms_log`
--
ALTER TABLE `pms_log`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pms_messages`
--
ALTER TABLE `pms_messages`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pms_payslips`
--
ALTER TABLE `pms_payslips`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
