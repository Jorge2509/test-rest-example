package com.example.springboot.web.rest.manejador;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class ManejadorZonaHoraria {

	public String manejador(LocalDateTime fecha, String zonaHoraria) {

		ZoneId zoneId = ZoneId.of(zonaHoraria);

		ZonedDateTime fecha1 = ZonedDateTime.of(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth(),
				fecha.getHour(), fecha.getMinute(), fecha.getSecond(), 00, ZoneId.of("America/Bogota"));

		ZonedDateTime fecha2 = ZonedDateTime.ofInstant(fecha1.plusHours(24).toInstant(), zoneId);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss Z");
		String formattedString = fecha2.format(formatter);

		return formattedString;

	}

}
