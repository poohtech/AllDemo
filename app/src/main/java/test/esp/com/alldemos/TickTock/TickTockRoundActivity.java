package test.esp.com.alldemos.TickTock;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import test.esp.com.alldemos.R;

public class TickTockRoundActivity extends AppCompatActivity implements View.OnClickListener {

    private Display display;
    private TextView box1, box2, box3, box4, box5, box6, box7, box8, box9;
    TextView txtTurn;
    TextView txtReload;
    private int turn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticktock_round);

        display = this.getWindowManager().getDefaultDisplay();
        findviewbyId();
        setTurn();

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(100); //You can manage the time of the blink with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        txtTurn.startAnimation(anim);

    }

    void setTurn() {
        if (turn == 0) {
            txtTurn.setText("Turn :- Player 1");
        } else {
            txtTurn.setText("Turn :- Player 2");
        }
    }

    void checkResult() {
        if (box1.getText().toString().equalsIgnoreCase("0") && box2.getText().toString().equalsIgnoreCase("0") && box3.getText().toString().equalsIgnoreCase("0")) {
            viewFinishDailog(0);
        } else if (box1.getText().toString().equalsIgnoreCase("0") && box4.getText().toString().equalsIgnoreCase("0") && box7.getText().toString().equalsIgnoreCase("0")) {
            viewFinishDailog(0);
        } else if (box1.getText().toString().equalsIgnoreCase("0") && box5.getText().toString().equalsIgnoreCase("0") && box9.getText().toString().equalsIgnoreCase("0")) {
            viewFinishDailog(0);
        } else if (box2.getText().toString().equalsIgnoreCase("0") && box5.getText().toString().equalsIgnoreCase("0") && box8.getText().toString().equalsIgnoreCase("0")) {
            viewFinishDailog(0);
        } else if (box3.getText().toString().equalsIgnoreCase("0") && box6.getText().toString().equalsIgnoreCase("0") && box9.getText().toString().equalsIgnoreCase("0")) {
            viewFinishDailog(0);
        } else if (box3.getText().toString().equalsIgnoreCase("0") && box5.getText().toString().equalsIgnoreCase("0") && box7.getText().toString().equalsIgnoreCase("0")) {
            viewFinishDailog(0);
        } else if (box4.getText().toString().equalsIgnoreCase("0") && box5.getText().toString().equalsIgnoreCase("0") && box6.getText().toString().equalsIgnoreCase("0")) {
            viewFinishDailog(0);
        } else if (box7.getText().toString().equalsIgnoreCase("0") && box8.getText().toString().equalsIgnoreCase("0") && box9.getText().toString().equalsIgnoreCase("0")) {
            viewFinishDailog(0);
        } else if (box1.getText().toString().equalsIgnoreCase("*") && box2.getText().toString().equalsIgnoreCase("*") && box3.getText().toString().equalsIgnoreCase("*")) {
            viewFinishDailog(1);
        } else if (box1.getText().toString().equalsIgnoreCase("*") && box4.getText().toString().equalsIgnoreCase("*") && box7.getText().toString().equalsIgnoreCase("*")) {
            viewFinishDailog(1);
        } else if (box1.getText().toString().equalsIgnoreCase("*") && box5.getText().toString().equalsIgnoreCase("*") && box9.getText().toString().equalsIgnoreCase("*")) {
            viewFinishDailog(1);
        } else if (box2.getText().toString().equalsIgnoreCase("*") && box5.getText().toString().equalsIgnoreCase("*") && box8.getText().toString().equalsIgnoreCase("*")) {
            viewFinishDailog(1);
        } else if (box3.getText().toString().equalsIgnoreCase("*") && box6.getText().toString().equalsIgnoreCase("*") && box9.getText().toString().equalsIgnoreCase("*")) {
            viewFinishDailog(1);
        } else if (box3.getText().toString().equalsIgnoreCase("*") && box5.getText().toString().equalsIgnoreCase("*") && box7.getText().toString().equalsIgnoreCase("*")) {
            viewFinishDailog(1);
        } else if (box4.getText().toString().equalsIgnoreCase("*") && box5.getText().toString().equalsIgnoreCase("*") && box6.getText().toString().equalsIgnoreCase("*")) {
            viewFinishDailog(1);
        } else if (box7.getText().toString().equalsIgnoreCase("*") && box8.getText().toString().equalsIgnoreCase("*") && box9.getText().toString().equalsIgnoreCase("*")) {
            viewFinishDailog(1);
        }
    }

    void findviewbyId() {
        int wh = display.getWidth() / 3;
        box1 = (TextView) findViewById(R.id.box1);
        box2 = (TextView) findViewById(R.id.box2);
        box3 = (TextView) findViewById(R.id.box3);
        box4 = (TextView) findViewById(R.id.box4);
        box5 = (TextView) findViewById(R.id.box5);
        box6 = (TextView) findViewById(R.id.box6);
        box7 = (TextView) findViewById(R.id.box7);
        box8 = (TextView) findViewById(R.id.box8);
        box9 = (TextView) findViewById(R.id.box9);
        txtTurn = (TextView) findViewById(R.id.txtTurn);
        txtReload = (TextView) findViewById(R.id.txtReload);

        box1.setWidth(wh);
        box1.setHeight(wh);

        box2.setWidth(wh);
        box2.setHeight(wh);

        box3.setWidth(wh);
        box3.setHeight(wh);

        box4.setWidth(wh);
        box4.setHeight(wh);

        box5.setWidth(wh);
        box5.setHeight(wh);

        box6.setWidth(wh);
        box6.setHeight(wh);

        box7.setWidth(wh);
        box7.setHeight(wh);

        box8.setWidth(wh);
        box8.setHeight(wh);

        box9.setWidth(wh);
        box9.setHeight(wh);

        box1.setOnClickListener(this);
        box2.setOnClickListener(this);
        box3.setOnClickListener(this);
        box4.setOnClickListener(this);
        box5.setOnClickListener(this);
        box6.setOnClickListener(this);
        box7.setOnClickListener(this);
        box8.setOnClickListener(this);
        box9.setOnClickListener(this);
        txtReload.setOnClickListener(this);
    }
    void viewFinishDailog(int pos)
    {
        AlertDialog.Builder alertDialog= new AlertDialog.Builder(this);
        alertDialog.setTitle("Game finish");

        if (pos == 0) {
            alertDialog.setMessage("Player 1 win");
        } else {
            alertDialog.setMessage("Player 2 win");
        }
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Intent intent = new Intent(TickTockRoundActivity.this, TickTockRoundActivity.class);
                startActivity(intent);
            }
        });
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.txtReload:
                this.finish();
                Intent intent = new Intent(this, TickTockRoundActivity.class);
                startActivity(intent);
                break;

            case R.id.box1:
                if (turn == 0) {
                    box1.setText("0");
                    box1.setBackgroundColor(Color.parseColor("#ff0000"));
                    turn = 1;
                } else {
                    box1.setText("*");
                    box1.setBackgroundColor(Color.parseColor("#0000ff"));
                    turn = 0;
                }
                box1.setEnabled(false);
                setTurn();
                checkResult();
                break;

            case R.id.box2:

                if (turn == 0) {
                    box2.setText("0");
                    box2.setBackgroundColor(Color.parseColor("#ff0000"));
                    turn = 1;
                } else {
                    box2.setText("*");
                    box2.setBackgroundColor(Color.parseColor("#0000ff"));
                    turn = 0;
                }
                box2.setEnabled(false);
                setTurn();
                checkResult();

                break;
            case R.id.box3:

                if (turn == 0) {
                    box3.setText("0");
                    box3.setBackgroundColor(Color.parseColor("#ff0000"));
                    turn = 1;
                } else {
                    box3.setText("*");
                    box3.setBackgroundColor(Color.parseColor("#0000ff"));
                    turn = 0;
                }
                box3.setEnabled(false);
                setTurn();
                checkResult();

                break;
            case R.id.box4:

                if (turn == 0) {
                    box4.setText("0");
                    box4.setBackgroundColor(Color.parseColor("#ff0000"));
                    turn = 1;
                } else {
                    box4.setText("*");
                    box4.setBackgroundColor(Color.parseColor("#0000ff"));
                    turn = 0;
                }
                box4.setEnabled(false);
                setTurn();
                checkResult();

                break;
            case R.id.box5:

                if (turn == 0) {
                    box5.setText("0");
                    box5.setBackgroundColor(Color.parseColor("#ff0000"));
                    turn = 1;
                } else {
                    box5.setText("*");
                    box5.setBackgroundColor(Color.parseColor("#0000ff"));
                    turn = 0;
                }
                box5.setEnabled(false);
                setTurn();
                checkResult();
                break;
            case R.id.box6:

                if (turn == 0) {
                    box6.setText("0");
                    box6.setBackgroundColor(Color.parseColor("#ff0000"));
                    turn = 1;
                } else {
                    box6.setText("*");
                    box6.setBackgroundColor(Color.parseColor("#0000ff"));
                    turn = 0;
                }
                box6.setEnabled(false);
                setTurn();
                checkResult();

                break;
            case R.id.box7:

                if (turn == 0) {
                    box7.setText("0");
                    box7.setBackgroundColor(Color.parseColor("#ff0000"));
                    turn = 1;
                } else {
                    box7.setText("*");
                    box7.setBackgroundColor(Color.parseColor("#0000ff"));
                    turn = 0;
                }
                box7.setEnabled(false);
                setTurn();
                checkResult();
                break;
            case R.id.box8:

                if (turn == 0) {
                    box8.setText("0");
                    box8.setBackgroundColor(Color.parseColor("#ff0000"));
                    turn = 1;
                } else {
                    box8.setText("*");
                    box8.setBackgroundColor(Color.parseColor("#0000ff"));
                    turn = 0;
                }
                box8.setEnabled(false);
                setTurn();
                checkResult();
                break;

            case R.id.box9:

                if (turn == 0) {
                    box9.setText("0");
                    box9.setBackgroundColor(Color.parseColor("#ff0000"));
                    turn = 1;
                } else {
                    box9.setText("*");
                    box9.setBackgroundColor(Color.parseColor("#0000ff"));
                    turn = 0;
                }
                box9.setEnabled(false);
                setTurn();
                checkResult();

                break;
        }
    }
}
