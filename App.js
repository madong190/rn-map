/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import ControlsExample from './example/controls';
import AMapView from './api/AMapView'


export default class App extends Component {
    render() {
        return (
            <ControlsExample style={{flex: 1}}/>
        );
    }
}

