package com.JairoOntiveros.conversor.modelos;

import java.util.Map;

public record ExchangeRateResponse(String base_code,
                                   String target_code,
                                   double conversion_rate,
                                   String time_last_update_utc) {

}
