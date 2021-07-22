package com.example.covicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayDeque;
import java.util.Deque;

public class bottomNavigation extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Deque<Integer> integerDeque = new ArrayDeque<>(4);
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setItemIconTintList(null);

        integerDeque.push(R.id.bn_home);

        loadFragment(new HomeFragment());

        bottomNavigationView.setSelectedItemId(R.id.bn_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        if(integerDeque.contains(id)){
                            if (id == R.id.bn_home){
                                if (integerDeque.size() != 1){
                                    if (flag){
                                        integerDeque.addFirst(R.id.bn_home);
                                        flag = false;
                                    }
                                }
                            }
                            integerDeque.remove(id);
                        }
                        integerDeque.push(id);
                        loadFragment(getFragment(item.getItemId()));
                        return true;
                    }
                }
        );
    }

    private Fragment getFragment(int itemId) {
        switch (itemId){
            case R.id.bn_home:
                bottomNavigationView.getMenu().getItem(0).setChecked(true);
                return new HomeFragment();
            case R.id.bn_stat:
                bottomNavigationView.getMenu().getItem(1).setChecked(true);
                return new StatFragment();
            case R.id.bn_contact:
                bottomNavigationView.getMenu().getItem(2).setChecked(true);
                return new Contact2Fragment();
            case R.id.bn_setting:
                bottomNavigationView.getMenu().getItem(3).setChecked(true);
                return new SettingsFragment();
        }
        bottomNavigationView.getMenu().getItem(0).setChecked(true);
        return new HomeFragment();
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment,fragment,fragment.getClass().getSimpleName())
                .commit();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Are you sure want to Exit?")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })

                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}