// src/data/planetas.ts
export type Planeta = {
  id: string;
  nome: string;
  description: string;
  content: string;
  imagem: any; 
  accentColor: string;
};

export const PLANETAS: Planeta[] = [
  {
    id: '1',
    nome: 'Variabili',
    description: 'Dados primitivos e variáveis',
    content: 'Conteúdo do planeta Variabili aqui...',
    imagem: require('../../assets/Planet1.png'),
    accentColor: '#49d730',
  },
  {
    id: '2',
    nome: 'Bifurca-9',
    description: 'Fluxo condicional',
    content: 'Conteúdo do planeta Bifurca-9 aqui...',
    imagem: require('../../assets/Planet2.png'),
    accentColor: '#c40edc'
  },
  {
    id: '3',
    nome: 'Ciclus',
    description: 'While, for e loops',
    content: 'Conteúdo do planeta Ciclus aqui...',

    imagem: require('../../assets/Planet3.png'),
    accentColor: '#67E8F9',
  },
  {
    id: '4',
    nome: 'Matrx-0',
    description: 'Arrays, listas e matrizes',
    content: 'Conteúdo do planeta Matrx-0 aqui...',
    imagem: require('../../assets/Planet4.png'),
    accentColor: '#406fd4',
  },
];