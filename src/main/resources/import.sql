insert into shop(id, name, place, created_at, updated_at) values(1, 'Barbershop', 'Budapest', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into shop(id, name, place, created_at, updated_at) values(2, 'Barbershop', 'Debrecen', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into shop(id, name, place, created_at, updated_at) values(3, 'Barbershop', 'Eger', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into barber (name, shop, start_time) values ('Aron Rahman', 'Eger', CURRENT_TIMESTAMP());
insert into barber (name, shop, start_time) values ('Jesus Weston', 'Budapest', CURRENT_TIMESTAMP());
insert into barber (name, shop, start_time) values ('Larry Kenny', 'Budapest', CURRENT_TIMESTAMP());
insert into barber (name, shop, start_time) values ('Edwin Beard', 'Debrecen', CURRENT_TIMESTAMP());

insert into reservation (barber_id, name, type, created_at, updated_at) values (1, 'Roberto Patton', 'beard', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into reservation (barber_id, name, type, created_at, updated_at) values (2, 'Joseph Bowman', 'hair', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into reservation (barber_id, name, type, created_at, updated_at) values (3, 'Jason Erickson', 'hair', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into reservation (barber_id, name, type, created_at, updated_at) values (3, 'Winston Murray', 'hair', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

insert into label (opinion, created_at, updated_at) values ('He did a good job!', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into label (opinion, created_at, updated_at) values ('It was terrible', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into label (opinion, created_at, updated_at) values ('Best barber!', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

insert into user (username, password, enabled, role) values ('user1', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', true, 'ROLE_ADMIN');
insert into user (username, password, enabled, role) values ('user2', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', true, 'ROLE_USER'); 


insert into barber_labels (barbers_id, labels_id) values (1, 1);
insert into barber_labels (barbers_id, labels_id) values (2, 2);
insert into barber_labels (barbers_id, labels_id) values (3, 3);
