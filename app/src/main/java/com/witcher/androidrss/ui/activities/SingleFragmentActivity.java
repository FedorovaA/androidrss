package com.witcher.androidrss.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.witcher.androidrss.R;
import com.witcher.androidrss.ui.fragments.OnFragmentResultListener;

public abstract class SingleFragmentActivity extends AppCompatActivity implements OnFragmentResultListener {

    /**
     * Передаваемые параметры в Intent
     */
    protected Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        handleIntent(getIntent());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            addFragment();
        }
    }

    /**
     * Получить отображаемый фрагмент.
     * (каждая активити возвращает свой фрагмент)
     * @return Fragment
     */
    protected abstract Fragment getFragment();

    /**
     * Извлечь параметры.
     * @param intent интент содержащий параметры
     */
    protected void handleIntent(Intent intent) {
        bundle = intent.getExtras();
    }

    /**
     * Добавить фрагмент на экран.
     */
    protected void addFragment() {
        replaceFragment(getFragment(), false);
    }

    /**
     * Поиск фрагмента по его классу.
     * @param fragmentClass класс фрагмента
     * @return Fragment
     */
    protected Fragment findFragmentByClass(Class fragmentClass) {
        return getSupportFragmentManager().findFragmentByTag(fragmentClass.getName());
    }

    /**
     * Заменить фрагмент на экране.
     * @param showFragment отображаемый фрагмент
     * @param addToBackStack флаг добавления в BackStack
     */
    protected void replaceFragment(Fragment showFragment, boolean addToBackStack) {
        if (showFragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, showFragment, showFragment.getClass().getName());

            if (addToBackStack) fragmentTransaction.addToBackStack(showFragment.getClass().getName());

            fragmentTransaction.commit();
        }
    }

    /**
     * Получить текущий фрагмент.
     * @return Fragment
     */
    protected Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.fragment_container);
    }

    /**
     * Отображение кнопки "Home" в ActionBar.
     * @param enabled флаг отображения
     */
    protected void setDisplayHomeAsUpEnabled(boolean enabled) {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(enabled);
        }
    }

    /**
     * Задание вида кнопки "Home" в ActionBar.
     * @param resId идентификатор ресурса
     */
    protected void setHomeAsUpIndicator(int resId) {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(resId);
        }
    }

    /**
     * Спрятать ActionBar.
     */
    protected void hideActionBar() {
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case android.R.id.home: {
                onBackPressed();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClose() {
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    public void onResult(Intent intent) {
        setResult(RESULT_OK, intent);
        finish();
    }

}
