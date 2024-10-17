-- tour_package definition

CREATE TABLE tour_package (
	code varchar(255) NOT NULL,
	end_date date NULL,
	name varchar(255) NULL,
	price float8 NULL,
	start_date date NULL,
	CONSTRAINT tour_package_pkey PRIMARY KEY (code)
);
