package com.reproducerapp;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;
import com.nativefunctions.NativeFunctionsModuleSpec;

import java.util.Map;

public class NativeLocalStorageModule extends NativeFunctionsModuleSpec {

    public static final String NAME = "NativeFunctionsModule";

    public NativeLocalStorageModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public void httpsCallable(String name, ReadableMap data, Promise promise) {
        try {
            ReadableMap nestedData = data.getMap("data");
            assert nestedData != null;
            Map<String, Object> resultData = nestedData.toHashMap();
            
            WritableMap response = Arguments.createMap();
            response.putMap("data", convertMapToWritableMap(resultData));
            
            promise.resolve(response);
        } catch (Exception e) {
            promise.reject("ERROR", "Failed to process data: " + e.getMessage());
        }
    }
    
    private WritableMap convertMapToWritableMap(Map<String, Object> map) {
        WritableMap writableMap = Arguments.createMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            
            if (value == null) {
                writableMap.putNull(key);
            } else if (value instanceof String) {
                writableMap.putString(key, (String) value);
            } else if (value instanceof Integer) {
                writableMap.putInt(key, (Integer) value);
            } else if (value instanceof Double) {
                writableMap.putDouble(key, (Double) value);
            } else if (value instanceof Boolean) {
                writableMap.putBoolean(key, (Boolean) value);
            } else if (value instanceof Map) {
                writableMap.putMap(key, convertMapToWritableMap((Map<String, Object>) value));
            }
        }
        return writableMap;
    }
}