/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.reactnative.camera;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.google.android.cameraview.AspectRatio;
import com.google.zxing.BarcodeFormat;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface Constants {

  AspectRatio DEFAULT_ASPECT_RATIO = AspectRatio.of(4, 3);

  int FACING_BACK = 0;
  int FACING_FRONT = 1;

  int FLASH_OFF = 0;
  int FLASH_ON = 1;
  int FLASH_TORCH = 2;
  int FLASH_AUTO = 3;
  int FLASH_RED_EYE = 4;

  int LANDSCAPE_90 = 90;
  int LANDSCAPE_270 = 270;

  int WB_AUTO = 0;
  int WB_CLOUDY = 1;
  int WB_SUNNY = 2;
  int WB_SHADOW = 3;
  int WB_FLUORESCENT = 4;
  int WB_INCANDESCENT = 5;

  int ORIENTATION_AUTO = 0;
  int ORIENTATION_UP = 1;
  int ORIENTATION_DOWN = 2;
  int ORIENTATION_LEFT = 3;
  int ORIENTATION_RIGHT = 4;

  static final int VIDEO_2160P = 0;
  static final int VIDEO_1080P = 1;
  static final int VIDEO_720P = 2;
    int VIDEO_480P = 3;
   final int VIDEO_4x3 = 4;

  static final int GOOGLE_VISION_BARCODE_MODE_NORMAL = 0;
  static final int GOOGLE_VISION_BARCODE_MODE_ALTERNATE = 1;
  static final int GOOGLE_VISION_BARCODE_MODE_INVERTED = 2;

  public static final Map<String, Object> VALID_BARCODE_TYPES =
          Collections.unmodifiableMap(new HashMap<String, Object>() {
            {
              put("aztec", BarcodeFormat.AZTEC.toString());
              put("ean13", BarcodeFormat.EAN_13.toString());
              put("ean8", BarcodeFormat.EAN_8.toString());
              put("qr", BarcodeFormat.QR_CODE.toString());
              put("pdf417", BarcodeFormat.PDF_417.toString());
              put("upc_e", BarcodeFormat.UPC_E.toString());
              put("datamatrix", BarcodeFormat.DATA_MATRIX.toString());
              put("code39", BarcodeFormat.CODE_39.toString());
              put("code93", BarcodeFormat.CODE_93.toString());
              put("interleaved2of5", BarcodeFormat.ITF.toString());
              put("codabar", BarcodeFormat.CODABAR.toString());
              put("code128", BarcodeFormat.CODE_128.toString());
              put("maxicode", BarcodeFormat.MAXICODE.toString());
              put("rss14", BarcodeFormat.RSS_14.toString());
              put("rssexpanded", BarcodeFormat.RSS_EXPANDED.toString());
              put("upc_a", BarcodeFormat.UPC_A.toString());
              put("upc_ean", BarcodeFormat.UPC_EAN_EXTENSION.toString());
            }
          });
}
