-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 09 jan. 2025 à 09:32
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_reservation`
--

-- --------------------------------------------------------

--
-- Structure de la table `cartebancaire`
--

CREATE TABLE `cartebancaire` (
  `id_carte` int(11) NOT NULL,
  `nom_porteur` varchar(255) NOT NULL,
  `numero_carte` char(16) NOT NULL,
  `mois_expiration` tinyint(4) NOT NULL CHECK (`mois_expiration` between 1 and 12),
  `annee_expiration` year(4) NOT NULL,
  `code_verification` char(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `cartebancaire`
--

INSERT INTO `cartebancaire` (`id_carte`, `nom_porteur`, `numero_carte`, `mois_expiration`, `annee_expiration`, `code_verification`) VALUES
(1, 'Hanae Sbai', '4111111111111111', 3, '2026', '123'),
(2, 'Othmane Boughali', '5500005555555559', 9, '2025', '456'),
(3, 'Rihab Lahbichi', '4532111111111118', 1, '2025', '456'),
(4, 'Kenza Bizarn', '6011111111111117', 2, '2028', '234'),
(5, 'Yasser Bichri', '340000000000009', 12, '2027', '789'),
(6, 'Imane Alaoui Modar', '5200000000000007', 6, '2028', '890'),
(7, 'Mohamed Amine', '4111222233334444', 11, '2025', '567'),
(8, 'Mustapha Kassimi', '6011000990139424', 7, '2027', '123');

-- --------------------------------------------------------

--
-- Structure de la table `horaire`
--

CREATE TABLE `horaire` (
  `horaire_id` int(11) NOT NULL,
  `station_depart_id` int(11) DEFAULT NULL,
  `station_arrive_id` int(11) DEFAULT NULL,
  `heure_depart` time DEFAULT NULL,
  `heure_arrive` time DEFAULT NULL,
  `train_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `horaire`
--

INSERT INTO `horaire` (`horaire_id`, `station_depart_id`, `station_arrive_id`, `heure_depart`, `heure_arrive`, `train_id`) VALUES
(1, 1, 4, '06:00:00', '08:10:00', 100),
(2, 1, 2, '06:00:00', '06:45:00', 100),
(3, 1, 3, '06:00:00', '07:17:00', 100),
(4, 3, 4, '07:17:00', '08:10:00', 100),
(5, 2, 3, '06:45:00', '07:17:00', 100),
(6, 2, 4, '06:45:00', '08:10:00', 100),
(7, 1, 4, '07:00:00', '09:10:00', 101),
(8, 1, 2, '07:00:00', '07:45:00', 101),
(9, 1, 3, '07:00:00', '08:17:00', 101),
(10, 3, 4, '08:17:00', '09:10:00', 101),
(11, 2, 3, '07:45:00', '08:17:00', 101),
(12, 2, 4, '07:45:00', '09:10:00', 101),
(13, 1, 4, '08:00:00', '10:10:00', 102),
(14, 1, 2, '08:00:00', '08:45:00', 102),
(15, 1, 3, '08:00:00', '09:17:00', 102),
(16, 3, 4, '09:17:00', '10:10:00', 102),
(17, 2, 3, '08:45:00', '09:17:00', 102),
(18, 2, 4, '08:45:00', '10:10:00', 102),
(19, 1, 4, '09:00:00', '11:10:00', 103),
(20, 1, 2, '09:00:00', '09:45:00', 103),
(21, 1, 3, '09:00:00', '10:17:00', 103),
(22, 3, 4, '10:17:00', '11:10:00', 103),
(23, 2, 3, '09:45:00', '10:17:00', 103),
(24, 2, 4, '09:45:00', '11:10:00', 103),
(25, 1, 4, '10:00:00', '12:10:00', 104),
(26, 1, 2, '10:00:00', '10:45:00', 104),
(27, 1, 3, '10:00:00', '11:17:00', 104),
(28, 3, 4, '11:17:00', '12:10:00', 104),
(29, 2, 3, '10:45:00', '11:17:00', 104),
(30, 2, 4, '10:45:00', '12:10:00', 104),
(31, 1, 4, '11:00:00', '13:10:00', 105),
(32, 1, 2, '11:00:00', '11:45:00', 105),
(33, 1, 3, '11:00:00', '12:17:00', 105),
(34, 3, 4, '12:17:00', '13:10:00', 105),
(35, 2, 3, '11:45:00', '12:17:00', 105),
(36, 2, 4, '11:45:00', '13:10:00', 105),
(37, 1, 4, '12:00:00', '14:10:00', 106),
(38, 1, 2, '12:00:00', '12:45:00', 106),
(39, 1, 3, '12:00:00', '13:17:00', 106),
(40, 3, 4, '13:17:00', '14:10:00', 106),
(41, 2, 3, '12:45:00', '13:17:00', 106),
(42, 2, 4, '12:45:00', '14:10:00', 106),
(49, 1, 4, '14:00:00', '16:10:00', 108),
(50, 1, 2, '14:00:00', '14:45:00', 108),
(51, 1, 3, '14:00:00', '15:17:00', 108),
(52, 3, 4, '15:17:00', '16:10:00', 108),
(53, 2, 3, '14:45:00', '15:17:00', 108),
(54, 2, 4, '14:45:00', '16:10:00', 108),
(55, 1, 4, '15:00:00', '17:10:00', 109),
(56, 1, 2, '15:00:00', '15:45:00', 109),
(57, 1, 3, '15:00:00', '16:17:00', 109),
(58, 3, 4, '16:17:00', '17:10:00', 109),
(59, 2, 3, '15:45:00', '16:17:00', 109),
(60, 2, 4, '15:45:00', '17:10:00', 109),
(61, 1, 4, '16:00:00', '18:10:00', 110),
(62, 1, 2, '16:00:00', '16:45:00', 110),
(63, 1, 3, '16:00:00', '17:17:00', 110),
(64, 3, 4, '17:17:00', '18:10:00', 110),
(65, 2, 3, '16:45:00', '17:17:00', 110),
(66, 2, 4, '16:45:00', '18:10:00', 110),
(67, 1, 4, '17:00:00', '19:10:00', 111),
(68, 1, 2, '17:00:00', '17:45:00', 111),
(69, 1, 3, '17:00:00', '18:17:00', 111),
(70, 3, 4, '18:17:00', '19:10:00', 111),
(71, 2, 3, '17:45:00', '18:17:00', 111),
(72, 2, 4, '17:45:00', '19:10:00', 111),
(73, 1, 4, '18:00:00', '20:10:00', 100),
(74, 1, 2, '18:00:00', '18:45:00', 100),
(75, 1, 3, '18:00:00', '19:17:00', 100),
(76, 3, 4, '19:17:00', '20:10:00', 100),
(77, 2, 3, '18:45:00', '19:17:00', 100),
(78, 2, 4, '18:45:00', '20:10:00', 100),
(79, 1, 4, '19:00:00', '21:10:00', 101),
(80, 1, 2, '19:00:00', '19:45:00', 101),
(81, 1, 3, '19:00:00', '20:17:00', 101),
(82, 3, 4, '20:17:00', '21:10:00', 101),
(83, 2, 3, '19:45:00', '20:17:00', 101),
(84, 2, 4, '19:45:00', '21:10:00', 101),
(85, 1, 4, '20:00:00', '22:10:00', 102),
(86, 1, 2, '20:00:00', '20:45:00', 102),
(87, 1, 3, '20:00:00', '21:17:00', 102),
(88, 3, 4, '21:17:00', '22:10:00', 102),
(89, 2, 3, '20:45:00', '21:17:00', 102),
(90, 2, 4, '20:45:00', '22:10:00', 102),
(91, 1, 4, '21:00:00', '23:10:00', 103),
(92, 1, 2, '21:00:00', '21:45:00', 103),
(93, 1, 3, '21:00:00', '22:17:00', 103),
(94, 3, 4, '22:17:00', '23:10:00', 103),
(95, 2, 3, '21:45:00', '22:17:00', 103),
(96, 2, 4, '21:45:00', '23:10:00', 103),
(97, 4, 1, '06:00:00', '08:10:00', 105),
(98, 4, 3, '06:00:00', '06:53:00', 105),
(99, 4, 2, '06:00:00', '07:25:00', 105),
(100, 3, 2, '06:53:00', '07:25:00', 105),
(101, 3, 1, '06:53:00', '08:10:00', 105),
(102, 2, 1, '07:25:00', '08:10:00', 105),
(103, 4, 1, '07:00:00', '09:10:00', 106),
(104, 4, 3, '07:00:00', '07:53:00', 106),
(105, 4, 2, '07:00:00', '08:25:00', 106),
(106, 3, 2, '07:53:00', '08:25:00', 106),
(107, 3, 1, '07:53:00', '09:10:00', 106),
(108, 2, 1, '08:25:00', '09:10:00', 106),
(109, 4, 1, '08:00:00', '10:10:00', 107),
(110, 4, 3, '08:00:00', '08:53:00', 107),
(111, 4, 2, '08:00:00', '09:25:00', 107),
(112, 3, 2, '08:53:00', '09:25:00', 107),
(113, 3, 1, '08:53:00', '10:10:00', 107),
(114, 2, 1, '09:25:00', '10:10:00', 107),
(115, 4, 1, '09:00:00', '11:10:00', 108),
(116, 4, 3, '09:00:00', '09:53:00', 108),
(117, 4, 2, '09:00:00', '10:25:00', 108),
(118, 3, 2, '09:53:00', '10:25:00', 108),
(119, 3, 1, '09:53:00', '11:10:00', 108),
(120, 2, 1, '10:25:00', '11:10:00', 108),
(121, 4, 1, '10:00:00', '12:10:00', 109),
(122, 4, 3, '10:00:00', '10:53:00', 109),
(123, 4, 2, '10:00:00', '11:25:00', 109),
(124, 3, 2, '10:53:00', '11:25:00', 109),
(125, 3, 1, '10:53:00', '12:10:00', 109),
(126, 2, 1, '11:25:00', '12:10:00', 109),
(127, 4, 1, '11:00:00', '13:10:00', 110),
(128, 4, 3, '11:00:00', '11:53:00', 110),
(129, 4, 2, '11:00:00', '12:25:00', 110),
(130, 3, 2, '11:53:00', '12:25:00', 110),
(131, 3, 1, '11:53:00', '13:10:00', 110),
(132, 2, 1, '12:25:00', '13:10:00', 110),
(133, 4, 1, '12:00:00', '14:10:00', 111),
(134, 4, 3, '12:00:00', '12:53:00', 111),
(135, 4, 2, '12:00:00', '13:25:00', 111),
(136, 3, 2, '12:53:00', '13:25:00', 111),
(137, 3, 1, '12:53:00', '14:10:00', 111),
(138, 2, 1, '13:25:00', '14:10:00', 111),
(139, 4, 1, '14:00:00', '16:10:00', 100),
(140, 4, 3, '14:00:00', '14:53:00', 100),
(141, 4, 2, '14:00:00', '15:25:00', 100),
(142, 3, 2, '14:53:00', '15:25:00', 100),
(143, 3, 1, '14:53:00', '16:10:00', 100),
(144, 2, 1, '15:25:00', '16:10:00', 100),
(145, 4, 1, '15:00:00', '17:10:00', 101),
(146, 4, 3, '15:00:00', '15:53:00', 101),
(147, 4, 2, '15:00:00', '16:25:00', 101),
(148, 3, 2, '15:53:00', '16:25:00', 101),
(149, 3, 1, '15:53:00', '17:10:00', 101),
(150, 2, 1, '16:25:00', '17:10:00', 101),
(151, 4, 1, '16:00:00', '18:10:00', 102),
(152, 4, 3, '16:00:00', '16:53:00', 102),
(153, 4, 2, '16:00:00', '17:25:00', 102),
(154, 3, 2, '16:53:00', '17:25:00', 102),
(155, 3, 1, '16:53:00', '18:10:00', 102),
(156, 2, 1, '17:25:00', '18:10:00', 102),
(157, 4, 1, '17:00:00', '19:10:00', 103),
(158, 4, 3, '17:00:00', '17:53:00', 103),
(159, 4, 2, '17:00:00', '18:25:00', 103),
(160, 3, 2, '17:53:00', '18:25:00', 103),
(161, 3, 1, '17:53:00', '19:10:00', 103),
(162, 2, 1, '18:25:00', '19:10:00', 103),
(163, 4, 1, '18:00:00', '20:10:00', 104),
(164, 4, 3, '18:00:00', '18:53:00', 104),
(165, 4, 2, '18:00:00', '19:25:00', 104),
(166, 3, 2, '18:53:00', '19:25:00', 104),
(167, 3, 1, '18:53:00', '20:10:00', 104),
(168, 2, 1, '19:25:00', '20:10:00', 104),
(169, 4, 1, '19:00:00', '21:10:00', 105),
(170, 4, 3, '19:00:00', '19:53:00', 105),
(171, 4, 2, '19:00:00', '20:25:00', 105),
(172, 3, 2, '19:53:00', '20:25:00', 105),
(173, 3, 1, '19:53:00', '21:10:00', 105),
(174, 2, 1, '20:25:00', '21:10:00', 105),
(175, 4, 1, '20:00:00', '22:10:00', 106),
(176, 4, 3, '20:00:00', '20:53:00', 106),
(177, 4, 2, '20:00:00', '21:25:00', 106),
(178, 3, 2, '20:53:00', '21:25:00', 106),
(179, 3, 1, '20:53:00', '22:10:00', 106),
(180, 2, 1, '21:25:00', '22:10:00', 106),
(181, 4, 1, '21:00:00', '23:10:00', 107),
(182, 4, 3, '21:00:00', '21:53:00', 107),
(183, 4, 2, '21:00:00', '22:25:00', 107),
(184, 3, 2, '21:53:00', '22:25:00', 107),
(185, 3, 1, '21:53:00', '23:10:00', 107),
(186, 2, 1, '22:25:00', '23:10:00', 107),
(187, 4, 1, '22:00:00', '00:10:00', 108),
(188, 4, 3, '22:00:00', '22:53:00', 108),
(189, 4, 2, '22:00:00', '23:25:00', 108),
(190, 3, 2, '22:53:00', '23:25:00', 108),
(191, 3, 1, '22:53:00', '00:10:00', 108),
(192, 2, 1, '23:25:00', '00:10:00', 108),
(193, 1, 4, '22:00:00', '00:10:00', 104),
(194, 1, 3, '22:00:00', '23:17:00', 104),
(195, 1, 2, '22:00:00', '22:45:00', 104),
(196, 2, 3, '22:45:00', '23:17:00', 104),
(197, 2, 4, '22:45:00', '00:10:00', 104),
(198, 3, 4, '23:17:00', '00:10:00', 104);

-- --------------------------------------------------------

--
-- Structure de la table `login`
--

CREATE TABLE `login` (
  `id_login` int(11) NOT NULL,
  `email_login` varchar(255) NOT NULL,
  `password_login` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `login`
--

INSERT INTO `login` (`id_login`, `email_login`, `password_login`) VALUES
(1, 'othmaneboughali1@gmail.com', 'bmnFrGBa'),
(2, 'bizarankenza@gmail.com', 'RPZbNARc'),
(4, 'yasserbichri443@gmail.com', 'VyoPR8Eg'),
(5, 'imanealaoui696@gmail.com', 'SsQMOoe8'),
(6, 'fatimazahraboughali@gmail.com', 'ZLcKz3f6');

-- --------------------------------------------------------

--
-- Structure de la table `prix_adult`
--

CREATE TABLE `prix_adult` (
  `adult_id` int(11) NOT NULL,
  `station_depart_id` int(11) DEFAULT NULL,
  `station_arrive_id` int(11) DEFAULT NULL,
  `prix` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `prix_adult`
--

INSERT INTO `prix_adult` (`adult_id`, `station_depart_id`, `station_arrive_id`, `prix`) VALUES
(1, 1, 2, 60),
(2, 2, 1, 60),
(3, 1, 3, 80),
(4, 3, 1, 80),
(5, 1, 4, 270),
(6, 4, 1, 270),
(7, 2, 3, 35),
(8, 3, 2, 35),
(9, 2, 4, 205),
(10, 4, 2, 205),
(11, 3, 4, 170),
(12, 4, 3, 170);

-- --------------------------------------------------------

--
-- Structure de la table `prix_enfant`
--

CREATE TABLE `prix_enfant` (
  `enfant_id` int(11) NOT NULL,
  `station_depart_id` int(11) DEFAULT NULL,
  `station_arrive_id` int(11) DEFAULT NULL,
  `prix` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `prix_enfant`
--

INSERT INTO `prix_enfant` (`enfant_id`, `station_depart_id`, `station_arrive_id`, `prix`) VALUES
(1, 1, 2, 42),
(2, 2, 1, 42),
(3, 1, 3, 50),
(4, 3, 1, 50),
(5, 1, 4, 50),
(6, 4, 1, 50),
(7, 2, 3, 16),
(8, 3, 2, 16),
(9, 2, 4, 50),
(10, 4, 2, 50),
(11, 3, 4, 50),
(12, 4, 3, 50);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `reservation_id` int(11) NOT NULL,
  `unique_code_voyageur` int(11) DEFAULT NULL,
  `train_id` int(11) DEFAULT NULL,
  `compartiment` int(11) DEFAULT NULL,
  `place` int(11) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `horaire_id` int(11) DEFAULT NULL,
  `travel_date` date DEFAULT NULL,
  `id_carte` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`reservation_id`, `unique_code_voyageur`, `train_id`, `compartiment`, `place`, `prix`, `horaire_id`, `travel_date`, `id_carte`) VALUES
(5, 1, 100, 3, 1, 270, 1, '2025-01-06', 6),
(6, 1, 101, 1, 1, 384, 7, '2025-01-07', 2),
(7, 1, 101, 1, 1, 270, 7, '2025-01-07', 2),
(8, 1, 101, 1, 1, 50, 7, '2025-01-07', 2),
(9, 1, 103, 3, 1, 270, 19, '2025-01-07', 2),
(10, 1, 103, 3, 2, 50, 19, '2025-01-07', 2),
(11, 1, 100, 3, 1, 60, 2, '2025-01-07', 2),
(12, 1, 100, 3, 2, 42, 2, '2025-01-07', 2),
(13, 1, 108, 3, 1, 60, 50, '2025-01-07', 2),
(14, 1, 108, 3, 2, 42, 50, '2025-01-07', 2),
(15, 1, 104, 3, 1, 60, 26, '2025-01-07', 2),
(16, 1, 104, 3, 2, 42, 26, '2025-01-07', 2),
(17, 1, 100, 3, 1, 270, 1, '2025-01-08', 3),
(18, 1, 100, 3, 2, 50, 1, '2025-01-08', 3),
(19, 1, 100, 1, 1, 246, 6, '2025-01-08', 2),
(20, 1, 100, 1, 2, 60, 6, '2025-01-08', 2),
(21, 6, 105, 1, 1, 324, 31, '2025-01-08', 2),
(22, 1, 100, 1, 1, 324, 1, '2025-01-08', 2),
(23, 1, 100, 1, 1, 324, 1, '2025-01-08', 2),
(24, 3, 100, 1, 1, 324, 1, '2025-01-08', 4),
(25, 1, 104, 1, 1, 324, 25, '2025-01-09', 2),
(26, 1, 104, 1, 1, 324, 25, '2025-01-09', 2),
(27, 1, 104, 1, 2, 324, 25, '2025-01-09', 2),
(28, 1, 104, 1, 1, 324, 25, '2025-01-09', 2),
(29, 1, 104, 1, 2, 324, 25, '2025-01-09', 2),
(30, 1, 104, 1, 3, 60, 25, '2025-01-09', 2),
(31, 1, 104, 1, 2, 324, 25, '2025-01-09', 2),
(32, 1, 104, 1, 3, 60, 25, '2025-01-09', 2),
(33, 1, 104, 1, 4, 60, 25, '2025-01-09', 2),
(34, 1, 104, 1, 3, 60, 25, '2025-01-09', 2),
(35, 1, 104, 1, 4, 60, 25, '2025-01-09', 2),
(36, 1, 104, 1, 4, 60, 25, '2025-01-09', 2);

-- --------------------------------------------------------

--
-- Structure de la table `station`
--

CREATE TABLE `station` (
  `station_id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `station`
--

INSERT INTO `station` (`station_id`, `name`, `location`) VALUES
(1, 'CASA VOYAGEURS', 'CASABLANCA'),
(2, 'RABAT AGDAL', 'RABAT'),
(3, 'KENITRA', 'KENITRA'),
(4, 'TANGER VILLE', 'TANGER');

-- --------------------------------------------------------

--
-- Structure de la table `train`
--

CREATE TABLE `train` (
  `train_id` int(11) NOT NULL,
  `train_type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `train`
--

INSERT INTO `train` (`train_id`, `train_type`) VALUES
(100, 'Boraq'),
(101, 'Boraq'),
(102, 'Boraq'),
(103, 'Boraq'),
(104, 'Boraq'),
(105, 'Boraq'),
(106, 'Boraq'),
(107, 'Boraq'),
(108, 'Boraq'),
(109, 'Boraq'),
(110, 'Boraq'),
(111, 'Boraq'),
(112, 'Boraq');

-- --------------------------------------------------------

--
-- Structure de la table `voyageur`
--

CREATE TABLE `voyageur` (
  `unique_code_voyageur` int(11) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `numero_telephone` varchar(15) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `voyageur`
--

INSERT INTO `voyageur` (`unique_code_voyageur`, `nom`, `email`, `numero_telephone`, `age`) VALUES
(1, 'OTHMANE BOUGHALI', 'othmaneboughali1@gmail.com', '0635363003', 20),
(3, 'Kenza  Bizaran', 'bizarankenza@gmail.com', '0632667850', 19),
(4, 'Yasser Bichri', 'yasserbichri443@gmail.com', '0678493821', 20),
(5, 'Imane Alaoui Modar', 'imanealaoui696@gmail.com', '0656123120', 22),
(6, 'fatima zahra boughali', 'fatimazahraboughali@gmail.com', '0635819084', 27);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cartebancaire`
--
ALTER TABLE `cartebancaire`
  ADD PRIMARY KEY (`id_carte`),
  ADD UNIQUE KEY `numero_carte` (`numero_carte`);

--
-- Index pour la table `horaire`
--
ALTER TABLE `horaire`
  ADD PRIMARY KEY (`horaire_id`),
  ADD KEY `station_depart_id` (`station_depart_id`),
  ADD KEY `station_arrive_id` (`station_arrive_id`),
  ADD KEY `train_id` (`train_id`);

--
-- Index pour la table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id_login`),
  ADD UNIQUE KEY `email_login` (`email_login`);

--
-- Index pour la table `prix_adult`
--
ALTER TABLE `prix_adult`
  ADD PRIMARY KEY (`adult_id`),
  ADD KEY `station_depart_id` (`station_depart_id`),
  ADD KEY `station_arrive_id` (`station_arrive_id`);

--
-- Index pour la table `prix_enfant`
--
ALTER TABLE `prix_enfant`
  ADD PRIMARY KEY (`enfant_id`),
  ADD KEY `station_depart_id` (`station_depart_id`),
  ADD KEY `station_arrive_id` (`station_arrive_id`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`reservation_id`),
  ADD KEY `voyageur_id` (`unique_code_voyageur`),
  ADD KEY `train_id` (`train_id`),
  ADD KEY `station_depart_id` (`compartiment`),
  ADD KEY `station_arrive_id` (`place`),
  ADD KEY `fk_horaire_id` (`horaire_id`),
  ADD KEY `fk_reservation_cartebancaire` (`id_carte`);

--
-- Index pour la table `station`
--
ALTER TABLE `station`
  ADD PRIMARY KEY (`station_id`);

--
-- Index pour la table `train`
--
ALTER TABLE `train`
  ADD PRIMARY KEY (`train_id`);

--
-- Index pour la table `voyageur`
--
ALTER TABLE `voyageur`
  ADD PRIMARY KEY (`unique_code_voyageur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cartebancaire`
--
ALTER TABLE `cartebancaire`
  MODIFY `id_carte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `horaire`
--
ALTER TABLE `horaire`
  MODIFY `horaire_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=199;

--
-- AUTO_INCREMENT pour la table `login`
--
ALTER TABLE `login`
  MODIFY `id_login` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `prix_adult`
--
ALTER TABLE `prix_adult`
  MODIFY `adult_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `prix_enfant`
--
ALTER TABLE `prix_enfant`
  MODIFY `enfant_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `reservation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT pour la table `voyageur`
--
ALTER TABLE `voyageur`
  MODIFY `unique_code_voyageur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `horaire`
--
ALTER TABLE `horaire`
  ADD CONSTRAINT `horaire_ibfk_1` FOREIGN KEY (`station_depart_id`) REFERENCES `station` (`station_id`),
  ADD CONSTRAINT `horaire_ibfk_2` FOREIGN KEY (`station_arrive_id`) REFERENCES `station` (`station_id`),
  ADD CONSTRAINT `horaire_ibfk_3` FOREIGN KEY (`train_id`) REFERENCES `train` (`train_id`);

--
-- Contraintes pour la table `prix_adult`
--
ALTER TABLE `prix_adult`
  ADD CONSTRAINT `prix_adult_ibfk_1` FOREIGN KEY (`station_depart_id`) REFERENCES `station` (`station_id`),
  ADD CONSTRAINT `prix_adult_ibfk_2` FOREIGN KEY (`station_arrive_id`) REFERENCES `station` (`station_id`);

--
-- Contraintes pour la table `prix_enfant`
--
ALTER TABLE `prix_enfant`
  ADD CONSTRAINT `prix_enfant_ibfk_1` FOREIGN KEY (`station_depart_id`) REFERENCES `station` (`station_id`),
  ADD CONSTRAINT `prix_enfant_ibfk_2` FOREIGN KEY (`station_arrive_id`) REFERENCES `station` (`station_id`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `fk_horaire_id` FOREIGN KEY (`horaire_id`) REFERENCES `horaire` (`horaire_id`),
  ADD CONSTRAINT `fk_reservation_cartebancaire` FOREIGN KEY (`id_carte`) REFERENCES `cartebancaire` (`id_carte`) ON DELETE SET NULL,
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`unique_code_voyageur`) REFERENCES `voyageur` (`unique_code_voyageur`),
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`train_id`) REFERENCES `train` (`train_id`),
  ADD CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`compartiment`) REFERENCES `station` (`station_id`),
  ADD CONSTRAINT `reservation_ibfk_4` FOREIGN KEY (`place`) REFERENCES `station` (`station_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
