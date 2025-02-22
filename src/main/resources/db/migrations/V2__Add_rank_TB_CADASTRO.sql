-- v2 Migrations para add a columa de  rank na tabela de cadastro

Alter TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);