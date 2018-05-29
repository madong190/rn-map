// @flow
import React, { PureComponent } from 'react'
import PropTypes from 'prop-types'
import { ColorPropType, processColor, requireNativeComponent, ViewPropTypes } from 'react-native'

const LatLng = PropTypes.shape({
    latitude: PropTypes.number.isRequired,
    longitude: PropTypes.number.isRequired,
})

export default class Polyline extends PureComponent {
  static propTypes = {
    ...ViewPropTypes,

    // /**
    //  * 节点坐标
    //  */
    coordinates: PropTypes.arrayOf(LatLng).isRequired,

    /**
     * 线段宽度
     */
    width: PropTypes.number,

    /**
     * 线段颜色
     */
    color: ColorPropType,

    /**
     * 层级
     */
    zIndex: PropTypes.number,

    /**
     * 多段颜色
     */
    colors: PropTypes.arrayOf(ColorPropType),


    /**
     * 是否绘制虚线
     */
    dashed: PropTypes.bool,

    // /**
    //  * 点击事件
    //  */
    // onPress: PropTypes.func,
  }

  static defaultProps = {
    colors: [],
  }
  name = 'AMapPolyline';

  render() {
    return <AMapPolyline {...this.props} />
  }
}

const AMapPolyline = requireNativeComponent('AMapPolyline', Polyline)
