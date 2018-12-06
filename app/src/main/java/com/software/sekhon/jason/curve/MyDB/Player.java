package com.software.sekhon.jason.curve.MyDB;

import android.arch.persistence.room.*;

import java.io.Serializable;

@Entity(tableName = "players")
public class Player implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int pid;

    @ColumnInfo(name = "first name")
    public String firstName;

    @ColumnInfo(name = "last name")
    public String lastName;

    @ColumnInfo(name = "position")
    public String position;

    @ColumnInfo(name = "headshot URL")
    public String headshotURL;

    @ColumnInfo(name = "stick URL")
    public String stickURL;

    @ColumnInfo(name = "brand")
    public String brand;

    @ColumnInfo(name = "curve name")
    public String curveName;

    @ColumnInfo(name = "curve type")
    public String curveType;

    @ColumnInfo(name = "lie")
    public double lie;

    @ColumnInfo(name = "face angle")
    public String face;

    @ColumnInfo(name = "toe shape")
    public String toe;

    @ColumnInfo(name = "blade length")
    public String bladeLength;

    public Player(String firstName, String lastName, String position, String headshotURL, String stickURL, String brand, String curveName, String curveType, double lie, String face, String toe, String bladeLength) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.headshotURL = headshotURL;
        this.stickURL = stickURL;
        this.brand = brand;
        this.curveName = curveName;
        this.curveType = curveType;
        this.lie = lie;
        this.face = face;
        this.toe = toe;
        this.bladeLength = bladeLength;
    }

    public static Player[] populateData() {
        return new Player[] {
                new Player("Steven", "Stamkos", "C", "https://nhl.bamcontent.com/images/headshots/current/168x168/8474564.jpg", "https://www.hockeygiant.com/ui/support/how_to/Bauer-PM9-Blade-Pattern.jpg", "Bauer", "PM9", "Mid-Heel", 5, "Open", "Round", "Medium"),
                new Player("Patrick", "Kane", "RW", "https://nhl.bamcontent.com/images/headshots/current/168x168/8474141.jpg", "https://www.hockeygiant.com/ui/support/how_to/Bauer-P88-Blade-Pattern.jpg", "Bauer", "P88", "Mid", 6, "Open-Wedge", "Round", "Medium"),
                new Player("Eric", "Staal", "C", "https://nhl.bamcontent.com/images/headshots/current/168x168/8470595.jpg", "https://www.hockeygiant.com/ui/support/how_to/Bauer-P91A-Blade-Pattern.jpg", "Bauer", "P91A", "Mid-Heel", 6, "Open-Wedge", "Round", "Long"),
                new Player("Alex", "Ovechkin", "LW", "https://nhl.bamcontent.com/images/headshots/current/168x168/8471214.jpg", "https://www.hockeygiant.com/ui/support/how_to/Bauer-P92-Blade-Pattern.jpg", "Bauer", "P92", "Mid-Toe", 5.5, "Open", "Round", "Medium"),
                new Player("Mike", "Richards", "C", "https://nhl.bamcontent.com/images/headshots/current/168x168/8470617.jpg", "https://www.hockeygiant.com/ui/support/how_to/Bauer-P106-Blade-Pattern.jpg", "Bauer", "P106", "Heel", 6, "Open", "Round", "Medium"),
                new Player("Claude", "Giroux", "C", "https://nhl.bamcontent.com/images/headshots/current/168x168/8473512.jpg", "https://www.hockeygiant.com/ui/support/how_to/Bauer-P02-Blade-Pattern.jpg", "Bauer", "P02", "Heel", 7, "Open", "Square", "Long"),
                new Player("Jonathan", "Toews", "C", "https://nhl.bamcontent.com/images/headshots/current/168x168/8473604.jpg", "https://www.hockeygiant.com/ui/support/how_to/Bauer-P14-Blade-Pattern.jpg", "Bauer", "P14", "Mid-Toe", 6, "Slightly-Open", "Round", "Medium"),
                new Player("Joffrey", "Lupul", "LW", "https://nhl.bamcontent.com/images/headshots/current/168x168/8470207.jpg", "https://www.hockeygiant.com/ui/support/how_to/Warrior-W01-Burrows-Blade-Pattern-Curve.jpg", "Warrior", "W01", "Mid-Heel", 4, "Slightly-Open", "Round", "Short"),
                new Player("Adam", "Henrique", "C", "https://nhl.bamcontent.com/images/headshots/current/168x168/8474641.jpg", "https://www.hockeygiant.com/ui/support/how_to/Warrior-W03-Henrique-Blade-Pattern-Curve.jpg", "Warrior", "W03", "Mid", 5, "Open", "Round", "Medium"),
                new Player("Mikael", "Granlund", "RW", "https://nhl.bamcontent.com/images/headshots/current/168x168/8475798.jpg", "https://www.hockeygiant.com/ui/support/how_to/Warrior-W05-Granlund-Blade-Pattern-Curve.jpg", "Warrior", "W05", "Heel", 5, "Open", "Round", "Long"),
                new Player("Joe", "Pavelski", "C", "https://nhl.bamcontent.com/images/headshots/current/168x168/8470794.jpg", "https://www.hockeygiant.com/ui/support/how_to/Warrior-W12-Pavelski-Blade-Pattern-Curve.jpg", "Warrior", "W12", "Mid-Heel", 4, "Open", "Round", "Medium"),
                new Player("Zdeno", "Chara", "D", "https://nhl.bamcontent.com/images/headshots/current/168x168/8465009.jpg", "https://www.hockeygiant.com/ui/support/how_to/Warrior-W14-Chara-Blade-Pattern-Curve.jpg", "Warrior", "W14", "Mid", 4, "Slightly-Open", "Round", "Short"),
                new Player("Erik", "Karlsson", "D", "https://nhl.bamcontent.com/images/headshots/current/168x168/8474578.jpg", "https://www.hockeygiant.com/ui/support/how_to/Warrior-W16-Karlsson-Blade-Pattern-Curve.jpg", "Warrior", "W16", "Mid-Heel", 5, "Slightly-Open", "Square", "Medium"),
                new Player("Nail", "Yakupov", "RW", "https://nhl.bamcontent.com/images/headshots/current/168x168/8476855.jpg", "https://www.hockeygiant.com/ui/support/how_to/Warrior-W28-Yakupov-Blade-Pattern-Curve.jpg", "Warrior", "W28", "Mid-Toe", 4, "Open-Toe", "Round", "Medium"),
                new Player("Max", "Pacioretty", "LW", "https://nhl.bamcontent.com/images/headshots/current/168x168/8474157.jpg", "https://www.hockeygiant.com/ui/support/how_to/Warrior-W71-Pacioretty-Blade-Pattern-Curve.jpg", "Warrior", "W71", "Mid", 5, "Open", "Round", "Long"),
                new Player("Henrik", "Zetterberg", "C", "https://nhl.bamcontent.com/images/headshots/current/168x168/8468083.jpg", "https://www.hockeygiant.com/ui/support/how_to/Warrior-W88-Zetterberg-Blade-Pattern-Curve.jpg", "Warrior", "W88", "Mid", 4, "Slightly-Open", "Round", "Medium")
                //new Player("", "", "", "", "", "", "", "", "", "", "", ""),
        };
    }
}
