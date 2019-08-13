package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView storyTextView;
    private Button buttonTop;
    private Button buttonBottom;
    private int currentAnswer1ID;
    private int currentAnswer2ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyTextView = (TextView) this.findViewById(R.id.storyTextView);
        buttonTop = (Button) this.findViewById(R.id.buttonTop);
        buttonBottom = (Button) this.findViewById(R.id.buttonBottom);

        currentAnswer1ID = R.string.T1_Ans1;
        currentAnswer2ID = R.string.T1_Ans2;


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        buttonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (currentAnswer1ID) {
                    case R.string.T1_Ans1:

                        changeStory(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
                        break;

                    case R.string.T2_Ans1:

                        changeStory(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
                        break;

                    case R.string.T3_Ans1:

                        endStory(R.string.T6_End);
                        break;
                }

            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        buttonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (currentAnswer2ID) {
                    case R.string.T1_Ans2:

                        changeStory(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2);
                        break;

                    case R.string.T2_Ans2:

                        endStory(R.string.T4_End);
                        break;

                    case R.string.T3_Ans2:

                        endStory(R.string.T5_End);
                        break;
                }

            }
        });

    }

    private void changeStory(int storyID, int answer1ID, int answer2ID) {
        this.currentAnswer1ID = answer1ID;
        this.currentAnswer2ID = answer2ID;

        this.storyTextView.setText(storyID);
        this.buttonTop.setText(answer1ID);
        this.buttonBottom.setText(answer2ID);
    }

    private void endStory(int storyEndID) {
        this.storyTextView.setText(storyEndID);
        this.buttonTop.setVisibility(View.GONE);
        this.buttonBottom.setVisibility(View.GONE);
    }
}
