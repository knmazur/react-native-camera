package org.reactnative.camera.events;

import androidx.annotation.Nullable;
import androidx.core.util.Pools;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

import org.reactnative.camera.Events;

public class CameraReadyEvent extends Event<CameraReadyEvent> {
    private static final Pools.SynchronizedPool<CameraReadyEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);

    private CameraReadyEvent(int surfaceId, int viewTag) {
        super(surfaceId, viewTag);
    }

    public static CameraReadyEvent obtain(int surfaceId, int viewTag) {
        CameraReadyEvent event = EVENTS_POOL.acquire();
        if (event == null) {
            event = new CameraReadyEvent(surfaceId, viewTag);
        }
        return event;
    }

    @Override
    public short getCoalescingKey() {
        return 0;
    }

    @Override
    public String getEventName() {
        return Events.EVENT_CAMERA_READY.toString();
    }

    @Nullable
    @Override
    protected WritableMap getEventData() {
        return Arguments.createMap();
    }
}
