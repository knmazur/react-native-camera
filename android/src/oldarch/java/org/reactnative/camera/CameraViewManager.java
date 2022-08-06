package org.reactnative.camera;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

public class CameraViewManager extends ViewGroupManager<RNCameraView> {
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

  @ReactProp(name = "type")
  public void setType(RNCameraView view, int type) {
    CameraViewManagerImpl.setType(view,type);
  }

  @ReactProp(name = "cameraId")
  public void setCameraId(RNCameraView view, String id) {
    CameraViewManagerImpl.setCameraId(view,id);
  }

  @ReactProp(name = "ratio")
  public void setRatio(RNCameraView view, String ratio) {
    CameraViewManagerImpl.setRatio(view,ratio);
  }

  @ReactProp(name = "flashMode")
  public void setFlashMode(RNCameraView view, int torchMode) {
    CameraViewManagerImpl.setFlashMode(view,torchMode);
  }

  @ReactProp(name = "exposure")
  public void setExposureCompensation(RNCameraView view, float exposure){
    CameraViewManagerImpl.setExposureCompensation(view,exposure);
  }

  @ReactProp(name = "autoFocus")
  public void setAutoFocus(RNCameraView view, boolean autoFocus) {
    CameraViewManagerImpl.setAutoFocus(view,autoFocus);
  }

  @ReactProp(name = "focusDepth")
  public void setFocusDepth(RNCameraView view, float depth) {
    view.setFocusDepth(depth);
  }

  @ReactProp(name = "autoFocusPointOfInterest")
  public void setAutoFocusPointOfInterest(RNCameraView view, ReadableMap coordinates) {
    CameraViewManagerImpl.setAutoFocusPointOfInterest(view,coordinates);
  }

  @ReactProp(name = "zoom")
  public void setZoom(RNCameraView view, float zoom) {
    CameraViewManagerImpl.setZoom(view,zoom);
  }

  @ReactProp(name = "useNativeZoom")
  public void setUseNativeZoom(RNCameraView view, boolean useNativeZoom) {
    CameraViewManagerImpl.setUseNativeZoom(view,useNativeZoom);
  }
  @ReactProp(name = "whiteBalance")
  public void setWhiteBalance(RNCameraView view, int whiteBalance) {
    CameraViewManagerImpl.setWhiteBalance(view,whiteBalance);
  }

  @ReactProp(name = "pictureSize")
  public void setPictureSize(RNCameraView view, String size) {
    CameraViewManagerImpl.setPictureSize(view,size);
  }

  @ReactProp(name = "playSoundOnCapture")
  public void setPlaySoundOnCapture(RNCameraView view, boolean playSoundOnCapture) {
    CameraViewManagerImpl.setPlaySoundOnCapture(view, playSoundOnCapture);
  }

  @ReactProp(name = "playSoundOnRecord")
  public void setPlaySoundOnRecord(RNCameraView view, boolean playSoundOnRecord) {
    CameraViewManagerImpl.setPlaySoundOnRecord(view, playSoundOnRecord);
  }

  @ReactProp(name = "barCodeTypes")
  public void setBarCodeTypes(RNCameraView view, ReadableArray barCodeTypes) {
    CameraViewManagerImpl.setBarCodeTypes(view,barCodeTypes);
  }

  @ReactProp(name = "detectedImageInEvent")
  public void setDetectedImageInEvent(RNCameraView view, boolean detectedImageInEvent) {
    CameraViewManagerImpl.setDetectedImageInEvent(view,detectedImageInEvent);
  }

  @ReactProp(name = "barCodeScannerEnabled")
  public void setBarCodeScanning(RNCameraView view, boolean barCodeScannerEnabled) {
    CameraViewManagerImpl.setBarCodeScanning(view, barCodeScannerEnabled);
  }

  @ReactProp(name = "useCamera2Api")
  public void setUseCamera2Api(RNCameraView view, boolean useCamera2Api) {
    CameraViewManagerImpl.setUseCamera2Api(view,useCamera2Api);
  }

  @ReactProp(name = "touchDetectorEnabled")
  public void setTouchDetectorEnabled(RNCameraView view, boolean touchDetectorEnabled) {
    CameraViewManagerImpl.setTouchDetectorEnabled(view,touchDetectorEnabled);
  }

  @ReactProp(name = "faceDetectorEnabled")
  public void setFaceDetecting(RNCameraView view, boolean faceDetectorEnabled) {
    CameraViewManagerImpl.setFaceDetecting(view,faceDetectorEnabled);
  }

  @ReactProp(name = "faceDetectionMode")
  public void setFaceDetectionMode(RNCameraView view, int mode) {
    CameraViewManagerImpl.setFaceDetectionMode(view,mode);
  }

  @ReactProp(name = "faceDetectionLandmarks")
  public void setFaceDetectionLandmarks(RNCameraView view, int landmarks) {
    CameraViewManagerImpl.setFaceDetectionLandmarks(view,landmarks);
  }

  @ReactProp(name = "faceDetectionClassifications")
  public void setFaceDetectionClassifications(RNCameraView view, int classifications) {
    CameraViewManagerImpl.setFaceDetectionClassifications(view,classifications);
  }

  @ReactProp(name = "trackingEnabled")
  public void setTracking(RNCameraView view, boolean trackingEnabled) {
    CameraViewManagerImpl.setTracking(view,trackingEnabled);
  }

  @ReactProp(name = "googleVisionBarcodeDetectorEnabled")
  public void setGoogleVisionBarcodeDetecting(RNCameraView view, boolean googleBarcodeDetectorEnabled) {
    CameraViewManagerImpl.setGoogleVisionBarcodeDetecting(view, googleBarcodeDetectorEnabled);
  }

  @ReactProp(name = "googleVisionBarcodeType")
  public void setGoogleVisionBarcodeType(RNCameraView view, int barcodeType) {
    CameraViewManagerImpl.setGoogleVisionBarcodeType(view, barcodeType);
  }

  @ReactProp(name = "googleVisionBarcodeMode")
  public void setGoogleVisionBarcodeMode(RNCameraView view, int barcodeMode) {
    CameraViewManagerImpl.setGoogleVisionBarcodeMode(view,barcodeMode);
  }

  @ReactProp(name = "textRecognizerEnabled")
  public void setTextRecognizing(RNCameraView view, boolean textRecognizerEnabled) {
    CameraViewManagerImpl.setTextRecognizing(view,textRecognizerEnabled);
  }

  /**---limit scan area addition---**/
  @ReactProp(name = "rectOfInterest")
  public void setRectOfInterest(RNCameraView view, ReadableMap coordinates) {
    CameraViewManagerImpl.setRectOfInterest(view, coordinates);
  }

  @ReactProp(name = "cameraViewDimensions")
  public void setCameraViewDimensions(RNCameraView view, ReadableMap dimensions) {
    CameraViewManagerImpl.setCameraViewDimensions(view, dimensions);
  }
  /**---limit scan area addition---**/
}
