package gbactol.cs134.miracosta.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    private TextView gallonsValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);


        gallonsValue = findViewById(R.id.estimatedPaintValue);

        Intent gallonsTransfer = getIntent();

        gallonsValue.setText(gallonsTransfer.getStringExtra("gallons") + " gallons");


    }

    public void closeActivity(View v)
    {
        this.finish();
    }
}
