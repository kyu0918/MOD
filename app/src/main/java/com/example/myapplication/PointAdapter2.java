package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.naver.maps.map.overlay.InfoWindow;

class PointAdapter2 extends InfoWindow.DefaultViewAdapter
{
    private final Context mContext;
    private final ViewGroup mParent;

    public PointAdapter2(@NonNull Context context, ViewGroup parent)
    {
        super(context);
        mContext = context;
        mParent = parent;
    }

    public PointAdapter2(@NonNull Context context, Context mContext, ViewGroup mParent) {
        super(context);
        this.mContext = mContext;
        this.mParent = mParent;
    }

    @NonNull
    @Override
    protected View getContentView(@NonNull InfoWindow infoWindow2)
    {

        View view = (View) LayoutInflater.from(mContext).inflate(R.layout.item_point, mParent, false);

        TextView txtTitle = (TextView) view.findViewById(R.id.txttitle);
        ImageView imagePoint = (ImageView) view.findViewById(R.id.imagepoint);
        TextView txtAddr = (TextView) view.findViewById(R.id.txtaddr);
        TextView txtTel = (TextView) view.findViewById(R.id.txttel);

        txtTitle.setText("백석홀 드론 대여");
        imagePoint.setImageResource(R.drawable.baekseokhall);
        txtAddr.setText("충청남도 천안시 동남구 안서동\n(도로명) 백석대학로1 백석홀");
        txtTel.setText("041-550-9114");

        return view;
    }
}