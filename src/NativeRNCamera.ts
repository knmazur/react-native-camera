// @flow
import type { TurboModule } from 'react-native/Libraries/TurboModule/RCTExport';
import { TurboModuleRegistry } from 'react-native';
import { Int32 } from 'react-native/Libraries/Types/CodegenTypes';

export interface Spec extends TurboModule {
    readonly getConstants: () => {
        FaceDetection: {};
        Type: {};
        WhiteBalance: {};
        VideoQuality: {};
        GoogleVisionBarcodeDetection: {};
        BarCodeType: {};
        Orientation: {};
        AutoFocus: {};
        FlashMode: {};
    };
    pausePreview(viewTag: Int32): void;
    resumePreview(viewTag: Int32): void;
    takePicture(options: Readonly<{}>, viewId: Int32): Promise<Readonly<{}>>;
    record(options: Readonly<{}>, viewId: Int32): Promise<Readonly<{}>>;
    stopRecording(viewTag: Int32): void;
    pauseRecording(viewTag: Int32): void;
    resumeRecording(viewTag: Int32): void;
    getSupportedRatios(viewTag: Int32): Promise<Array<string>>;
    getCameraIds(viewTag: Int32): Promise<Readonly<{}>>;
    getAvailablePictureSizes(ratio: string, viewTag: Int32): Promise<Array<string>>;
    checkIfRecordAudioPermissionsAreDefined(): Promise<boolean>;
    getSupportedPreviewFpsRange(viewTag: Int32): Promise<Readonly<{}>>;
    hasTorch(): Promise<boolean>;
    checkIfVideoIsValid(path: string): Promise<boolean>;
}

export default (TurboModuleRegistry.get<Spec>('RNCameraModule')) as Spec;