package gbactol.cs134.miracosta.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import gbactol.cs134.miracosta.edu.Model.InteriorRoom;

public class MainActivity extends AppCompatActivity {

    private EditText lengthValue;
    private EditText widthValue;
    private EditText heightValue;
    private EditText doorValue;
    private EditText windowValue;
    private Button computeGallonsButton;
    private Button helpButton;
    private TextView interiorSurfaceAreaValue;
    private TextView gallonsNeededValue;
    private InteriorRoom roomDesign;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lengthValue = findViewById(R.id.lengthValue);
        widthValue = findViewById(R.id.widthValue);
        heightValue = findViewById(R.id.heightValue);

        doorValue = findViewById(R.id.doorsValue);
        windowValue = findViewById(R.id.windowsValue);

        computeGallonsButton = findViewById(R.id.computeGallonsButton);
        helpButton = findViewById(R.id.helpButton);

        interiorSurfaceAreaValue = findViewById(R.id.interiorSurfaceAreaValue);
        gallonsNeededValue = findViewById(R.id.gallonsNeededValue);

        roomDesign = new InteriorRoom();


        computeGallonsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lengthValue.getText().toString().equals(""))
                {
                    roomDesign.setLength(0);
                }
                else
                {
                    //if not, display the current bill
                    roomDesign.setLength(Integer.parseInt(lengthValue.getText().toString()));
                }

                if(widthValue.getText().toString().equals(""))
                {
                    roomDesign.setWidth(0.0);
                }
                else
                {
                    //if not, display the current bill
                    roomDesign.setWidth(Double.parseDouble(widthValue.getText().toString()));
                }

                if(heightValue.getText().toString().equals(""))
                {
                    roomDesign.setHeight(0.0);
                }
                else
                {
                    //if not, display the current bill
                    roomDesign.setHeight(Double.parseDouble(heightValue.getText().toString()));
                }

                if(doorValue.getText().toString().equals(""))
                {
                    roomDesign.setDoors(0);
                }
                else
                {
                    //if not, display the current bill
                    roomDesign.setDoors(Integer.parseInt(doorValue.getText().toString()));
                }
                if(windowValue.getText().toString().equals(""))
                {
                    roomDesign.setWindows(0);
                }
                else
                {
                    //if not, display the current bill
                    roomDesign.setWindows(Integer.parseInt(windowValue.getText().toString()));
                }

                interiorSurfaceAreaValue.setText(String.valueOf(roomDesign.totalSurfaceArea()));
                gallonsNeededValue.setText(String.valueOf(roomDesign.gallonsofPaintRequired()));


            }
        });





    }
    public void helpMenu(View v)
    {

        Intent helpTransfer = new Intent(this, HelpActivity.class);

        helpTransfer.putExtra("gallons", gallonsNeededValue.getText().toString());
        startActivity(helpTransfer);

    }
}
