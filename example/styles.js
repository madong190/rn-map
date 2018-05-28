import { StyleSheet, Platform } from 'react-native'

export default StyleSheet.create({
  map: {
    flex: 1
  },
  controls: {
    height: 72,
    flexDirection: 'row',
    justifyContent: 'space-between',
    elevation: 4,
    paddingLeft: 20,
    paddingRight: 20,
    backgroundColor: '#f5f5f5',
  },
  control: {
    alignItems: 'center',
    justifyContent: 'center',
  },
  switch: {
    marginTop: 5,
  },
})
