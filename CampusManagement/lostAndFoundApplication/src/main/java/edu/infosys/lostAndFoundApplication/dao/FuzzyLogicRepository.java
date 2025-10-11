package edu.infosys.lostAndFoundApplication.dao;

import edu.infosys.lostAndFoundApplication.bean.FoundItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuzzyLogicRepository extends JpaRepository<FoundItem, String> {

    @Query("SELECT f FROM FoundItem f WHERE f.username <> ?1")
    List<FoundItem> findFoundItemsExcludingUser(String username);

    @Query("SELECT f FROM FoundItem f WHERE f.username <> :username AND f.category = :category")
    List<FoundItem> findPotentialMatches(@Param("username") String username, @Param("category") String category);
}