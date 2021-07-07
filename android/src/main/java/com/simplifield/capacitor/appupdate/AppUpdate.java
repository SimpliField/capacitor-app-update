package com.simplifield.capacitor.appupdate;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.getcapacitor.JSObject;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.install.model.AppUpdateType;

public class AppUpdate {

    public JSObject getAppUpdateInfo(Context context, AppUpdateInfo appUpdateInfo, PackageInfo pInfo) {
        JSObject ret = new JSObject();
        ret.put("currentVersion", String.valueOf(pInfo.versionCode));
        ret.put("availableVersion", String.valueOf(appUpdateInfo.availableVersionCode()));
        ret.put("updateAvailability", appUpdateInfo.updateAvailability());
        ret.put("updatePriority", appUpdateInfo.updatePriority());
        ret.put("immediateUpdateAllowed", appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE));
        ret.put("flexibleUpdateAllowed", appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE));
        return ret;
    }

    public PackageInfo getPackageInfo(Context context) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        return context.getPackageManager().getPackageInfo(packageName, 0);
    }
}
