package com.example.tlu_hub.ui.navigationDrawer.qrCode

interface QrCodeView {
    fun showProgress()
    fun hideProgress()
    fun onSuccess()
    fun onError()
}