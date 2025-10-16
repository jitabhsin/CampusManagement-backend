package edu.infosys.lostAndFoundApplication.dao;

import edu.infosys.lostAndFoundApplication.bean.FoundItem;
import edu.infosys.lostAndFoundApplication.bean.LostItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@org.springframework.stereotype.Repository
// The only change is here: Object -> FoundItem
public interface FuzzyLogicRepository extends Repository<FoundItem, String> {

    @Query("SELECT f FROM FoundItem f WHERE f.username <> :username AND f.category = :category")
    List<FoundItem> findPotentialFoundMatches(@Param("username") String username, @Param("category") String category);

    @Query("SELECT l FROM LostItem l WHERE l.username <> :username AND l.category = :category")
    List<LostItem> findPotentialLostMatches(@Param("username") String username, @Param("category") String category);
}