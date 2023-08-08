package edu.huflit.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import edu.huflit.myapplication.Activity.ThemThongTinLienHe;
import edu.huflit.myapplication.Models.TTKhachHang;
import edu.huflit.myapplication.R;

public class ThemTTKHAdapter extends BaseAdapter {

    public ThemTTKHAdapter(KHListener listener, Context context, ArrayList<TTKhachHang> list) {
        this.listener = listener;
        this.context = context;
        this.list = list;
    }

    KHListener listener;
    Context context;
    ArrayList<TTKhachHang> list;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
           holder = new ViewHolder();
           LayoutInflater inflater =((Activity)context).getLayoutInflater();
           view = inflater.inflate(R.layout.activity_them_thong_tin_lien_he,null);
           holder.ten = view.findViewById(R.id.edt_Hoten);
           holder.email= view.findViewById(R.id.edt_Email);
           holder.sdt = view.findViewById(R.id.edt_SDT);
           holder.diachi = view.findViewById(R.id.edt_SDT);
           holder.them  = view.findViewById(R.id.btn_Them);
           view.setTag(holder);
        }
        else{
            holder =(ViewHolder)view.getTag();
        }
        TTKhachHang p = list.get(i);
        holder.them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = holder.ten.getText().toString().trim();
                String email = holder.email.getText().toString().trim();
                int SDT = Integer.parseInt(holder.email.getText().toString().trim());
                String DiaChi= holder.diachi.getText().toString().trim();


            }
        });


        return null;
    }

    public interface  KHListener{
        void ListenerOnItemCLick(TTKhachHang ttKhachHang);
    }
    class ViewHolder {

        EditText ten,sdt,email,diachi;
        Button them;

    }
}
