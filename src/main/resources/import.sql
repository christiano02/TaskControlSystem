insert into tb_user (id, name, email, password, role) values (1, 'João Silva', 'joao@email.com', '123456', 'ADMIN');
insert into tb_user (id, name, email, password, role) values (2, 'Maria Souza', 'maria@email.com', 'abcdef', 'USER');

insert into tb_task (id, title, description, creation_date, status, user_id) values (1, 'Estudar Java', 'Focar em Streams e Lambdas', CURRENT_TIMESTAMP, 'PENDING', 1);
insert into tb_task (id, title, description, creation_date, status, user_id) values (2, 'Revisar Spring', 'Anotações @Service, @Repository...', CURRENT_TIMESTAMP, 'PENDING', 1);
insert into tb_task (id, title, description, creation_date, status, user_id) values (3, 'Planejar Projeto', 'Sistema de controle de tarefas', CURRENT_TIMESTAMP, 'PENDING', 2);

