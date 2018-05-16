-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2016 at 06:23 PM
-- Server version: 5.7.16-log
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `medicine_info`
--

-- --------------------------------------------------------

--
-- Table structure for table `medint`
--

CREATE TABLE `medint` (
  `ID` int(5) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Price` double(5,2) NOT NULL,
  `Quantity` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medint`
--

INSERT INTO `medint` (`ID`, `Name`, `Price`, `Quantity`) VALUES
(100, 'Napa', 2.50, 10),
(101, 'Offco', 2.65, 25),
(102, 'Baclofen', 2.31, 12),
(103, 'Abarelix', 2.31, 12),
(104, 'Acetaminophen', 2.31, 12),
(105, 'Adderall', 2.31, 12),
(106, 'Breo Ellipta', 2.31, 12),
(107, 'Bydureon', 3.50, 85),
(109, 'adsfafd', 2.31, 12),
(110, 'dgasgda', 2.31, 12),
(111, 'fgsgsdfgf', 2.31, 12),
(112, 'aaaaa', 2.31, 12),
(113, 'bbbbbbb', 2.31, 12),
(114, 'ccccc', 2.31, 12),
(115, 'ddddd', 2.31, 12),
(116, 'fffffffff', 2.31, 12),
(117, 'dfedfed', 2.31, 12),
(118, 'ggggggg', 2.31, 12),
(119, 'hhhhhh', 2.31, 12),
(120, 'iiiiiiiii', 2.31, 12),
(127, 'jjjjjjjjjj', 2.31, 12),
(128, 'kllllllllll', 2.31, 12);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `medint`
--
ALTER TABLE `medint`
  ADD PRIMARY KEY (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
