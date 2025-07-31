package com.JairoOntiveros.conversor.utilidades;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Utilidades {

    public static String formatearFechaEnEspanol(String fechaUTC) {
        DateTimeFormatter fechaProcesada = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        ZonedDateTime fecha = ZonedDateTime.parse(fechaUTC, fechaProcesada);
        DateTimeFormatter formatterES = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM 'de' yyyy HH:mm:ss", new Locale("es", "ES"));
        return fecha.format(formatterES);
    }
}
