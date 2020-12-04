package com.example.tlu_hub.ui.navigationDrawer.qrCode

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toolbar
import com.example.tlu_hub.MainActivity
import com.example.tlu_hub.R
import com.example.tlu_hub.ui.navigationDrawer.qrCode.Util.StatusBarUtils
import com.king.zxing.CaptureActivity
import com.king.zxing.camera.FrontLightMode

class QRCodeActivity : CaptureActivity() {
    private var isContinuousScan = false
    override fun getLayoutId(): Int {
        return R.layout.activity_q_r_code
    }

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        StatusBarUtils.immersiveStatusBar(this, toolbar, 0.2f)
        val btnStop = findViewById<Button>(R.id.btnStop)
        btnStop.setOnClickListener { onBackPressed() }
        isContinuousScan = intent.getBooleanExtra("key_continuous_scan", false)

        captureHelper.playBeep(false) //播放音效
            .vibrate(true) //震动
            .supportVerticalCode(true)

            .frontLightMode(FrontLightMode.AUTO)
            .tooDarkLux(45f)
            .brightEnoughLux(100f)
            .continuousScan(isContinuousScan) //是否连扫
            .supportLuminanceInvert(true)
    }


    override fun onResultCallback(result: String?): Boolean {
        if (isContinuousScan) {
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }
        return super.onResultCallback(result)
    }

    fun onClick(v: View) {
        when (v.id) {
            R.id.ivLeft -> onBackPressed()
        }
    }
}