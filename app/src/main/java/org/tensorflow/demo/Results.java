package org.tensorflow.demo;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.tensorflow.demo.MainActivity;
import org.tensorflow.demo.R;
import org.tensorflow.demo.RecognitionScoreView;

/**
 * Created by Kshitij on 2018-04-09.
 */

public class Results extends MainActivity {
    Button btnHome;
    questionnaireAgent qA = new questionnaireAgent();
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);
        showResult();
        btnHome = findViewById(R.id.goBack);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent classifyIntent = new Intent(Results.this, MainActivity.class);
                startActivity(classifyIntent);

            }
        });


    }

    private void showResult() {
        int classNumber = Integer.parseInt(RecognitionScoreView.title.split(" ")[1]);

        for (int i = 0; i < nearbyRoadSigns.length; i ++){
            System.out.println("Before: " + nearbyRoadSigns[i]);
        }
        DecisionController finalDecision = new DecisionController(qA.questionnaireAgent(), nearbyRoadSigns, classNumber);
        String finalConsensus = finalDecision.comeToConsensus();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Top Match: " + finalConsensus);
        builder.setPositiveButton("Done", null);
        builder.create().show();
    }
}
