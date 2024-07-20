package org.reactnative.camera.events;

import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import org.reactnative.barcodedetector.RNBarcodeDetector;
import org.reactnative.camera.Events;

public class BarcodeDetectionErrorEvent extends Event<BarcodeDetectionErrorEvent> {

  private static final Pools.SynchronizedPool<BarcodeDetectionErrorEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);
  private final  RNBarcodeDetector mBarcodeDetector;

  private BarcodeDetectionErrorEvent(int surfaceId, int viewTag, RNBarcodeDetector barcodeDetector) {
    super(surfaceId, viewTag);
    mBarcodeDetector = barcodeDetector;
  }

  public static BarcodeDetectionErrorEvent obtain(int surfaceId, int viewTag, RNBarcodeDetector barcodeDetector) {
    BarcodeDetectionErrorEvent event = EVENTS_POOL.acquire();
    if (event == null) {
      event = new BarcodeDetectionErrorEvent(surfaceId, viewTag, barcodeDetector);
    }
    return event;
  }


  @Override
  public short getCoalescingKey() {
    return 0;
  }

  @Override
  public String getEventName() {
    return Events.EVENT_ON_BARCODE_DETECTION_ERROR.toString();
  }

  @Nullable
  @Override
  protected WritableMap getEventData() {
    WritableMap map = Arguments.createMap();
    map.putBoolean("isOperational", mBarcodeDetector != null && mBarcodeDetector.isOperational());
    return map;
  }
}
