import React from 'react'
import {requireNativeComponent,View} from 'react-native'
export default requireNativeComponent('MapViewe', {
    name: 'MapViewe',
    propTypes: {
        ...View.propTypes,
    },
})