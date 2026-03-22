import { StyleSheet, Dimensions, Platform } from 'react-native';

const { width } = Dimensions.get('window');

const BOTTOM_SAFE_AREA_PADDING = Platform.OS === 'ios' ? 25 : 15;

export const styles = StyleSheet.create({
  container: {
    position: 'absolute',
    bottom: 0,           
    left: 0,
    width: width, 
    height: 70 + BOTTOM_SAFE_AREA_PADDING, 
    paddingBottom: BOTTOM_SAFE_AREA_PADDING,
    backgroundColor: '#1E293B',
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-around', 
    borderTopWidth: 2,
    borderTopColor: '#334155', 
    shadowColor: '#000',
    shadowOffset: { width: 0, height: -3 },
    shadowOpacity: 0.2,
    shadowRadius: 5,
    elevation: 10, 
    zIndex: 10,
  },
  
  button: {
    alignItems: 'center', 
    justifyContent: 'center',
    flex: 1, 
    paddingVertical: 10,
  },
  
  homeButton: {
    backgroundColor: 'rgba(124, 58, 237, 0.1)',
    borderRadius: 20,
    marginHorizontal: width * 0.05,
    borderWidth: 1,
    borderColor: '#7C3AED',
  },
  
  buttonText: {
    color: '#94A3B8',
    fontSize: 10,
    fontWeight: '600',
    marginTop: 4,
    textTransform: 'uppercase',
    letterSpacing: 1,
  },
  
  homeButtonText: {
    color: '#FFF',
    fontWeight: 'bold', 
    letterSpacing: 1.5,
  },
  
  exitText: {
    color: '#EF4444',
    fontWeight: 'bold',
  },
});