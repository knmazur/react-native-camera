package org.reactnative.camera.events;

import androidx.annotation.Nullable;
import androidx.core.util.Pools;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

import org.reactnative.camera.Events;

public class RecordingStartEvent extends Event<RecordingStartEvent> {
    private static final Pools.SynchronizedPool<RecordingStartEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);

    private RecordingStartEvent(int surfaceId, int viewTag, WritableMap response) {
        super(surfaceId, viewTag);
        mResponse = response;
    }

    private WritableMap mResponse;

    public static RecordingStartEvent obtain(int surfaceId, int viewTag, WritableMap response) {
        RecordingStartEvent event = EVENTS_POOL.acquire();
        if (event == null) {
            event = new RecordingStartEvent(surfaceId, viewTag, response);
        }
        return event;
    }

    @Override
    public String getEventName() {
        return Events.EVENT_ON_RECORDING_START.toString();
    }

    @Nullable
    @Override
    protected WritableMap getEventData() {
        return mResponse;
    }
}
