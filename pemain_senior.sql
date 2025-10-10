-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2025 at 10:43 AM
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
-- Table structure for table `pemain_senior`
--

CREATE TABLE `pemain_senior` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `klub` varchar(100) NOT NULL,
  `posisi` varchar(50) NOT NULL,
  `nomor_punggung` int(11) NOT NULL,
  `usia` int(11) NOT NULL,
  `penghargaan` varchar(200) DEFAULT NULL,
  `catatan` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pemain_senior`
--

INSERT INTO `pemain_senior` (`id`, `nama`, `klub`, `posisi`, `nomor_punggung`, `usia`, `penghargaan`, `catatan`) VALUES
(8, 'Erling Haland', 'Manchester City', 'Striker', 9, 24, 'Top Skor Premier League 2023/2024', ''),
(9, 'Mohamed Salah', 'Liverpool', 'Winger', 11, 32, 'Pemain Terbaik Afrika 2022', ''),
(10, 'Bukayo Saka', 'Arsenal', 'Winger', 7, 23, 'Pemain Muda Terbaik PFA 2023', 'Bermain Baik Musim Lalu'),
(11, 'Bruno Fernandes', 'Manchester United', 'Gelandang', 8, 30, 'Pemain Terbaik MU 2022', ''),
(12, 'Son Heung-min', 'Tottenham Hotspur', 'Winger', 7, 33, 'Golden Boot Premier League 2021/2022', 'Kurang Menit Bermain Musim Lalu'),
(13, 'Declan Rice', 'Arsenal', 'Gelandang Bertahan', 41, 26, 'Pemain Terbaik West Ham 2022', ''),
(14, 'Cole Palmer', 'Chelsea', 'Gelandang Serang', 20, 22, 'Pemain Muda Chelsea Terbaik 2024', ''),
(15, 'Ollie Watkins', 'Aston Villa', 'Striker', 11, 29, 'Pemain Terbaik Aston Villa 2024', ''),
(16, 'Virgil van Dijk', 'Liverpool', 'Bek Tengah', 4, 34, 'Pemain Bertahan Terbaik UEFA 2019', ''),
(17, 'Kevin De Bruyne', 'Manchester City', 'Gelandang Serang', 17, 34, 'Pemain Terbaik PFA 2020 dan 2021', 'Sering Cedera Musim Lalu');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pemain_senior`
--
ALTER TABLE `pemain_senior`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pemain_senior`
--
ALTER TABLE `pemain_senior`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
