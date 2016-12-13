\COPY groups(gid, nickname) FROM 'data/groups.dat' WITH DELIMITER ',' NULL '' CSV
\COPY users(email, name, passwordHash) FROM 'data/users.dat' WITH DELIMITER ',' NULL '' CSV
\COPY isDrivenBy(trip_id, email) FROM 'data/isDrivenBy.dat' WITH DELIMITER ',' NULL '' CSV
\COPY isMemberOf(email, gid) FROM 'data/isMemberOf.dat' WITH DELIMITER ',' NULL '' CSV
\COPY passengers(trip_id, email) FROM 'data/passengers.dat' WITH DELIMITER ',' NULL '' CSV
\COPY trips(trip_id, current_location, destination, estimated_start_date_time) FROM 'data/trips.dat' WITH DELIMITER ',' NULL '' CSV
\COPY usersWithCar(email, numSeats) FROM 'data/usersWithCar.dat' WITH DELIMITER ',' NULL '' CSV

