![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Evaluación Final Transversal – Desarrollo Orientado a Objetos I

## 👤 Autor del proyecto
- **Nombre completo:** Francisco Villa Duran
- **Carrera:** Aalista Programador
- **Sede:** DUOC online

---

## 📘 Descripción general del sistema
Este proyecto corresponde a la Evaluación Final Transversal de la asignatura *Desarrollo Orientado a Objetos I*. Corresponde a un sistema desarrollado en Java para la gestión de información de personas, clasificadas en Clientes, Empleados y Proveedores.

El sistema permite administrar un listado de personas con las siguientes funcionalidades:
- Carga inicial de datos desde archivos de texto (personas y direcciones)
- Listado completo de todas las personas registradas
- Filtrado por tipo (cliente, empleado o proveedor)
- Registro interactivo de nuevas personas
- Validación de RUT
- Manejo de errores para entradas inválidas

El diseño está basado en POO, utilizando herencia, polimorfismo, encapsulamiento y una interfaz para estandarizar el registro de personas.

Este proyecto fue desarrollado a partir de un caso contextualizado (empresa de turismo Llanquihue Tours), abordando problemas reales y proponiendo una solución estructurada, modular y reutilizable.
---

## 🧱 Estructura general del proyecto

📦 SistemaGestionPersonas
├── 📂 src
│   ├── 📂 app
│   │   └── Main.java                 # Punto de entrada
│   ├── 📂 model
│   │   ├── Persona.java              # Clase Padre
│   │   ├── Cliente.java              # Cliente
│   │   ├── Empleado.java             # Empleado
│   │   ├── Proveedor.java            # Proveedor
│   │   ├── Direccion.java            # Dirección
│   │   ├── RUT.java                  # RUT
│   │   └── Registrable.java          # Interfaz
│   ├── 📂 data
│   │   └── GestorDeDatos.java        # Lectura de archivos
│   └── 📂 utils
│       ├── PersonaService.java       # Logica de datos
│       └── RutInvalidoException.java # Excepción personalizada para ingreso de RUT
├── 📂 archivos
│   ├── Datos personas.txt
│   └── Direcciones.txt
└── README.md

---



## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/usuario/repositorio-evaluacion-final.git
```

2. Abre el proyecto en IntelliJ IDEA.

3. Verifica que los archivos `.txt` estén correctamente ubicados.

4. Ejecuta el archivo `Main.java` desde el paquete `app`.

5. Sigue las instrucciones en consola o en la interfaz gráfica (si corresponde).


---

**Repositorio GitHub:** \[Pega aquí el enlace al repositorio]
**Fecha de entrega:** \[DD/MM/2025]

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Evaluación Final Transversal EFT
