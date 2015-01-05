
-- Table: buildings

--DROP TABLE buildings;

CREATE TABLE buildings
(
  id bigint NOT NULL,
  pb character varying(2000),
  wtb character varying(2000),
  additional_info character varying(2000),
  definition character varying(2000),
  expression character varying(2000),
  isheader character varying(255),
  law_other character varying(2000),
  position character varying(255),
  CONSTRAINT buildings_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);

-- Table: companies

-- DROP TABLE companies;

CREATE TABLE companies
(
  id bigint NOT NULL,
  index bigint,
  address character varying(255),
  city character varying(255),
  companyname character varying(255),
  email character varying(255),
  line character varying(255),
  phone character varying(255),
  province character varying(255),
  remarks character varying(255),
  www character varying(255),
  latitude character varying(255),
  longitude character varying(255),
  maplink character varying(500),
  "position" character varying(255),
  CONSTRAINT companies_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);




-- Table: dictionary_colloquial_expressions

--DROP TABLE dictionary_colloquial_expressions;
CREATE TABLE dictionary_colloquial_expressions
(
  id bigint NOT NULL,
  expression character varying(500),
  synonym_expression character varying(500),
  CONSTRAINT dictionary_colloquial_expressions_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);



-- Table: dictionary_colloquial_expressions_line

--DROP TABLE dictionary_colloquial_expressions_line
CREATE TABLE dictionary_colloquial_expressions_line
(
  id bigint NOT NULL,
  expression character varying(500),
  synonym_expression character varying(500),
  CONSTRAINT dictionary_colloquial_expressions_line_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);



-- Table: expressions

--DROP TABLE expressions;

CREATE TABLE expressions
(
  id bigint NOT NULL,
  additionalinformation character varying(2000),
  definition character varying(2000),
  description character varying(2000),
  expression character varying(255),
  law character varying(2000),
  CONSTRAINT expressions_pkey PRIMARY KEY (id )
)
WITH (
  OIDS=FALSE
);



-- Table: textexpressions

--DROP TABLE textexpressions;

CREATE TABLE textexpressions
(
  id bigint NOT NULL,
  definition character varying(50000),
  expression character varying(1000),
  CONSTRAINT textexpressions_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);




-- Table: users

--DROP TABLE users;

CREATE TABLE users
(
  id bigint NOT NULL,
  login character varying(255),
  password character varying(255),
  CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);

INSERT INTO users(id, login, password) VALUES (1, 'admin', 'pass');


     