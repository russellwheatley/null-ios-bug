/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import { Button, StatusBar, StyleSheet, useColorScheme, View } from 'react-native';
import NativeFunctionsModule from './specs/NativeFunctionsModule';

function App() {
  const isDarkMode = useColorScheme() === 'dark';

  return (
    <View style={styles.container}>
      <StatusBar barStyle={isDarkMode ? 'light-content' : 'dark-content'} />
      <View style={{ height: 80 }} />
      <Button title="Call Function" onPress={() => {
        NativeFunctionsModule.httpsCallable('testFunction', { data: { message: 'Hello, world!', nullType: null } }).then((result) => {
          console.log(result);
        });
      }} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
});

export default App;
