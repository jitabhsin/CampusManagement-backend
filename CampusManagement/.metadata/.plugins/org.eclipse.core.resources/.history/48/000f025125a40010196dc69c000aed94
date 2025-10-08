package edu.infosys.lostAndFoundApplication.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.infosys.lostAndFoundApplication.bean.LostFoundItem;

@Repository
public interface FuzzyLogicRepository extends JpaRepository<LostFoundItem, Long> {

    /**
     * This query finds all items that have been marked as "found" 
     * (foundDate is not null) AND were posted by a user other than the one provided.
     * This is dedicated to the fuzzy matching service.
     */
    @Query("SELECT f FROM LostFoundItem f WHERE f.foundDate IS NOT NULL AND f.username <> ?1")
    List<LostFoundItem> findFoundItemsExcludingUser(String username);

}