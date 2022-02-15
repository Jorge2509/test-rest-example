package com.example.springboot.web.rest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.springboot.web.rest.entity.RespuestaExamen;

public interface RespuestaRepository  extends GenericRepository<RespuestaExamen, Integer> {

	@Query(value = "SELECT SUM(p.puntaje) as puntaje_examen "
			+ "FROM "
			+ "test_rest.examenes e inner join test_rest.preguntas as p on e.id = p.examen_id "
			+ "inner join test_rest.opciones as o on p.id = o.pregunta_id "
			+ "inner join test_rest.respuestas as r on r.pregunta_id = p.id and r.opcion_id = o.id "
			+ "inner join test_rest.respuesta_examen as re on re.id = r.respuestaexamen_id "
			+ "inner join test_rest.registro_examen as regexa on regexa.id = re.registroexamen_id "
			+ "inner join test_rest.estudiantes as est on est.id = regexa.estudiante_id "
			+ "WHERE o.opcion_correcta = 1 and e.id= :idExamen and est.id = :idEstudiante "
			+ "and re.id = (select max(id) from test_rest.respuesta_examen)", nativeQuery = true)
	Double calcularPuntajeExamen(@Param(value = "idEstudiante") Integer idEstudiante, @Param(value = "idExamen") Integer idExamen);
}
