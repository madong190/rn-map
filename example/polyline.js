import React, { Component } from 'react'
import { StyleSheet, Alert } from 'react-native'
import MapView from '../api/AMapView';
import Polyline from '../api/Polyline'


export default class PolylineExample extends Component {


  _line1 = [
    {
      latitude: 40.006901,
      longitude: 116.097972,
    },
    {
      latitude: 40.006901,
      longitude: 116.597972,
    },
  ]

  _line2 = [
    {
      latitude: 38.906901,
      longitude: 116.097972,
    },
    {
      latitude: 38.906901,
      longitude: 116.597972,
    },
  ]

  _line3 = [
    {
      latitude: 39.806901,
      longitude: 116.097972,
    },
    {
      latitude: 39.806901,
      longitude: 116.257972,
    },
    {
        latitude: 38.906901,
        longitude: 116.597972,
    }
  ]

  _onPress = () => Alert.alert('onPress')

  render() {
    return (
      <MapView style={StyleSheet.absoluteFill}>
        <Polyline
          width={5}
          color="rgba(255, 0, 0, 0.5)"
          coordinates={this._line1}
        />
        <Polyline
          dashed
          color="rgba(0, 255, 0, 0.5)"
          width={5}
          coordinates={this._line2}
        />
        <Polyline
          gradient
          colors={['#f44336', '#2196f3']}
          width={5}
          onPress={this._onPress}
          coordinates={this._line3}
        />
      </MapView>
    )
  }
}
