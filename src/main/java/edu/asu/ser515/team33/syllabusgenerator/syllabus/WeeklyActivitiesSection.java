package edu.asu.ser515.team33.syllabusgenerator.syllabus;

import java.util.List;

public class WeeklyActivitiesSection extends Section {
    List<DailyActivity> dailyActivities;

    public WeeklyActivitiesSection(String id, int order, String title, String content) {
        super(id, order, title, content);
    }
}
