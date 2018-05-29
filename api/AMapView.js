import React from 'react'
import PropTypes from 'prop-types'
import {requireNativeComponent,View} from 'react-native'
export default class MapView extends React. Component {
    static propTypes = {
        /**
         * 是否显示指南针
         */
        showsCompass: PropTypes.bool,
        /**
         * 是否显示放大缩小按钮
         */
        showsZoomControls: PropTypes.bool,
        /**
         * 是否显示比例尺
         */
        showsScale: PropTypes.bool,
        /**
         * 是否显示定位按钮
         */
        showsLocationButton: PropTypes.bool,
        /**
         * 是否启用定位
         */
        locationEnabled: PropTypes.bool,
        /**
         * 点击事件
         *
         * @param {{ nativeEvent: LatLng }}
         */
        onPress: PropTypes.func,


        /**
         * 定位事件
         *
         * @param {{
         *   nativeEvent: {
         *     longitude: number,
         *     latitude: number,
         *   }
         * }}
         */
        onLocaltionChange: PropTypes.func,
        /**
         * 可视区域变化
         *
         * @param {{
         *   nativeEvent: {
         *     zoom: number
         *   }
         * }}
         */
        onCameraChange: PropTypes.func,
        /**
         * 可视区域变化
         *
         * @param {{
         *   nativeEvent: {
         *     zoom: number,
         *     southwest: string,
         *     longitude: number,
         *     latitude: number,
         *   }
         * }}
         */
        onCameraChangeFinish: PropTypes.func,
        ...View.propTypes,
    }

    name = 'AMapView'

    render() {
        return <AMapView {...this.props}/>
    }
}
const AMapView = requireNativeComponent('AMapView', MapView);
