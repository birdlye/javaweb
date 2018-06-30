create table product
(
  id                  int not null auto_increment,
  name                varchar(20),
  price               decimal(8,2),
  remark              longtext,
  date                timestamp default CURRENT_TIMESTAMP,
  primary key (id)
);


/* ����������*/
insert into product (name,price,remark) values ('computer',3000.00,'test....');

select * from product;