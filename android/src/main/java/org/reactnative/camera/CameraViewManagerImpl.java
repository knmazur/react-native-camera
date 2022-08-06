package org.reactnative.camera;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.google.android.cameraview.AspectRatio;
import com.google.android.cameraview.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CameraViewManagerImpl {
    public static final String NAME = "RNCamera";

    @Nullable
    public static Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder<String, Object> builder = MapBuilder.builder();
        for (Events event : Events.values()) {
            builder.put("top" + event.toString(), MapBuilder.of("registrationName", event.toString()));
        }
        return builder.build();
    }

    public static void setType(RNCameraView view, int type) {
        view.setFacing(type);
    }

    public static void setCameraId(RNCameraView view, String id) {
        view.setCameraId(id);
    }

    public static void setRatio(RNCameraView view, String ratio) {
        view.setAspectRatio(AspectRatio.parse(ratio));
    }

    public static void setFlashMode(RNCameraView view, int torchMode) {
        view.setFlash(torchMode);
    }

    public static void setExposureCompensation(RNCameraView view, float exposure){
        view.setExposureCompensation(exposure);
    }

    public static void setAutoFocus(RNCameraView view, boolean autoFocus) {
        view.setAutoFocus(autoFocus);
    }

    public static void setFocusDepth(RNCameraView view, float depth) {
        view.setFocusDepth(depth);
    }

    public static void setAutoFocusPointOfInterest(RNCameraView view, ReadableMap coordinates) {
        if(coordinates != null){
            float x = (float) coordinates.getDouble("x");
            float y = (float) coordinates.getDouble("y");
            view.setAutoFocusPointOfInterest(x, y);
        }
    }

    public static void setZoom(RNCameraView view, float zoom) {
        view.setZoom(zoom);
    }

    public static void setUseNativeZoom(RNCameraView view, boolean useNativeZoom) {
        view.setUseNativeZoom(useNativeZoom);
    }

    public static void setWhiteBalance(RNCameraView view, int whiteBalance) {
        view.setWhiteBalance(whiteBalance);
    }

    public static void setPictureSize(RNCameraView view, String size) {
        view.setPictureSize(size.equals("None") ? null : Size.parse(size));
    }

    public static void setPlaySoundOnCapture(RNCameraView view, boolean playSoundOnCapture) {
        view.setPlaySoundOnCapture(playSoundOnCapture);
    }

    public static void setPlaySoundOnRecord(RNCameraView view, boolean playSoundOnRecord) {
        view.setPlaySoundOnRecord(playSoundOnRecord);
    }

    public static void setBarCodeTypes(RNCameraView view, ReadableArray barCodeTypes) {
        if (barCodeTypes == null) {
            return;
        }
        List<String> result = new ArrayList<>(barCodeTypes.size());
        for (int i = 0; i < barCodeTypes.size(); i++) {
            result.add(barCodeTypes.getString(i));
        }
        view.setBarCodeTypes(result);
    }

    public static void setDetectedImageInEvent(RNCameraView view, boolean detectedImageInEvent) {
        view.setDetectedImageInEvent(detectedImageInEvent);
    }

    public static void setBarCodeScanning(RNCameraView view, boolean barCodeScannerEnabled) {
        view.setShouldScanBarCodes(barCodeScannerEnabled);
    }

    public static void setUseCamera2Api(RNCameraView view, boolean useCamera2Api) {
        view.setUsingCamera2Api(useCamera2Api);
    }

    public static void setTouchDetectorEnabled(RNCameraView view, boolean touchDetectorEnabled) {
        view.setShouldDetectTouches(touchDetectorEnabled);
    }

    public static void setFaceDetecting(RNCameraView view, boolean faceDetectorEnabled) {
        view.setShouldDetectFaces(faceDetectorEnabled);
    }

    public static void setFaceDetectionMode(RNCameraView view, int mode) {
        view.setFaceDetectionMode(mode);
    }

    public static void setFaceDetectionLandmarks(RNCameraView view, int landmarks) {
        view.setFaceDetectionLandmarks(landmarks);
    }

    public static void setFaceDetectionClassifications(RNCameraView view, int classifications) {
        view.setFaceDetectionClassifications(classifications);
    }

    public static void setTracking(RNCameraView view, boolean trackingEnabled) {
        view.setTracking(trackingEnabled);
    }

    public static void setGoogleVisionBarcodeDetecting(RNCameraView view, boolean googleBarcodeDetectorEnabled) {
        view.setShouldGoogleDetectBarcodes(googleBarcodeDetectorEnabled);
    }

    public static void setGoogleVisionBarcodeType(RNCameraView view, int barcodeType) {
        view.setGoogleVisionBarcodeType(barcodeType);
    }

    public static void setGoogleVisionBarcodeMode(RNCameraView view, int barcodeMode) {
        view.setGoogleVisionBarcodeMode(barcodeMode);
    }

    public static void setTextRecognizing(RNCameraView view, boolean textRecognizerEnabled) {
        view.setShouldRecognizeText(textRecognizerEnabled);
    }

    /**---limit scan area addition---**/
    public static void setRectOfInterest(RNCameraView view, ReadableMap coordinates) {
        if(coordinates != null){
            float x = (float) coordinates.getDouble("x");
            float y = (float) coordinates.getDouble("y");
            float width = (float) coordinates.getDouble("width");
            float height = (float) coordinates.getDouble("height");
            view.setRectOfInterest(x, y, width, height);
        }
    }

    public static void setCameraViewDimensions(RNCameraView view, ReadableMap dimensions) {
        if(dimensions != null){
            int cameraViewWidth = (int) dimensions.getDouble("width");
            int cameraViewHeight = (int) dimensions.getDouble("height");
            view.setCameraViewDimensions(cameraViewWidth, cameraViewHeight);
        }
    }
}
