package br.com.webscrap.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import br.com.webscrap.MainActivity;
import br.com.webscrap.R;
import br.com.webscrap.model.Casa;

/**
 * Created by Gustavo Terras on 16/07/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private static final String TAG = MyAdapter.class.getSimpleName();
    private List<Casa> casas;
    private Context context;

    public MyAdapter(Context context, List<Casa> casas) {
        this.context = context;
        this.casas = casas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Casa casa = casas.get(position);

        Glide.with(context).load(casa.getLogo())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(holder.picture);

        holder.name.setText(casa.getName());
    }

    private void setAnimation(View viewToAnimate, int anim) {
        viewToAnimate.setVisibility(View.VISIBLE);
        Animation animation = AnimationUtils.loadAnimation(context, anim);
        viewToAnimate.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return casas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnTouchListener{
        private TextView name;
        private ImageView picture;

        ViewHolder(View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.txt_name);
            this.picture = (ImageView) view.findViewById(R.id.img_content);

            view.setOnClickListener(this);
            view.setOnTouchListener(this);
        }

        @Override
        public void onClick(View view) {
            context.startActivity(new Intent(context, MainActivity.class).putExtra("extra", casas.get(getPosition())));
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction()==MotionEvent.ACTION_DOWN)
                setAnimation(v, android.R.anim.fade_out);
            if(event.getAction() == MotionEvent.ACTION_UP)
                setAnimation(v, android.R.anim.fade_in);
            return false;
        }
    }
}