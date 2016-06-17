package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.udacity.gradle.Jokes;
import com.udacity.gradle.jokedisplay.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ProgressBar spinner;
    private String joke;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button jokeButton = (Button) root.findViewById(R.id.joke_button);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchJoke();
            }
        });

        spinner = (ProgressBar) root.findViewById(R.id.progressBar);

        return root;
    }

    private void fetchJoke() {
        new EndpointsAsyncTask() {

            @Override
            protected void onPreExecute() {
                spinner.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPostExecute(final String result) {
                joke = result;
                launchJokeActivity(joke);
            }
        }.execute();
    }

    private void launchJokeActivity(String joke) {
        if (joke == null || joke.isEmpty()) {
            Toast.makeText(getContext(), R.string.empty_joke_error, Toast.LENGTH_SHORT).show();
            joke = Jokes.getJoke();
        }
        spinner.setVisibility(View.GONE);
        Intent intent = new Intent(getContext(), JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_KEY, joke);
        startActivity(intent);
    }


}
