# Conversor de Monedas

Este proyecto es un conversor de monedas que utiliza la API [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tasas de cambio en tiempo real y formatea las fechas al español.

---

## Características

- Conversión directa entre pares de monedas (ej. USD a ARS, COP a USD).
- Formateo de la fecha de la última actualización de la tasa en español.
- Validación de entrada para evitar cantidades negativas.
- Manejo básico de errores para problemas de conexión o respuesta inválida.

---

## Tecnologías

- Java 17+
- Java HTTP Client (java.net.http)
- Gson para parseo JSON
- API ExchangeRate-API

---

## Uso

1. Clona el repositorio.

2. Agrega tu API key en la clase `APIService` en la constante `API_KEY`.

3. Compila y ejecuta el programa.

4. Sigue las instrucciones del menú para convertir monedas.



## Ejemplo de uso

<img width="563" height="511" alt="image" src="https://github.com/user-attachments/assets/0a5c46e1-b6d4-4b6d-8cba-52fe193742cb" />
