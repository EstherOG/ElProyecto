package com.esther.myapllication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class Mapa extends AppCompatActivity implements GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker markerPrueba, markerDrag, InfoWindow;
    private Button btn_Hibrido, btn_Normal, btn_Menu;


    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        btn_Menu = (Button) findViewById(R.id.btmenu);
        setContentView(R.layout.activity_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        btn_Hibrido = (Button) findViewById(R.id.bp1);

        btn_Normal = (Button) findViewById(R.id.bp4);

    }

    public void CambiarHibrido(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    public void CambiarNormal(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    public void CambiarMenu(View view) {
        Intent Cm = new Intent(getApplicationContext(), Menu.class);
        startActivity(Cm);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng Bogota = new LatLng(4.60971, -74.08175);
        mMap.addMarker(new MarkerOptions().position(Bogota).title("Bogotá").snippet("Fundaciones de la ciudad de Bogotá DC").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));

        LatLng Fun1 = new LatLng(4.63, -74.08);
        mMap.addMarker(new MarkerOptions().position(Fun1).title("Colombía Chiquit").snippet("cra 128a # 137-03,Bogotá ").icon(BitmapDescriptorFactory.fromResource(R.drawable.fundi)));
        LatLng Fun2 = new LatLng(4.60, -74.08);
        mMap.addMarker(new MarkerOptions().position(Fun2).title("Fundación 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.fundi)));
        LatLng Fun3 = new LatLng(4.58, -74.10);
        mMap.addMarker(new MarkerOptions().position(Fun3).title("Fundación 3").icon(BitmapDescriptorFactory.fromResource(R.drawable.fundi)));
        LatLng Fun4 = new LatLng(4.62, -74.07);
        mMap.addMarker(new MarkerOptions().position(Fun4).title("Fundación 4").icon(BitmapDescriptorFactory.fromResource(R.drawable.fundi)));
        LatLng Fun5 = new LatLng(4.64, -74.06);
        mMap.addMarker(new MarkerOptions().position(Fun5).title("Fundación 5").icon(BitmapDescriptorFactory.fromResource(R.drawable.fundi)));
        LatLng Fun7 = new LatLng(4.68, -74.12);
        mMap.addMarker(new MarkerOptions().position(Fun2).title("Fundación 7").icon(BitmapDescriptorFactory.fromResource(R.drawable.fundi)));
        LatLng Fun8 = new LatLng(4.64, -74.13);
        mMap.addMarker(new MarkerOptions().position(Fun2).title("Fundación 8").icon(BitmapDescriptorFactory.fromResource(R.drawable.fundi)));
        LatLng navegar = new LatLng(4.60971, -74.08175);
        markerDrag = googleMap.addMarker(new MarkerOptions().position(navegar).title("Navegar Mijo").draggable(true).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        LatLng Fun6 = new LatLng(4.68, -74.07);
        InfoWindow = googleMap.addMarker(new MarkerOptions().position(Fun6).title("FundaciónColombíaChiquita").snippet("cra 128a # 137-03,Bogotá ").icon(BitmapDescriptorFactory.fromResource(R.drawable.fundi)));
        //
        LatLng Fun10 = new LatLng(4.65, -74.12);
        InfoWindow = googleMap.addMarker(new MarkerOptions().position(Fun10).title("Fundación sol en los Andes").snippet("cra 57b # 67-03,Bogotá ").icon(BitmapDescriptorFactory.fromResource(R.drawable.fundi)));
        LatLng Fun11 = new LatLng(4.64, -74.11);
        InfoWindow = googleMap.addMarker(new MarkerOptions().position(Fun11).title("Fundación Natura Colombía").snippet("cra 21 # 39-43,Bogotá ").icon(BitmapDescriptorFactory.fromResource(R.drawable.fundi)));
        LatLng Fun12 = new LatLng(4.62, -74.12);
        InfoWindow = googleMap.addMarker(new MarkerOptions().position(Fun12).title("Fundación Barefoot feet").snippet("cra 57b # 67-03,Bogotá ").icon(BitmapDescriptorFactory.fromResource(R.drawable.fundi)));
        LatLng Fun13 = new LatLng(4.62, -74.10);
        InfoWindow = googleMap.addMarker(new MarkerOptions().position(Fun13).title("Fundación María José").snippet("cra 57b # 67-03,Bogotá ").icon(BitmapDescriptorFactory.fromResource(R.drawable.fundi)));
        LatLng Fun14 = new LatLng(4.60, -74.12);
        InfoWindow = googleMap.addMarker(new MarkerOptions().position(Fun14).title("Fundación Proyecto Union").snippet("cra 57b # 67-03,Bogotá ").icon(BitmapDescriptorFactory.fromResource(R.drawable.fundi)));
        LatLng Fun15 = new LatLng(4.65, -74.09);
        InfoWindow = googleMap.addMarker(new MarkerOptions().position(Fun15).title("Fundación Corona").snippet("cra 57b # 67-03,Bogotá ").icon(BitmapDescriptorFactory.fromResource(R.drawable.fundi)));
        LatLng Fun16 = new LatLng(4.61, -74.12);
        InfoWindow = googleMap.addMarker(new MarkerOptions().position(Fun16).title("Fundación SIMOMN").snippet("cra 57b # 67-03,Bogotá ").icon(BitmapDescriptorFactory.fromResource(R.drawable.fundi)));


        //
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Bogota, 12));
        googleMap.setOnMarkerClickListener(this);
        googleMap.setOnMarkerDragListener(this);
        googleMap.setOnInfoWindowClickListener(this);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        if (marker.equals(InfoWindow)) {
            mFragment.newInstance(marker.getTitle(), getString(R.string.FundaciónColombíaChiquita)).show(getSupportFragmentManager(), null);
        }
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        if (marker.equals(markerDrag)) {
            Toast.makeText(this, "Start", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        if (marker.equals(markerDrag)) {
            String newTitle = String.format(Locale.getDefault(),
                    getString(R.string.marker_detail_latlng),
                    marker.getPosition().latitude,
                    marker.getPosition().longitude);
            setTitle(newTitle);
        }
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        if (marker.equals(markerDrag)) {
            Toast.makeText(this, "Finish", Toast.LENGTH_LONG).show();
            setTitle(R.string.app_name);
        }

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.equals(markerPrueba)) {
            String lat = Double.toString(marker.getPosition().latitude);
            String lng = Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + "," + lng, Toast.LENGTH_SHORT).show();
        }
        return false;
    }

}
