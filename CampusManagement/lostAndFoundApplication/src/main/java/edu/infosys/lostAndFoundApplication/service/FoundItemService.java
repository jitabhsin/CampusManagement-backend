package edu.infosys.lostAndFoundApplication.service;

import edu.infosys.lostAndFoundApplication.bean.FoundItem;
import edu.infosys.lostAndFoundApplication.dao.FoundItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FoundItemService {

    @Autowired
    private FoundItemRepository foundItemRepository;

    public synchronized String generateNextFoundItemId() {
        Long maxId = foundItemRepository.findMaxIdNumber();
        long nextId = (maxId == null) ? 1 : maxId + 1;
        return String.format("F%04d", nextId);
    }

    public FoundItem addFoundItem(FoundItem foundItem) {
        foundItem.setFoundItemId(generateNextFoundItemId());
        return foundItemRepository.save(foundItem);
    }

    public List<FoundItem> getAllFoundItems() {
        return foundItemRepository.findAll();
    }

    public Optional<FoundItem> getFoundItemById(String id) {
        return foundItemRepository.findById(id);
    }

    public void deleteFoundItem(String id) {
        foundItemRepository.deleteById(id);
    }

    public List<FoundItem> getFoundItemsByUsername(String username) {
        return foundItemRepository.findByUsername(username);
    }
}