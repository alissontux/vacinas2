INSERT INTO USUARIO(nome, email, senha) VALUES('Aplicador', 'aplicador@email.com', 
'$2a$10$zu8DleonqmDzK4voVUkzO.eO56fCn5gIqKnJHY822ZB5Jy34Q3REW');

INSERT INTO USUARIO(nome, email, senha) VALUES('Administrador', 'admin@email.com', 
'$2a$10$zu8DleonqmDzK4voVUkzO.eO56fCn5gIqKnJHY822ZB5Jy34Q3REW');

INSERT INTO PERFIL(id, nome) VALUES(1, 'ROLE_APLICADOR');
INSERT INTO PERFIL(id, nome) VALUES(2, 'ROLE_ADMIN');

INSERT INTO USUARIO_PERFIS (usuario_id, perfis_id) VALUES (1, 1);
INSERT INTO USUARIO_PERFIS (usuario_id, perfis_id) VALUES (2, 2);

INSERT INTO vacina (nome) VALUES ('CoronaVac');
INSERT INTO vacina (nome) VALUES ('Oxford/AstraZeneca');
INSERT INTO vacina (nome) VALUES ('Pfizer/BioTech');
INSERT INTO vacina (nome) VALUES ('Sputnik V');

INSERT INTO CIDADAO (nome, email, cpf, data_Nascimento) 
VALUES ('Teste3', 'teste3@gmail.com', '000.000.000-00', '1990-08-25');