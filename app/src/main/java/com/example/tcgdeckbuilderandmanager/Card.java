package com.example.tcgdeckbuilderandmanager;

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

    @NonNull
    @ColumnInfo(name = "Set Number")
    private Integer setNum;

    @NonNull
    @ColumnInfo(name = "Set Monster Number")
    private Integer setMonNum;

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

    // Each card has a certain power level! For monsters, this is the strength of a creature
    // For items/spells, this tends to be how much of a boost it gives to the attached creature

    // Each card has a different typing (rock , paper, scissors)
    @NonNull
    @ColumnInfo(name = "RPS Type")
    private Integer rpsType;

    @NonNull
    @ColumnInfo(name = "Card Power Level")
    private Integer power;

    // Each card has a certain amount of slots! For monsters, this is amount of slots available
    // For items/spells, this tends to be how many slots the item takes up on a creature
    @NonNull
    @ColumnInfo(name = "Card Slots")
    private Integer slots;

    // If a card has an effect, it will be listed here!
    @NonNull
    @ColumnInfo(name = "Card Effect")
    private String effect;

    // Quick boolean that is used to show if a card is still legal
    @NonNull
    @ColumnInfo(name = "Card Legality?")
    private boolean isLegal;

    // Boolean Variable that is used to show if a you can multiple variants of a certain card in a deck
    @NonNull
    @ColumnInfo(name = "Duplicates Allowed?")
    private boolean dupesAllowed;

    public Card(@NonNull String name, @NonNull Integer rpsType, @NonNull Integer type,
                @NonNull Integer subType, @NonNull Integer power, @NonNull Integer slots,
                @NonNull boolean dupesAllowed, @NonNull Integer setNum, @NonNull Integer setMonNum,
                @NonNull boolean isLegal, String effect) {

        this.name = name;
        this.setNum = setNum;
        this.setMonNum = setMonNum;
        this.type = type;
        this.subType = subType;
        this.rpsType = rpsType;
        this.power = power;
        this.slots = slots;
        this.isLegal = isLegal;
        this.dupesAllowed = dupesAllowed;

        if (effect == null) {
            this.effect = "No special effects";
        }

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

    public String getName() {
        return name;
    }

    public Integer getSetNum() {
        return setNum;
    }

    public Integer getSetMonNum() {
        return setMonNum;
    }

    public Integer getType() {
        return type;
    }

    public Integer getPower() {
        return power;
    }

    public Integer getSlots() {
        return slots;
    }

    public String getEffect() {
        return effect;
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

    // Returns a formatted string that's dependent on a creatures set number and individual number in that set
    public String getFormNum(){

        return "S" + this.getSetNum() + "-" + this.getSetMonNum();

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