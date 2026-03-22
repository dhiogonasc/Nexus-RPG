import { Stack } from 'expo-router';
import React from 'react';

export default function Layout() {
  return (
    <Stack
      screenOptions={{
        headerShown: false,
        contentStyle: { backgroundColor: '#000000' }, 
      }}
    >
      <Stack.Screen name="index" />
      <Stack.Screen name="mission" />
    </Stack>
  );
}