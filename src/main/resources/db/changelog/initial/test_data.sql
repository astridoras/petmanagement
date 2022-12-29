--users
INSERT INTO public."user" (id, username, password) VALUES (DEFAULT, 'crazycatlady', '123PasswordIs4You');
INSERT INTO public."user" (id, username, password) VALUES (DEFAULT, 'mypetaccount', 'Passw6rd123!?');
INSERT INTO public."user" (id, username, password) VALUES (DEFAULT, 'lazydoglady', 'Passw6rd123!?');


--pets
INSERT INTO public."PET" (id, name, code, user_id, type, color, country)VALUES (DEFAULT, 'Mustika', '202211151535', 2,'CAT', 'BLACK', 'ESTONIA');
INSERT INTO public."PET" (id, name, code, user_id, type, color, country)VALUES (DEFAULT, 'Roy', '202211151536', 2, 'DOG', 'BROWN', 'LATVIA');
INSERT INTO public."PET" (id, name, code, user_id, type, color, country)VALUES (DEFAULT, 'Charles', '202211151536', 2,'HORSE', 'WHITE', 'NORWAY');

INSERT INTO public."PET" (id, name, code, user_id, type, color, country)VALUES (DEFAULT, 'Rex', '202211151534', 3,'DOG', 'BLACK', 'ESTONIA');
INSERT INTO public."PET" (id, name, code, user_id, type, color, country)VALUES (DEFAULT, 'Beethoven', '202211151533', 3, 'DOG', 'BROWN', 'LATVIA');
INSERT INTO public."PET" (id, name, code, user_id, type, color, country)VALUES (DEFAULT, 'Lassie', '202211151532', 3 ,'DOG', 'WHITE', 'NORWAY');



