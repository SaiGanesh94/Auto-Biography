package com.example.divum.users_home_page;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.divum.auto_biography.ListingActors;
import com.example.divum.auto_biography.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UsersHomePage extends AppCompatActivity {

    @Bind(R.id.cv_actors)
    CardView mCvActors;

    @Bind(R.id.cv_directors)
    CardView mCvDirectors;

    @Bind(R.id.cv_cinematographer)
    CardView mCvCinematographer;

    @Bind(R.id.cv_music_director)
    CardView mCvMusicDirectors;

    @Bind(R.id.cv_art_director)
    CardView mCvArtDirector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_homepage_collapsing_toolbar);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Auto Biography");

        mCvActors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsersHomePage.this, ListingActors.class);
                startActivity(intent);
            }
        });

        mCvDirectors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UsersHomePage.this, ListingActors.class);
                startActivity(intent);
            }
        });

        mCvCinematographer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UsersHomePage.this, ListingActors.class);
                startActivity(intent);
            }
        });

        mCvMusicDirectors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UsersHomePage.this, ListingActors.class);
                startActivity(intent);
            }
        });

        mCvArtDirector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UsersHomePage.this, ListingActors.class);
                startActivity(intent);
            }
        });
    }

}
