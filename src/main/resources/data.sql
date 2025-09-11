INSERT INTO Hotel (id, hotel_code, hotel_name, city, room_type, amount_per_night, available_from, available_to, is_reserved) VALUES
(1, 'CH-0002', 'Cataratas Hotel', 'Puerto Iguazu', 'Doble', 6300, '2022-02-10', '2022-03-20', 'NO'),
(2, 'CH-0003', 'Cataratas Hotel 2', 'Puerto Iguazu', 'Triple', 8200, '2022-02-10', '2022-03-23', 'NO'),
(3, 'HB-0001', 'Hotel Bristol', 'Buenos Aires', 'Single', 5435, '2022-02-10', '2022-03-19', 'NO'),
(4, 'BH-0002', 'Hotel Bristol 2', 'Buenos Aires', 'Doble', 7200, '2022-02-12', '2022-04-17', 'NO'),
(5, 'SH-0002', 'Sheraton', 'Tucuman', 'Doble', 5790, '2022-04-17', '2022-05-23', 'NO'),
(6, 'SH-0001', 'Sheraton 2', 'Tucuman', 'Single', 4150, '2022-01-02', '2022-02-19', 'NO'),
(7, 'SE-0001', 'Selina', 'Bogota', 'Single', 3900, '2022-01-23', '2022-11-23', 'NO'),
(8, 'SE-0002', 'Selina 2', 'Bogota', 'Doble', 5840, '2022-01-23', '2022-10-15', 'NO'),
(9, 'EC-0003', 'El Campin', 'Bogota', 'Triple', 7020, '2022-02-15', '2022-03-27', 'NO'),
(10, 'CP-0004', 'Central Plaza', 'Medellin', 'Multiple', 8600, '2022-03-01', '2022-04-17', 'NO'),
(11, 'CP-0002', 'Central Plaza 2', 'Medellin', 'Doble', 6400, '2022-02-10', '2022-03-20', 'NO'),
(12, 'BG-0004', 'Bocagrande', 'Cartagena', 'Multiple', 9370, '2022-04-17', '2022-06-12', 'NO');


INSERT INTO Flight (id, flight_number, origin, destination, seat_type, amount, date_from, date_to) VALUES 
(1, 'BAPI-1235', 'Buenos Aires', 'Puerto Iguazu', 'Economy', 6500, '2022-02-10', '2022-02-15'),
(2, 'PIBA-1420', 'Puerto Iguazu', 'Bogota', 'Business', 43200, '2022-02-10', '2022-02-20'),
(3, 'PIBA-1420', 'Puerto Iguazu', 'Bogota', 'Economy', 25735, '2022-02-10', '2022-02-21'),
(4, 'BATU-5536', 'Buenos Aires', 'Tucuman', 'Economy', 7320, '2022-02-10', '2022-02-17'),
(5, 'TUPI-3369', 'Tucuman', 'Puerto Iguazu', 'Business', 12530, '2022-02-12', '2022-02-23'),
(6, 'TUPI-3369', 'Tucuman', 'Puerto Iguazu', 'Economy', 5400, '2022-01-02', '2022-01-16'),
(7, 'BOCA-4213', 'Bogota', 'Cartagena', 'Economy', 8000, '2022-01-23', '2022-02-05'),
(8, 'CAME-0321', 'Cartagena', 'Medellin', 'Economy', 7800, '2022-01-23', '2022-01-31'),
(9, 'BOBA-6567', 'Bogota', 'Buenos Aires', 'Business', 57000, '2022-02-15', '2022-02-28'),
(10, 'BOBA-6567', 'Bogota', 'Buenos Aires', 'Economy', 39860, '2022-03-01', '2022-03-14'),
(11, 'BOME-4442', 'Bogota', 'Medellin', 'Economy', 11000, '2022-02-10', '2022-02-24'),
(12, 'MEPI-9986', 'Medellin', 'Puerto Iguazu', 'Business', 41640, '2022-04-17', '2022-05-02');

