create table testimonials(
	
	id bigint not null auto_increment,
	name varchar(100) not null,
	testimonial varchar(255) not null,
	photo varchar(8000),
	
	primary key(id)

);