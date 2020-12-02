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
        //        TextView tvTitle = findViewById(R.id.tvTitle);
        isContinuousScan = intent.getBooleanExtra("key_continuous_scan", false)
        //获取CaptureHelper，里面有扫码相关的配置设置
        captureHelper.playBeep(false) //播放音效
            .vibrate(true) //震动
            .supportVerticalCode(true) //支持扫垂直条码，建议有此需求时才使用。
            //                .decodeFormats(DecodeFormatManager.QR_CODE_FORMATS)//设置只识别二维码会提升速度
            //                .framingRectRatio(0.9f)//设置识别区域比例，范围建议在0.625 ~ 1.0之间。非全屏识别时才有效
            //                .framingRectVerticalOffset(0)//设置识别区域垂直方向偏移量，非全屏识别时才有效
            //                .framingRectHorizontalOffset(0)//设置识别区域水平方向偏移量，非全屏识别时才有效
            .frontLightMode(FrontLightMode.AUTO) //设置闪光灯模式
            .tooDarkLux(45f) //设置光线太暗时，自动触发开启闪光灯的照度值
            .brightEnoughLux(100f) //设置光线足够明亮时，自动触发关闭闪光灯的照度值
            .continuousScan(isContinuousScan) //是否连扫
            .supportLuminanceInvert(true) //是否支持识别反色码（黑白反色的码），增加识别率
    }


    /**
     * 扫码结果回调
     * @param result 扫码结果
     * @return
     */
    override fun onResultCallback(result: String?): Boolean {
        if (isContinuousScan) { //连续扫码时，直接弹出结果
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