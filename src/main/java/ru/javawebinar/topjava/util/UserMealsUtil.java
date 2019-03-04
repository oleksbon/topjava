package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;



public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();

    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with correctly exceeded field
        System.out.println("Experiment successful!!!! + One more Try");

        /*mealList.forEach(i -> if(isBetween())

                System.out.println(i.getDateTime() + " " + i.getDescription()));
        */
        mealList.forEach(i -> System.out.println(i.getDateTime()));

        System.out.println();


        LocalDateTime a = LocalDateTime.of(2015, Month.MAY, 30,10,0);
        System.out.println("The hour is: " + a.getHour());
        System.out.println(TimeUtil.isBetween(LocalTime.of(10,0), LocalTime.of(7, 0), LocalTime.of(12,0)));

        List<UserMealWithExceed> mealListExceed = Arrays.asList();
        mealList.forEach(i -> new UserMealWithExceed(i.getDateTime(), i.getDescription(), i.getCalories(),true));

        mealListExceed.forEach(i -> System.out.println(i.getExceed()));

        // between time
        mealList.forEach(i -> System.out.println(i.getDateTime()));
        mealList.forEach(i -> {
            LocalDateTime ab = i.getDateTime();
            LocalTime localHours = ab.toLocalTime();
            boolean ac = TimeUtil.isBetween(localHours, LocalTime.of(7, 0), LocalTime.of(12,0));
            if(ac) {
                System.out.println(i.getDescription());
            }
        });

        // exceed 2000 calories per day

        mealList.forEach(i -> {
            int abc = 0;
            do {
                abc += i.getCalories();
            } while (!"Ужин".equals(i.getDescription()));
            System.out.println(abc);
        });


        /*mealList.forEach(i -> if(TimeUtil.isBetween(i.getDateTime().getHour(), LocalTime.of(7, 0), LocalTime.of(12,0)));

        System.out.println(i.getDateTime()));

        */
        // mealListExceed


        return null;
    }
}
