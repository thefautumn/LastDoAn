package edu.huflit.myapplication.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import edu.huflit.myapplication.Models.HomeTour;
import edu.huflit.myapplication.R;

public class HomeRecAdapter extends RecyclerView.Adapter<HomeRecAdapter.MyViewHolder> {


    public HomeRecAdapter(Context context, Listener listener, ArrayList<HomeTour> homeTourArrayList) {
        this.context = context;
        this.listener = listener;
        this.homeTourArrayList = homeTourArrayList;
    }

    Context context;
    Listener listener;

    ArrayList<HomeTour> homeTourArrayList;
    @NonNull
    @Override
    public HomeRecAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_tour,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecAdapter.MyViewHolder holder, int position) {

        HomeTour homeTour = homeTourArrayList.get(position);

        holder.tittle.setText(homeTour.getTen_tour());
        holder.vnd.setText(String.valueOf(homeTour.getSoTien()));
        holder.mota.setText(homeTour.getMota());
        holder.tvHDV.setText(homeTour.getHDV());
        holder.tvPTDC.setText(homeTour.getPTDC());
        Glide.with(context).load(homeTour.getAnhbia()).into(holder.anh);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemListener(homeTour);
            }
        });


    }

    @Override
    public int getItemCount() {
        return homeTourArrayList.size();
    }

    public void searchDataList(ArrayList<HomeTour> searchList) {
        homeTourArrayList = searchList;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView vnd,tittle,vnd_dis,tvHDV,tvPTDC;
        ReadMoreTextView mota;
        ImageView anh;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vnd = itemView.findViewById(R.id.gia_ban_dau_1);
            tittle = itemView.findViewById(R.id.Ten_Tour);
            vnd_dis = itemView.findViewById(R.id.gia_discount);
            anh = itemView.findViewById(R.id.Anhbia);
            mota =  itemView.findViewById(R.id.mo_ta);
            tvHDV = itemView.findViewById(R.id.tvHDV);
            tvPTDC = itemView.findViewById(R.id.PTDC);



          }
    }


    public interface Listener
    {
        void onItemListener(HomeTour Tourdetails);

    }
}
