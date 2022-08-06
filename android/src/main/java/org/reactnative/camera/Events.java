package org.reactnative.camera;

public enum Events {
    EVENT_CAMERA_READY("onCameraReady"),
    EVENT_ON_MOUNT_ERROR("onMountError"),
    EVENT_ON_BAR_CODE_READ("onBarCodeRead"),
    EVENT_ON_FACES_DETECTED("onFacesDetected"),
    EVENT_ON_BARCODES_DETECTED("onGoogleVisionBarcodesDetected"),
    EVENT_ON_FACE_DETECTION_ERROR("onFaceDetectionError"),
    EVENT_ON_BARCODE_DETECTION_ERROR("onGoogleVisionBarcodeDetectionError"),
    EVENT_ON_TEXT_RECOGNIZED("onTextRecognized"),
    EVENT_ON_PICTURE_TAKEN("onPictureTaken"),
    EVENT_ON_PICTURE_SAVED("onPictureSaved"),
    EVENT_ON_RECORDING_START("onRecordingStart"),
    EVENT_ON_RECORDING_END("onRecordingEnd"),
    EVENT_ON_TOUCH("onTouch");

    private final String mName;

    Events(final String name) {
        mName = name;
    }

    @Override
    public String toString() {
        return mName;
    }
}