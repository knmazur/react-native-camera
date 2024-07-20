package org.reactnative.camera.events;

import androidx.annotation.Nullable;
import androidx.core.util.Pools;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

import org.reactnative.camera.Events;

public class PictureTakenEvent extends Event<PictureTakenEvent> {
    private static final Pools.SynchronizedPool<PictureTakenEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);

    private PictureTakenEvent(int surfaceId, int viewTag) {
        super(surfaceId, viewTag);
    }

    public static PictureTakenEvent obtain(int surfaceId, int viewTag) {
        PictureTakenEvent event = EVENTS_POOL.acquire();
        if (event == null) {
            event = new PictureTakenEvent(surfaceId, viewTag);
        }
        return event;
    }

    @Override
    public short getCoalescingKey() {
        return 0;
    }

    @Override
    public String getEventName() {
        return Events.EVENT_ON_PICTURE_TAKEN.toString();
    }

    @Nullable
    @Override
    protected WritableMap getEventData() {
        return Arguments.createMap();
    }
}
