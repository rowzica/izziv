package com.gamerowzixgmail.izziv;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String JSON_URL = "http://api.themoviedb.org/3/movie/264660?api_key=c4ddfd471c809b69c0b52aad79da6fea";

    private Button buttonGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageView = (ImageView) findViewById(R.id.ImageViewID);

        Picasso.with(this)
                //.load("http://image.tmdb.org/t/p/original/btbRB7BrD887j5NrvjxceRDmaot.jpg")
                .load("http://image.tmdb.org/t/p/w500/btbRB7BrD887j5NrvjxceRDmaot.jpg")

                .fit()
                .into(imageView);

        sendRequest();

       /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }


    private void sendRequest(){
        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json){
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();
        TextView overviewText = (TextView)findViewById(R.id.overviewId);
        //TextView titleText = (TextView)findViewById(R.id.titleId);
        TextView ReleaseDateText = (TextView)findViewById(R.id.releaseDateTextId);
        TextView RunTimeText = (TextView)findViewById(R.id.runTimeTextId);
        TextView RevenueText = (TextView)findViewById(R.id.revenueTextId);
        TextView VoteAverageText = (TextView)findViewById(R.id.voteAverageId);
        TextView VoteCountText = (TextView)findViewById(R.id.voteCountId);
        overviewText.setText(pj.overview);
        //titleText.setText(pj.original_title);
        ReleaseDateText.setText(pj.release_date);
        RunTimeText.setText(pj.runtime);
        RevenueText.setText("$ "+pj.revenue);
        VoteAverageText.setText(pj.vote_average);
        VoteCountText.setText("( "+pj.vote_count+" votes)");
        //CustomList cl = new CustomList(this, ParseJSON.ids,ParseJSON.names,ParseJSON.emails);
        //listView.setAdapter(cl);
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

    @Override
    public void onClick(View v) {
        sendRequest();
    }
}
