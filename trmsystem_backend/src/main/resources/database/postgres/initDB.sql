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

-- roles
CREATE TABLE IF NOT EXISTS roles (
  id   UUID        NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  name VARCHAR(50) NOT NULL
);

-- user_roles
CREATE TABLE IF NOT EXISTS user_roles (
  user_id UUID NOT NULL,
  role_id UUID NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
);

CREATE TABLE IF NOT EXISTS statuses (
  id   UUID        NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS teams (
  id            UUID          NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  name          VARCHAR(50)   NOT NULL,
  description   VARCHAR(1000) NOT NULL,
  supervisor_id UUID          NOT NULL,

  FOREIGN KEY (supervisor_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS specialists (
  id               UUID         NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  personnel_number INT          NOT NULL,
  first_name       VARCHAR(50)  NOT NULL,
  last_name        VARCHAR(100) NOT NULL,
  team_id          UUID         NOT NULL,
  status_id        UUID         NOT NULL,
  birth_date       TIMESTAMP,

  FOREIGN KEY (team_id) REFERENCES teams (id),
  FOREIGN KEY (status_id) REFERENCES statuses (id)
);

CREATE TABLE IF NOT EXISTS admittances (
  id          UUID          NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  name        VARCHAR(50)   NOT NULL,
  description VARCHAR(1000) NOT NULL
);

CREATE TABLE IF NOT EXISTS specialist_admittances (
  specialist_id UUID NOT NULL,
  admittance_id UUID NOT NULL,

  FOREIGN KEY (specialist_id) REFERENCES specialists (id),
  FOREIGN KEY (admittance_id) REFERENCES admittances (id),

  UNIQUE (specialist_id, admittance_id)
);

CREATE TABLE IF NOT EXISTS events (
  id         UUID        NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  name       VARCHAR(50) NOT NULL,
  event_date TIMESTAMP   NOT NULL
);

CREATE TABLE IF NOT EXISTS workplaces (
  id          UUID          NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  name        VARCHAR(50)   NOT NULL,
  description VARCHAR(1000) NOT NULL
);

CREATE TABLE IF NOT EXISTS event_workplaces (
  event_id     UUID NOT NULL,
  workplace_id UUID NOT NULL,

  FOREIGN KEY (event_id) REFERENCES events (id),
  FOREIGN KEY (workplace_id) REFERENCES workplaces (id),

  UNIQUE (event_id, workplace_id)
);

CREATE TABLE IF NOT EXISTS event_specialists (
  event_id      UUID NOT NULL,
  specialist_id UUID NOT NULL,

  FOREIGN KEY (event_id) REFERENCES events (id),
  FOREIGN KEY (specialist_id) REFERENCES specialists (id),

  UNIQUE (event_id, specialist_id)
);

CREATE TABLE IF NOT EXISTS specialties (
  id   UUID        NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
  name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS specialist_specialties (
  specialist_id UUID NOT NULL,
  specialty_id  UUID NOT NULL,

  FOREIGN KEY (specialist_id) REFERENCES specialists (id),
  FOREIGN KEY (specialty_id) REFERENCES specialties (id),

  UNIQUE (specialist_id, specialty_id)
);