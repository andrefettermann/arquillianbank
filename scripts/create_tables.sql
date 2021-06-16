DROP TABLE arquillian.tbl_account;

CREATE TABLE arquillian.tbl_account (
	id int8 NOT NULL,
	number varchar(30) NOT NULL,
	cust_name varchar(100) NULL,
	bank_name varchar(100) NULL,
	bank_agency varchar(50) NULL,
	CONSTRAINT tbl_account_id_pk PRIMARY KEY (id)
);

CREATE SEQUENCE arquillian.hibernate_sequence
    INCREMENT 1
    START 0
    MINVALUE 0
    MAXVALUE 100000000000
    CACHE 1;

ALTER SEQUENCE arquillian.hibernate_sequence
    OWNER TO postgres;

GRANT ALL ON SEQUENCE arquillian.hibernate_sequence TO arquillian;

GRANT ALL ON SEQUENCE arquillian.hibernate_sequence TO postgres;