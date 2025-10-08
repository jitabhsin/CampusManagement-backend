package edu.infosys.lostAndFoundApplication.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.infosys.lostAndFoundApplication.bean.LostFoundItem;
import edu.infosys.lostAndFoundApplication.dao.FuzzyLogicRepository; // UPDATED

@Service
public class FuzzyLogic {

    @Autowired
    private FuzzyLogicRepository fuzzyLogicRepository; // UPDATED to use the dedicated repository

    private final JaroWinklerSimilarity jaro = new JaroWinklerSimilarity();

    public List<LostFoundItem> findMatchingFoundItems(Long lostItemId, double threshold) {
        // Step 1: Safely retrieve the lost item using the standard findById method.
        Optional<LostFoundItem> lostItemOptional = fuzzyLogicRepository.findById(lostItemId);

        if (lostItemOptional.isEmpty()) {
            return Collections.emptyList();
        }
        LostFoundItem lostItem = lostItemOptional.get();

        String usernameOfLoser = lostItem.getUsername();

        // Step 2: Fetch "found" items from OTHER users using the dedicated repository.
        List<LostFoundItem> foundItemsFromOthers = fuzzyLogicRepository.findFoundItemsExcludingUser(usernameOfLoser);

        List<LostFoundItem> matches = new ArrayList<>();

        // Step 3: Iterate and calculate similarity.
        for (LostFoundItem foundItem : foundItemsFromOthers) {
            double itemNameScore = jaro.apply(lostItem.getItemName(), foundItem.getItemName());
            double brandScore = jaro.apply(lostItem.getBrand(), foundItem.getBrand());
            double colorScore = jaro.apply(lostItem.getColor(), foundItem.getColor());
            double categoryScore = jaro.apply(lostItem.getCategory(), foundItem.getCategory());

            double averageScore = (itemNameScore * 0.5) + (brandScore * 0.2) + (colorScore * 0.2) + (categoryScore * 0.1);

            if (averageScore >= threshold) {
                matches.add(foundItem);
            }
        }

        return matches;
    }
}