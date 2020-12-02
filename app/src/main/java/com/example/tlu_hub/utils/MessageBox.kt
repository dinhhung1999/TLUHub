package vn.dms.sharkforsale.dmsforcustomer.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Toast

class MessageBox {
    fun showToast(ctx: Context?, string: String) {
        if (ctx != null)
            Toast.makeText(ctx, string, Toast.LENGTH_LONG).show()
    }

    fun showAlert(
        ctx: Context?,
        title: String,
        message: String,
        button: String,
        listener: DialogInterface.OnClickListener
    ) {
        if (ctx != null) {
            val builder = AlertDialog.Builder(ctx)
            builder.setTitle(title).setMessage(message)
                .setPositiveButton(button, listener)
            builder.setCancelable(false)
            val dl: Dialog = builder.create()
            dl.show()
        }
    }

    fun showAlert(
        ctx: Context?,
        title: String,
        message: String,
        button: String
    ) {
        if (ctx != null) {
            val builder = AlertDialog.Builder(ctx)
            builder.setTitle(title).setMessage(message)
                .setPositiveButton(button, null)
            builder.setCancelable(false)
            val dl: Dialog = builder.create()
            dl.show()
        }
    }

    fun showAlert(
        ctx: Context?, title: String, message: String, button1: String, listener1:
        DialogInterface.OnClickListener, button2: String, listener2: DialogInterface.OnClickListener
    ) {
        if (ctx != null) {
            val builder = AlertDialog.Builder(ctx)
            builder.setTitle(title).setMessage(message)
                .setPositiveButton(button1, listener1)
                .setNegativeButton(button2, listener2)
            builder.setCancelable(false)
            val dl: Dialog = builder.create()
            dl.show()
        }
    }

    fun showAlert(
        ctx: Context?,
        title: String,
        message: String,
        button1: String,
        listener1:
        DialogInterface.OnClickListener,
        button2: String,
        listener2: DialogInterface.OnClickListener,
        isCancelable: Boolean
    ) {
        if (ctx != null) {
            val builder = AlertDialog.Builder(ctx)
            builder.setTitle(title).setMessage(message)
                .setPositiveButton(button1, listener1)
                .setNegativeButton(button2, listener2)
            builder.setCancelable(isCancelable)
            val dl: Dialog = builder.create()
            dl.show()
        }
    }
}