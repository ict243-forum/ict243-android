package cd.synapsehub.ict243.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cd.synapsehub.ict243.R;
import cd.synapsehub.ict243.model.Dessert;
import cd.synapsehub.ict243.model.Menu;

/**
 * Created by michelo
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.SimpleItemVH> {

    //  Data
    private List<Menu> menus = new ArrayList<>();

    Context context;

    public MenuAdapter(Context context) {
        this.context = context;
        prepareMenus();
    }

    private void prepareMenus() {
        String[] nameArray = context.getResources().getStringArray(R.array.menu_titre);
        String[] descArray = context.getResources().getStringArray(R.array.menu_descriptions);
        String[] imgArray = context.getResources().getStringArray(R.array.menu_images);

        final int SIZE = nameArray.length;

        for (int i = 0; i < SIZE; i++) {
            Menu dmenu = new Menu(
                    nameArray[i],
                    descArray[i]

            );

            menus.add(dmenu);
        }
    }

    @Override
    public SimpleItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_layout, parent, false);

        return new SimpleItemVH(v);
    }

    @Override
    public void onBindViewHolder(SimpleItemVH holder, int position) {

        Menu menu = menus.get(position);

        holder.txtTitle.setText(menu.getName());
        holder.txtDesc.setText(menu.getDescription());
    }

    @Override
    public int getItemCount() {
        return menus != null ? menus.size() : 0;
    }

    protected static class SimpleItemVH extends RecyclerView.ViewHolder {

        TextView txtTitle, txtDesc;
        public ImageView thumbnail;

        public SimpleItemVH(View itemView) {
            super(itemView);

            txtTitle = (TextView) itemView.findViewById(R.id.name_text);
            txtDesc = (TextView) itemView.findViewById(R.id.status_text);


        }
    }
}
