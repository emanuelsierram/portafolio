update cita
set descripcion = :descripcion,
	fecha_inicio = :fechaInicio,
	fecha_final = :fechaFinal,
	valor= :valorAcordado,
	id_usuario= :idUsuario
where id = :id