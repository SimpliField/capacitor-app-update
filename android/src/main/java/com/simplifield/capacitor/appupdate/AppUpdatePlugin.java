package com.simplifield.capacitor.appupdate;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.gms.tasks.Task;

@CapacitorPlugin(name = "AppUpdate")
public class AppUpdatePlugin extends Plugin {

    private AppUpdate implementation = new AppUpdate();

    @PluginMethod
    public void getAppUpdateInfo(PluginCall call) {
        try {
            Context context = this.getContext();

            AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(context);

            Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();
            appUpdateInfoTask.addOnSuccessListener(
                appUpdateInfo -> {
                    try {
                        PackageInfo pInfo = implementation.getPackageInfo(context);
                        JSObject updInfo = implementation.getAppUpdateInfo(context, appUpdateInfo, pInfo);
                        call.resolve(updInfo);
                    } catch (Exception e) {
                        call.reject("Unable to get App Info");
                    }
                }
            );
            appUpdateInfoTask.addOnFailureListener(
                    failure -> {
                        String message = failure.getMessage();
                        call.reject(message);
                    }
            );
        } catch (Exception e) {
            call.reject("Unable to get App Info");
        }
    }

    @PluginMethod
    public void openAppStore(PluginCall call) {
        String packageName = this.getContext().getPackageName();
        Intent launchIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
        try {
            this.getBridge().getActivity().startActivity(launchIntent);
        } catch (ActivityNotFoundException ex) {
            launchIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            this.getBridge().getActivity().startActivity(launchIntent);
        }
        call.resolve();
    }
}
