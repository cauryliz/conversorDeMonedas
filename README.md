# conversorDeMonedas
Practica de conversion de cambio de divisas

# 💱 Conversor de Monedas en Java

Este proyecto es una aplicación de consola escrita en **Java 11+** que permite consultar tipos de cambio actualizados entre distintas monedas (USD, MXN, ARS, BRL), utilizando una **API REST** y la librería **Gson** para procesar JSON.

---

## 🚀 Funcionalidades

- Menú interactivo por consola.
- Consulta del tipo de cambio actual entre:
  - USD ↔ MXN (Peso mexicano)
  - USD ↔ ARS (Peso argentino)
  - USD ↔ BRL (Real brasileño)
- Conversión de cantidades ingresadas por el usuario.
- Uso de `HttpClient` para consumir APIs REST.
- Procesamiento de datos JSON con `Gson`.

---

## 🛠 Requisitos

- Java 11 o superior.
- Conexión a internet.
- Clave API gratuita de [ExchangeRate-API](https://www.exchangerate-api.com/).
- Librería Gson instalada (vía Maven o manual).

---

## 📦 Instalación

### 1. Clonar o copiar el proyecto

```bash
git clone https://github.com/tuusuario/conversor-monedas-java.git
cd conversor-monedas-java
