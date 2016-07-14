package com.example.aluno.aula2;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aluno on 12/07/2016.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyHolder> {
    private static final int REQUEST_CALL = 1;
    private List<String> mList;
    private Activity mContext;

    public ListAdapter(Activity context,List<String> list) {
        this.mList = list;
        this.mContext = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return new MyHolder(LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.row_list, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(MyHolder myHolder, final int position) {

        String item = mList.get(position);
        Context context = myHolder.itemView.getContext();

        myHolder.tvText.setText(item);
        myHolder.imageView.setImageResource(R.drawable.android_icone);

        if (position % 2 == 0) {
            myHolder.itemView.setBackgroundColor(Color.TRANSPARENT);
        } else {
            myHolder.itemView.setBackgroundColor(Color.GREEN);
        }

        myHolder.itemView.setOnClickListener(null);

        switch (position) {
            case 0:
                myHolder.imageView.setImageResource(R.drawable.notify_icon);
                myHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();

                        intent.putExtra("KEY_RETURN","Item " + position);
                        mContext.setResult(0,intent);
                        mContext.finish();
                    }
                });
                break;
            case 1:
                myHolder.imageView.setImageResource(R.drawable.call_icon);
                myHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:05195959595"));
                        mContext.startActivity(intent);
                    }
                });
                break;
            case 2:
                myHolder.imageView.setImageResource(R.drawable.netscape_icon);
                myHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.quora.com"));
                        mContext.startActivity(intent);
                    }
                });
                break;
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvText;

        public MyHolder(View itemView){
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            tvText = (TextView) itemView.findViewById(R.id.tvText);
        }
    }
}
