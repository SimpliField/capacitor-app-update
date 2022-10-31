# @simplifield/capacitor-app-update

Checks for app updates on Aplle Store and Google Play

## Install

```bash
npm install @simplifield/capacitor-app-update
npx cap sync
```

## API

<docgen-index>

* [`getAppUpdateInfo()`](#getappupdateinfo)
* [`openAppStore()`](#openappstore)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getAppUpdateInfo()

```typescript
getAppUpdateInfo() => Promise<AppUpdateInfo>
```

Supported platform(s): Android, iOS
Returns app update informations.

**Returns:** <code>Promise&lt;<a href="#appupdateinfo">AppUpdateInfo</a>&gt;</code>

--------------------


### openAppStore()

```typescript
openAppStore() => Promise<void>
```

Supported platform(s): Android, iOS
Opens the app store entry of the app in the Play Store (Android) or App Store (iOS).

--------------------


### Interfaces


#### AppUpdateInfo

| Prop                              | Type                          | Description                                                                                                                            |
| --------------------------------- | ----------------------------- | -------------------------------------------------------------------------------------------------------------------------------------- |
| **`currentVersion`**              | <code>string</code>           | Supported platform(s): Android, iOS Version code (Android) or CFBundleShortVersionString (iOS) of the currently installed app version. |
| **`availableVersion`**            | <code>string</code>           | Supported platform(s): Android, iOS Version code (Android) or CFBundleShortVersionString (iOS) of the update.                          |
| **`availableVersionReleaseDate`** | <code>string</code>           | Supported platform(s): iOS Release date of the update in ISO 8601 (UTC) format.                                                        |
| **`updateAvailability`**          | <code>0 \| 1 \| 2 \| 3</code> | Supported platform(s): Android, iOS The app update availability.                                                                       |
| **`updatePriority`**              | <code>number</code>           | Supported platform(s): Android In-app update priority for this update, as defined by the developer in the Google Play Developer API.   |
| **`immediateUpdateAllowed`**      | <code>boolean</code>          | Supported platform(s): Android `true` if an immediate update is allowed, otherwise `false`.                                            |
| **`flexibleUpdateAllowed`**       | <code>boolean</code>          | Supported platform(s): Android `true` if a flexible update is allowed, otherwise `false`.                                              |

</docgen-api>
