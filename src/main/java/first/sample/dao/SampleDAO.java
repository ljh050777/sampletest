package first.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import first.common.dao.AbstractDAO;

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO{	
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectMainList(Map<String, Object> map) throws Exception{
		log.debug("sampleDAO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return (List<Map<String, Object>>)selectList("sample.selectMainList", map);
    
	}
	
	public void insertList(Map<String, Object> map) throws Exception{
	    insert("sample.insertList", map);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectListDetail(Map<String, Object> map) throws Exception{
	    return (Map<String, Object>) selectOne("sample.selectListDetail", map);
	}
	
	public void updateList(Map<String, Object> map) throws Exception{
	    update("sample.updateList", map);
	}
	
	public void deleteList(Map<String, Object> map) throws Exception{
	    update("sample.deleteList", map);
	}
}	
