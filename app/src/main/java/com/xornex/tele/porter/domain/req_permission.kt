//import android.Manifest
//import android.widget.Toast
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.compose.ui.platform.LocalContext
//
//val context = LocalContext.current
//// Permission launcher
//val permissionLauncher = rememberLauncherForActivityResult(
//    contract = ActivityResultContracts.RequestMultiplePermissions(),
//    onResult = { permissions ->
//        val granted = permissions[Manifest.permission.READ_SMS] == true &&
//                permissions[Manifest.permission.RECEIVE_SMS] == true
//
//        if (granted) {
//            Toast.makeText(context, "SMS Permissions Granted", Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(context, "SMS Permissions Denied", Toast.LENGTH_SHORT).show()
//        }
//    }
//)
//
//LaunchedEffect(Unit) {
//    permissionLauncher.launch(
//        arrayOf(
//            Manifest.permission.READ_SMS,
//            Manifest.permission.RECEIVE_SMS
//        )
//    )
//}