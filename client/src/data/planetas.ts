// src/data/planetas.ts
export type Questions = {
  id: string;
  titulo: string;
  pergunta: string;
  opcoes: string[];
  respostaCorretaIndex: number;
}

export type Planeta = {
  id: string;
  nome: string;
  description: string;
  order: number;
  content: string;
  imagem: any; 
  accentColor: string;
  questions: Questions[];
};

import { VISUAIS_DOS_PLANETAS } from './planetVisuals';

export const PLANETAS: Planeta[] = [
  {
    id: '1',
    order: 1,
    nome: 'Variabili',
    description: 'Dados primitivos e variáveis',
    content: 'Conteúdo do planeta Variabili aqui...',
    imagem: VISUAIS_DOS_PLANETAS['1'].img,
    accentColor: VISUAIS_DOS_PLANETAS['1'].cor,
    questions: [
      {
        id: 'var-1',
        titulo: 'Missao 1',
        pergunta: 'O que é uma variável na programação?',
        opcoes: [
          'Um espaço na memória para guardar dados',
          'Um erro no código',
          'Um tipo de banco de dados',
          'Um comando para imprimir na tela'
        ],
        respostaCorretaIndex: 0,
      }
    ],
  },

  {
    id: '2',
    order: 2,
    nome: 'Bifurca-9',
    description: 'Fluxo condicional',
    content: 'Conteúdo do planeta Bifurca-9 aqui...',
    imagem: VISUAIS_DOS_PLANETAS['2'].img,
    accentColor: VISUAIS_DOS_PLANETAS['2'].cor,
    questions: [
      {
        id: 'var-1',
        titulo: 'Missao 1',
        pergunta: 'O que é uma variável na programação?',
        opcoes: [
          'Um espaço na memória para guardar dados',
          'Um erro no código',
          'Um tipo de banco de dados',
          'Um comando para imprimir na tela'
        ],
        respostaCorretaIndex: 0,
      }
    ]
  },

  {
    id: '3',
    order: 3,
    nome: 'Ciclus',
    description: 'While, for e loops',
    content: 'Conteúdo do planeta Ciclus aqui...',

    imagem: VISUAIS_DOS_PLANETAS['3'].img,
    accentColor: VISUAIS_DOS_PLANETAS['3'].cor,
    questions: [
      {
        id: 'var-1',
        titulo: 'Missao 1',
        pergunta: 'O que é uma variável na programação?',
        opcoes: [
          'Um espaço na memória para guardar dados',
          'Um erro no código',
          'Um tipo de banco de dados',
          'Um comando para imprimir na tela'
        ],
        respostaCorretaIndex: 0,
      }
    ]
  },

  {
    id: '4',
    order: 4,
    nome: 'Matrx-0',
    description: 'Arrays, listas e matrizes',
    content: 'Conteúdo do planeta Matrx-0 aqui...',
    imagem: VISUAIS_DOS_PLANETAS['4'].img,
    accentColor: VISUAIS_DOS_PLANETAS['4'].cor,
    questions: [
      {
        id: 'var-1',
        titulo: 'Missao 1',
        pergunta: 'O que é uma variável na programação?',
        opcoes: [
          'Um espaço na memória para guardar dados',
          'Um erro no código',
          'Um tipo de banco de dados',
          'Um comando para imprimir na tela'
        ],
        respostaCorretaIndex: 0,
      }
    ]
  },
];