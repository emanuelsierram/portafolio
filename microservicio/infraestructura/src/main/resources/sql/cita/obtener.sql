select id,descripcion,fecha_inicio,fecha_final,valor, id_trabajador
from cita where id_trabajador= :id_trabajador AND id = :id