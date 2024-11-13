# NovelApp - Gestión de Biblioteca de Novelas

## Descripción

**NovelApp** es una aplicación de gestión de una biblioteca personal de novelas, desarrollada con **Kotlin** y **Jetpack Compose**. La aplicación permite a los usuarios agregar, editar, eliminar y marcar como favoritas sus novelas. Además, se sincronizan los datos de las novelas con Firebase en segundo plano, utilizando `JobScheduler` y `AlarmManager` para realizar la sincronización de manera eficiente. La app también gestiona notificaciones para informar al usuario cuando se completa la sincronización.

## Características

- **Gestión de Novelas**: Añadir, eliminar, ver detalles y marcar novelas como favoritas.
- **Sincronización en Segundo Plano**:
  - Sincronización automática de los datos con Firebase usando `JobScheduler`.
  - Sincronización periódica mediante `AlarmManager` a intervalos regulares (configurado para cada 24 horas).
- **Notificaciones**: Notificaciones locales para informar sobre la finalización de la sincronización de datos.
- **Recepción de Broadcasts**: Uso de `BroadcastReceiver` para activar la sincronización cuando el dispositivo se conecta a una red Wi-Fi.
- **Interfaz de Usuario**: Diseñada con Jetpack Compose para una experiencia intuitiva y fluida.

## Tecnologías Usadas

- **Kotlin** para el desarrollo nativo en Android.
- **Jetpack Compose** para el diseño de la UI moderna y declarativa.
- **Firebase Firestore** para almacenamiento y sincronización en tiempo real.
- **JobScheduler** y **AlarmManager** para la ejecución de tareas en segundo plano.
- **BroadcastReceiver** para recibir eventos del sistema, como la conexión a redes Wi-Fi.
- **NotificationManager** para mostrar notificaciones locales.

## Requisitos

- **Android Studio** (versión reciente)
- **Conexión a Firebase**: Asegúrate de haber configurado Firebase en el proyecto. Sigue las instrucciones de [Firebase Console](https://console.firebase.google.com/).
- **Dispositivo o emulador Android** con versión mínima API 24 (Android 7.0 Nougat).

link repositorio: https://github.com/jacobgalactico/NovelAppFirebase.git

