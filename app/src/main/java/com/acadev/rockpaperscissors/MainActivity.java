package com.acadev.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnRock,btnPaper,btnScissors;
    ImageView imgVwComputer,imgVwUser;

    String userChoice,cpuChoice,result;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgVwComputer = findViewById(R.id.imgVwComputer);
        imgVwUser = findViewById(R.id.imgVwUser);

        btnRock = findViewById(R.id.btnRock);
        btnPaper = findViewById(R.id.btnPaper);
        btnScissors = findViewById(R.id.btnScissors);

        random = new Random();

        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoice="Rock";
                imgVwUser.setImageResource(R.drawable.icons8_rock_50px);
                calc();
            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoice="Paper";
                imgVwUser.setImageResource(R.drawable.icons8_sheet_of_paper_50px);

                calc();
            }
        });

        btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userChoice="Scissors";
                imgVwUser.setImageResource(R.drawable.icons8_scissors_50px);

                calc();
            }
        });
    }

    public void calc()
    {
        int cpu = random.nextInt(3);

        if(cpu == 0)
        {
            cpuChoice ="Rock";
            imgVwComputer.setImageResource(R.drawable.icons8_rock_50px);
        }
        else if(cpu == 1)
        {
            cpuChoice ="Paper";
            imgVwComputer.setImageResource(R.drawable.icons8_sheet_of_paper_50px);

        }
        else if(cpu == 2)
        {
            cpuChoice="Scissors";
            imgVwComputer.setImageResource(R.drawable.icons8_scissors_50px);

        }
        //rock
        if(userChoice.equals("Rock") && cpuChoice.equals("Paper"))
        {
            result ="You lost !!!";
        }
        else if(userChoice.equals("Rock") && cpuChoice.equals("Scissors"))
        {
            result ="You Won !!!";
        }
        else if(userChoice.equals("Rock") && cpuChoice.equals("Rock"))
        {
            result ="DRAW !!!";
        }
        //paper
        else if(userChoice.equals("Paper") && cpuChoice.equals("Rock"))
        {
            result ="You Won !!!";
        }
        else if(userChoice.equals("Paper") && cpuChoice.equals("Scissors"))
        {
            result ="You Lost !!!";
        }
        else if(userChoice.equals("Paper") && cpuChoice.equals("Paper"))
        {
            result ="DRAW !!!";
        }
        //scissors
        else if(userChoice.equals("Scissors") && cpuChoice.equals("Paper"))
        {
            result ="You Won !!!";
        }
        else if(userChoice.equals("Scissors") && cpuChoice.equals("Scissors"))
        {
            result ="DRAW !!!";
        }
        else if(userChoice.equals("Scissors") && cpuChoice.equals("Rock"))
        {
            result ="You lost !!!";
        }

        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

    }
}