import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

// Define generic types outside the interface
export type RequestData = unknown;
export type ResponseData = unknown;

export interface Spec extends TurboModule {
  /**
   * Calls a Cloud Function with the given name and data.
   *
   * @param emulatorHost - The emulator host (can be null)
   * @param emulatorPort - The emulator port (can be -1 for no emulator)
   * @param name - The name of the Cloud Function to call
   * @param data - The data to pass to the function
   * @param options - Additional options for the call
   * @returns Promise that resolves with the function result
   */
  httpsCallable(
    name: string,
    data: { data: Object },
  ): Promise<{ data: ResponseData }>;
}

export default TurboModuleRegistry.getEnforcing<Spec>('NativeFunctionsModule');
