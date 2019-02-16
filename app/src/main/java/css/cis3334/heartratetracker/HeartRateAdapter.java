package css.cis3334.heartratetracker;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HeartRateAdapter extends ArrayAdapter<HeartRate> {

    private final Context context;      // The activity calling this adapter
    private HeartRateList hrList;       // The object holding the arraylist of hear rates

    /**
     *
     * @param context The activity calling this adapter
     * @param rowLayout The xml file defining the layout for one item or row in the list
     * @param txtDummy the ID for a TextView in the row layout. Not used, but needed by the parent object
     * @param hrList The object holding the arraylist of hear rates
     */
    public HeartRateAdapter(Context context, int rowLayout, int txtDummy, HeartRateList hrList) {
        super(context, rowLayout, txtDummy, hrList.getList());
        this.context = context;
        this.hrList = hrList;
    }

    /**
     * This is called automatically to display each item in the list.
     *    Here you must fill the layout for one row or item in the list
     *
     * @param position index in the list that is being selected
     * @param convertView
     * @param parent The parent layout this list is in
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.heart_rate_row, null);
        //get the heart rate we are displaying
        HeartRate hr = hrList.getHeartRate(position);

        TextView txtPulse=(TextView)view.findViewById(R.id.textViewPulse);
        txtPulse.setText(hr.getPulse().toString());

        TextView txtRange = view.findViewById(R.id.txtRange);
        txtRange.setText(hr.getRangeName());

        if(hr.getRangeName().equals("Resting")){
            txtRange.setTextColor(ContextCompat.getColor(context, R.color.Resting));
        }
        else if(hr.getRangeName().equals("Moderate")){
            txtRange.setTextColor(ContextCompat.getColor(context, R.color.Moderate));
        }
        else if(hr.getRangeName().equals("Endurance")){
            txtRange.setTextColor(ContextCompat.getColor(context, R.color.Endurance));
        }
        else if(hr.getRangeName().equals("Aerobic")){
            txtRange.setTextColor(ContextCompat.getColor(context, R.color.Aerobic));
        }
        else if(hr.getRangeName().equals("Anaerobic")){
            txtRange.setTextColor(ContextCompat.getColor(context, R.color.Anaerobic));
        }
        else if(hr.getRangeName().equals("Red zone")){
            txtRange.setTextColor(ContextCompat.getColor(context, R.color.RedZone));
        }

        TextView txtDescription = view.findViewById(R.id.txtDescription);
        txtDescription.setText(hr.getRangeDescrtiption());

        return(view);
    }
}
