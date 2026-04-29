import { ImageSourcePropType } from 'react-native';
import { PlanetLabel } from '@/model/enum';

export const PLANET_IMAGES: Record<PlanetLabel, ImageSourcePropType> = {
  [PlanetLabel.VARIABILI]: require('../../assets/Planet1.png'),
  [PlanetLabel.BIFURCA_9]: require('../../assets/Planet2.png'),
  [PlanetLabel.CICLUS]: require('../../assets/Planet3.png'),
  [PlanetLabel.MATRX_0]: require('../../assets/Planet4.png'),
};