import { StyleSheet, Dimensions } from 'react-native';

const { width } = Dimensions.get('window');

export const styles = StyleSheet.create({
  container: {
    alignItems: 'center',
    marginVertical: 0,
    paddingRight: 0,
    width: width,
    
  },

  navegador: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center',
    width: 'auto',
  },

  gradientFade: {
    position: 'absolute',
    left: 0,
    right: 0,
    bottom: 0,
    height: 120,
  },


  card: {
    width: width * 0.50,
    height: width * 0.75, 
    backgroundColor: 'rgba(30, 41, 59, 0.4)', 
    borderRadius: 20,
    borderWidth: 1,
    borderColor: '#334155',
    marginHorizontal: width * 0.05,
    overflow: 'hidden',
  },

  nome: {
    color: '#FFF',
    fontSize: 24,
    fontWeight: 'black',
    fontFamily: 'sans-serif-medium',
    marginTop: 20,
    textTransform: 'uppercase',
    letterSpacing: 2,
    textShadowColor: 'rgba(0, 0, 0, 0.75)',
    textShadowOffset: { width: -1, height: 1 },
    textShadowRadius: 10,
  },

  
});