package com.heyangpeng.demo_menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    private boolean isRefresh;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//必须在view挂载前添加，一般在onCreate()中。
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        isRefresh = false;
        return inflater.inflate(R.layout.activity_fragment, container, false);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_fragment, menu);//加载自己的menu
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_item_fragment:
                isRefresh = true;
                getActivity().invalidateOptionsMenu();
                Toast.makeText(getContext(), "REFRESH_FRAGMENT", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.remove_item_fragment:
                Toast.makeText(getContext(), "REMOVE_FRAGMENT", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem item = menu.findItem(R.id.add_item_fragment);
        if (isRefresh) {
            item.setTitle("REFRESHED_FRAGMENT");
        } else {
            item.setTitle(item.getTitle());
        }
    }
}
