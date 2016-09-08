CREATE TABLE PRODUCT (
  	id SERIAL primary key,
	name varchar(255) not null
);


CREATE TABLE COMPLEXKEY (
  	locale varchar(255) not null,
	name varchar(255) not null,
	val varchar(255) not null, 
	product_id int not null REFERENCES product (id)
);
