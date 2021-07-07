import { WebPlugin } from '@capacitor/core';

import type { AppUpdatePlugin } from './definitions';

export class AppUpdateWeb extends WebPlugin implements AppUpdatePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
