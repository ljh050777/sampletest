package first.sample.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import first.sample.dao.SampleDAO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="sampleDAO")
    private SampleDAO sampleDAO;     
   
    @Override
    public List<Map<String, Object>> selectMainList(Map<String, Object> map) throws Exception {
        return sampleDAO.selectMainList(map);
    }
    
    @Override
    public void insertList(Map<String, Object> map) throws Exception {
        sampleDAO.insertList(map);
    }
    
    @Override
    public Map<String, Object> selectListDetail(Map<String, Object> map) throws Exception {        
        Map<String, Object> resultMap = sampleDAO.selectListDetail(map);
        return resultMap;
    }
    
    @Override
    public void updateList(Map<String, Object> map) throws Exception{
        sampleDAO.updateList(map);
    }
    
    @Override
    public void deleteList(Map<String, Object> map) throws Exception {
        sampleDAO.deleteList(map);
    }

}
