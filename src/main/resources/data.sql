

-- User


-- Tarefas
INSERT INTO tb_task (id, title, description, creation_date, status, user_id) VALUES
  (1, 'Estudar Java', 'Focar em Streams e Lambdas', CURRENT_TIMESTAMP, 'PENDING', 1),
  (2, 'Revisar Spring', 'Anotações @Service, @Repository...', CURRENT_TIMESTAMP, 'PENDING', 1),
  (3, 'Planejar Projeto', 'Sistema de controle de tarefas', CURRENT_TIMESTAMP, 'PENDING', 2);