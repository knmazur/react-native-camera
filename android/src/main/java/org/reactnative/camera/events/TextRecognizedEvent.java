package org.reactnative.camera.events;

import androidx.annotation.Nullable;
import androidx.core.util.Pools;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

import org.reactnative.camera.Events;


public class TextRecognizedEvent extends Event<TextRecognizedEvent> {

    private static final Pools.SynchronizedPool<TextRecognizedEvent> EVENTS_POOL =
            new Pools.SynchronizedPool<>(3);

    private WritableArray mData;

    private TextRecognizedEvent(int surfaceId, int viewTag, WritableArray data) {
        super(surfaceId, viewTag);
        mData = data;
    }

    public static TextRecognizedEvent obtain(int surfaceId, int viewTag, WritableArray data) {
        TextRecognizedEvent event = EVENTS_POOL.acquire();
        if (event == null) {
            event = new TextRecognizedEvent(surfaceId, viewTag, data);
        }
        return event;
    }

    @Override
    public String getEventName() {
        return Events.EVENT_ON_TEXT_RECOGNIZED.toString();
    }

    @Nullable
    @Override
    protected WritableMap getEventData() {
        WritableMap event = Arguments.createMap();
        event.putString("type", "textBlock");
        event.putArray("textBlocks", mData);
        event.putInt("target", getViewTag());
        return event;
    }
}
