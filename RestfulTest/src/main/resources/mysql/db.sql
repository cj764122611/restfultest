create table person(
	id int primary key auto_increment,
	name varchar(20)
)

--插入sql语句
insert into person (name) values('陈杰'),('张三'),('李四'),('王五'),('赵六'),('钱七')

--查询person
select * from person;

--更新数据
update person set name = '张龙' where id = 6

--分页查询数据
select * from person limit 0,2


--删除用户数据
delete  from person where id = 7;