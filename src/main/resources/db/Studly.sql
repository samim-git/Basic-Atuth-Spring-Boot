-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 04, 2022 at 09:59 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Studly`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `fname` varchar(80) NOT NULL,
  `lname` varchar(80) DEFAULT NULL,
  `email` varchar(40) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `password` varchar(400) DEFAULT NULL,
  `profile` varchar(150) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `dob` timestamp NULL DEFAULT NULL,
  `role` int(11) NOT NULL COMMENT '1: Student\r\n2: Teacher'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `fname`, `lname`, `email`, `phone`, `password`, `profile`, `address`, `dob`, `role`) VALUES
(1, 'Hafizullah', 'Samim', 'hafizullah.samim@gmail.com', NULL, 'samimjan', 'Profile.png', 'Albert-Swietzer Str, 65667, Kl', NULL, 1),
(7, 'Hafizullah', 'Samim', 'hafizullah.samim2@gmail.com', NULL, 'samimjan', 'Profile.png', 'Albert-Swietzer Str, 65667, Kl', NULL, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `reference_unique` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
