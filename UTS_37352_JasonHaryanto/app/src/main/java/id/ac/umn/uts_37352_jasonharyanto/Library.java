package id.ac.umn.uts_37352_jasonharyanto;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Objects;

public class Library extends AppCompatActivity {

    RecyclerView rvDaftarSound;
    LibraryAdapter mAdapter;
    LinkedList<SumberSound> daftarSound = new LinkedList<>();
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Intent mainIntent = getIntent();
        String login = mainIntent.getStringExtra("Nama");

        getSupportActionBar(). setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(login);

        Toast.makeText(Library.this,"Selamat Datang, " + login, Toast.LENGTH_LONG).show();

        isiDaftarSound();
        rvDaftarSound = (RecyclerView) findViewById(R.id.RV);
        mAdapter = new LibraryAdapter(this, daftarSound);
        rvDaftarSound.setAdapter(mAdapter);
        rvDaftarSound.setLayoutManager(new LinearLayoutManager(this));

        btnDelete = (Button) findViewById(R.id.btnDelete);
    }

    public void isiDaftarSound(){
        daftarSound.add(new SumberSound("Cheer", "Audience Cheer and Applause", "android.resource://" + getPackageName() + "/" + R.raw.cheer));
        daftarSound.add(new SumberSound("Clock", "Clock Beeping Sound", "android.resource://" + getPackageName() + "/" + R.raw.clock));
        daftarSound.add(new SumberSound("Cough", "A Man Coughing", "android.resource://" + getPackageName() + "/" + R.raw.cough));
        daftarSound.add(new SumberSound("Horror", "Horror Film Sounds", "android.resource://" + getPackageName() + "/" + R.raw.horror));
        daftarSound.add(new SumberSound("Laugh", "People Laughing", "android.resource://" + getPackageName() + "/" + R.raw.laugh));
        daftarSound.add(new SumberSound("Lion", "Lion's Roar", "android.resource://" + getPackageName() + "/" + R.raw.lion));
        daftarSound.add(new SumberSound("Roar", "Beast Animal Roar", "android.resource://" + getPackageName() + "/" + R.raw.roar));
        daftarSound.add(new SumberSound("Street", "Crowd walking on street", "android.resource://" + getPackageName() + "/" + R.raw.street));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            Intent profileIntent = new Intent(Library.this, Profile.class);
            startActivity(profileIntent);
        } else{
            Intent homeIntent = new Intent(Library.this, MainActivity.class);
            startActivity(homeIntent);
        }

        return super.onOptionsItemSelected(item);
    }
}