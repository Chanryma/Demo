package com.chanryma.fetchtopactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActivityC extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
    }

    public void onButtonClick(View view) {
        List<Activity> activities = getActivities();
        String result = concatenateActivityNames(activities);
        ((TextView) findViewById(R.id.tv_result)).setText(result);
    }

    private String concatenateActivityNames(List<Activity> activities) {
        StringBuilder strBuilder = new StringBuilder();
        if (activities != null) {
            for (Activity activity : activities) {
                if (strBuilder.length() > 0) {
                    strBuilder.append("\n");
                }

                strBuilder.append(activity.getClass().getSimpleName());
            }
        }

        return strBuilder.toString();
    }

    /**
     * The order of activities in the returned list is not constant.
     * As far as this demo project is concerned, I expect the result to be [ActivityA,ActivityB,ActivityC], but it varies.
     * @return activities
     */
    private List<Activity> getActivities() {
        List<Activity> activities = new ArrayList<Activity>();
        try {
            Class activityThreadClass = Class.forName("android.app.ActivityThread");
            Object activityThread = activityThreadClass.getMethod("currentActivityThread").invoke(null);
            Field activitiesField = activityThreadClass.getDeclaredField("mActivities");
            activitiesField.setAccessible(true);

            Map<Object, Object> activityRecords = (Map<Object, Object>) activitiesField.get(activityThread);
            if (activityRecords == null) {
                return activities;
            }

            for (Object activityRecord : activityRecords.values()) {
                Class activityRecordClass = activityRecord.getClass();
                Field activityField = activityRecordClass.getDeclaredField("activity");
                activityField.setAccessible(true);
                Activity activity = (Activity) activityField.get(activityRecord);
                activities.add(activity);
            }
        } catch (Exception e) {
            Log.e("ActivityC", "Error", e);
        }

        return activities;
    }


    public static Activity getActivity() throws Exception {
        Class activityThreadClass = Class.forName("android.app.ActivityThread");
        Object activityThread = activityThreadClass.getMethod("currentActivityThread").invoke(null);
        Field activitiesField = activityThreadClass.getDeclaredField("mActivities");
        activitiesField.setAccessible(true);

        Map<Object, Object> activities = (Map<Object, Object>) activitiesField.get(activityThread);
        if (activities == null) return null;

        for (Object activityRecord : activities.values()) {
            Class activityRecordClass = activityRecord.getClass();
            Field pausedField = activityRecordClass.getDeclaredField("paused");
            pausedField.setAccessible(true);
            if (!pausedField.getBoolean(activityRecord)) {
                Field activityField = activityRecordClass.getDeclaredField("activity");
                activityField.setAccessible(true);
                Activity activity = (Activity) activityField.get(activityRecord);
                return activity;
            }
        }

        return null;
    }
}
