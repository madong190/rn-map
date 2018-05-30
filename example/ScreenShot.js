import React, { Component } from 'react'
import { StyleSheet, Switch, Text, View,TouchableOpacity,NativeModules} from 'react-native'
import MapView from '../api/AMapView'
import styles from './styles'

const AMapScreenShot = NativeModules.AMapScreenShot;//获取截屏模块
export default class ScreenShotExample extends Component {
    state={
        tips:''
    }
    shot(){
        AMapScreenShot.ScreenShot("我要截图了").then((res)=>{
            this.setState({tips:res});
        })
    }

    render() {
        return (
            <View style={StyleSheet.absoluteFill}>
                <View style={styles.controls}>
                    <View style={styles.control}>
                        <TouchableOpacity onPress={()=>{this.shot()}}>
                            <Text>截图</Text>
                        </TouchableOpacity>
                        <Text>{this.state.tips}</Text>
                    </View>
                </View>
                <MapView
                    style={styles.map}
                />
            </View>
        )
    }
}
