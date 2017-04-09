package com.tinkerstudy;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

import java.io.File;

/**
 * Created by liuhao on 2017/4/8.
 */
@DefaultLifeCycle(application = ".SimpleTinkerInApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class SimpleTinkerInApplicationLike extends DefaultApplicationLike {

    private Context context;

    public SimpleTinkerInApplicationLike(Application application,
                                         int tinkerFlags,
                                         boolean tinkerLoadVerifyFlag,
                                         long applicationStartElapsedTime,
                                         long applicationStartMillisTime,
                                         Intent tinkerResultIntent) {
        super(application,
                tinkerFlags,
                tinkerLoadVerifyFlag,
                applicationStartElapsedTime,
                applicationStartMillisTime,
                tinkerResultIntent);
    }


    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        MultiDex.install(base);
        this.context = base;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        TinkerInstaller.install(this);

        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/patch_signed_7zip.apk");

        if(file.exists()){
            TinkerInstaller.onReceiveUpgradePatch(context,file.getAbsolutePath());
        }
    }
}
