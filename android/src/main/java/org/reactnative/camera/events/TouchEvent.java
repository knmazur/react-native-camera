package org.reactnative.camera.events;

import androidx.annotation.Nullable;
import androidx.core.util.Pools;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

import org.reactnative.camera.Events;


public class TouchEvent extends Event<TouchEvent> {
    private static final Pools.SynchronizedPool<TouchEvent> EVENTS_POOL =
            new Pools.SynchronizedPool<>(3);

    private int mX;
    private int mY;
    private boolean mIsDoubleTap;

    private TouchEvent(int surfaceId, int viewTag, boolean isDoubleTap, int x, int y) {
        super(surfaceId, viewTag);
        mX = x;
        mY = y;
        mIsDoubleTap = isDoubleTap;
    }

    public static TouchEvent obtain(int surfaceId, int viewTag, boolean isDoubleTap, int x, int y) {
        TouchEvent event = EVENTS_POOL.acquire();
        if (event == null) {
            event = new TouchEvent(surfaceId, viewTag, isDoubleTap, x, y);
        }
        return event;
    }

    @Override
    public short getCoalescingKey() {
        return 0;
    }

    @Override
    public String getEventName() {
        return Events.EVENT_ON_TOUCH.toString();
    }

    @Nullable
    @Override
    protected WritableMap getEventData() {
        WritableMap event = Arguments.createMap();

        event.putInt("target", getViewTag());

        WritableMap touchOrigin = Arguments.createMap();
        touchOrigin.putInt("x", mX);
        touchOrigin.putInt("y", mY);

        event.putBoolean("isDoubleTap", mIsDoubleTap);
        event.putMap("touchOrigin", touchOrigin);
        return event;
    }
}
