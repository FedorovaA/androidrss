package com.witcher.androidrss.ui.fragments;

import android.content.Intent;

public interface OnResultListener {

    /**
     * Передает результат при закрытии экрана.
     * @param intent некий результат
     */
    void onResult(Intent intent);
}
