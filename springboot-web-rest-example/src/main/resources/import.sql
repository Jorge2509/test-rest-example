--Insert estudiantes
insert into estudiantes (ciudad, edad, nombre, zona_horaria) values ('Hong_Kong', 25, 'Kashimoto', 'Asia/Hong_Kong');

--Insert Examenes
insert into examenes (codigo_examen) values ('EX001');

--Insert Preguntas
insert into preguntas (descripcion, puntaje, examen_id) values ('Pregunta 1', 10, 1);
insert into opciones (descripcion,codigo,opcion_correcta, pregunta_id) values ('Opcion 1','A',true, 1);
insert into opciones (descripcion,codigo,opcion_correcta, pregunta_id) values ('Opcion 2','B',false, 1);
insert into opciones (descripcion,codigo,opcion_correcta, pregunta_id) values ('Opcion 3','C',false, 1);
insert into opciones (descripcion,codigo,opcion_correcta, pregunta_id) values ('Opcion 4','D',false, 1);

insert into preguntas (descripcion, puntaje, examen_id) values ('Pregunta 2', 90, 1);
insert into opciones (descripcion,codigo,opcion_correcta, pregunta_id) values ('Opcion 1','A',false, 2);
insert into opciones (descripcion,codigo,opcion_correcta, pregunta_id) values ('Opcion 2','B',false, 2);
insert into opciones (descripcion,codigo,opcion_correcta, pregunta_id) values ('Opcion 3','C',true, 2);
insert into opciones (descripcion,codigo,opcion_correcta, pregunta_id) values ('Opcion 4','D',false, 2);

--Insert RegistroExamen
insert into registro_examen (estudiante_id, examen_id, fecha_examen) values (1, 1, '2022-02-14 10:21:00');