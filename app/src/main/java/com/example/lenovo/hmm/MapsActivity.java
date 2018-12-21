package com.example.lenovo.hmm;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;

    private static final String TAG = "MapsActivity";
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;

    private EditText mSearchText;
    private String jenisKey;
    private Boolean mLocationPermissionGranted = false;
    private GoogleMap nMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        getLocationPermission();

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
//                (this, Manifest.permission.ACCESS_COARSE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//            return;
//        }

        LatLng latLng = new LatLng(-5.385883, 105.287995);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13f));

//        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng Rs_Immanuel = new LatLng(-5.385883, 105.287995);
        mMap.addMarker(new MarkerOptions().position(Rs_Immanuel).title("Rumah Sakit Immanuel"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rs_Immanuel));

        LatLng Rs_Urip_Sumoharjo = new LatLng(-5.391746, 105.276377);
        mMap.addMarker(new MarkerOptions().position(Rs_Urip_Sumoharjo).title("Rumah Sakit Urip Sumoharjo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rs_Urip_Sumoharjo));

        LatLng Rs_Bumi_Waras = new LatLng(-5.425165, 105.251023);
        mMap.addMarker(new MarkerOptions().position(Rs_Bumi_Waras).title("Rumah Sakit Bumi Waras"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rs_Bumi_Waras));

        LatLng Rs_Advent = new LatLng(-5.391955, 105.262181);
        mMap.addMarker(new MarkerOptions().position(Rs_Advent).title("Rumah Sakit Advent"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rs_Advent));

        LatLng Rsia_Betik_hati = new LatLng(-5.391955, 105.262181);
        mMap.addMarker(new MarkerOptions().position(Rsia_Betik_hati).title("Rumah Sakit Ibu Anak Betik Hati"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rsia_Betik_hati));

        LatLng Rs_Abdul_muluk = new LatLng(-5.402763, 105.258608);
        mMap.addMarker(new MarkerOptions().position(Rs_Abdul_muluk).title("Rumah Sakit Abdul Muluk"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rs_Abdul_muluk));

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
//    private void getLocationPermission(){
//        Log.d(TAG, "getLocationPermission: get permission");
//        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
//                Manifest.permission.ACCESS_COARSE_LOCATION};
//
//        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
//                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
//            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
//                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
//                mLocationPermissionGranted = true;
//                initMap();
//            } else {
//                ActivityCompat.requestPermissions(this,
//                        permissions,
//                        LOCATION_PERMISSION_REQUEST_CODE);
//            }
//        } else {
//            ActivityCompat.requestPermissions(this,
//                    permissions,
//                    LOCATION_PERMISSION_REQUEST_CODE);
//        }
//    }
//    private void initMap(){
//        Log.d(TAG, "initMap: initialinzing map");
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(MapsActivity.this);
//    }
//    private void getDeviceLocation(){
//        Log.d(TAG, "getDeviceLocation: getting the devices current location");
//        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
//        try {
//            if (mLocationPermissionGranted){
//                final com.google.android.gms.tasks.Task location = mFusedLocationProviderClient.getLastLocation();
//                location.addOnCompleteListener(new OnCompleteListener() {
//                    @Override
//                    public void onComplete(@NonNull com.google.android.gms.tasks.Task task) {
//                        if (task.isSuccessful()){
//                            Log.d(TAG, "onComplete: found location");
//                            Location currentLocation = (Location) task.getResult();
//
//                            moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
//                                    15f, "MyLocation");
//
//
//
//                        }
//                        else {
//                            Log.d(TAG, "onComplete: current location is null");
//                            Toast.makeText(MapsActivity.this, "unable to get current location", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//        }catch (SecurityException e){
//            Log.e(TAG, "getDeviceLocation: SecurityException: " + e.getMessage() );
//        }
//    }
//    private void moveCamera(LatLng latLng, float zoom, String title){
//        Log.d(TAG, "moveCamera: moving the camera to lat: "+latLng.latitude + ", lng : "+ latLng.longitude);
//        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
//
////        MarkerOptions options = new MarkerOptions()
////                .position(latLng)
////                .title(title);
////        nMap.addMarker(options);
//    }
}
