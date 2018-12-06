package com.software.sekhon.jason.curve.MyDB;

import android.arch.persistence.room.*;

import java.util.List;

@Dao
public interface PlayerDao {

    @Query("SELECT * FROM players")
    List<Player> getALL();

    @Query("SELECT * FROM players WHERE pid IN (:playerIds)")
    List<Player> loadAllByIds(int[] playerIds);

    @Query("SELECT * FROM players WHERE `first name` LIKE :first AND " +
            "`last name` LIKE :last LIMIT 1")
    Player findByName(String first, String last);

    @Query("SELECT * FROM players WHERE `first name` LIKE :first AND `last name` LIKE :last AND `position` LIKE :position" +
            " AND `brand` LIKE :brand AND `face angle` LIKE :face AND `toe shape` LIKE :toe AND `lie` BETWEEN :minLie AND :maxLie")
    List<Player> filterQuery(String first, String last, String position, String brand, String face, String toe, int minLie, int maxLie);

    @Insert
    void insertAll(Player... players);

    @Delete
    void delete(Player player);

    @Update
    void updatePlayers(Player... players);
}
