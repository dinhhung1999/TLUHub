package com.example.tlu_hub.utils;

import android.util.Log;

public class LogUtil {
	
	public static final boolean IS_DEBUG = false;
	
	
	public static void debug(String tag, int value){
		if (IS_DEBUG) Log.d(tag, String.valueOf(value));
	}
	
	public static void debug(String tag, float value){
		if (IS_DEBUG) Log.d(tag, String.valueOf(value));
	}

	public static void debug(String tag, boolean value){
		if (IS_DEBUG) Log.d(tag, String.valueOf(value));
	}
	
	public static void debug(String tag, String message){
		if (IS_DEBUG) Log.d(tag, message);
	}
}
