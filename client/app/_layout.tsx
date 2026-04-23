import { Stack, usePathname } from 'expo-router';
import { View } from 'react-native';
import FooterBar from '../src/components/FooterBar';
import React from 'react';

export default function Layout() {
  // Pega o caminho (rota) atual que o usuário está acessando
  const pathname = usePathname();

  // Define em quais rotas o Footer NÃO deve aparecer
  const rotasSemFooter = ['/', '/register', '/logout'];

  // Se a rota atual NÃO estiver na lista acima, deve mostrar o Footer
  const deveMostrarFooter = !rotasSemFooter.includes(pathname);

  return (
    <View style={{ flex: 1, backgroundColor: '#000000' }}>
      <Stack
        screenOptions={{
          headerShown: false,
          contentStyle: { backgroundColor: '#000000' },
        }}
      >
        <Stack.Screen name="index" />
      </Stack>

      {deveMostrarFooter && <FooterBar />}
    </View>
  );
}