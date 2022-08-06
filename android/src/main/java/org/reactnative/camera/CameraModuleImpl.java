package org.reactnative.camera;

import android.Manifest;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;


import com.facebook.react.bridge.*;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import com.google.android.cameraview.AspectRatio;
import com.google.zxing.BarcodeFormat;
import org.reactnative.barcodedetector.BarcodeFormatUtils;
import org.reactnative.camera.utils.ScopedContext;
import org.reactnative.facedetector.RNFaceDetector;
import com.google.android.cameraview.Size;

import javax.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.SortedSet;

import android.util.Log;


public class CameraModuleImpl  {
    public static final String NAME = "RNCameraModule";

    public static Map<String, Object> getConstants() {
        Log.d("INFO", "getConstants()");
        return Collections.unmodifiableMap(new HashMap<String, Object>() {
            {
                put("Type", getTypeConstants());
                put("FlashMode", getFlashModeConstants());
                put("AutoFocus", getAutoFocusConstants());
                put("WhiteBalance", getWhiteBalanceConstants());
                put("VideoQuality", getVideoQualityConstants());
                put("BarCodeType", getBarCodeConstants());
                put("FaceDetection", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("Mode", getFaceDetectionModeConstants());
                        put("Landmarks", getFaceDetectionLandmarksConstants());
                        put("Classifications", getFaceDetectionClassificationsConstants());
                    }

                    private Map<String, Object> getFaceDetectionModeConstants() {
                        return Collections.unmodifiableMap(new HashMap<String, Object>() {
                            {
                                put("fast", RNFaceDetector.FAST_MODE);
                                put("accurate", RNFaceDetector.ACCURATE_MODE);
                            }
                        });
                    }

                    private Map<String, Object> getFaceDetectionClassificationsConstants() {
                        return Collections.unmodifiableMap(new HashMap<String, Object>() {
                            {
                                put("all", RNFaceDetector.ALL_CLASSIFICATIONS);
                                put("none", RNFaceDetector.NO_CLASSIFICATIONS);
                            }
                        });
                    }

                    private Map<String, Object> getFaceDetectionLandmarksConstants() {
                        return Collections.unmodifiableMap(new HashMap<String, Object>() {
                            {
                                put("all", RNFaceDetector.ALL_LANDMARKS);
                                put("none", RNFaceDetector.NO_LANDMARKS);
                            }
                        });
                    }
                }));
                put("GoogleVisionBarcodeDetection", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("BarcodeType", BarcodeFormatUtils.REVERSE_FORMATS);
                        put("BarcodeMode", getGoogleVisionBarcodeModeConstants());
                    }
                }));
                put("Orientation", Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("auto", Constants.ORIENTATION_AUTO);
                        put("portrait", Constants.ORIENTATION_UP);
                        put("portraitUpsideDown", Constants.ORIENTATION_DOWN);
                        put("landscapeLeft", Constants.ORIENTATION_LEFT);
                        put("landscapeRight", Constants.ORIENTATION_RIGHT);
                    }
                }));
            }

            private Map<String, Object> getTypeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("front", Constants.FACING_FRONT);
                        put("back", Constants.FACING_BACK);
                    }
                });
            }

            private Map<String, Object> getFlashModeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("off", Constants.FLASH_OFF);
                        put("on", Constants.FLASH_ON);
                        put("auto", Constants.FLASH_AUTO);
                        put("torch", Constants.FLASH_TORCH);
                    }
                });
            }

            private Map<String, Object> getAutoFocusConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("on", true);
                        put("off", false);
                    }
                });
            }

            private Map<String, Object> getWhiteBalanceConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("auto", Constants.WB_AUTO);
                        put("cloudy", Constants.WB_CLOUDY);
                        put("sunny", Constants.WB_SUNNY);
                        put("shadow", Constants.WB_SHADOW);
                        put("fluorescent", Constants.WB_FLUORESCENT);
                        put("incandescent", Constants.WB_INCANDESCENT);
                    }
                });
            }

            private Map<String, Object> getVideoQualityConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("2160p", Constants.VIDEO_2160P);
                        put("1080p", Constants.VIDEO_1080P);
                        put("720p", Constants.VIDEO_720P);
                        put("480p", Constants.VIDEO_480P);
                        put("4:3", Constants.VIDEO_4x3);
                    }
                });
            }

            private Map<String, Object> getGoogleVisionBarcodeModeConstants() {
                return Collections.unmodifiableMap(new HashMap<String, Object>() {
                    {
                        put("NORMAL", Constants.GOOGLE_VISION_BARCODE_MODE_NORMAL);
                        put("ALTERNATE", Constants.GOOGLE_VISION_BARCODE_MODE_ALTERNATE);
                        put("INVERTED", Constants.GOOGLE_VISION_BARCODE_MODE_INVERTED);
                    }
                });
            }

            private Map<String, Object> getBarCodeConstants() {
                return Constants.VALID_BARCODE_TYPES;
            }
        });
    }

    public static void pausePreview(final int viewTag, final ReactApplicationContext context) {
        UIManagerModule uiManager = context.getNativeModule(UIManagerModule.class);
        uiManager.addUIBlock(new UIBlock() {
            @Override
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                final RNCameraView cameraView;

                try {
                    cameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(viewTag);
                    if (cameraView.isCameraOpened()) {
                        cameraView.pausePreview();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void resumePreview(final int viewTag, final ReactApplicationContext context) {
        UIManagerModule uiManager = context.getNativeModule(UIManagerModule.class);
        uiManager.addUIBlock(new UIBlock() {
            @Override
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                final RNCameraView cameraView;

                try {
                    cameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(viewTag);
                    if (cameraView.isCameraOpened()) {
                        cameraView.resumePreview();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void takePicture(final ReadableMap options, final int viewTag, final Promise promise, final ReactApplicationContext context, final ScopedContext scopedContext) {
        final File cacheDirectory = scopedContext.getCacheDirectory();
        UIManagerModule uiManager = context.getNativeModule(UIManagerModule.class);
        uiManager.addUIBlock(new UIBlock() {
            @Override
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                RNCameraView cameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(viewTag);
                try {
                    if (cameraView.isCameraOpened()) {
                        cameraView.takePicture(options, promise, cacheDirectory);
                    } else {
                        promise.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                    }
                }
                catch (Exception e) {
                    promise.reject("E_TAKE_PICTURE_FAILED", e.getMessage());
                }
            }
        });
    }

    public static void record(final ReadableMap options, final int viewTag, final Promise promise, final ReactApplicationContext context, final ScopedContext scopedContext) {
        final File cacheDirectory = scopedContext.getCacheDirectory();
        UIManagerModule uiManager = context.getNativeModule(UIManagerModule.class);

        uiManager.addUIBlock(new UIBlock() {
            @Override
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                final RNCameraView cameraView;

                try {
                    cameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(viewTag);
                    if (cameraView.isCameraOpened()) {
                        cameraView.record(options, promise, cacheDirectory);
                    } else {
                        promise.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                    }
                } catch (Exception e) {
                    promise.reject("E_CAPTURE_FAILED", e.getMessage());
                }
            }
        });
    }

    public static void stopRecording(final int viewTag, final ReactApplicationContext context) {
        UIManagerModule uiManager = context.getNativeModule(UIManagerModule.class);
        uiManager.addUIBlock(new UIBlock() {
            @Override
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                final RNCameraView cameraView;

                try {
                    cameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(viewTag);
                    if (cameraView.isCameraOpened()) {
                        cameraView.stopRecording();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void pauseRecording(final int viewTag, final ReactApplicationContext context) {
        UIManagerModule uiManager = context.getNativeModule(UIManagerModule.class);
        uiManager.addUIBlock(new UIBlock() {
            @Override
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                final RNCameraView cameraView;

                try {
                    cameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(viewTag);
                    if (cameraView.isCameraOpened()) {
                        cameraView.pauseRecording();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void resumeRecording(final int viewTag, final ReactApplicationContext context) {
        UIManagerModule uiManager = context.getNativeModule(UIManagerModule.class);
        uiManager.addUIBlock(new UIBlock() {
            @Override
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                final RNCameraView cameraView;

                try {
                    cameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(viewTag);
                    if (cameraView.isCameraOpened()) {
                        cameraView.resumeRecording();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void getSupportedRatios(final int viewTag, final Promise promise, final ReactApplicationContext context) {
        UIManagerModule uiManager = context.getNativeModule(UIManagerModule.class);
        uiManager.addUIBlock(new UIBlock() {
            @Override
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                final RNCameraView cameraView;
                try {
                    cameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(viewTag);
                    WritableArray result = Arguments.createArray();
                    if (cameraView.isCameraOpened()) {
                        Set<AspectRatio> ratios = cameraView.getSupportedAspectRatios();
                        for (AspectRatio ratio : ratios) {
                            result.pushString(ratio.toString());
                        }
                        promise.resolve(result);
                    } else {
                        promise.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void getCameraIds(final int viewTag, final Promise promise, final ReactApplicationContext context) {
        UIManagerModule uiManager = context.getNativeModule(UIManagerModule.class);
        uiManager.addUIBlock(new UIBlock() {
            @Override
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                final RNCameraView cameraView;
                try {
                    cameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(viewTag);
                    WritableArray result = Arguments.createArray();
                    List<Properties> ids = cameraView.getCameraIds();
                    for (Properties p : ids) {
                        WritableMap m = new WritableNativeMap();
                        m.putString("id", p.getProperty("id"));
                        m.putInt("type", Integer.valueOf(p.getProperty("type")));
                        result.pushMap(m);
                    }
                    promise.resolve(result);
                } catch (Exception e) {
                    e.printStackTrace();
                    promise.reject("E_CAMERA_FAILED", e.getMessage());
                }
            }
        });
    }

    public static void getAvailablePictureSizes(final String ratio, final int viewTag, final Promise promise, final ReactApplicationContext context) {
        UIManagerModule uiManager = context.getNativeModule(UIManagerModule.class);
        uiManager.addUIBlock(new UIBlock() {
            @Override
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                final RNCameraView cameraView;

                try {
                    cameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(viewTag);
                    WritableArray result = Arguments.createArray();
                    if (cameraView.isCameraOpened()) {
                        SortedSet<Size> sizes = cameraView.getAvailablePictureSizes(AspectRatio.parse(ratio));
                        for (Size size : sizes) {
                            result.pushString(size.toString());
                        }
                        promise.resolve(result);
                    } else {
                        promise.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                    }
                } catch (Exception e) {
                    promise.reject("E_CAMERA_BAD_VIEWTAG", "getAvailablePictureSizesAsync: Expected a Camera component");
                }
            }
        });
    }

    public static void checkIfRecordAudioPermissionsAreDefined(final Promise promise, final ReactApplicationContext context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS);
            if (info.requestedPermissions != null) {
                for (String p : info.requestedPermissions) {
                    if (p.equals(Manifest.permission.RECORD_AUDIO)) {
                        promise.resolve(true);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        promise.resolve(false);
    }

    public static void getSupportedPreviewFpsRange(final int viewTag, final Promise promise, final ReactApplicationContext context) {
        UIManagerModule uiManager = context.getNativeModule(UIManagerModule.class);
        uiManager.addUIBlock(new UIBlock() {
            @Override
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                final RNCameraView cameraView;

                try {
                    cameraView = (RNCameraView) nativeViewHierarchyManager.resolveView(viewTag);
                    WritableArray result = Arguments.createArray();
                    ArrayList<int[]> ranges = cameraView.getSupportedPreviewFpsRange();
                    for (int[] range : ranges) {
                        WritableMap m = new WritableNativeMap();
                        m.putInt("MINIMUM_FPS", range[0]);
                        m.putInt("MAXIMUM_FPS", range[1]);
                        result.pushMap(m);
                    }
                    promise.resolve(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void hasTorch(final Promise promise, final ReactApplicationContext context) {
        promise.resolve(context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH));
    }

    // Helper method to check for corrupted videos on Android
    public static void checkIfVideoIsValid(final String path, final Promise promise, final ReactApplicationContext context) {

        // run in a background thread in order to
        // not block the UI
        new GuardedAsyncTask<Void, Void>(context) {
            @Override
            protected void doInBackgroundGuarded(Void... params) {
                MediaMetadataRetriever retriever = new MediaMetadataRetriever();

                try{
                    try {
                        retriever.setDataSource(path);
                    }
                    catch (Exception e){
                        e.printStackTrace();

                        // if we failed to load the source, also return true
                        // as this may cause false positives.
                        promise.resolve(true);
                        return;
                    }

                    // extract a few values since different devices may only report
                    // certain metadata
                    String hasVideo = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_HAS_VIDEO);
                    String mimeType = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_MIMETYPE);

                    // if we were unable to extract metadata, also return true
                    // since we will otherwise get false positives.
                    //promise.resolve(hasVideo == null || "yes".equals(hasVideo));
                    promise.resolve(hasVideo != null && ("yes".equals(hasVideo) || "true".equals(hasVideo) ||
                            mimeType != null && mimeType.contains("video")));
                }
                finally{
                    // this many fail or may not be available in API < 29
                    try{
                        retriever.release();
                    }
                    catch(Throwable e){}
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
