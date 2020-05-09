-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2020 at 04:00 PM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `scpk`
--

-- --------------------------------------------------------

--
-- Table structure for table `datas`
--

CREATE TABLE `datas` (
  `nama` varchar(191) NOT NULL,
  `lokasi` varchar(191) NOT NULL,
  `harga` bigint(12) NOT NULL,
  `jarak` int(11) NOT NULL,
  `luas` int(11) NOT NULL,
  `keamanan` int(11) NOT NULL,
  `kebersihan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datas`
--

INSERT INTO `datas` (`nama`, `lokasi`, `harga`, `jarak`, `luas`, `keamanan`, `kebersihan`) VALUES
('agung', 'tambakbayan', 12000000, 12, 20, 7, 6),
('sri', 'babarsari', 10000000, 12, 22, 8, 7),
('wedari', 'kulon', 8000000, 30, 21, 8, 6);

-- --------------------------------------------------------

--
-- Table structure for table `datas1`
--

CREATE TABLE `datas1` (
  `nama` varchar(191) NOT NULL,
  `prioritas` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
