package fr.umontpellier.exercice1capteur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    //Exercice1
    ListView listView ;
    SensorManager sensorManager ;
    List<Sensor> listsensor;
    List<String> liststring ;
    ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Exercice1
        listView = (ListView)findViewById(R.id.listview1);
        liststring = new ArrayList<String>();
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        listsensor = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for(int i=0; i<listsensor.size(); i++){
            liststring.add(listsensor.get(i).getName());
        }

        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_2,
                android.R.id.text1, liststring
        );

       listView.setAdapter(adapter);
    }
}