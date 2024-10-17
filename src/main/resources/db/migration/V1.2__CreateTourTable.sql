-- tour schema
CREATE TABLE tour (
	id uuid NOT NULL,
	description varchar(255) NULL,
	duration varchar(255) NULL,
	price int4 NULL,
	title varchar(255) NULL,
	nice_place bool NULL,
	code varchar(255) NULL,
	CONSTRAINT tour_pkey PRIMARY KEY (id)
);

ALTER TABLE tour ADD CONSTRAINT tour_package_fkey FOREIGN KEY (code) REFERENCES tour_package(code);

