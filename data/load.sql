\COPY groups(gid, nickname) FROM 'data/groups.dat' WITH DELIMITER ',' NULL '' CSV
\COPY users(email, name, passwordhash) FROM 'data/users.dat' WITH DELIMITER ',' NULL '' CSV
\COPY isdrivenby(trip_id, email) FROM 'data/isDrivenBy.dat' WITH DELIMITER ',' NULL '' CSV
\COPY ismemberof(email, gid) FROM 'data/isMemberOf.dat' WITH DELIMITER ',' NULL '' CSV
\COPY passengers(trip_id, email) FROM 'data/passengers.dat' WITH DELIMITER ',' NULL '' CSV
\COPY trips(trip_id, current_location, destination, estimated_start_date_time) FROM 'data/trips.dat' WITH DELIMITER ',' NULL '' CSV
\COPY userswithcar(email, numseats) FROM 'data/usersWithCar.dat' WITH DELIMITER ',' NULL '' CSV

