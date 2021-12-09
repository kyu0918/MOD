package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.util.FusedLocationSource;
import com.naver.maps.map.util.MarkerIcons;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback
{
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private FusedLocationSource locationSource;
    private MapView mapView;
    private static NaverMap naverMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //네이버 지도
        mapView = (MapView) findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        locationSource =
                new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,  @NonNull int[] grantResults) {
        if (locationSource.onRequestPermissionsResult(
                requestCode, permissions, grantResults)) {
            if (!locationSource.isActivated()) { // 권한 거부됨
                naverMap.setLocationTrackingMode(LocationTrackingMode.None);
            }
            return;
        }
        super.onRequestPermissionsResult(
                requestCode, permissions, grantResults);
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap)
    {
        this.naverMap = naverMap;
        naverMap.getUiSettings().setLocationButtonEnabled(true);

        CameraPosition cameraPosition = new CameraPosition(
                new LatLng(36.839496, 127.184083),  // 위치 지정
                16,// 줌 레벨
                45, //기울임 각도
                45 //방향
        );
        naverMap.setCameraPosition(cameraPosition);
        naverMap.setLocationSource(locationSource);

        Marker marker1 = new Marker();
        marker1.setPosition(new LatLng(36.839252, 127.185959));
        marker1.setMap(naverMap);
        marker1.setWidth(70);
        marker1.setHeight(90);
        marker1.setIconPerspectiveEnabled(true); //마커 원근효과
        marker1.setCaptionText("본부동");
        marker1.setCaptionTextSize(16);

        Marker marker2 = new Marker();
        marker2.setPosition(new LatLng(36.839659, 127.184795));
        marker2.setMap(naverMap);
        marker2.setWidth(70);
        marker2.setHeight(90);
        marker2.setIconPerspectiveEnabled(true); //마커 원근효과
        marker2.setIcon(MarkerIcons.BLUE);
        marker2.setCaptionText("교수회관");
        marker2.setCaptionTextSize(16);

        Marker marker3 = new Marker();
        marker3.setPosition(new LatLng(36.839461, 127.182542));
        marker3.setMap(naverMap);
        marker3.setWidth(70);
        marker3.setHeight(90);
        marker3.setIconPerspectiveEnabled(true); //마커 원근효과
        marker3.setIcon(MarkerIcons.YELLOW);
        marker3.setCaptionText("진리관");
        marker3.setCaptionTextSize(16);


        InfoWindow infoWindow = new InfoWindow();
        InfoWindow infoWindow1 = new InfoWindow();
        InfoWindow infoWindow2 = new InfoWindow();

        //지도 클릭시 정보창 닫기
        naverMap.setOnMapClickListener((coord, point) ->{
            infoWindow.close();
            infoWindow1.close();
            infoWindow2.close();
        });

        //마커1 클릭시
        marker1.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {

                ViewGroup rootView = (ViewGroup) findViewById(R.id.map_view);
                PointAdapter adapter = new PointAdapter(MainActivity.this, rootView);

                infoWindow.setAdapter(adapter);
                if (marker1.getInfoWindow() == null){
                    //현재 마커에 정보창이 없을 경우 열기
                    infoWindow.open(marker1);
                } else {
                    infoWindow.close();
                }
                return true;

            }

        });

        infoWindow.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {
                Intent intent = new Intent(getApplicationContext(),ShopInfo.class);
                startActivity(intent);
                return false;
            }
        });

        //마커2 클릭시
        marker2.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {

                ViewGroup rootView = (ViewGroup) findViewById(R.id.map_view);
                PointAdapter1 adapter = new PointAdapter1(MainActivity.this, rootView);

                infoWindow1.setAdapter(adapter);
                if (marker2.getInfoWindow() == null){
                    //현재 마커에 정보창이 없을 경우 열기
                    infoWindow1.open(marker2);
                } else {
                    infoWindow1.close();
                }
                return true;
            }
        });

        //마커3 클릭시
        marker3.setOnClickListener(new Overlay.OnClickListener() {
            @Override
            public boolean onClick(@NonNull Overlay overlay) {

                ViewGroup rootView = (ViewGroup) findViewById(R.id.map_view);
                PointAdapter2 adapter = new PointAdapter2(MainActivity.this, rootView);

                infoWindow2.setAdapter(adapter);
                if (marker3.getInfoWindow() == null){
                    //현재 마커에 정보창이 없을 경우 열기
                    infoWindow2.open(marker3);
                } else {
                    infoWindow2.close();
                }
                return true;
            }
        });


    } //OnMapReady
} //MainActivity