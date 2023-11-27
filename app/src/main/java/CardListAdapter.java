import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class CardListAdapter extends ListAdapter<Card, CardViewHolder> {

    public CardListAdapter(@NonNull DiffUtil.ItemCallback<Card> diffCallback) {
        super(diffCallback);
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CardViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Card current = getItem(position);
        holder.bind(current.getCardName());
    }

    static class CardDiff extends DiffUtil.ItemCallback<Card> {

        // todo: possibly look into changing these functions in the future
        @Override
        public boolean areItemsTheSame(@NonNull Card oldItem, @NonNull Card newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Card oldItem, @NonNull Card newItem) {
            return oldItem.getCardName().equals(newItem.getCardName());
        }
    }
}