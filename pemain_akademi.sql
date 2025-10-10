-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2025 at 10:44 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pemain_bola`
--

-- --------------------------------------------------------

--
-- Table structure for table `pemain_akademi`
--

CREATE TABLE `pemain_akademi` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `klub` varchar(100) NOT NULL,
  `posisi` varchar(50) NOT NULL,
  `nomor_punggung` int(11) NOT NULL,
  `usia` int(11) NOT NULL,
  `akademi` varchar(100) DEFAULT NULL,
  `tahun_masuk` int(11) DEFAULT NULL,
  `catatan` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pemain_akademi`
--

INSERT INTO `pemain_akademi` (`id`, `nama`, `klub`, `posisi`, `nomor_punggung`, `usia`, `akademi`, `tahun_masuk`, `catatan`) VALUES
(1, 'Kobbie Mainoo', 'Manchester United', 'Gelandang', 37, 19, 'Travis Binnio', 2022, ''),
(2, 'Rico Lewis', 'Manchester City', 'Bek Kanan', 82, 19, 'Brian Barry-Murphy', 2021, 'Tampil impresif saat debut Premier League'),
(3, 'Lewis Hall', 'Newcastle United', 'Bek Kiri', 20, 20, 'Neil Winskill', 2022, ''),
(4, 'Carney Chukwuemeka', 'Chelsea', 'Gelandang Serang', 30, 21, 'Mark Robinson', 2021, ''),
(5, 'Ben Doak', 'Liverpool', '50', 18, 18, 'Barry Lewtas', 2022, ''),
(6, 'Alejandro Garnacho', 'Manchester United', 'Winger', 17, 20, 'Travis Binnion', 2020, 'Kurang Perform Musim Lalu'),
(7, 'Ethan Nwaneri', 'Arsenal', 'Gelandang Serang', 63, 17, 'Jack Wilshere', 2022, ''),
(8, 'Alfie Gilchrist', 'Chelsea', 'Bek Tengah', 42, 20, 'Mark Robinson', 2021, ''),
(9, 'James McAtee', 'Manchester City', 'Gelandang', 87, 22, 'Brian Barry-Murphy', 2020, ''),
(10, 'Jaden Philogene', 'Aston Villa', 'Winger', 32, 23, 'Tony Carss', 2019, '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pemain_akademi`
--
ALTER TABLE `pemain_akademi`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pemain_akademi`
--
ALTER TABLE `pemain_akademi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
