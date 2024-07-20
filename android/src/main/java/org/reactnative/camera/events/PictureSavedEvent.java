package org.reactnative.camera.events;

import androidx.annotation.Nullable;
import androidx.core.util.Pools;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

import org.reactnative.camera.Events;

public class PictureSavedEvent extends Event<PictureSavedEvent> {
    private static final Pools.SynchronizedPool<PictureSavedEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(5);

    private PictureSavedEvent(int surfaceId, int viewTag, WritableMap response) {
        super(surfaceId, viewTag);
        mResponse = response;
    }

    private WritableMap mResponse;

    public static PictureSavedEvent obtain(int surfaceId, int viewTag, WritableMap response) {
        PictureSavedEvent event = EVENTS_POOL.acquire();
        if (event == null) {
            event = new PictureSavedEvent(surfaceId, viewTag, response);
        }
        return event;
    }

    @Override
    public short getCoalescingKey() {
        int hashCode = mResponse.getMap("data").getString("uri").hashCode() % Short.MAX_VALUE;
        return (short) hashCode;
    }

    @Override
    public String getEventName() {
        return Events.EVENT_ON_PICTURE_SAVED.toString();
    }

    @Nullable
    @Override
    protected WritableMap getEventData() {
        return mResponse;
    }
}
