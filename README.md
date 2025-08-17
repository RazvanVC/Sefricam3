# Sefricam3

Aplicación Android para la digitalización de datos de aves.

## Descripción
Sefricam3 es una aplicación móvil desarrollada en Android que permite digitalizar, registrar y gestionar información sobre aves. Está diseñada para facilitar la recolección de datos en campo, permitiendo almacenar y consultar registros de avistamientos, censos y otros datos relevantes de aves de manera eficiente y segura.

## Características principales
- Registro digital de datos de aves (avistamientos, censos, características, ubicaciones, etc.)
- Gestión y consulta de registros desde la app
- Interfaz intuitiva y adaptada a dispositivos móviles
- Exportación o sincronización de datos (opcional, según configuración)
- Soporte para múltiples resoluciones de pantalla

## Requisitos previos
- Android Studio instalado
- JDK 8 o superior
- Gradle

## Instalación y compilación
1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/Sefricam3.git
   ```
2. Abre el proyecto en Android Studio.
3. Sincroniza el proyecto con Gradle.
4. Configura el archivo `google-services.json` en `app/` si usas servicios de Firebase.
5. Compila y ejecuta la aplicación en un dispositivo o emulador Android.

## Estructura del proyecto
```
Sefricam3/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/sefricam/        # Código fuente principal
│   │   │   ├── res/                      # Recursos gráficos y layouts
│   │   │   └── AndroidManifest.xml       # Manifest de la app
│   ├── build.gradle                      # Configuración de módulo
├── build.gradle                          # Configuración global
├── README.md                             # Este archivo
└── ...
```

## Créditos
Desarrollado por el equipo de Sefricam.

## Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.
