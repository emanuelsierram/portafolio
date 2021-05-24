update cita
set descripcion = :descripcion,
	fecha_inicio = :fechaInicio,
	fecha_final = :fechaFinal,
	valor= :valorAcordado,
	metodo_pago= :metodoPago
where id = :id