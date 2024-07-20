package org.reactnative.camera.events;

import androidx.annotation.Nullable;
import androidx.core.util.Pools;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

import org.reactnative.camera.Events;

public class CameraMountErrorEvent extends Event<CameraMountErrorEvent> {
    private static final Pools.SynchronizedPool<CameraMountErrorEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);
    private String mError;

    private CameraMountErrorEvent(int surfaceId, int viewTag, String error) {
        super(surfaceId, viewTag);
        mError = error;
    }

    public static CameraMountErrorEvent obtain(int surfaceId, int viewTag, String error) {
        CameraMountErrorEvent event = EVENTS_POOL.acquire();
        if (event == null) {
            event = new CameraMountErrorEvent(surfaceId, viewTag, error);
        }

        return event;
    }


    @Override
    public short getCoalescingKey() {
        return 0;
    }

    @Override
    public String getEventName() {
        return Events.EVENT_ON_MOUNT_ERROR.toString();
    }

    @Nullable
    @Override
    protected WritableMap getEventData() {
        WritableMap arguments = Arguments.createMap();
        arguments.putString("message", mError);
        return arguments;
    }
}
