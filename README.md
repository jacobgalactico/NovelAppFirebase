# 📚 NovelApp - Gestión de Biblioteca de Novelas

## Descripción

**NovelApp** es una aplicación de gestión de una biblioteca personal de novelas, desarrollada con **Kotlin** y **Jetpack Compose**. La aplicación permite a los usuarios agregar, editar, eliminar y marcar como favoritas sus novelas. Además, sincroniza los datos de las novelas con **Firebase** en segundo plano, utilizando **JobScheduler** y **AlarmManager** para realizar la sincronización de manera eficiente. La app también gestiona notificaciones para informar al usuario cuando se completa la sincronización y cuenta con un widget que permite ver las novelas favoritas desde la pantalla de inicio.

## 📑 Características

- **Gestión de Novelas**: Añadir, eliminar, ver detalles y marcar novelas como favoritas.
- **Fragmentos**: La aplicación utiliza fragmentos para una interfaz modular, mostrando la lista de novelas y sus detalles en una sola actividad. Esto mejora la adaptabilidad en diferentes tamaños de pantalla.
- **Widget de Favoritos**: Un widget de pantalla de inicio permite visualizar una lista resumida de las novelas marcadas como favoritas, permitiendo acceso rápido a la aplicación para ver más detalles.
- **Sincronización en Segundo Plano**:
  - Sincronización automática de los datos con Firebase usando **JobScheduler**.
  - Sincronización periódica mediante **AlarmManager** a intervalos regulares (configurado para cada 24 horas).
- **Notificaciones**: Notificaciones locales para informar sobre la finalización de la sincronización de datos.
- **Recepción de Broadcasts**: Uso de **BroadcastReceiver** para activar la sincronización cuando el dispositivo se conecta a una red Wi-Fi.
- **Interfaz de Usuario**: Diseñada con **Jetpack Compose** para una experiencia intuitiva y fluida.

## 🛠 Tecnologías Usadas

- **Kotlin** para el desarrollo nativo en Android.
- **Jetpack Compose** para el diseño de la UI moderna y declarativa.
- **Fragment** para la creación de una interfaz modular y adaptable.
- **AppWidgetProvider** para implementar widgets de pantalla de inicio.
- **Firebase Firestore** para almacenamiento y sincronización en tiempo real.
- **JobScheduler** y **AlarmManager** para la ejecución de tareas en segundo plano.
- **BroadcastReceiver** para recibir eventos del sistema, como la conexión a redes Wi-Fi.
- **NotificationManager** para mostrar notificaciones locales.

## Link: https://github.com/jacobgalactico/NovelAppFirebase.git

