# 💱 Conversor de Moneda Dinámico

![Java](https://img.shields.io/badge/Java-17-blue) ![Swing](https://img.shields.io/badge/Swing-GUI-orange) ![Maven](https://img.shields.io/badge/Maven-Project-green) ![API](https://img.shields.io/badge/ExchangeRateAPI-Online-red)

Un **Conversor de Moneda** que obtiene tasas de cambio en tiempo real desde [ExchangeRate-API](https://www.exchangerate-api.com/) y muestra la conversión en una **interfaz gráfica con Swing**.  
Además, la lista de monedas se carga **dinámicamente desde la API**, lo que permite actualizarse automáticamente si se agregan nuevas monedas.

---

## 🎯 Objetivos del proyecto

1. Aprender a integrar **APIs REST** con Java usando `HttpClient`.  
2. Trabajar con **JSON** y Gson para parsear datos.  
3. Crear interfaces gráficas con **Swing** (JFrame, JComboBox, JTextField, JLabel, JButton).  
4. Separar la **lógica de negocio** (llamadas a API, conversiones) de la **interfaz gráfica**.  
5. Proporcionar un conversor funcional y escalable para **cualquier moneda soportada por la API**.

---

## 🗂 Estructura del proyecto

E:/Alura/moneyexchange/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/alura/moneyexchange/
│ │ │ ├── MainSwing.java # Interfaz gráfica del conversor
│ │ │ └── CurrencyAPI.java # Lógica para obtener monedas y tasas de cambio
│ │ └── resources/
│ └── test/
├── pom.xml # Dependencias y configuración de Maven
└── README.md



---

## 📦 Tecnologías usadas

- **Java 17** – Lenguaje principal  
- **Swing** – Para la interfaz gráfica  
- **HttpClient** – Para hacer solicitudes HTTP a la API  
- **Gson** – Para parsear JSON  
- **Maven** – Para gestión de dependencias y compilación  

---

## 🧩 Descripción de las clases

### **1️⃣ CurrencyAPI.java**
- Se encarga de interactuar con la API de ExchangeRate:
  - `getRate(String from, String to)` → obtiene la tasa de conversión de una moneda a otra.
  - `getCurrencies()` → devuelve un array con todos los códigos de monedas soportadas, para llenar los JComboBox dinámicamente.
- Mantiene la lógica separada de la interfaz gráfica.

### **2️⃣ MainSwing.java**
- Interfaz gráfica principal del conversor:
  - JComboBox para seleccionar **moneda origen** y **moneda destino**.
  - JTextField para ingresar la **cantidad a convertir**.
  - JButton para realizar la conversión.
  - JLabel para mostrar el **resultado**.
- Llama a `CurrencyAPI` para obtener la tasa de cambio y calcular el resultado.
- Maneja validaciones básicas (cantidad numérica, errores de conexión).

---

## 🚀 Cómo ejecutar el proyecto

1. Clona el proyecto o descárgalo en tu workspace.  
2. Asegúrate de tener **JDK 17** instalado y configurado en Eclipse o tu IDE.  
3. Ejecuta `MainSwing.java` como **Java Application**.  
4. Espera unos segundos mientras se cargan las monedas desde la API.  
5. Selecciona la moneda origen y destino, ingresa la cantidad y presiona **Convertir**.  
6. ¡Verás el resultado actualizado en tiempo real!  

---

## ⚠️ Notas importantes

- La primera carga de monedas depende de la conexión a Internet y puede tardar unos segundos.  
- Si la API no está disponible o la clave es inválida, se muestran algunas monedas por defecto (`USD`, `PEN`).  
- Puedes reemplazar la API Key en `CurrencyAPI.java` por tu propia clave para evitar límites de uso.  

---

## 🔗 Recursos

- [Documentación oficial ExchangeRate-API](https://www.exchangerate-api.com/docs)  
- [Gson GitHub](https://github.com/google/gson)  
- [Swing Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)  

---

## 💡 Mejoras futuras

- Guardar tasas en **archivo local JSON** para usar sin conexión.  
- Agregar validación avanzada y mensajes de error más claros.  
- Mostrar historial de conversiones.  
- Mejorar la interfaz con colores y fuentes personalizadas.  

---

> Hecho con ❤️ por  Michelle

