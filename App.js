/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import MapViewe from './AMapView'

type Props = {};
export default class App extends Component<Props> {
    render() {
        return (
            <MapViewe style={{flex: 1}}/>
        );
    }
}

