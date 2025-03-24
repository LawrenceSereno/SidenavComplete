package com.example.newjks;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private CardView cardGoogleMap, cardGames, cardEWallet, cardTwitter,
            cardYoutube, cardBrowser, cardFlashlight, cardCalculator;
    private View HomeFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Show a Toast message when the HomeFragment loads

        // Initialize CardViews
        cardGoogleMap = view.findViewById(R.id.cardGoogleMap);
        cardGames = view.findViewById(R.id.cardGames);
        cardEWallet = view.findViewById(R.id.cardEWallet);
        cardTwitter = view.findViewById(R.id.cardTwitter);
        cardYoutube = view.findViewById(R.id.cardYoutube);
        cardBrowser = view.findViewById(R.id.cardBrowser);
        cardFlashlight = view.findViewById(R.id.cardFlashlight);
        cardCalculator = view.findViewById(R.id.cardCalculator);

        // Set Click Listeners
        cardGoogleMap.setOnClickListener(v -> openLink("https://www.google.com/maps"));
        cardGames.setOnClickListener(v -> openLink("https://play.google.com/store/apps"));
        cardEWallet.setOnClickListener(v -> openLink("https://www.paypal.com"));
        cardTwitter.setOnClickListener(v -> openLink("https://twitter.com"));
        cardYoutube.setOnClickListener(v -> openLink("https://www.youtube.com"));
        cardBrowser.setOnClickListener(v -> openLink("https://www.google.com"));
        cardCalculator.setOnClickListener(v -> openCalculator(HomeFragment, this,Calculator.class));
        cardFlashlight.setOnClickListener(v -> toggleFlashlight());
        cardCalculator.setOnClickListener(v -> toggleCalculator());

        return view;
    }

    private void openCalculator(View view, com.example.newjks.HomeFragment homeFragment, Class<Calculator> calculatorClass) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_CALCULATOR);
        startActivity(intent);
    }

    // Method to open a website link
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void toggleCalculator() {
        Toast.makeText(getContext(), "Under Maintenance", Toast.LENGTH_SHORT).show();
    }
        // Toggle Flashlight (Requires Permission)
        private void toggleFlashlight () {
            Toast.makeText(getContext(), "Under Maintenance.", Toast.LENGTH_LONG).show();

        }


}

