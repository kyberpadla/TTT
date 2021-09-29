package com.example.pr1;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity<voi> extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    int[] field = new int[9];
    int turn = 0;
    int winchk = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        for (int i = 0; i < 9; i++)
        {
            field[i] = 10+i;
        }
        btn1.setOnClickListener(view -> {
            if (turn % 2 == 0)
            {
                btn1.setText("X");
                field[0] = 0;
            }
            else
                {
                btn1.setText("O");
                field[0] = 1;
                }
            turn++;
            btn1.setEnabled(false);
            WinCondition();
        });
        btn2.setOnClickListener(view -> {
            if (turn % 2 == 0)
            {
                btn2.setText("X");
                field[1] = 0;
            }
            else
                {
                btn2.setText("O");
                field[1] = 1;
                }
            turn++;
            btn2.setEnabled(false);
            WinCondition();
        });
        btn3.setOnClickListener(view -> {
            if (turn % 2 == 0)
            {
                btn3.setText("X");
                field[2] = 0;
            }
            else
                {
                btn3.setText("O");
                field[2] = 1;
                }
            turn++;
            btn3.setEnabled(false);
            WinCondition();
        });
        btn4.setOnClickListener(view -> {
            if (turn % 2 == 0)
            {
                btn4.setText("X");
                field[3] = 0;
            }
            else
                {
                btn4.setText("O");
                field[3] = 1;
                }
            turn++;
            btn4.setEnabled(false);
            WinCondition();
        });
        btn5.setOnClickListener(view -> {
            if (turn % 2 == 0)
            {
                btn5.setText("X");
                field[4] = 0;
            }
            else
                {
                btn5.setText("O");
                field[4] = 1;
                }
            btn5.setEnabled(false);
            turn++;
            WinCondition();
        });
        btn6.setOnClickListener(view -> {
            if (turn % 2 == 0)
            {
                btn6.setText("X");
                field[5] = 0;
            }
            else
                {
                btn6.setText("O");
                field[5] = 1;
                }
            turn++;
            btn6.setEnabled(false);
            WinCondition();
        });
        btn7.setOnClickListener(view -> {
            if (turn % 2 == 0)
            {
                btn7.setText("X");
                field[6] = 0;
            } else
                {
                btn7.setText("O");
                field[6] = 1;
                }
            turn++;
            btn7.setEnabled(false);
            WinCondition();
        });
        btn8.setOnClickListener(view -> {
            if (turn % 2 == 0)
            {
                btn8.setText("X");
                field[7] = 0;
            }
            else
                {
                btn8.setText("O");
                field[7] = 1;
                }
            turn++;
            btn8.setEnabled(false);
            WinCondition();
        });
        btn9.setOnClickListener(view -> {
            if (turn % 2 == 0)
            {
                btn9.setText("X");
                field[8] = 0;
            }
            else
                {
                btn9.setText("O");
                field[8] = 1;
                }
            turn++;
            btn9.setEnabled(false);
            WinCondition();
        });
    }

    public boolean HorizontalCHK()
    {
        return (field[0] == field[1] && field[1] == field[2]) || (field[3] == field[4] && field[4] == field[5]) || (field[6] == field[7] && field[7] == field[8]);
    }
    public boolean VerticalCHK()
    {
        return (field[0] == field[3] && field[3] == field[6]) || (field[1] == field[4] && field[4] == field[7]) || (field[2] == field[5] && field[5] == field[8]);
    }
    public boolean DiagonalCHK()
    {
        return (field[0] == field[4] && field[4] == field[8]) || (field[2] == field[4] && field[4] == field[6]);
    }
    public void FullDisable()
    {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }

    public void WinCondition() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        if (turn % 2 != 0) {
            if (HorizontalCHK() || VerticalCHK() || DiagonalCHK())
            {
                winchk =1;
                FullDisable();
                intent.putExtra("Value", "Выиграли крестики!");
                intent.putExtra("Turns", turn);
                startActivity(intent);
            }
        }
        if (turn % 2 == 0) {
            if (HorizontalCHK() || VerticalCHK() || DiagonalCHK())
           {
                winchk=1;
                FullDisable();
                intent.putExtra("Value", "Выиграли нолики!");
                intent.putExtra("Turns", turn);
                startActivity(intent);
           }
        }
        else if(turn==9 && winchk!=1){
            FullDisable();
            intent.putExtra("Value", "Ничья!");
            intent.putExtra("Turns", turn);
            startActivity(intent);
        }

    }

}