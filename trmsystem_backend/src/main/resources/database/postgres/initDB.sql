CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- users
CREATE TABLE IF NOT EXISTS users (
  id                UUID         NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  email             VARCHAR(255) NOT NULL,
  usertype          VARCHAR(50)  NOT NULL,
  username          VARCHAR(50)  NOT NULL,
  first_name        VARCHAR(50)  NOT NULL,
  last_name         VARCHAR(100) NOT NULL,
  password          VARCHAR(255) NOT NULL,
  registration_date TIMESTAMP    NOT NULL,
  birth_date        TIMESTAMP
);

create unique index uq_users_email on users (username);
create unique index uq_users_username on users (email);

-- roles
CREATE TABLE IF NOT EXISTS roles (
  id   UUID        NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  name VARCHAR(50) NOT NULL
);

-- user_roles
CREATE TABLE IF NOT EXISTS user_roles (
  user_id UUID NOT NULL,
  role_id UUID NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id)
  on delete cascade
  on update cascade,
  FOREIGN KEY (role_id) REFERENCES roles (id)
  on delete cascade
  on update cascade,

  UNIQUE (user_id, role_id)
);

-- statuses
CREATE TABLE IF NOT EXISTS statuses (
  id   UUID        NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  name VARCHAR(50) NOT NULL
);

-- teams
CREATE TABLE IF NOT EXISTS teams (
  id            UUID          NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  name          VARCHAR(50)   NOT NULL,
  description   VARCHAR(1000) NOT NULL,
  supervisor_id UUID          NOT NULL,

  FOREIGN KEY (supervisor_id) REFERENCES users (id)
);

-- specialists
CREATE TABLE IF NOT EXISTS specialists (
  id               UUID         NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  personnel_number INT          NOT NULL,
  first_name       VARCHAR(50)  NOT NULL,
  last_name        VARCHAR(100) NOT NULL,
  team_id          UUID         NOT NULL,
  status_id        UUID         NOT NULL,
  birth_date       TIMESTAMP,

  FOREIGN KEY (team_id) REFERENCES teams (id)
  on delete cascade
  on update cascade,
  FOREIGN KEY (status_id) REFERENCES statuses (id)
  on delete cascade
  on update cascade
);

-- admittances
CREATE TABLE IF NOT EXISTS admittances (
  id          UUID          NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  name        VARCHAR(50)   NOT NULL,
  description VARCHAR(1000) NOT NULL
);

-- specialist_admittances
CREATE TABLE IF NOT EXISTS specialist_admittances (
  specialist_id UUID NOT NULL,
  admittance_id UUID NOT NULL,

  FOREIGN KEY (specialist_id) REFERENCES specialists (id)
  on delete cascade
  on update cascade,
  FOREIGN KEY (admittance_id) REFERENCES admittances (id)
  on delete cascade
  on update cascade,

  UNIQUE (specialist_id, admittance_id)
);

-- event_types
CREATE TABLE IF NOT EXISTS event_types (
  id          UUID          NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  name        VARCHAR(50)   NOT NULL,
  description VARCHAR(1000) NOT NULL
);

-- events
CREATE TABLE IF NOT EXISTS events (
  id            UUID        NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  name          VARCHAR(50) NOT NULL,
  event_date    TIMESTAMP   NOT NULL,
  event_type_id UUID        NOT NULL,

  FOREIGN KEY (event_type_id) REFERENCES event_types (id)
);

-- workplaces
CREATE TABLE IF NOT EXISTS workplaces (
  id          UUID          NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  name        VARCHAR(50)   NOT NULL,
  description VARCHAR(1000) NOT NULL
);

-- event_workplaces
CREATE TABLE IF NOT EXISTS event_workplaces (
  event_id     UUID NOT NULL,
  workplace_id UUID NOT NULL,

  FOREIGN KEY (event_id) REFERENCES events (id),
  FOREIGN KEY (workplace_id) REFERENCES workplaces (id),

  UNIQUE (event_id, workplace_id)
);

-- event_specialists
CREATE TABLE IF NOT EXISTS event_specialists (
  event_id      UUID NOT NULL,
  specialist_id UUID NOT NULL,

  FOREIGN KEY (event_id) REFERENCES events (id)
  on delete cascade
  on update cascade,
  FOREIGN KEY (specialist_id) REFERENCES specialists (id)
  on delete cascade
  on update cascade,

  UNIQUE (event_id, specialist_id)
);

-- specialties
CREATE TABLE IF NOT EXISTS specialties (
  id   UUID        NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  name VARCHAR(50) NOT NULL
);

-- specialist_specialties
CREATE TABLE IF NOT EXISTS specialist_specialties (
  specialist_id UUID NOT NULL,
  specialty_id  UUID NOT NULL,

  FOREIGN KEY (specialist_id) REFERENCES specialists (id)
  on delete cascade
  on update cascade,
  FOREIGN KEY (specialty_id) REFERENCES specialties (id)
  on delete cascade
  on update cascade,
  UNIQUE (specialist_id, specialty_id)
);