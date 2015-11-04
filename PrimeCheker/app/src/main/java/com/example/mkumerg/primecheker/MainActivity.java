package com.example.mkumerg.primecheker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Creating the Variables.
    Button showPrime;
    TextView primeList;
    EditText etSt, etNd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void init() {

        //Setting the value of Variables.
        showPrime = (Button) findViewById(R.id.swPrime);
        primeList = (TextView) findViewById(R.id.tvPrime);
        etSt = (EditText) findViewById(R.id.etStrt);
        etNd = (EditText) findViewById(R.id.etEnd);

        //Initialize OnClickListener.
        showPrime.setOnClickListener(this);
    }

    private boolean isPrime(int num) {
        switch (num) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                return true;
            default:
                for (int i = 2; i < num / 2 + 1; i++) {
                    if (num % i == 0)
                        return false;
                }
                return true;
        }
    }

    @Override
    public void onClick(View v) {
        if (etSt.getText().toString().trim().length() == 0 && etNd.getText().toString().trim().length() == 0) {
            etSt.setError("You have not Entered any Starting point");
            etNd.setError("You have not Entered any Ending point");
            return;
        } else if (etSt.getText().toString().trim().length() == 0) {
            etSt.setError("You have not Entered any Starting point");
            etSt.requestFocus();
            return;
        } else if (etNd.getText().toString().trim().length() == 0) {
            etNd.setError("You have not Entered any Ending point");
            etNd.requestFocus();
            return;
        } else {
            ArrayList<Integer> primes = new ArrayList<>();
            int stp = Integer.parseInt(etSt.getText().toString());
            int endp = Integer.parseInt(etNd.getText().toString());
            for (int i = stp; i <= endp; i++) {
                if (isPrime(i)) {
                    primes.add(i);
                }
            }
            primeList.setText(primes.toString());
        }
    }
}
