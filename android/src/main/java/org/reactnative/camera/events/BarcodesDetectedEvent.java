package org.reactnative.camera.events;

import android.util.Base64;

import androidx.annotation.Nullable;
import androidx.core.util.Pools;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

import org.reactnative.camera.Events;

public class BarcodesDetectedEvent extends Event<BarcodesDetectedEvent> {

    private static final Pools.SynchronizedPool<BarcodesDetectedEvent> EVENTS_POOL =
            new Pools.SynchronizedPool<>(3);

    private WritableArray mBarcodes;
    private byte[] mCompressedImage;

    private BarcodesDetectedEvent(int surfaceId,
                                  int viewTag,
                                  WritableArray barcodes,
                                  byte[] compressedImage) {
        super(surfaceId, viewTag);
        mBarcodes = barcodes;
        mCompressedImage = compressedImage;
    }

    public static BarcodesDetectedEvent obtain(
            int surfaceId,
            int viewTag,
            WritableArray barcodes,
            byte[] compressedImage) {
        BarcodesDetectedEvent event = EVENTS_POOL.acquire();
        if (event == null) {
            event = new BarcodesDetectedEvent(surfaceId, viewTag, barcodes, compressedImage);
        }

        return event;
    }


    /**
     * note(@sjchmiela)
     * Should the events about detected barcodes coalesce, the best strategy will be
     * to ensure that events with different barcodes count are always being transmitted.
     */
    @Override
    public short getCoalescingKey() {
        if (mBarcodes.size() > Short.MAX_VALUE) {
            return Short.MAX_VALUE;
        }

        return (short) mBarcodes.size();
    }

    @Override
    public String getEventName() {
        return Events.EVENT_ON_BARCODES_DETECTED.toString();
    }

    @Nullable
    @Override
    protected WritableMap getEventData() {
        WritableMap event = Arguments.createMap();
        event.putString("type", "barcode");
        event.putArray("barcodes", Arguments.makeNativeArray(mBarcodes.toArrayList().toArray()));
        event.putInt("target", getViewTag());
        if (mCompressedImage != null) {
            event.putString("image", Base64.encodeToString(mCompressedImage, Base64.NO_WRAP));
        }
        return event;
    }
}
