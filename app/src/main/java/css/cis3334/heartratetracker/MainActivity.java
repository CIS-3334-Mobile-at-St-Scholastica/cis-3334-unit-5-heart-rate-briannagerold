package css.cis3334.heartratetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    HeartRateList heartRateList;        // The list of heart rate objects
    ArrayAdapter<HeartRate> hrAdapter;
    ListView lvHeartRates;
    TextView txtSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heartRateList = new HeartRateList();
        heartRateList.InitRandomElderly();

        lvHeartRates = findViewById(R.id.lvHeartRates);
        txtSelect = findViewById(R.id.txtSelect);

        hrAdapter = new HeartRateAdapter(this, R.layout.heart_rate_row, R.id.textViewPulse, heartRateList);
        hrAdapter.setDropDownViewResource(R.layout.heart_rate_row);
        lvHeartRates.setAdapter(hrAdapter);

        lvHeartRates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HeartRate hr = (HeartRate) parent.getItemAtPosition(position);
                Intent detailActIntent = new Intent(parent.getContext(), DetailsActivity.class);
                detailActIntent.putExtra("hr", hr);
                startActivity(detailActIntent);
            }
        });
    }
}
