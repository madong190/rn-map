import React, { Component } from 'react'
import { FlatList, StyleSheet, Text, View } from 'react-native'
import MapView from '../api/AMapView'

const styles = StyleSheet.create({
  body: {
    flex: 1,
  },
  logs: {
    elevation: 8,
    backgroundColor: '#fff',
  },
  logText: {
    paddingLeft: 15,
    paddingRight: 15,
    paddingTop: 10,
    paddingBottom: 10,
  },
})

export default class EventsExample extends Component {

  state = {
    logs: [],
  }

  _log(event, data) {
    this.setState({
      logs: [
        {
          key: Date.now(),
          time: new Date().toLocaleString(),
          event,
          data: JSON.stringify(data, null, 2),
        },
        ...this.state.logs,
      ],
    })
  }

  _logPressEvent = ({ nativeEvent }) => {this._log('onPress', nativeEvent);}
  _logCameraChangeFinish= ({ nativeEvent }) => this._log('onLocation', nativeEvent)

  _renderItem = ({ item }) =>
    <Text style={styles.logText}>{item.time} {item.event}: {item.data}</Text>

  render() {
    return (
      <View style={styles.body}>
        <MapView
          locationEnabled
          showsLocationButton
          onPress={this._logPressEvent}
          onCameraChangeFinish={this._logCameraChangeFinish}
          style={styles.body}
        />
        <FlatList
          style={styles.logs}
          data={this.state.logs}
          renderItem={this._renderItem}
        />
      </View>
    )
  }
}
