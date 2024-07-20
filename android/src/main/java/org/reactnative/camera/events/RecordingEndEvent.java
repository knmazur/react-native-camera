package org.reactnative.camera.events;

import androidx.annotation.Nullable;
import androidx.core.util.Pools;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

import org.reactnative.camera.Events;

public class RecordingEndEvent extends Event<RecordingEndEvent> {
    private static final Pools.SynchronizedPool<RecordingEndEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);

    private RecordingEndEvent(int surfaceId, int viewTag) {
        super(surfaceId, viewTag);
    }

    public static RecordingEndEvent obtain(int surfaceId, int viewTag) {
        RecordingEndEvent event = EVENTS_POOL.acquire();
        if (event == null) {
            event = new RecordingEndEvent(surfaceId, viewTag);
        }
        return event;
    }

    @Override
    public short getCoalescingKey() {
        return 0;
    }

    @Override
    public String getEventName() {
        return Events.EVENT_ON_RECORDING_END.toString();
    }

    @Nullable
    @Override
    protected WritableMap getEventData() {
        return Arguments.createMap();
    }
}
