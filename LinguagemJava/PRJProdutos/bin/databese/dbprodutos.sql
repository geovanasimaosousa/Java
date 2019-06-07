-- Banco de dado do projeto PRJProdutos
create database dbprodutos;
use dbprodutos;
-- colocar os requisitos
create table tbProdutos(
id int auto_increment primary key,
nome varchar(50) not null,
fabricante varchar(50) not null,
quantidade int not null,
preco decimal (10,2)
);
-- colocar os produtos
insert into tbProdutos(nome,fabricante,quantidade,preco)
values('Garrafa','ana@terra.com.br', 1, 50.00);
select * from tbProdutos;