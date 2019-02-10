package com.witcher.androidrss.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.witcher.androidrss.R;
import com.witcher.androidrss.domain.Theme;

import java.util.ArrayList;
import java.util.List;

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.ViewHolder> {

    private List<Theme> themes;
    private ThemeOnClickListener listener;

    public ThemeAdapter(ThemeOnClickListener listener) {
        this.listener = listener;
        this.themes = new ArrayList<>();
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.theme_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Theme theme = themes.get(i);

        viewHolder.themeTitle.setText(theme.getTitle());
        viewHolder.themeItem.setTag(theme);
        viewHolder.themeItem.setOnClickListener(view -> {
            final Theme tagTheme = (Theme)view.getTag();
            listener.onClickTheme(tagTheme);
        });
    }

    @Override
    public int getItemCount() {
        return themes != null ? themes.size() : 0;
    }

    /**
     * Холдер для UI.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView themeTitle;
        private View themeItem;

        public ViewHolder(View itemView) {
            super(itemView);

            themeItem = itemView.findViewById(R.id.theme_item);
            themeTitle = itemView.findViewById(R.id.theme_title);
        }
    }

    /**
     * Интерфейс для колбэка нажатия на элемент.
     */
    public interface ThemeOnClickListener {

        void onClickTheme(Theme theme);
    }
}
