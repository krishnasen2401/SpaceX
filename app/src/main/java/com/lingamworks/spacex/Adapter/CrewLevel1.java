package com.lingamworks.spacex.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lingamworks.spacex.Data.Crew;
import com.lingamworks.spacex.R;
import com.lingamworks.spacex.databinding.SinglerowtextBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CrewLevel1 extends RecyclerView.Adapter<CrewLevel1.ViewHolder> {
    private Context mContext1;
    private List<Crew> mlists;
    private RecyclerView mRecyclerV1;
    SinglerowtextBinding binding;
    public class ViewHolder extends RecyclerView.ViewHolder{

        SinglerowtextBinding binding;//Name of the test_list_item.xml in camel case + "Binding"
        public ViewHolder(SinglerowtextBinding b){
            super(b.getRoot());
            binding = b;
        }
    }
    public CrewLevel1(List<Crew> myDataset, Context context, RecyclerView recyclerView) {
        mlists = myDataset;
        mContext1 = context;
        mRecyclerV1 = recyclerView;
    }
    @NonNull
    @Override
    public CrewLevel1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                                   int viewType) {
        return new ViewHolder(SinglerowtextBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }
    @Override
    public int getItemCount() {
        return mlists.size();
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Crew al = mlists.get(position);
        Animation rotate;
        boolean expanded = al.isExpanded();
            if (expanded) {
                //holder.binding.rvImg1.setImageResource(R.drawable.uparrow);
                Picasso.get().load(al.getImage()).error(R.drawable.ic_spacex).into(holder.binding.crewProfile);
                rotate= AnimationUtils.loadAnimation(mContext1,R.anim.rotate180to360);
            } else {
                //holder.binding.rvImg1.setImageResource(R.drawable.downarrow);
                rotate= AnimationUtils.loadAnimation(mContext1,R.anim.rotate0to180);
            }

        holder.binding.llcrewDetail.setVisibility(expanded ? View.VISIBLE : View.GONE);
        holder.binding.rvTV1.setText(al.getName());
        holder.binding.tvAgency.setText("Agency:    "+al.getAgency().toUpperCase());
        holder.binding.tvStatus.setText("Status:    "+al.getStatus().toUpperCase());
        holder.binding.tvWikipedia.setText("Wikipedia: Open Link");
        holder.binding.tvWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(al.getWikipedia()));
                mContext1.startActivity(intent);
            }
        });
        holder.binding.rvImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.binding.rvImg1.startAnimation(rotate);
                boolean expanded = al.isExpanded();
                al.setExpanded(!expanded);
                notifyItemChanged(position);
            }
        });


        }

}
