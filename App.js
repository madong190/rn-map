/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import ControlsExample from './example/controls';
import EventExample from './example/events';
import AMapView from './api/AMapView'


export default class App extends Component {
    render() {
        return (
            <EventExample style={{flex: 1}}/>
        );
    }
}

