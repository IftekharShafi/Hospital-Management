-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2019 at 05:22 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `serialNo` varchar(6) NOT NULL,
  `apptDate` varchar(15) NOT NULL,
  `doctorName` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`serialNo`, `apptDate`, `doctorName`) VALUES
('00030', '05-06-1019', 'nicolai'),
('10', '01-02-2019', 'Dr. Jack Cole'),
('15', '05-05-2020', 'Dr. Bruce Ron'),
('7', '02-04-2019', 'Dr. Ron Perl');

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `dId` varchar(6) NOT NULL,
  `dName` varchar(30) NOT NULL,
  `dMobileNo` int(12) NOT NULL,
  `dSalary` double(8,2) NOT NULL,
  `specialization` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`dId`, `dName`, `dMobileNo`, `dSalary`, `specialization`) VALUES
('d00002', 'FGH', 486986, 45377.00, 'as'),
('d00010', 'ABCD', 17000000, 30000.00, 'Medicine'),
('d00020', 'EFGH', 180000000, 35000.00, 'Cardiologist'),
('d00030', 'IJKL', 19000005, 40000.00, 'Neurologist');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(6) NOT NULL,
  `password` varchar(10) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('d00002', '16706222', 0),
('d00010', '1234', 0),
('d00020', '5678', 0),
('d00030', '2468', 0),
('d01', '7777', 0),
('p00012', '4444', 2),
('p00013', '17321898', 2),
('p00022', '5555', 2),
('p00033', '6666', 2),
('s00011', '1111', 1),
('s00012', '1234', 1),
('s00021', '2222', 1),
('s00031', '3333', 1),
('s00041', '12941266', 1),
('s011', '15280324', 1),
('s6565', '1111', 1);

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE `patients` (
  `pId` varchar(6) NOT NULL,
  `pName` varchar(30) NOT NULL,
  `pAge` int(3) NOT NULL,
  `pGender` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`pId`, `pName`, `pAge`, `pGender`) VALUES
('p00012', 'IJK', 40, 'Female'),
('p00013', 'MLK', 20, 'Male'),
('p00022', 'MNO', 55, 'Male'),
('p00032', 'XYZ', 5, 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `staffmembers`
--

CREATE TABLE `staffmembers` (
  `sName` varchar(30) NOT NULL,
  `sId` varchar(6) NOT NULL,
  `sMobileNo` varchar(20) NOT NULL,
  `sSalary` double(8,2) NOT NULL,
  `jobTitle` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staffmembers`
--

INSERT INTO `staffmembers` (`sName`, `sId`, `sMobileNo`, `sSalary`, `jobTitle`) VALUES
('ABC', 's00011', '1100000', 10000.00, 'Receptionist'),
('DEF', 's00021', '12000000', 5000.00, 'Nurse'),
('FGH', 's00031', '1900000', 4000.00, 'Wardboy'),
('Tony', 'Tony', '0289821', 5000.55, 'Staff');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`serialNo`);

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`dId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
  ADD PRIMARY KEY (`pId`);

--
-- Indexes for table `staffmembers`
--
ALTER TABLE `staffmembers`
  ADD PRIMARY KEY (`sId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
