package com.example.robert.smilesad;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainMenu extends Activity {

    private Button newGameButton, continueButton, optionsButton, quitGameButton;
    private ImageButton titleBackground;
    public static int LEVEL = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        titleBackground = (ImageButton) findViewById(R.id.titlebackground);
        titleBackground.setBackgroundResource(R.drawable.buttonactivebackground);


        newGameButton = (Button) findViewById(R.id.newgamebutton);
        newGameButton.setBackgroundResource(R.drawable.buttonactivebackground);
        onNewGameClick();

        continueButton = (Button) findViewById(R.id.continuebutton);
        continueButton.setBackgroundResource(R.drawable.buttoninactivebackground);

        optionsButton = (Button) findViewById(R.id.optionsmenu);
        optionsButton.setBackgroundResource(R.drawable.buttonactivebackground);

        quitGameButton = (Button) findViewById(R.id.quitgamebutton);
        quitGameButton.setBackgroundResource(R.drawable.buttonactivebackground);
        onQuitGameClick();

    }
    public void onNewGameClick(){
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, Board.class));
                LEVEL++;
            }
        });
    }
    public void onQuitGameClick(){
        quitGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainMenu.this)
                        .setTitle("Closing operation")
                        .setMessage("Are you sure you want to close this game?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });
    }
}
