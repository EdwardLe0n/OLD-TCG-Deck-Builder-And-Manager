import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Using  a modified version of the word code: https://developer.android.com/codelabs/android-room-with-a-view#16

// todo: Implement cards having thie own images
// todo: Implement season numbers and individual card season numbers  (S0 -100)
// todo: Set up 'Requirements' (Summon monsters needing another specific monster in the deck)

@Entity(tableName = "card_table")
public class Card {

    // Primary key is used to help look through the list of cards
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int id;

    // Each card has it's own name!!!
    @NonNull
    @ColumnInfo(name = "Card Name")
    private String name;

    // Type refers to what type of card a card is (1 = monster, 2 = item/spell)
    @NonNull
    @ColumnInfo(name = "Card Type")
    private Integer type;

    // Sub Type refers to the specific type of card a card is dependent on what primary type the card is

    // If the card is a monster: If the subtype is one, then it's a basic monster
    // If the subtype is two, it's a summonable monster and needs another monster to be played

    // If the card is a item/spell then it's either an item or spell which is determined by the subtype num

    @NonNull
    @ColumnInfo(name = "Card Sub-Type")
    private Integer subType;

    // Quick boolean that is used to show if a card is still legal
    @NonNull
    @ColumnInfo(name = "Card Legality?")
    private boolean isLegal;

    // Boolean Variable that is used to show if a you can multiple variants of a certain card in a deck
    @NonNull
    @ColumnInfo(name = "Duplicates Allowed?")
    private boolean dupesAllowed;

    public Card(@NonNull String name, @NonNull Integer type,
                @NonNull Integer subType, @NonNull boolean isLegal,
                @NonNull boolean dupesAllowed) {
        this.name = name;
        this.type = type;
        this.subType = subType;
        this.isLegal = isLegal;
        this.dupesAllowed = dupesAllowed;

    }

    // Standard getters that get used throughout the code

    public String getCardName() {
        return this.name;
    }

    public Integer getCardType() {
        return this.type;
    }

    public Integer getSubType() {
        return this.subType;
    }

    public boolean isLegal() {
        return isLegal;
    }

    public boolean isDupesAllowed() {
        return dupesAllowed;
    }

    // This class returns a string dependent on the cards type and subtype
    // This class is used to turn the two ints type/subtype into text a normal user can understand
    public String getFormType() {
        String temp = "";

        if (this.getCardType() == 1) {

            if (this.getSubType() == 1) {
                temp = "Basic Monster";
            } else {
                temp = "Summonable Monster";
            }

        } else if (this.getCardType() == 2) {

            if (this.getSubType() == 1) {
                temp = "Equipment";
            } else {
                temp = "Spell";
            }

        }

        return temp;
    }

    public String getIsLegal() {
        if (this.isLegal()) {
            return "YEAH";
        } else {
            return "Nuh uh";
        }
    }

    public String getDupesAllowed() {
        if (this.isDupesAllowed()) {
            return "YEAH";
        } else {
            return "Nuh uh";
        }
    }
}