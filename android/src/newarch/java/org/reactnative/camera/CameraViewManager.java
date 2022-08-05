package org.reactnative.camera;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.module.annotations.ReactModule;

import com.facebook.react.viewmanagers.RNCameraManagerInterface;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNCameraManagerDelegate;

import java.util.Map;

@ReactModule(name = CameraViewManagerImpl.NAME)
public class CameraViewManager extends ViewGroupManager<RNCameraView> implements RNCameraManagerInterface<RNCameraView> {
  public enum Events {
    EVENT_CAMERA_READY("topOnCameraReady"),
    EVENT_ON_MOUNT_ERROR("topOnMountError"),
    EVENT_ON_BAR_CODE_READ("topOnBarCodeRead"),
    EVENT_ON_FACES_DETECTED("topOnFacesDetected"),
    EVENT_ON_BARCODES_DETECTED("topOnGoogleVisionBarcodesDetected"),
    EVENT_ON_FACE_DETECTION_ERROR("topOnFaceDetectionError"),
    EVENT_ON_BARCODE_DETECTION_ERROR("topOnGoogleVisionBarcodeDetectionError"),
    EVENT_ON_TEXT_RECOGNIZED("topOnTextRecognized"),
    EVENT_ON_PICTURE_TAKEN("topOnPictureTaken"),
    EVENT_ON_PICTURE_SAVED("topOnPictureSaved"),
    EVENT_ON_RECORDING_START("topOnRecordingStart"),
    EVENT_ON_RECORDING_END("topOnRecordingEnd"),
    EVENT_ON_TOUCH("topOnTouch");


    private final String mName;

    Events(final String name) {
      mName = name;
    }

    @Override
    public String toString() {
      return mName;
    }
  }

  private final ViewManagerDelegate<RNCameraView> mDelegate;

  public CameraViewManager() {
      mDelegate = new RNCameraManagerDelegate<>(this);
  }

  @Nullable
  @Override
  protected ViewManagerDelegate<RNCameraView> getDelegate() {
      return mDelegate;
  }

  @Override
  public void onDropViewInstance(RNCameraView view) {
    view.onHostDestroy();
    super.onDropViewInstance(view);
  }

  @Override
  public String getName() {
    return CameraViewManagerImpl.NAME;
  }

  @Override
  protected RNCameraView createViewInstance(ThemedReactContext themedReactContext) {
    return new RNCameraView(themedReactContext);
  }

  @Override
  @Nullable
  public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
    return CameraViewManagerImpl.getExportedCustomDirectEventTypeConstants();
  }

  @Override
  @ReactProp(name = "type")
  public void setType(RNCameraView view, int type) {
   // CameraViewManagerImpl.setType(view,type);
  }

  @Override
  @ReactProp(name = "cameraId")
  public void setCameraId(RNCameraView view, String id) {
   // CameraViewManagerImpl.setCameraId(view,id);
  }

  @Override
  @ReactProp(name = "ratio")
  public void setRatio(RNCameraView view, String ratio) {
    //CameraViewManagerImpl.setRatio(view,ratio);
  }

  @Override
  @ReactProp(name = "flashMode")
  public void setFlashMode(RNCameraView view, int torchMode) {
    //CameraViewManagerImpl.setFlashMode(view,torchMode);
  }

  @Override
  @ReactProp(name = "exposure")
  public void setExposure(RNCameraView view, float exposure){
   // CameraViewManagerImpl.setExposureCompensation(view,exposure);
  }

  @Override
  @ReactProp(name = "autoFocus")
  public void setAutoFocus(RNCameraView view, boolean autoFocus) {
    //CameraViewManagerImpl.setAutoFocus(view,autoFocus);
  }

  @Override
  @ReactProp(name = "focusDepth")
  public void setFocusDepth(RNCameraView view, float depth) {
    //view.setFocusDepth(depth);
  }

  @Override
  @ReactProp(name = "autoFocusPointOfInterest")
  public void setAutoFocusPointOfInterest(RNCameraView view, ReadableMap coordinates) {
    //CameraViewManagerImpl.setAutoFocusPointOfInterest(view,coordinates);
  }

  @Override
  @ReactProp(name = "zoom")
  public void setZoom(RNCameraView view, float zoom) {
    //CameraViewManagerImpl.setZoom(view,zoom);
  }

  @Override
  @ReactProp(name = "useNativeZoom")
  public void setUseNativeZoom(RNCameraView view, boolean useNativeZoom) {
    //CameraViewManagerImpl.setUseNativeZoom(view,useNativeZoom);
  }

  @Override
  @ReactProp(name = "whiteBalance")
  public void setWhiteBalance(RNCameraView view, int whiteBalance) {
    //CameraViewManagerImpl.setWhiteBalance(view,whiteBalance);
  }

  @Override
  @ReactProp(name = "pictureSize")
  public void setPictureSize(RNCameraView view, String size) {
    //CameraViewManagerImpl.setPictureSize(view,size);
  }

  @Override
  @ReactProp(name = "playSoundOnCapture")
  public void setPlaySoundOnCapture(RNCameraView view, boolean playSoundOnCapture) {
    //CameraViewManagerImpl.setPlaySoundOnCapture(view, playSoundOnCapture);
  }

  @Override
  @ReactProp(name = "playSoundOnRecord")
  public void setPlaySoundOnRecord(RNCameraView view, boolean playSoundOnRecord) {
    //CameraViewManagerImpl.setPlaySoundOnRecord(view, playSoundOnRecord);
  }

  @Override
  @ReactProp(name = "barCodeTypes")
  public void setBarCodeTypes(RNCameraView view, ReadableArray barCodeTypes) {
    //CameraViewManagerImpl.setBarCodeTypes(view,barCodeTypes);
  }

  @Override
  @ReactProp(name = "detectedImageInEvent")
  public void setDetectedImageInEvent(RNCameraView view, boolean detectedImageInEvent) {
    //CameraViewManagerImpl.setDetectedImageInEvent(view,detectedImageInEvent);
  }

  @Override
  @ReactProp(name = "barCodeScannerEnabled")
  public void setBarCodeScannerEnabled(RNCameraView view, boolean barCodeScannerEnabled) {
    //CameraViewManagerImpl.setBarCodeScanning(view, barCodeScannerEnabled);
  }

  @Override
  @ReactProp(name = "useCamera2Api")
  public void setUseCamera2Api(RNCameraView view, boolean useCamera2Api) {
    //CameraViewManagerImpl.setUseCamera2Api(view,useCamera2Api);
  }

  @Override
  @ReactProp(name = "touchDetectorEnabled")
  public void setTouchDetectorEnabled(RNCameraView view, boolean touchDetectorEnabled) {
    //CameraViewManagerImpl.setTouchDetectorEnabled(view,touchDetectorEnabled);
  }

  @Override
  @ReactProp(name = "faceDetectorEnabled")
  public void setFaceDetectorEnabled(RNCameraView view, boolean faceDetectorEnabled) {
   // CameraViewManagerImpl.setFaceDetecting(view,faceDetectorEnabled);
  }

  @Override
  @ReactProp(name = "faceDetectionMode")
  public void setFaceDetectionMode(RNCameraView view, int mode) {
    //CameraViewManagerImpl.setFaceDetectionMode(view,mode);
  }

  @Override
  @ReactProp(name = "faceDetectionLandmarks")
  public void setFaceDetectionLandmarks(RNCameraView view, int landmarks) {
    //CameraViewManagerImpl.setFaceDetectionLandmarks(view,landmarks);
  }

  @Override
  @ReactProp(name = "faceDetectionClassifications")
  public void setFaceDetectionClassifications(RNCameraView view, int classifications) {
    //CameraViewManagerImpl.setFaceDetectionClassifications(view,classifications);
  }

  @Override
  @ReactProp(name = "trackingEnabled")
  public void setTrackingEnabled(RNCameraView view, boolean trackingEnabled) {
    //CameraViewManagerImpl.setTracking(view,trackingEnabled);
  }

  @Override
  @ReactProp(name = "googleVisionBarcodeDetectorEnabled")
  public void setGoogleVisionBarcodeDetectorEnabled(RNCameraView view, boolean googleBarcodeDetectorEnabled) {
    //CameraViewManagerImpl.setGoogleVisionBarcodeDetecting(view, googleBarcodeDetectorEnabled);
  }

  @Override
  @ReactProp(name = "googleVisionBarcodeType")
  public void setGoogleVisionBarcodeType(RNCameraView view, int barcodeType) {
    //CameraViewManagerImpl.setGoogleVisionBarcodeType(view, barcodeType);
  }

  @Override
  @ReactProp(name = "googleVisionBarcodeMode")
  public void setGoogleVisionBarcodeMode(RNCameraView view, int barcodeMode) {
    //CameraViewManagerImpl.setGoogleVisionBarcodeMode(view,barcodeMode);
  }

  @Override
  @ReactProp(name = "textRecognizerEnabled")
  public void setTextRecognizerEnabled(RNCameraView view, boolean textRecognizerEnabled) {
    //CameraViewManagerImpl.setTextRecognizing(view,textRecognizerEnabled);
  }

  /**---limit scan area addition---**/
  @Override
  @ReactProp(name = "rectOfInterest")
  public void setRectOfInterest(RNCameraView view, ReadableMap coordinates) {
    //CameraViewManagerImpl.setRectOfInterest(view, coordinates);
  }

  @Override
  @ReactProp(name = "cameraViewDimensions")
  public void setCameraViewDimensions(RNCameraView view, ReadableMap dimensions) {
    //CameraViewManagerImpl.setCameraViewDimensions(view, dimensions);
  }
  /**---limit scan area addition---**/
}