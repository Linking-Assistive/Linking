package com.example.hearing_java_figma;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.hearing_java_figma.DAO.KeywordDao;
import com.example.hearing_java_figma.DB.AppDatabase;
import com.example.hearing_java_figma.PO.Keyword;
import com.example.hearing_java_figma.VM.KeywordViewModel;
import com.example.hearing_java_figma.VO.KeywordTuple;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.hearing_java_figma.databinding.ActivityMainBinding;

import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_keywords, R.id.navigation_messages, R.id.navigation_devices)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
}