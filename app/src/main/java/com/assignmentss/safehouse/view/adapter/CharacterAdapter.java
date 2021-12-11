package com.assignmentss.safehouse.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.assignmentss.safehouse.R;
import com.assignmentss.safehouse.data.remote.model.CharacterResponseItem;
import com.assignmentss.safehouse.databinding.ItemCharacterBinding;
import com.assignmentss.safehouse.utils.CommonMethods;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterVH> {
    private final Context context;
    private final List<CharacterResponseItem> characterResponseItems;
    private final LayoutInflater inflater;

    public CharacterAdapter(Context context, List<CharacterResponseItem> characterResponseItems) {
        this.context = context;
        this.characterResponseItems = characterResponseItems;
        inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CharacterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterVH(DataBindingUtil.inflate(inflater, R.layout.item_character,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterVH holder, int position) {
        CommonMethods.loadImage(holder.getItemCharacterBinding().imageView,characterResponseItems.get(position).getImg());
        holder.getItemCharacterBinding().getRoot().setOnLongClickListener(v -> {
            CommonMethods.showShortToast(context, characterResponseItems.get(position).getNameOccupation());
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return characterResponseItems.size();
    }

    public static class CharacterVH extends RecyclerView.ViewHolder{
        private ItemCharacterBinding itemCharacterBinding;
        public CharacterVH(@NonNull ItemCharacterBinding itemCharacterBinding) {
            super(itemCharacterBinding.getRoot());
            setItemCharacterBinding(itemCharacterBinding);
        }

        public ItemCharacterBinding getItemCharacterBinding() {
            return itemCharacterBinding;
        }

        public void setItemCharacterBinding(ItemCharacterBinding itemCharacterBinding) {
            this.itemCharacterBinding = itemCharacterBinding;
        }
    }
}
