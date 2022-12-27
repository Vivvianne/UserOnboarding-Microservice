--  -- Creating the users table:

-- create table if not exists spa.Users (
	
--  	email varchar(25) ,
--  	first_name varchar(25) ,
--  	last_name varchar(25) ,
--  	contact_no varchar(20) ,
--  	status varchar(10) ,
--     password varchar(50),
--  	created_on timestamp ,
--  	updated_on timestamp,
--     permission_id bigint 
--  );


--  -- Permissions relating to users:

--  create table if not exists spa.Permissions (

--  	permission_id bigint auto_increment ,
--  	name varchar(25) ,
--  	status varchar(10) ,
--  	description varchar(100),
--  	created_on timestamp ,
--  	updated_on timestamp,
--     primary key (permission_id)

	
-- );



--  -- Creating user requests table:

--  create table if not exists spa.User_requests (

--  	request_id bigint not null,
--  	operation_name varchar(10) not null,
--  	description varchar(100) not null,
--  	status varchar(10) not null,
--  	created_on timestamp not null,
--  	updated_on timestamp not null,
--  	primary key (request_id )

--  );


--  -- Creating services table:

--  create table if not exists spa.Services (

--  	service_id bigint auto_increment not null,
--  	name varchar(25) not null,
--  	description varchar(100) not null,
--  	status varchar(10) not null,
--  	price varchar(10) not null,
--  	created_on timestamp not null,
--  	updated_on timestamp not null,
--  	primary key (service_id)
--  );


--  -- Creating purchase table:

--  create table if not exists spa.Bookings (

--  	booking_id bigint auto_increment not null,
--  	status varchar(10) not null,
--  	description varchar(100) not null,
--  	created_on timestamp not null,
--  	updated_on timestamp not null,
--  	primary key (booking_id)
	
--  );





-- -- -- User foreign keys:
-- --
-- -- alter table spa.Users
-- --   add column permission_id bigint;
-- --   alter table spa.Users
-- --   add foreign key (permission_id) references spa.Permissions(permission_id);
-- --
-- --
-- -- -- User requests foreign keys:
-- -- alter table spa.User_requests
-- -- add column email varchar(25);
-- -- alter table spa.User_requests
-- -- add foreign key (email) references spa.Users(email);
-- --
-- -- alter table spa.User_requests
-- -- add column service_id bigint;
-- -- alter table spa.User_requests
-- -- add foreign key (service_id) references spa.Services(service_id);
-- --
-- -- alter table spa.User_requests
-- -- add column permission_id bigint;
-- -- alter table spa.User_requests
-- -- add foreign key (permission_id) references spa.Permissions(permission_id);
-- --
-- --
-- -- -- Bookings foreign keys:
-- --
-- -- alter table spa.Bookings
-- -- add column email varchar(25);
-- -- alter table spa.Bookings
-- -- add foreign key (email) references spa.Users(email);
-- --
-- -- alter table spa.Bookings
-- -- add column service_id bigint;
-- --alter table spa.Bookings
-- -- add foreign key (service_id) references spa.Services(service_id);

