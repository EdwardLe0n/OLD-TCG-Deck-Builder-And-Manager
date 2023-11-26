import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "card_table")
public class Card {

    @PrimaryKey (autoGenerate = true)
    private int id;

    @NonNull
    private String name;

    @NonNull
    private String type;

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(type = "Type")
    private String mType;

    @NonNull
    private String subType;

    @ColumnInfo(subType = "subType")
    private String mSubType;

    public Card(@NonNull String name, @NonNull String type) {
        this.mName = name;
        this.mType = type;
    }

    public String getCardName() {return this.mName;}

    public String getCardType() {return this.mType;}

}
