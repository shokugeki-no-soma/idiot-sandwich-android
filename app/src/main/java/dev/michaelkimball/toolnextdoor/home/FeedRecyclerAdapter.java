package dev.michaelkimball.toolnextdoor.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.michaelkimball.toolnextdoor.R;

public class FeedRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NeighborRequest> requests = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_list_item, parent, false);
        return new RequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((RequestViewHolder)holder).bind(requests.get(position));
    }

    @Override
    public int getItemCount() {
        return this.requests.size();
    }

    public void setRequests(List<NeighborRequest> data) {
        this.requests = data;
        notifyDataSetChanged();
    }

    public class RequestViewHolder extends RecyclerView.ViewHolder {

        TextView message;
        ImageView avatar;
        Button accept;
        Button ignore;
        NeighborRequest neighborRequest;

        public RequestViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.message);
            avatar = itemView.findViewById(R.id.avatar);
            accept = itemView.findViewById(R.id.yes_button);
            ignore = itemView.findViewById(R.id.no_button);
            accept.setOnClickListener((item) -> {
                Toast.makeText(itemView.getContext(), "Accepted!", Toast.LENGTH_SHORT).show();
                requests.remove(neighborRequest);
                notifyDataSetChanged();
            });
            ignore.setOnClickListener((item) -> {
                Toast.makeText(itemView.getContext(), "Ignored :(", Toast.LENGTH_SHORT).show();
                requests.remove(neighborRequest);
                notifyDataSetChanged();
            });
        }

        public void bind(NeighborRequest request){
            this.neighborRequest = request;
            message.setText(request.getBody());
            avatar.setBackground(itemView.getResources().getDrawable(R.drawable.avatar));

        }
    }
}