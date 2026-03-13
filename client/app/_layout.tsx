import { Stack } from 'expo-router';

export default function Layout() {
  return (
    // headerShown: false esconde o cabeçalho padrão para o jogo ficar em tela cheia
    <Stack screenOptions={{ headerShown: false }}>
      <Stack.Screen name="index" />
      <Stack.Screen name="mission" />
    </Stack>
  );
}