CREATE TABLE client (
    client_id VARCHAR(36), 
    email VARCHAR(320) NOT NULL,
    password VARCHAR(32) NOT NULL,
    PRIMARY KEY (client_id)
);

CREATE TABLE booking (
    booking_id VARCHAR(36),
    checkinDate DATETIME,
    checkoutDate DATETIME,
    client_id VARCHAR(36),
    PRIMARY KEY (booking_id),
    FOREIGN KEY (client_id) REFERENCES client(client_id) ON DELETE SET NULL
);

CREATE TABLE room (
    room_id INT,
    floor_number INT,
    booking_id VARCHAR(36),
    PRIMARY KEY (room_id),
    FOREIGN KEY (booking_id) REFERENCES booking(booking_id) ON DELETE SET NULL
);
