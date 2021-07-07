import { WebPlugin } from '@capacitor/core';

import type { AppUpdateInfo, AppUpdatePlugin } from './definitions';

export class AppUpdateWeb extends WebPlugin implements AppUpdatePlugin {
  async getAppUpdateInfo(): Promise<AppUpdateInfo> {
    throw new Error('Web platform is not supported.');
  }

  async openAppStore(): Promise<void> {
    throw new Error('Web platform is not supported.');
  }
}
