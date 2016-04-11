package commrhardman23.httpsgithub.towersofhanoi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SolveTowers extends AppCompatActivity {

    private EditText edtxtDiskNumber;
    private TextView txtvwSolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_towers);

        edtxtDiskNumber = (EditText) findViewById(R.id.edtxtDiskNumber);
        txtvwSolution = (TextView) findViewById(R.id.txtvwSolution);
    }

    /**
     * solveTowersPuzzle is the method that is called when the user inputs a number of disks for
     * the Towers of Hanoi puzzle
     * @param vw is the button that is associated with the solveTowersPuzzle method
     */
    public void solveTowersPuzzle(View vw){

        int userEnteredDisks = 0;

        if(edtxtDiskNumber.getText().toString().equals("")){
            txtvwSolution.setText("You must enter a number!");
        } else {
            userEnteredDisks = Integer.parseInt(edtxtDiskNumber.getText().toString());
        }

        txtvwSolution.setText("The sequence of moves needed to solve the Towers of Hanoi puzzle" +
                " are:\n");

        towerSolve(userEnteredDisks, 'A', 'C', 'B');

    }

    /**
     * towerSolve is the recursive method that solves the Towers of Hanoi puzzle
     * @param diskNumber is the disk that should be moved at this step
     * @param fromPeg is the peg to move from
     * @param toPeg is the peg to move to
     * @param auxPeg is the third peg that is not involved in this step
     */
    public void towerSolve(int diskNumber, char fromPeg, char toPeg, char auxPeg){

        if(diskNumber == 1) {

            txtvwSolution.setText(txtvwSolution.getText().toString() + String.format("\nMove disk 1 from peg %c to peg %c", fromPeg, toPeg));
            return;

        }

        towerSolve(diskNumber - 1, fromPeg, auxPeg, toPeg);
        txtvwSolution.setText(txtvwSolution.getText().toString() + String.format("\nMove disk %d from peg %c to peg %c", diskNumber, fromPeg, toPeg));
        towerSolve(diskNumber - 1, auxPeg, toPeg, fromPeg);

    }
}
