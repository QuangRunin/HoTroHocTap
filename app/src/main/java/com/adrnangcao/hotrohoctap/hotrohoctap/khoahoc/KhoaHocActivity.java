package com.adrnangcao.hotrohoctap.hotrohoctap.khoahoc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.adrnangcao.hotrohoctap.hotrohoctap.HomeActivity;
import com.adrnangcao.hotrohoctap.hotrohoctap.R;
import com.adrnangcao.hotrohoctap.hotrohoctap.khoahoc.fragment.DanhSach_Fragment;
import com.adrnangcao.hotrohoctap.hotrohoctap.khoahoc.fragment.LichHocFragment;
import com.adrnangcao.hotrohoctap.hotrohoctap.khoahoc.fragment.LichThi_Fragment;
import com.adrnangcao.hotrohoctap.hotrohoctap.khoahoc.fragment.MonHocDaDangKi_Fragment;
import com.adrnangcao.hotrohoctap.hotrohoctap.khoahoc.fragment.ThongTin_Fragment;

public class KhoaHocActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fram_layout, new ThongTin_Fragment()).commit();
        getSupportActionBar().setTitle("Thông Tin Sinh Viên");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.ThongTin) {
            fragmentManager.beginTransaction().replace(R.id.fram_layout, new ThongTin_Fragment()).commit();
            getSupportActionBar().setTitle("Thông Tin Sinh Viên");
        } else
        if (id == R.id.DanhSach) {
            fragmentManager.beginTransaction().replace(R.id.fram_layout, new DanhSach_Fragment()).commit();
            getSupportActionBar().setTitle("Đăng Kí Môn Học");
        } else if (id == R.id.DangKy) {
            fragmentManager.beginTransaction().replace(R.id.fram_layout, new MonHocDaDangKi_Fragment()).commit();
            getSupportActionBar().setTitle("Môn Học Đã Đăng Kí");
        }
        else if (id == R.id.LichHoc) {
            fragmentManager.beginTransaction().replace(R.id.fram_layout, new LichHocFragment()).commit();
            getSupportActionBar().setTitle("Lịch Học");
        }
        else if (id == R.id.LichThi) {
            fragmentManager.beginTransaction().replace(R.id.fram_layout, new LichThi_Fragment()).commit();
            getSupportActionBar().setTitle("Lịch Thi");
        } else if (id == R.id.home) {
            Intent i = new Intent(KhoaHocActivity.this, HomeActivity.class);
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
