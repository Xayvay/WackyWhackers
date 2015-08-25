package x.wackywhackers;


import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {
    /*Display idisplay = getWindowManager().getDefaultDisplay();

    public int displayWidth = idisplay.getWidth();
    public int displayHeight = idisplay.getHeight();*/
    public boolean go = false;
    public int displayWidth;
    public int displayHeight;
    public int score = 0;
    public int sec;
    public int timeInc;
    CountDownTimer timer;
    Random rand = new Random();
    public long displayTime;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main );

        timeInc = 20;
        sec = 20000;
        score = 0;

        go = false;

    }

    public void onStartClick(View view){
        Display display = getWindowManager().getDefaultDisplay();
        displayWidth = display.getWidth();
        displayHeight = display.getHeight();

         timer = new CountDownTimer(sec, 1000) {

            TextView timerField = (TextView) findViewById(R.id.timer);
            View h = findViewById(R.id.hitme);
            View a  = findViewById(R.id.again);

            public void onTick(long millisUntilFinished) {
                if(score < timeInc) {
                    displayTime = millisUntilFinished / 1000;
                    timerField.setText("Time: " + displayTime );
                }

            }

            public void onFinish() {
                timerField.setText("TRY AGAIN!");
                h.setVisibility(View.GONE);
                a.setVisibility(View.VISIBLE);
            }
        }.start();



        View t = findViewById(R.id.hitme);
        t.setVisibility(View.VISIBLE);

        View s = findViewById(R.id.start);
        s.setVisibility(View.GONE);

        Random r = new Random();
        int x;
        int y;

        if(go == false){
            x = r.nextInt(80);
            y = r.nextInt(80);
            go = true;
        }else{
            x = r.nextInt(displayWidth - 150);
            y = r.nextInt(displayHeight - 150);
        }

        if(y<20){
            y+=100;
        }
        if(x<20){
            x+=100;
        }
        if(x> (displayWidth)){
            x-=100;
        }
        if(y> (displayHeight)){
            y-=100;
        }
        t.setX(x);
        t.setY(y);
    }


    public void onAgainClick(View view){
        Display display = getWindowManager().getDefaultDisplay();
        displayWidth = display.getWidth();
        displayHeight = display.getHeight();
        timeInc = 20;
        sec = 20000;
        score = 0;

        timer = new CountDownTimer(sec, 1000) {

            TextView timerField = (TextView) findViewById(R.id.timer);
            View h = findViewById(R.id.hitme);
            View a  = findViewById(R.id.again);

            public void onTick(long millisUntilFinished) {
                displayTime = millisUntilFinished / 1000;
                    timerField.setText("Time: " + displayTime);


            }

            public void onFinish() {
                timerField.setText("TRY AGAIN!");
                h.setVisibility(View.GONE);
                a.setVisibility(View.VISIBLE);
            }
        }.start();

        TextView s = (TextView)(findViewById(R.id.score));
        s.setText("Score: "+ score);

        View t = findViewById(R.id.hitme);
        t.setVisibility(View.VISIBLE);

        View a = findViewById(R.id.again);
        a.setVisibility(View.GONE);

        Random r = new Random();

        int x = r.nextInt(displayWidth - 150);
        int y = r.nextInt(displayHeight - 150);
        System.out.println(""+x + ", " + y);
        if(y<100){
            y+=100;
        }
        if(x<100){
            x+=100;
        }
        if(x> (displayWidth-150)){
            x-=150;
        }
        if(y> (displayHeight-150)){
            y-=150;
        }
        t.setX(x);
        t.setY(y);
    }


    public void onTapClick(View view){
        View t = findViewById(R.id.hitme);

        score++;

        TextView s = (TextView)(findViewById(R.id.score));
        s.setText("Score: "+ score);

        if(score == timeInc){

            if(timer != null){
                timer.cancel();
                timer = null;
            }
            sec = sec + sec;
          timer = new CountDownTimer(sec, 1000) {

                TextView timerField = (TextView) findViewById(R.id.timer);
                View h = findViewById(R.id.hitme);
                View a  = findViewById(R.id.again);

                public void onTick(long millisUntilFinished) {
                    displayTime = millisUntilFinished / 1000;
                        timerField.setText("Time: " + displayTime);


                }

                public void onFinish() {
                    timerField.setText("Next");
                    h.setVisibility(View.GONE);
                    a.setVisibility(View.VISIBLE);
                }
            }.start();

            timeInc = timeInc + timeInc;
        }


        Random r = new Random();

        int x = r.nextInt(displayWidth)- 150;
        int y = r.nextInt(displayHeight)- 150;

        System.out.println(""+x + ", " + y);
        if(y<100){
            y+=100;
        }
        if(x<100){
            x+=100;
        }
        if(x> (displayWidth-150)){
            x-=150;
        }
        if(y> (displayHeight-150)){
            y-=151;
        }
        t.setX(x);
        t.setY(y);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public void onBackPressed() {
    }

}
