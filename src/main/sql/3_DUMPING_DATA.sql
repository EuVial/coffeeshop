USE `CoffeeShop`;

--
-- Dumping data for table `Configuration`
--
INSERT INTO `Configuration` 
(id, value) 
VALUES 
('m','2'),
('n','5'),
('x','10');

--
-- Dumping data for table `CoffeeType`
--
INSERT INTO `CoffeeType`
(id, type_name, price, disabled)
VALUES
  ('1','Arabic', '2.0', 'Y'),
  ('2','Robust', '1.0', 'N'),
  ('3','Arabic', '2.0', 'N');

--
-- Dumping data for table `CoffeeOrder`
--
INSERT INTO `CoffeeOrder`
(id, order_date, name, delivery_address, cost)
VALUES
('1','2018-01-12', 'Ivanov', 'Minsk', '4.0'),
('2','2018-01-17', 'Petrov', 'Vitebsk', '6.0'),
('3','2018-01-17', 'Pavel', 'Brest', '4.0');