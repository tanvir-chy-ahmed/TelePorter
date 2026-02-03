import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

fun areSmsPermissionsGranted(context: Context): Boolean {
    val readSms = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_SMS)
    val receiveSms = ContextCompat.checkSelfPermission(context, Manifest.permission.RECEIVE_SMS)
    return readSms == PackageManager.PERMISSION_GRANTED &&
            receiveSms == PackageManager.PERMISSION_GRANTED
}
