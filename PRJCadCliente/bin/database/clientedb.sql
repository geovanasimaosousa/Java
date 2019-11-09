-- Banco de dado do projeto PRJCadCliente
create database clientedb;
use clientedb;
-- colocar os requisitos
create table tbcliente(
id int auto_increment primary key,
nome varchar(50) not null,
email varchar(50) not null,
telefone varchar(15) not null,
idade int not null
);
-- colocar os cliente
insert into tbcliente(nome,email,telefone,idade)
values('Ana','ana@terra.com.br','1111-1111',40);
select * from tbcliente;
