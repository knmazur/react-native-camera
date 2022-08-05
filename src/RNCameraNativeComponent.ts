// @flow
import type {ViewProps} from 'react-native/Libraries/Components/View/ViewPropTypes';
import type {HostComponent} from 'react-native';
import {Int32,Float} from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';


interface NativeProps extends ViewProps {
    type: Int32;
    cameraId: string;
    ratio: string;
    flashMode: Int32;
    exposure: Float;
    autoFocus: boolean;
    focusDepth: Float;
    autoFocusPointOfInterest: Readonly<{}>;
    zoom: Float;
    useNativeZoom: boolean;
    whiteBalance: Int32;
    pictureSize: string;
    playSoundOnCapture: boolean;
    playSoundOnRecord: boolean;
    barCodeTypes: readonly string[];
    detectedImageInEvent: boolean;
    barCodeScannerEnabled: boolean;
    useCamera2Api: boolean;
    touchDetectorEnabled: boolean;
    faceDetectorEnabled: boolean;
    faceDetectionMode: Int32;
    faceDetectionLandmarks: Int32;
    faceDetectionClassifications: Int32;
    trackingEnabled: boolean;
    googleVisionBarcodeDetectorEnabled: boolean;
    googleVisionBarcodeType: Int32;
    googleVisionBarcodeMode: Int32;
    textRecognizerEnabled: boolean;
    rectOfInterest: Readonly<{}>;
    cameraViewDimensions: Readonly<{}>;
}

export default (codegenNativeComponent<NativeProps>('RNCamera') as HostComponent<NativeProps>);