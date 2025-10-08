package edu.infosys.lostAndFoundApplication.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.infosys.lostAndFoundApplication.bean.LostFoundItem;
import edu.infosys.lostAndFoundApplication.dao.LostFoundItemDao;

@Service
public class FuzzyLogic {

    @Autowired
    private LostFoundItemDao lostFoundItemDao;

    private JaroWinklerSimilarity jaro = new JaroWinklerSimilarity();

    /**
     * Find matching found items for a lost item based on Jaro-Winkler similarity.
     * @param lostItemId the lost item to match
     * @param threshold similarity threshold (0.8 = 80%)
     * @return list of matching found items
     */
    public List<LostFoundItem> findMatchingFoundItems(Long lostItemId, double threshold) {
        LostFoundItem lostItem = lostFoundItemDao.findById(lostItemId);
        List<LostFoundItem> foundItems = lostFoundItemDao.foundItemList();
        List<LostFoundItem> matches = new ArrayList<>();

        for (LostFoundItem foundItem : foundItems) {
            double itemNameScore = jaro.apply(lostItem.getItemName(), foundItem.getItemName());
            double brandScore = jaro.apply(lostItem.getBrand(), foundItem.getBrand());
            double colorScore = jaro.apply(lostItem.getColor(), foundItem.getColor());
            double categoryScore = jaro.apply(lostItem.getCategory(), foundItem.getCategory());

            // Weighted average similarity
            double averageScore = (itemNameScore*0.5 + brandScore*0.2 + colorScore*0.2 + categoryScore*0.1);

            if (averageScore >= threshold) {
                matches.add(foundItem);
            }
        }
        return matches;
    }
}
