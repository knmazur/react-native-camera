package org.reactnative.camera;

import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.google.zxing.BarcodeFormat;

import org.reactnative.barcodedetector.BarcodeFormatUtils;
import org.reactnative.facedetector.RNFaceDetector;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TurboConstants {
    private WritableMap getFaceDetectionModeConstants() {
        WritableMap result = Arguments.createMap();
        result.putInt("fast", RNFaceDetector.FAST_MODE);
        result.putInt("accurate", RNFaceDetector.ACCURATE_MODE);
        return result;
    }

    private WritableMap getFaceDetectionClassificationsConstants() {
        WritableMap result = Arguments.createMap();
        result.putInt("all", RNFaceDetector.ALL_CLASSIFICATIONS);
        result.putInt("none", RNFaceDetector.NO_CLASSIFICATIONS);
        return result;
    }

    private WritableMap getFaceDetectionLandmarksConstants() {
        WritableMap result = Arguments.createMap();
        result.putInt("all", RNFaceDetector.ALL_LANDMARKS);
        result.putInt("none", RNFaceDetector.NO_LANDMARKS);
        return result;

    }

    private WritableMap getTypeConstants() {
        WritableMap result = Arguments.createMap();
        result.putInt("front", Constants.FACING_FRONT);
        result.putInt("back", Constants.FACING_BACK);
        return result;
    }

    private WritableMap getFlashModeConstants() {
        WritableMap result = Arguments.createMap();
        result.putInt("off", Constants.FLASH_OFF);
        result.putInt("on", Constants.FLASH_ON);
        result.putInt("auto", Constants.FLASH_AUTO);
        result.putInt("torch", Constants.FLASH_TORCH);
        return result;
    }

    private WritableMap getAutoFocusConstants() {
        WritableMap result = Arguments.createMap();
        result.putBoolean("on", true);
        result.putBoolean("off", false);
        return result;
    }

    private WritableMap getWhiteBalanceConstants() {
        WritableMap result = Arguments.createMap();
        result.putInt("auto", Constants.WB_AUTO);
        result.putInt("cloudy", Constants.WB_CLOUDY);
        result.putInt("sunny", Constants.WB_SUNNY);
        result.putInt("shadow", Constants.WB_SHADOW);
        result.putInt("fluorescent", Constants.WB_FLUORESCENT);
        result.putInt("incandescent", Constants.WB_INCANDESCENT);
        return result;
    }

    private WritableMap getVideoQualityConstants() {
        WritableMap result = Arguments.createMap();
        result.putInt("2160p", Constants.VIDEO_2160P);
        result.putInt("1080p", Constants.VIDEO_1080P);
        result.putInt("720p", Constants.VIDEO_720P);
        result.putInt("480p", Constants.VIDEO_480P);
        result.putInt("4:3", Constants.VIDEO_4x3);
        return result;
    }

    private WritableMap getGoogleVisionBarcodeModeConstants() {
        WritableMap result = Arguments.createMap();
        result.putInt("NORMAL", Constants.GOOGLE_VISION_BARCODE_MODE_NORMAL);
        result.putInt("ALTERNATE", Constants.GOOGLE_VISION_BARCODE_MODE_ALTERNATE);
        result.putInt("INVERTED", Constants.GOOGLE_VISION_BARCODE_MODE_INVERTED);
        return result;
    }

    private WritableMap getBarCodeConstants() {
        WritableMap result = Arguments.createMap();
        result.putString("aztec", BarcodeFormat.AZTEC.toString());
        result.putString("ean13", BarcodeFormat.EAN_13.toString());
        result.putString("ean8", BarcodeFormat.EAN_8.toString());
        result.putString("qr", BarcodeFormat.QR_CODE.toString());
        result.putString("pdf417", BarcodeFormat.PDF_417.toString());
        result.putString("upc_e", BarcodeFormat.UPC_E.toString());
        result.putString("datamatrix", BarcodeFormat.DATA_MATRIX.toString());
        result.putString("code39", BarcodeFormat.CODE_39.toString());
        result.putString("code93", BarcodeFormat.CODE_93.toString());
        result.putString("interleaved2of5", BarcodeFormat.ITF.toString());
        result.putString("codabar", BarcodeFormat.CODABAR.toString());
        result.putString("code128", BarcodeFormat.CODE_128.toString());
        result.putString("maxicode", BarcodeFormat.MAXICODE.toString());
        result.putString("rss14", BarcodeFormat.RSS_14.toString());
        result.putString("rssexpanded", BarcodeFormat.RSS_EXPANDED.toString());
        result.putString("upc_a", BarcodeFormat.UPC_A.toString());
        result.putString("upc_ean", BarcodeFormat.UPC_EAN_EXTENSION.toString());
        return result;

    }

    private WritableMap getOrientationConstants() {
        WritableMap result = Arguments.createMap();
        result.putInt("auto", Constants.ORIENTATION_AUTO);
        result.putInt("portrait", Constants.ORIENTATION_UP);
        result.putInt("portraitUpsideDown", Constants.ORIENTATION_DOWN);
        result.putInt("landscapeLeft", Constants.ORIENTATION_LEFT);
        result.putInt("landscapeRight", Constants.ORIENTATION_RIGHT);
        return result;
    }

    private WritableMap getFaceDetectionConstants() {
        WritableMap result = Arguments.createMap();
        result.putMap("Mode", getFaceDetectionModeConstants());
        result.putMap("Landmarks", getFaceDetectionLandmarksConstants());
        result.putMap("Classifications", getFaceDetectionClassificationsConstants());
        return result;
    }

    private WritableMap getGoogleVisionBarcodeDetectionConstants() {
        WritableMap result = Arguments.createMap();
        result.putMap("BarcodeMode", getGoogleVisionBarcodeModeConstants());
        return result;
    }

    public WritableMap getConstants() {
        WritableMap result = Arguments.createMap();

        result.putMap("Type", getTypeConstants());
        result.putMap("FlashMode", getFlashModeConstants());
        result.putMap("AutoFocus", getAutoFocusConstants());
        result.putMap("WhiteBalance", getWhiteBalanceConstants());
        result.putMap("VideoQuality", getVideoQualityConstants());
        result.putMap("BarCodeType", getBarCodeConstants());

        result.putMap("Orientation", getOrientationConstants());
        result.putMap("FaceDetection", getFaceDetectionConstants());

        return result;
    }
}
