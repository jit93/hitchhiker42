SELECT name FROM users;

SELECT email FROM usersWithCar;

SELECT * FROM trips;

SELECT nickname FROM groups;

INSERT INTO users VALUES ('csh34@duke.edu', 'coolcat', 54321);

UPDATE users SET passwordHash = 'password' WHERE email  = 'katso@gmail.com';

DELETE FROM userswithcar WHERE email = 'cool_cattie@yahoo.com';

INSERT INTO groups VALUES (5, 'the best');

UPDATE trips SET destination = 'Las Vegas' WHERE destination  = 'hotel california';

DELETE FROM groups WHERE gid = '2';

INSERT INTO isMemberOF VALUES(‘notexistent, should fail due to foreign key constraint’, 1);
