package com.example.aijie.aijieandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by aijie on 16/4/27.
 */
public class BasketballActivity extends Activity {
    int scoreTeamA=0;
    int scoreTeamB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basketball);
        displayForTeamA(8);

    }
    public void addThreeForTeamA(View v){
        scoreTeamA=scoreTeamA+3;
        displayForTeamA(scoreTeamA);
    }
    public void addTwoForTeamA(View v){
        scoreTeamA=scoreTeamA+2;
        displayForTeamA(scoreTeamA);
    }
    public void addOneForTeamA(View v){
        scoreTeamA=scoreTeamA+1;
        displayForTeamA(scoreTeamA);
    }

    public void addThreeForTeamB(View v){
        scoreTeamB=scoreTeamB+3;
        displayForTeamB(scoreTeamB);

    }
    //Increase the score for Team B by 2 points.
    public void addTwoForTeamB(View v){
        scoreTeamB=scoreTeamB+2;
        displayForTeamB(scoreTeamB);

    }
    public void addOneForTeamB(View v){
        scoreTeamB=scoreTeamB+1;
        displayForTeamB(scoreTeamB);

    }
    public void displayForTeamB(int score){
        TextView scoreView=(TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    //Resets the score for both teams back to 0.
    public void ResetScore(View v){
        scoreTeamA=0;
        scoreTeamB=0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
    public void displayForTeamA(int score){
        TextView scoreView=(TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
}
