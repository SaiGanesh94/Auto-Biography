package com.example.divum.auto_biography;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class ListingActors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_actors);

        Toolbar toolbar = (Toolbar) findViewById(R.id.actors_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        ArrayList<ActorsEntity> actors=new ArrayList<ActorsEntity>();

        for(int i=0;i<10;i++){
            ActorsEntity actorsEntity=new ActorsEntity("Vijay",41,"Vijay (born Joseph Vijay Chandrasekhar) is an Indian film actor and playback singer who works in the Tamil film industry. Son of film director and producer S. A. Chandrasekhar, he started his career as a child actor in the movie Vetri and later made his debut as a lead actor in the 1992 film Naalaya Theerpu, both of which were directed by his father. He also launched the Vijay Makkal Iyakkam, a social welfare organisation in 2009. Vijay was listed 28 in Forbes India's Celebrity 100 List for the year 2012, 49 in the year 2013 and 41 in the year 2014");
            actors.add(actorsEntity);
        }

        ActorsRecyclerAdapter actorsRecyclerAdapter=new ActorsRecyclerAdapter(this,actors);
        recyclerView.setAdapter(actorsRecyclerAdapter);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listing_actors, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
