package first.sample.service;

import java.util.List;
import java.util.Map;

public interface SampleService {

	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> selectMainList(Map<String, Object> map) throws Exception;
	
	void insertList(Map<String, Object> map) throws Exception;
	
	Map<String, Object> selectListDetail(Map<String, Object> map) throws Exception;
	
	void updateList(Map<String, Object> map) throws Exception;
	
	void deleteList(Map<String, Object> map) throws Exception;

}
