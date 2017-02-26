-- -- roles
INSERT INTO roles VALUES (DEFAULT, 'ROLE_USER');
INSERT INTO roles VALUES (DEFAULT, 'ROLE_SUPERVISOR');
INSERT INTO roles VALUES (DEFAULT, 'ROLE_ADMIN');

-- statuses
INSERT INTO statuses VALUES (DEFAULT, 'active');
INSERT INTO statuses VALUES (DEFAULT, 'vacation');
INSERT INTO statuses VALUES (DEFAULT, 'hospital');
INSERT INTO statuses VALUES (DEFAULT, 'business trip');
INSERT INTO statuses VALUES (DEFAULT, 'medical examination');

-- admittances
INSERT INTO admittances VALUES (DEFAULT, 'DVT', 'This is DVT admittance');
INSERT INTO admittances VALUES (DEFAULT, 'DVC', 'This is DVC admittance');
INSERT INTO admittances VALUES (DEFAULT, 'DVW','This is DVW admittance');
INSERT INTO admittances VALUES (DEFAULT, 'DVE','This is DVE admittance');
INSERT INTO admittances VALUES (DEFAULT, 'DVW + DWE','This is DVW + DVE admittance');
INSERT INTO admittances VALUES (DEFAULT, 'DVN','This is DVN admittance');
INSERT INTO admittances VALUES (DEFAULT, 'DVB','This is DVB admittance');
INSERT INTO admittances VALUES (DEFAULT, 'DVS','This is DVS admittance');
INSERT INTO admittances VALUES (DEFAULT, 'DVS + DVB','This is DVS + DVB admittance');
INSERT INTO admittances VALUES (DEFAULT, 'SUPERVISOR','This is SUPERVISOR admittance');
INSERT INTO admittances VALUES (DEFAULT, 'INSTRUCTOR','This is INSTRUCTOR admittance');

-- event_types
INSERT INTO event_types VALUES (DEFAULT, 'WORKDAY', 'This is simple work shift');
INSERT INTO event_types VALUES (DEFAULT, 'TECHNICAL STUDY', 'This is technical study');
INSERT INTO event_types VALUES (DEFAULT, 'SIMULATOR TRAINING', 'This is simulator training');
INSERT INTO event_types VALUES (DEFAULT, 'CONFERENCE', 'This is conference');

-- specialties
INSERT INTO specialties VALUES (DEFAULT , 'CONTROLLER');
INSERT INTO specialties VALUES (DEFAULT , 'INSTRUCTOR');
INSERT INTO specialties VALUES (DEFAULT , 'SUPERVISOR');

-- workplaces
INSERT INTO workplaces VALUES (DEFAULT , 'DVT', 'This is DVT position');
INSERT INTO workplaces VALUES (DEFAULT , 'DVC', 'This is DVC position');
INSERT INTO workplaces VALUES (DEFAULT , 'DVW', 'This is DVW position');
INSERT INTO workplaces VALUES (DEFAULT , 'DVE', 'This is DVE position');
INSERT INTO workplaces VALUES (DEFAULT , 'DVW + DVE', 'This is DVW + DVE position');
INSERT INTO workplaces VALUES (DEFAULT , 'DVN', 'This is DVN position');
INSERT INTO workplaces VALUES (DEFAULT , 'DVS', 'This is DVS position');
INSERT INTO workplaces VALUES (DEFAULT , 'DVB', 'This is DVB position');
INSERT INTO workplaces VALUES (DEFAULT , 'DVS + DVB', 'This is DVS + DVB position');
INSERT INTO workplaces VALUES (DEFAULT , 'SENIOR CONTROLLER', 'This is senior controller position');
INSERT INTO workplaces VALUES (DEFAULT , 'SUPERVISOR', 'This is supervisor position');