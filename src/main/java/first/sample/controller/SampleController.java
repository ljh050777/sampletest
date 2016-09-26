package first.sample.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import first.common.common.CommandMap;
import first.sample.service.SampleService;

@Controller
public class SampleController {
	
	Logger log = Logger.getLogger(this.getClass());
    
    @Resource(name="sampleService")
    private SampleService sampleService;
    
    @RequestMapping(value="/sample/openSampleList.do")
    public ModelAndView openSampleList(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("");
        log.debug("���ͼ��� �׽�Ʈ");
         
        return mv;
    }
    
    //Mainȭ��
    @RequestMapping(value="/sample/mainlist.do")
    public ModelAndView openBoardWrite(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/mainlist");
        
        List<Map<String,Object>> list = sampleService.selectMainList(commandMap);
        mv.addObject("list", list);
         
        return mv;
    }
    
    //�Է�ȭ��
    @RequestMapping(value="/sample/listwrite.do")
    public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/listWrite");
         
        return mv;
    }
    
    //�Է½���
    @RequestMapping(value="/sample/insertlist.do")
    public ModelAndView insertListWrite(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("redirect:/sample/mainlist.do");
        
        sampleService.insertList(commandMap.getMap());
         
        return mv;
    }
    
    //��ȭ��
    @RequestMapping(value="/sample/openListDetail.do")
    public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/listDetail");
         
        Map<String,Object> map = sampleService.selectListDetail(commandMap.getMap());
        mv.addObject("map", map);
         
        return mv;
    }
    
    //����ȭ��
    @RequestMapping(value="/sample/openListUpdate.do")
    public ModelAndView openBoardUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/listUpdate");
         
        Map<String,Object> map = sampleService.selectListDetail(commandMap.getMap());
        mv.addObject("map", map);
         
        return mv;
    }
    
    //��������
    @RequestMapping(value="/sample/updateList.do")
    public ModelAndView updateBoard(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("redirect:/sample/openListDetail.do");
         
        sampleService.updateList(commandMap.getMap());
         
        mv.addObject("PID", commandMap.get("PID"));
        return mv;
    }
    
    //��������
    @RequestMapping(value="/sample/deleteList.do")
    public ModelAndView deleteBoard(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("redirect:/sample/mainlist.do");
         
        sampleService.deleteList(commandMap.getMap());
         
        return mv;
    }
  
    
}
