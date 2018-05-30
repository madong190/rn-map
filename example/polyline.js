import React, { Component } from 'react'
import { StyleSheet, Alert,TouchableOpacity,View,Text } from 'react-native'
import MapView from '../api/AMapView';
import Polyline from '../api/Polyline'
import styles from './styles'

const line1=[
    {
        latitude: 40.006901,
        longitude: 116.097972,
    },
    {
        latitude: 40.006901,
        longitude: 116.597972,
    },
];
const line2=[
    {
        latitude: 41.006901,
        longitude: 116.097972,
    },
    {
        latitude: 41.006901,
        longitude: 116.597972,
    },
];
let count=0;
export default class PolylineExample extends Component {
    state = {
        line:line1,
        color:'red',
        showPoly:true,
    }


  _onPress = () => Alert.alert('onPress')
    reSet(){
        count +=1;
        if(count%2==1){
            this.setState({line:line1});
        }else{
            this.setState({line:line2});
        }
    }
    reDraw(){
        const l = this.state.line;
        this.setState({line:l,showPoly:true});
    }
  renderPol(){
    if(this.state.showPoly){
      return (<MapView style={styles.map}>
            <Polyline
                width={5}
                color={this.state.color}
                coordinates={this.state.line}
            />
        </MapView>);
    }
    return (<MapView style={styles.map}>
    </MapView>) ;
  }
  render() {
    return (
      <View style={StyleSheet.absoluteFill}>
        <View style={styles.controls}>
          <View style={styles.control}>
            <TouchableOpacity onPress={()=>{this.reSet()}}>
              <Text>移动</Text>
            </TouchableOpacity>
          </View>
          <View style={styles.control}>
            <TouchableOpacity  onPress={()=>{this.setState({showPoly:false})}}>
              <Text>删除</Text>
            </TouchableOpacity>
          </View>
          <View style={styles.control}>
            <TouchableOpacity onPress={()=>{this.reDraw()}}>
              <Text>重绘</Text>
            </TouchableOpacity>
          </View>
        </View>
          {this.renderPol()}
      </View>
    )
  }
}
