import { View, Text, StyleSheet } from 'react-native';

export default function Taverna() {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>Você entrou na Taverna.</Text>
      <Text>O estalajadeiro olha para você de canto de olho...</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, justifyContent: 'center', alignItems: 'center' },
  title: { fontSize: 20, fontWeight: 'bold', marginBottom: 10 },
});