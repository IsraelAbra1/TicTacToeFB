package com.example.tictactoefb;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    FbModule fbModule;
    BoardGame boardGame;
    GameMudule gameMudule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game);

        boardGame = new BoardGame(this);
        setContentView(boardGame);

        fbModule = new FbModule(this);
        gameMudule = new GameMudule();
    }

    public void setPlayInGameActivity(Position position) {
        // This function calls from Firebase Module when onDataChange
        int line = position.getLine();
        int col = position.getCol();
        boardGame.setNewValOnBoard(line,col);
        if(gameMudule.isWin(boardGame.getArr()) != GameMudule.noWin)
            Toast.makeText(this, "win = " + gameMudule.isWin(boardGame.getArr()), Toast.LENGTH_SHORT).show();
    }

    public void setNewTouch(int line, int col) {
        Position position = new Position(line,col);
        fbModule.setPlayInFireBase(position);
    }
}