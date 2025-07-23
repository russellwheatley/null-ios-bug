//
//  RCTNativeFunctionsModule.m
//  ReproducerApp
//
//  Created by Russell Wheatley on 23/07/2025.
//

#import "RCTNativeFunctionsModule.h"

@implementation RCTNativeFunctionsModule

+ (NSString *)moduleName { 
  return @"NativeFunctionsModule";
}

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:(const facebook::react::ObjCTurboModule::InitParams &)params { 
  return std::make_shared<facebook::react::NativeFunctionsModuleSpecJSI>(params);
}

- (void)httpsCallable:(nonnull NSString *)name data:(JS::NativeFunctionsModule::SpecHttpsCallableData &)data resolve:(nonnull RCTPromiseResolveBlock)resolve reject:(nonnull RCTPromiseRejectBlock)reject { 
  id updatedData = data.data();
  NSLog(@"name %@", name);
  NSLog(@"data %@", updatedData);
  
  id someData = @{@"data": updatedData};
  resolve(someData);
}

@end
