package com.example.dknguyen.mycalculator;

import com.example.dknguyen.mycalculator.view.HomeActivity;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import butterknife.ButterKnife;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainTest {
    HomeActivity homeActivity;

    @Before
    public void setUp() {
        homeActivity = Robolectric.setupActivity(HomeActivity.class);
        ButterKnife.bind(homeActivity);
    }

}