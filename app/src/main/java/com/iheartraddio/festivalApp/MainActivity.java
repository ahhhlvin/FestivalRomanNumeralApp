package com.iheartraddio.festivalApp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;


public class MainActivity  extends ActionBarActivity {

    public static final String IHEART_FESTIVAL_LABEL = "iHeartRadio Music Festival";
    private final RomanNumeralsUtil mRomanNumeralUtil = new RomanNumeralsUtil();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.list_event);
        List<String> list = getEventLabels();
        listView.setAdapter(new EventAdapter(this, list));
    }

    private List<String> getEventLabels() {
        return Arrays.asList(
                formatWithRomanNumeral(IHEART_FESTIVAL_LABEL, 1),
                formatWithRomanNumeral(IHEART_FESTIVAL_LABEL, 2),
                formatWithRomanNumeral(IHEART_FESTIVAL_LABEL, 3),
                formatWithRomanNumeral(IHEART_FESTIVAL_LABEL, 4),
                formatWithRomanNumeral(IHEART_FESTIVAL_LABEL, 5),

        // FOR TESTING
        formatWithRomanNumeral(IHEART_FESTIVAL_LABEL, 143),
        formatWithRomanNumeral(IHEART_FESTIVAL_LABEL, 643),
        formatWithRomanNumeral(IHEART_FESTIVAL_LABEL, 5000),
        formatWithRomanNumeral(IHEART_FESTIVAL_LABEL, 4999));

    }

    private String formatWithRomanNumeral(String label, int number) {
        final String possibleRomanNumeral = mRomanNumeralUtil.convertToRomanNumeral(number);

        // FOR TESTING
//        System.out.println(possibleRomanNumeral + " VALID: " + mRomanNumeralUtil.isValidRomanNumeral(possibleRomanNumeral));

        if(!mRomanNumeralUtil.isValidRomanNumeral(possibleRomanNumeral)) {
            return "";
        }

        return label + " " + possibleRomanNumeral;
    }
}
