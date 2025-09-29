package edu.infosys.lostAndFoundApplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.infosys.lostAndFoundApplication.bean.LostFoundItem;

@Service
@Repository
public class LostFoundItemDaoImpl implements LostFoundItemDao {
    private LostFoundItemRepository repository;
    
    @Autowired
    public LostFoundItemDaoImpl(LostFoundItemRepository repository) {
        this.repository = repository;
    }

	@Override
	public void save(LostFoundItem item) {
		// TODO Auto-generated method stub
            repository.save(item);
	}

	@Override
	public List<LostFoundItem> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Long generateId() {
		// TODO Auto-generated method stub
		Long id = repository.findMaxId();
		if(id == null) {
			id =100001L;
		}else {
			id=id+1;
		}
		return id;
	}

	@Override
	public List<LostFoundItem> notFoundItemList() {
		// TODO Auto-generated method stub
		 return repository.notFoundItemList();
	}

	@Override
	public List<LostFoundItem> foundItemList() {
		// TODO Auto-generated method stub
		return repository.foundItemList();
	}

	@Override
	public LostFoundItem findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
          repository.deleteById(id);
	}

}
