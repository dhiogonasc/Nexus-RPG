import React, { useState } from 'react';
import { View, StyleProp, TextInput, ViewStyle, StyleSheet, TextInputProps, TouchableOpacity } from 'react-native';
import { Feather } from '@expo/vector-icons';

interface PasswordInputProps extends
  TextInputProps {
  iconName?: keyof typeof Feather.glyphMap;
  containerStyle?: StyleProp<ViewStyle>;
}

export default function PasswordInput(
  {
    iconName,
    containerStyle,
    style,
    ...rest
  }: PasswordInputProps) {

  const [showPassword, setShowPassword] = useState(false);

  return (
    <View style={[styles.inputContainer, containerStyle]}>
      {iconName && (
        <Feather name={iconName} size={20} color="#C4C4C4" style={styles.icon} />
      )}

      <TextInput
        style={[styles.textInput, style]}
        placeholderTextColor="#C4C4C4"
        {...rest}
      />
      <TouchableOpacity style={styles.eyeIcon} onPress={() => setShowPassword(!showPassword)}>
        <Feather name={showPassword ? 'eye-off' : 'eye'} size={24} color="#888" />
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  inputContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: '#2B2B2B',
    width: '100%',
    height: 55,
    borderRadius: 8,
    borderWidth: 1,
    borderColor: '#C4C4C4',
    marginBottom: 15,
    paddingHorizontal: 15,
  },
  icon: {
    marginRight: 10,
  },
  textInput: {
    flex: 1,
    height: '100%',
    color: '#FFFFFF',
    fontSize: 16,
  },
  eyeIcon: {
    padding: 10,
  },
});