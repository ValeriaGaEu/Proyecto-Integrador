create database hydroponic_garden;
 
 use hydroponic_garden;
 
create table record(
	id_user int auto_increment not null primary key,
    name_user varchar(45) not null,
    last_name varchar(45) not null,
    birthdate date not null,
    phone_mail varchar(45) not null,
    password_user varchar(45) not null
 );
 
create table garden_system(
	id_system int auto_increment not null primary key,
    capacity_liters double not null,
    type_system varchar(45) not null,
    ubication varchar(45)
);
 
alter table garden_system add id_user int null;
alter table garden_system add foreign key(id_user) references record(id_user);

create table plant(
	id_plant int auto_increment not null primary key,
    name_planat varchar(35) not null,
    variety varchar(35) not null,
    harvest_time_days int not null,
    ph_ideal_max decimal not null,
    ph_ideal_min decimal not null
);

alter table plant add id_system int null;
alter table plant add foreign key(id_system) references garden_system(id_system);

create table monitoring(
	id_monitoring int auto_increment not null primary key,
    water_temperature decimal not null,
    ambient_temperature decimal not null,
    ambient_humidity decimal not null,
    ec_measured decimal not null,
    ph_measured decimal not null,
    date_time datetime default current_timestamp
);

alter table monitoring add id_system int null;
alter table monitoring add foreign key(id_system) references garden_system(id_system);

create table nutrient_solution(
	id_solution int auto_increment not null primary key,
    preparation_date date not null,
    conductivity decimal not null,
    temperature decimal not null,
    level_ph decimal not null
);

alter table nutrient_solution add id_system int null;
alter table nutrient_solution add foreign key(id_system) references garden_system(id_system);

create table batch(
	id_batch int auto_increment not null primary key,
    state varchar(45) not null, 
    quantity int not null,
    planting_date date not null
);

alter table batch add id_system int null;
alter table batch add foreign key(id_system) references garden_system(id_system);

alter table batch add id_plant int null;
alter table batch add foreign key(id_plant) references plant(id_plan)

