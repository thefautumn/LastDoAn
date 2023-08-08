package edu.huflit.myapplication.Activity;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;

import edu.huflit.myapplication.Adapter.HomeRecAdapter;
import edu.huflit.myapplication.Models.HomeTour;
import edu.huflit.myapplication.R;

public class TrangChu extends AppCompatActivity implements HomeRecAdapter.Listener {

   private SearchView searchview_mhc;
    ImageView next_tai_khoan, next_thue_xe;

    ImageView next_tim_kiem_tour, next_tich_diem, next_danh_sach_giao_dich;
    //Giá ban đầu
    TextView gia_1, gia_2;

    RecyclerView recyclerView;
    ArrayList<HomeTour> arrayList;
    HomeRecAdapter adapter;
    FirebaseFirestore db;
    FirebaseUser user;
    FirebaseAuth mAuth;
    ProgressDialog progressDialog;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        anhXa();

        progressDialog = new ProgressDialog(TrangChu.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Đang chuyển dữ liệu");
        progressDialog.show();


        recyclerView = findViewById(R.id.Re_danhsachTour);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(TrangChu.this,LinearLayoutManager.HORIZONTAL,true));


        db = FirebaseFirestore.getInstance();
        arrayList = new ArrayList<HomeTour>();
        adapter = new HomeRecAdapter(TrangChu.this,this,arrayList);

        recyclerView.setAdapter(adapter);

        EvenChangeListener();

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchview_mhc.setQueryHint("Tìm kiếm");
        searchview_mhc.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchview_mhc.setMaxWidth(Integer.MAX_VALUE);
        searchview_mhc.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });



        //ẤN ĐỂ CHUYỂN TỚI MÀN HÌNH TÀI KHOẢN
        next_tai_khoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = mAuth.getCurrentUser();
                if(user != null){
                    Intent next_dsgd = new Intent(getApplicationContext(), ManHinhTaiKhoan.class);
                    startActivity(next_dsgd);
                }
                if(user == null){
                    Intent next_dsgd = new Intent(getApplicationContext(), ChuaDangNhap_TK.class);
                    startActivity(next_dsgd);
                }
            }
        });
        //CHUYỂN TỚI MÀN HÌNH TÌM KIẾM TOUR
        next_tim_kiem_tour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_tour = new Intent(getApplicationContext(), ManHinhTimKiemTour.class);
                startActivity(next_tour);
            }
        });
        //CHUYỂN TỚI MÀN HÌNH TÍCH ĐIỂM
        next_tich_diem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_td = new Intent(getApplicationContext(), ManHinhTichDiem.class);
                startActivity(next_td);
            }
        });
        //CHUYỂN TỚI THUÊ XE
        next_thue_xe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_tx = new Intent(getApplicationContext(), ManHinhTimThueXe.class);
                startActivity(next_tx);
            }
        });
        //TẠO DẤU GẠCH NGANG GIỮA CHO GIÁ BAN ĐẦU (ẢNH HOT TOUR)

        //CHUYỂN TỚI LỊCH SỬ GIAO DỊCH
        next_danh_sach_giao_dich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              user = mAuth.getCurrentUser();
              if(user != null){
                  Intent next_dsgd = new Intent(getApplicationContext(), DanhSachGiaoDich.class);
                  startActivity(next_dsgd);
              }
              if(user == null){
                  Intent next_dsgd = new Intent(getApplicationContext(), CDNDatCho.class);
                  startActivity(next_dsgd);
              }
            }
        });

    }
    public void anhXa()
    {
        searchview_mhc = (SearchView) findViewById(R.id.searchview_mhc);
        next_tai_khoan = (ImageView) findViewById(R.id.next_tai_khoan);
        gia_1 = (TextView) findViewById(R.id.gia_ban_dau_1);
        mAuth = FirebaseAuth.getInstance();

        next_tim_kiem_tour = (ImageView) findViewById(R.id.next_tim_kiem_tour);
        next_tich_diem = (ImageView) findViewById(R.id.next_man_hinh_tich_diem);
        next_thue_xe = (ImageView) findViewById(R.id.next_thue_xe);
        next_danh_sach_giao_dich =(ImageView) findViewById(R.id.next_danh_sach_giao_dich);


    }
    public void searchList(String text){
        ArrayList<HomeTour> searchList = new ArrayList<>();
        for (HomeTour mainModel: arrayList){
            if (mainModel.getTen_tour().toLowerCase().contains(text.toLowerCase())){
                searchList.add(mainModel);
            }
        }
        adapter.searchDataList(searchList);
    }
    public void EvenChangeListener(){

            db.collection("Tour").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {

                    for (QueryDocumentSnapshot document : task.getResult()) {
                                progressDialog.dismiss();
                        String ten = document.get("tenTour") != null ? document.get("tenTour").toString() : "";;
                        String hinhanh = document.get("imageUrl") != null ? document.get("imageUrl").toString() : "";
                        int price = document.get("giaTour") != null ? Integer.parseInt(document.get("giaTour").toString()) : 0;
                        String HDV = document.get("HuongDanVien")!= null ? document.get("HuongDanVien").toString() : "";
                        String Mota = document.get("moTa")!= null ? document.get("moTa").toString() : "";
                        String PTDC = document.get("ptdc")!= null ? document.get("ptdc").toString() : "";
                        int Id = document.get("matour") != null ? Integer.parseInt(document.get("matour").toString()) : 0;

                        HomeTour homeTour =new HomeTour(ten,hinhanh,price,Mota,Id,HDV,PTDC);

                                arrayList.add(homeTour);
                                adapter.notifyDataSetChanged();
                        }

                }
            });
    }

    @Override
    public void onItemListener(HomeTour Tourdetails) {
        Intent intent = new Intent(getApplicationContext(), ManHinhChiTietTour.class);
        intent.putExtra("TenTour",  Tourdetails.getTen_tour());
        intent.putExtra("MoTa",  Tourdetails.getMota());
        intent.putExtra("Anh",  Tourdetails.getAnhbia());
        intent.putExtra("HDV",  Tourdetails.getHDV());
        intent.putExtra("PTDC",  Tourdetails.getPTDC());
        intent.putExtra("Tien",  Tourdetails.getSoTien());

        startActivity(intent);
    }
}