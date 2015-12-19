package com.tinochan.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tino on 19/12/15.
 */
public class BusinessDateService {

    static String currentBusinessDateString = "20151101";
    static String referenceDate;

    public static void setReferenceDate(boolean isThrowException){

        DateFormat df = new SimpleDateFormat("yyyyMMdd");

        try {
            Date currentBusinessDate = df.parse(currentBusinessDateString);
            if(isThrowException) {
                throw new ParseException("Wrong format", 0);
            }
            System.out.println(currentBusinessDate);
            referenceDate = currentBusinessDateString;
        } catch (ParseException e) {
            e.printStackTrace();
            referenceDate = df.format(new Date());
        }

        String yearString = referenceDate.substring(0, 4);
        String monthString = referenceDate.substring(4, 6);

        System.out.format("yearString: %s monthString: %s", yearString, monthString);
        System.out.println();

    }

    public static void main(String[] args){
        setReferenceDate(false);
        setReferenceDate(true);
    }

}
