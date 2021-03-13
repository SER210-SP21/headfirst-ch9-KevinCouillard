package edu.quinnipiac.ser210.chapter_9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.view.View;

/**
 * Kevin Couillard
 * Chapter 9 Demo
 * 3/9/21
 * MainActivity (Workout)
 */
public class MainActivity extends Activity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        //the textbook has fragmentContainer != null which I think would display what we want on the right for a tablet,
        //but for the emulator to see it working I changed the != to ==
        if (fragmentContainer == null) {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            details.setWorkout(id);
            ft.replace(R.id.fragment_container, details);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }
    }
}