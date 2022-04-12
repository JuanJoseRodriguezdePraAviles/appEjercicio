CREATE DATABASE appEjercicio;
GRANT ALL ON *.* to 'root'@'%' IDENTIFIED BY 'root';
CREATE TABLE IF NOT EXISTS `userAccount` (
`userAccountId` int(11) NOT NULL AUTO_INCREMENT,
`nombre` varchar(30) NOT NULL,
`apellidos` varchar(60) NOT NULL,
`fechaNacimiento` DATE,
`email` varchar(60) NOT NULL,
PRIMARY KEY (`userAccountId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
DELETE FROM useraccount WHERE userAccountId=4;
DROP TABLE useraccount;
CREATE TABLE IF NOT EXISTS `userAccount` (
`userAccountId` int(11) NOT NULL AUTO_INCREMENT,
`nombre` varchar(30) NOT NULL,
`apellidos` varchar(60) NOT NULL,
`fechaNacimiento` DATE NOT NULL,
`email` varchar(60) NOT NULL,
`fechaRegistro` DATE NOT NULL,
PRIMARY KEY (`userAccountId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;
DELETE FROM useraccount WHERE userAccountId > 0;