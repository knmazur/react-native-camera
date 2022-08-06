package org.reactnative.camera;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;

import org.reactnative.camera.utils.ScopedContext;

import java.util.Map;

import javax.annotation.Nullable;

public class CameraModule extends NativeRNCameraSpec {
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

    @Override
    public WritableMap getTurboConstants() {
        return new TurboConstants().getConstants();
    }

    @Override
    public void pausePreview(final double viewTag) {
        CameraModuleImpl.pausePreview((int)viewTag, getReactApplicationContext());
    }

    @Override
    public void resumePreview(final double viewTag) {
        CameraModuleImpl.resumePreview((int)viewTag, getReactApplicationContext());
    }

    @Override
    public void takePicture(final ReadableMap options, final double viewTag, final Promise promise) {
        CameraModuleImpl.takePicture(options, (int)viewTag, promise, getReactApplicationContext(), mScopedContext);
    }

    @Override
    public void record(final ReadableMap options, final double viewTag, final Promise promise) {
        CameraModuleImpl.record(options, (int)viewTag, promise, getReactApplicationContext(), mScopedContext);
    }

    @Override
    public void stopRecording(final double viewTag) {
        CameraModuleImpl.stopRecording((int)viewTag, getReactApplicationContext());
    }

    @Override
    public void pauseRecording(final double viewTag) {
        CameraModuleImpl.pauseRecording((int)viewTag, getReactApplicationContext());
    }

    @Override
    public void resumeRecording(final double viewTag) {
        CameraModuleImpl.resumeRecording((int)viewTag, getReactApplicationContext());
    }

    @Override
    public void getSupportedRatios(final double viewTag, final Promise promise) {
        CameraModuleImpl.getSupportedRatios((int)viewTag, promise, getReactApplicationContext());
    }

    @Override
    public void getCameraIds(final double viewTag, final Promise promise) {
        CameraModuleImpl.getCameraIds((int)viewTag, promise, getReactApplicationContext());
    }

    @Override
    public void getAvailablePictureSizes(final String ratio, final double viewTag, final Promise promise) {
        CameraModuleImpl.getAvailablePictureSizes(ratio, (int)viewTag, promise, getReactApplicationContext());
    }

    @Override
    public void checkIfRecordAudioPermissionsAreDefined(final Promise promise) {
        CameraModuleImpl.checkIfRecordAudioPermissionsAreDefined(promise, getReactApplicationContext());
    }

    @Override
    public void getSupportedPreviewFpsRange(final double viewTag, final Promise promise) {
        CameraModuleImpl.getSupportedPreviewFpsRange((int)viewTag, promise, getReactApplicationContext());
    }

    @Override
    public void hasTorch(final Promise promise) {
        CameraModuleImpl.hasTorch(promise, getReactApplicationContext());
    }

    // Helper method to check for corrupted videos on Android
    @Override
    public void checkIfVideoIsValid(final String path, final Promise promise) {
        CameraModuleImpl.checkIfVideoIsValid(path, promise, getReactApplicationContext());
    }
}