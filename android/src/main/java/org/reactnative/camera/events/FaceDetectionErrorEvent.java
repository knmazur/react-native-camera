package org.reactnative.camera.events;

import androidx.annotation.Nullable;
import androidx.core.util.Pools;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

import org.reactnative.camera.Events;
import org.reactnative.facedetector.RNFaceDetector;

public class FaceDetectionErrorEvent extends Event<FaceDetectionErrorEvent> {
    private static final Pools.SynchronizedPool<FaceDetectionErrorEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);
    private RNFaceDetector mFaceDetector;

    private FaceDetectionErrorEvent(int surfaceId, int viewTag, RNFaceDetector faceDetector) {
        super(surfaceId, viewTag);
        mFaceDetector = faceDetector;
    }

    public static FaceDetectionErrorEvent obtain(int surfaceId, int viewTag, RNFaceDetector faceDetector) {
        FaceDetectionErrorEvent event = EVENTS_POOL.acquire();
        if (event == null) {
            event = new FaceDetectionErrorEvent(surfaceId, viewTag, faceDetector);
        }
        return event;
    }


    @Override
    public short getCoalescingKey() {
        return 0;
    }

    @Override
    public String getEventName() {
        return Events.EVENT_ON_FACE_DETECTION_ERROR.toString();
    }

    @Nullable
    @Override
    protected WritableMap getEventData() {
        WritableMap map = Arguments.createMap();
        map.putBoolean("isOperational", mFaceDetector != null && mFaceDetector.isOperational());
        return map;
    }
}
