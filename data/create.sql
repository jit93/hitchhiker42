CREATE TABLE users (
    email    TEXT NOT NULL UNIQUE,
    name TEXT NOT NULL,
    passwordHash    TEXT NOT NULL,
    PRIMARY KEY(email)
);



CREATE TABLE usersWithCar (
    email TEXT NOT NULL UNIQUE,
    numSeats INTEGER NOT NULL,
    PRIMARY KEY(email),
    FOREIGN KEY(email) REFERENCES users ( email )
);

CREATE TABLE trips (
    trip_id    INTEGER NOT NULL UNIQUE,
    current_location    TEXT,
    destination    TEXT,
    estimated_start_date_time    TEXT,
    PRIMARY KEY(trip_id)
);

CREATE TABLE passengers (
    trip_id    INTEGER NOT NULL,
    email    TEXT NOT NULL,
    PRIMARY KEY(trip_id,email),
    FOREIGN KEY(email) REFERENCES users ( email )
);

CREATE TABLE groups (
    gid    INTEGER NOT NULL,
    nickname    TEXT NOT NULL,
    PRIMARY KEY(gid)
);

CREATE TABLE isMemberOf (
    email    TEXT NOT NULL,
    gid    INTEGER NOT NULL,
    PRIMARY KEY(email,gid),
    FOREIGN KEY(email) REFERENCES users(email),
    FOREIGN KEY(gid) REFERENCES groups(gid)
);

CREATE TABLE isDrivenBy (
    trip_id    INTEGER NOT NULL UNIQUE,
    email    TEXT,
    PRIMARY KEY(trip_id),
    FOREIGN KEY(email) REFERENCES users ( email )
);
