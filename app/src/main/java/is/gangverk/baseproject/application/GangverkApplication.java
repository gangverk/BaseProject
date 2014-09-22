package is.gangverk.baseproject.application;

import android.app.Application;

/**
 * Created by Arnaldur on 22/09/14.
 */
public class GangverkApplication extends Application {
    public static String mPackageName;

    @Override
    public void onCreate() {
        super.onCreate();
        mPackageName = getApplicationContext().getPackageName();
    }

    public static String createIdentifier(String postfix) {
        return mPackageName + "." + postfix;
    }

}
