package test.esp.com.alldemos;

import android.app.Application;

import com.urbanairship.UAirship;
import com.urbanairship.push.notifications.CustomLayoutNotificationFactory;

/**
 * Created by admin on 8/12/15.
 */
public class DemoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UAirship.takeOff(this, new UAirship.OnReadyCallback() {
            @Override
            public void onAirshipReady(UAirship uAirship) {
                uAirship.shared().getPushManager().setUserNotificationsEnabled(true);
            }
        });

        String channelId = UAirship.shared().getPushManager().getChannelId();
        System.out.println("============My Application Channel ID: ============" + channelId);

        CustomLayoutNotificationFactory nf = new CustomLayoutNotificationFactory(this);
        nf.layout = R.layout.layout_notification;
        nf.layoutIconDrawableId = R.mipmap.ic_launcher;
        nf.layoutIconId = R.id.icon;
        nf.layoutSubjectId = R.id.subject;
        nf.layoutMessageId = R.id.message;
        nf.constantNotificationId = 100;
//        nf.soundUri = Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.cat);
        UAirship.shared().getPushManager().setNotificationFactory(nf);
    }
}
