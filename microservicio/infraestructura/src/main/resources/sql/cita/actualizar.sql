update cita
set descripcion = :descripcion,
	fecha_inicio = :fechaInicio,
	fecha_final = :fechaFinal,
	valor= :valorAcordado,
	id_trabajador= :idTrabajador
where id = :id