package edu.infosys.lostAndFoundApplication.dao;

import java.util.List;

import edu.infosys.lostAndFoundApplication.bean.LostFoundItem;

public interface LostFoundItemDao {
    public void save(LostFoundItem item);
    public List<LostFoundItem> findAll();
    public Long generateId();
    public List<LostFoundItem> notFoundItemList();
    public List<LostFoundItem> foundItemList();
    public LostFoundItem findById(Long id);
    public void deleteById(Long id);
}