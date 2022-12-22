-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-12-2022 a las 20:25:58
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `beclever`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employee`
--

CREATE TABLE `employee` (
  `idEmployee` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `registerType` smallint(6) NOT NULL,
  `businessLocation` varchar(30) NOT NULL,
  `sexo` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `employee`
--

INSERT INTO `employee` (`idEmployee`, `name`, `lastName`, `date`, `registerType`, `businessLocation`, `sexo`) VALUES
(19, 'Carlos', 'Lucero', '2022-12-22', 1, 'San Luis', 1),
(20, 'Sofia', 'Guzman', '2022-08-04', 1, 'San Luis', 0),
(21, 'Hernesto', 'Guevara', '2020-06-03', 1, 'Buenos Aires', 1),
(22, 'Maria', 'Tagliafico', '2021-11-17', 0, 'Mendoza', 0),
(23, 'Sebastian', 'Sonora', '2022-12-22', 1, 'Mendoza', 1),
(24, 'Pedro', 'Estefani', '2022-09-18', 0, 'Santa Fe', 1),
(25, 'Juliana', 'Figueroa', '2022-05-09', 0, 'Tucuman', 0),
(26, 'Ludmila', 'Miranda', '2018-01-18', 0, 'Rio Negro', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`idEmployee`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `employee`
--
ALTER TABLE `employee`
  MODIFY `idEmployee` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
