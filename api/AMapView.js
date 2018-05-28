import React from 'react'
import PropTypes from 'prop-types'
import {requireNativeComponent,View} from 'react-native'
export default requireNativeComponent('AMapView', {
    name: 'AMapView',
    propTypes: {
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
        ...View.propTypes,
    },
})