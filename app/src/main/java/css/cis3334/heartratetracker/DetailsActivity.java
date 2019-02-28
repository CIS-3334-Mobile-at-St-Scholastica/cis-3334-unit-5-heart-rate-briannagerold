package css.cis3334.heartratetracker;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView txtPulse, txtRange, txtDescription, txtHeading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();
        HeartRate hr = (HeartRate) extras.getSerializable("hr");

        txtHeading = findViewById(R.id.txtHeading);
        txtPulse = findViewById(R.id.txtPulse);
        txtRange = findViewById(R.id.txtRange);
        txtDescription = findViewById(R.id.txtDescription);


        txtPulse.setText(hr.getPulse().toString());
        txtRange.setText(hr.getRangeName());
        txtDescription.setText(hr.getRangeDescrtiption());

        if(hr.getRangeName().equals("Resting")){
            txtHeading.setTextColor(ContextCompat.getColor(this, R.color.Resting));
        }
        else if(hr.getRangeName().equals("Moderate")){
            txtHeading.setTextColor(ContextCompat.getColor(this, R.color.Moderate));
        }
        else if(hr.getRangeName().equals("Endurance")){
            txtHeading.setTextColor(ContextCompat.getColor(this, R.color.Endurance));
        }
        else if(hr.getRangeName().equals("Aerobic")){
            txtHeading.setTextColor(ContextCompat.getColor(this, R.color.Aerobic));
        }
        else if(hr.getRangeName().equals("Anaerobic")){
            txtHeading.setTextColor(ContextCompat.getColor(this, R.color.Anaerobic));
        }
        else if(hr.getRangeName().equals("Red zone")){
            txtHeading.setTextColor(ContextCompat.getColor(this, R.color.RedZone));
        }
    }
}
