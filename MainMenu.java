package com.example.robert.smilesad;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainMenu extends Activity {

    private RelativeLayout relativeLayout;
    private Button newGameButton, continueButton, optionsButton, quitGameButton;
    private ImageButton titleBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        titleBackground = (ImageButton) findViewById(R.id.titlebackground);
        titleBackground.setBackgroundResource(R.drawable.buttonactivebackground);


        newGameButton = (Button) findViewById(R.id.newgamebutton);
        newGameButton.setBackgroundResource(R.drawable.buttonactivebackground);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, Level1.class));
            }
        });

        continueButton = (Button) findViewById(R.id.continuebutton);
        continueButton.setBackgroundResource(R.drawable.buttoninactivebackground);

        optionsButton = (Button) findViewById(R.id.optionsmenu);
        optionsButton.setBackgroundResource(R.drawable.buttonactivebackground);

        quitGameButton = (Button) findViewById(R.id.quitgamebutton);
        quitGameButton.setBackgroundResource(R.drawable.buttonactivebackground);
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
