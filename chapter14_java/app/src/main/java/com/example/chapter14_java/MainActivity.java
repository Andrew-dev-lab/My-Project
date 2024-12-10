package com.example.chapter14_java;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && requestCode == 0) {
            boolean allGranted = true;
            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    allGranted = false;
                    break;
                }
            }
            if (allGranted) {
                loadMap();
            } else {
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableEdgeToEdge();
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBarsInsets.left, systemBarsInsets.top, systemBarsInsets.right, systemBarsInsets.bottom);
            return insets;
        });

        loadMap();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap map) {
        boolean isAccessFineLocationGranted = ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED;

        boolean isAccessCoarseLocationGranted = ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED;

        if (isAccessFineLocationGranted && isAccessCoarseLocationGranted) {
            map.setMyLocationEnabled(true);

            MarkerOptions marker1 = new MarkerOptions()
                    .position(new LatLng(25.033611, 121.565000))
                    .title("台北101")
                    .draggable(true);
            map.addMarker(marker1);

            MarkerOptions marker2 = new MarkerOptions()
                    .position(new LatLng(25.047924, 121.517081))
                    .title("台北車站")
                    .draggable(true);
            map.addMarker(marker2);

            PolylineOptions polylineOpt = new PolylineOptions()
                    .add(new LatLng(25.033611, 121.565000))
                    .add(new LatLng(25.032435, 121.534905))
                    .add(new LatLng(25.047924, 121.517081))
                    .color(Color.BLUE)
                    .width(10f);
            map.addPolyline(polylineOpt);

            map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(25.035, 121.54), 13f));
        } else {
            ActivityCompat.requestPermissions(
                    this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0
            );
        }
    }

    private void loadMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapFragment);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    private void enableEdgeToEdge() {
    }
}