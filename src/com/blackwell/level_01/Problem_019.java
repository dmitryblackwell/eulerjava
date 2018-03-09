package com.blackwell.level_01;

public class Problem_019 {
    class Date{
        private int day;
        private String WeekDay;
        private int month;
        private int year;

        private int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        private String[] WeekDaysName={"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        public Date(int day, String weekDay, int month, int year) {
            this.day = day;
            WeekDay = weekDay;
            this.month = month;
            this.year = year;
        }
        private int getWeekDayNumber(){
            for(int i=0; i<7; ++i)
                if (WeekDay.equals(WeekDaysName[i]))
                    return i;
            return 0;
        }
        public int getDay() {
            return day;
        }

        public String getWeekDay() {
            return WeekDay;
        }

        public int getYear() {
            return year;
        }

        private boolean isLeap(){
            return  ((year%4 == 0 && year%100 != 0) || year%400 == 0);
        }
        public void plus(int days){
            day += days;
            int WeekDayNumber = (getWeekDayNumber()+days)%7;
            WeekDay = WeekDaysName[WeekDayNumber];
            while (day > daysInMonth[month-1]) {
                day -= daysInMonth[month-1];
                month ++;
                if(month == 13) {
                    month = 1;
                    year++;
                    daysInMonth[1] = isLeap() ? 29 : 28;

                }
            }
        }
        public void print(){
            System.out.println(day+"."+month+"."+year+" "+WeekDay);
        }
    }

    public Problem_019() {
        Date date=new Date(6,"Sunday",1,1901);
        int sundays = 0;

        while(date.getYear()< 2001){;
            date.plus(7);
            if (date.getWeekDay().equals("Sunday") && date.getDay() == 1)
                sundays ++;
        }
        System.out.println(sundays);
    }
}
