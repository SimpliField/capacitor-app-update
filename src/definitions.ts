export interface AppUpdatePlugin {
  /**
 * Supported platform(s): Android, iOS
 * Returns app update informations.
 */
  getAppUpdateInfo(): Promise<AppUpdateInfo>;
  /**
   * Supported platform(s): Android, iOS
   * Opens the app store entry of the app in the Play Store (Android) or App Store (iOS).
   */
  openAppStore(): Promise<void>;
}

export interface AppUpdateInfo {
  /**
   * Supported platform(s): Android, iOS
   * Version code (Android) or CFBundleShortVersionString (iOS) of the currently installed app version.
   */
  currentVersion: string;
  /**
   * Supported platform(s): Android, iOS
   * Version code (Android) or CFBundleShortVersionString (iOS) of the update.
   */
  availableVersion: string;
  /**
   * Supported platform(s): iOS
   * Release date of the update in ISO 8601 (UTC) format.
   */
  availableVersionReleaseDate?: string;
  /**
   * Supported platform(s): Android, iOS
   * The app update availability.
   */
  updateAvailability: typeof AppUpdateAvailability[keyof typeof AppUpdateAvailability];
  /**
   * Supported platform(s): Android
   * In-app update priority for this update, as defined by the developer in the Google Play Developer API.
   */
  updatePriority?: number;
  /**
   * Supported platform(s): Android
   * `true` if an immediate update is allowed, otherwise `false`.
   */
  immediateUpdateAllowed?: boolean;
  /**
   * Supported platform(s): Android
   * `true` if a flexible update is allowed, otherwise `false`.
   */
  flexibleUpdateAllowed?: boolean;
}

export const AppUpdateAvailability = {
  UNKNOWN: 0,
  UPDATE_NOT_AVAILABLE: 1,
  UPDATE_AVAILABLE: 2,
  UPDATE_IN_PROGRESS: 3,
} as const
