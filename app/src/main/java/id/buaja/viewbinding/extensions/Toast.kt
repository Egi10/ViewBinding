package id.buaja.viewbinding.extensions

import android.app.Activity
import android.widget.Toast

/**
 * Created By Julsapargi Nursam 4/26/20
 */
 
 fun Activity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}