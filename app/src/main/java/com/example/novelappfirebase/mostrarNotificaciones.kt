import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.novelappfirebase.R

fun mostrarNotificacion(context: Context) {
    val notificationId = 1
    val channelId = "sync_channel"

    // Verificar si el permiso de notificaciones ha sido concedido
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // No tenemos permiso, no mostramos la notificación
            return
        }
    }

    // Crear la notificación
    val builder = NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle("Sincronización Completada")
        .setContentText("Los datos de las novelas han sido sincronizados con el servidor.")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    // Mostrar la notificación
    with(NotificationManagerCompat.from(context)) {
        notify(notificationId, builder.build())
    }
}
