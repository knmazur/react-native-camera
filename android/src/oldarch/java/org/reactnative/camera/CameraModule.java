package org.reactnative.camera;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import org.reactnative.camera.utils.ScopedContext;

import java.util.Map;

import javax.annotation.Nullable;


public class CameraModule extends ReactContextBaseJavaModule {
    private ScopedContext mScopedContext;

    public CameraModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mScopedContext = new ScopedContext(reactContext);
    }

    public ScopedContext getScopedContext() {
        return mScopedContext;
    }

    @Override
    public String getName() {
        return CameraModuleImpl.NAME;
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        return CameraModuleImpl.getConstants();
    }

    @ReactMethod
    public void pausePreview(final int viewTag) {
        CameraModuleImpl.pausePreview(viewTag, getReactApplicationContext());
    }

    @ReactMethod
    public void resumePreview(final int viewTag) {
        CameraModuleImpl.resumePreview(viewTag, getReactApplicationContext());
    }

    @ReactMethod
    public void takePicture(final ReadableMap options, final int viewTag, final Promise promise) {
        CameraModuleImpl.takePicture(options, viewTag, promise, getReactApplicationContext(), mScopedContext);
    }

    @ReactMethod
    public void record(final ReadableMap options, final int viewTag, final Promise promise) {
        CameraModuleImpl.record(options, viewTag, promise, getReactApplicationContext(), mScopedContext);
    }

    @ReactMethod
    public void stopRecording(final int viewTag) {
        CameraModuleImpl.stopRecording(viewTag, getReactApplicationContext());
    }

    @ReactMethod
    public void pauseRecording(final int viewTag) {
        CameraModuleImpl.pauseRecording(viewTag, getReactApplicationContext());
    }

    @ReactMethod
    public void resumeRecording(final int viewTag) {
        CameraModuleImpl.resumeRecording(viewTag, getReactApplicationContext());
    }

    @ReactMethod
    public void getSupportedRatios(final int viewTag, final Promise promise) {
        CameraModuleImpl.getSupportedRatios(viewTag, promise, getReactApplicationContext());
    }

    @ReactMethod
    public void getCameraIds(final int viewTag, final Promise promise) {
        CameraModuleImpl.getCameraIds(viewTag, promise, getReactApplicationContext());
    }

    @ReactMethod
    public void getAvailablePictureSizes(final String ratio, final int viewTag, final Promise promise) {
        CameraModuleImpl.getAvailablePictureSizes(ratio, viewTag, promise, getReactApplicationContext());
    }

    @ReactMethod
    public void checkIfRecordAudioPermissionsAreDefined(final Promise promise) {
        CameraModuleImpl.checkIfRecordAudioPermissionsAreDefined(promise, getReactApplicationContext());
    }

    @ReactMethod
    public void getSupportedPreviewFpsRange(final int viewTag, final Promise promise) {
        CameraModuleImpl.getSupportedPreviewFpsRange(viewTag, promise, getReactApplicationContext());
    }

    @ReactMethod
    public void hasTorch(final Promise promise) {
        CameraModuleImpl.hasTorch(promise, getReactApplicationContext());
    }

    // Helper method to check for corrupted videos on Android
    @ReactMethod
    public void checkIfVideoIsValid(final String path, final Promise promise) {
        CameraModuleImpl.checkIfVideoIsValid(path, promise, getReactApplicationContext());
    }
}