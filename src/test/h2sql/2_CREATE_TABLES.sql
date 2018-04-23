USE `CoffeeShop`;

--
-- Table structure for table `CoffeeOrder`
--

DROP TABLE IF EXISTS CoffeeOrder;
CREATE TABLE CoffeeOrder (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `name` varchar(80) DEFAULT NULL,
  `delivery_address` varchar(100) NOT NULL,
  `cost` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `CoffeeType`
--

DROP TABLE IF EXISTS `CoffeeType`;
CREATE TABLE `CoffeeType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  `disabled` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `CoffeeOrderItem`
--

DROP TABLE IF EXISTS `CoffeeOrderItem`;
CREATE TABLE `CoffeeOrderItem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  foreign key (order_id) references CoffeeOrder(ID),
  foreign key (type_id) references CoffeeType(ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `Configuration`
--

DROP TABLE IF EXISTS `Configuration`;
CREATE TABLE `Configuration` (
  `id` varchar(30) NOT NULL,
  `value` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;