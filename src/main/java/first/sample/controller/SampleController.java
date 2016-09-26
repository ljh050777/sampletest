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
        log.debug("인터셉터 테스트");
         
        return mv;
    }
    
    //Main화면
    @RequestMapping(value="/sample/mainlist.do")
    public ModelAndView openBoardWrite(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/mainlist");
        
        List<Map<String,Object>> list = sampleService.selectMainList(commandMap);
        mv.addObject("list", list);
         
        return mv;
    }
    
    //입력화면
    @RequestMapping(value="/sample/listwrite.do")
    public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/listWrite");
         
        return mv;
    }
    
    //입력실행
    @RequestMapping(value="/sample/insertlist.do")
    public ModelAndView insertListWrite(CommandMap commandMap) throws Exception{
    	ModelAndView mv = new ModelAndView("redirect:/sample/mainlist.do");
        
        sampleService.insertList(commandMap.getMap());
         
        return mv;
    }
    
    //상세화면
    @RequestMapping(value="/sample/openListDetail.do")
    public ModelAndView openBoardDetail(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/listDetail");
         
        Map<String,Object> map = sampleService.selectListDetail(commandMap.getMap());
        mv.addObject("map", map);
         
        return mv;
    }
    
    //수정화면
    @RequestMapping(value="/sample/openListUpdate.do")
    public ModelAndView openBoardUpdate(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/listUpdate");
         
        Map<String,Object> map = sampleService.selectListDetail(commandMap.getMap());
        mv.addObject("map", map);
         
        return mv;
    }
    
    //수정실행
    @RequestMapping(value="/sample/updateList.do")
    public ModelAndView updateBoard(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("redirect:/sample/openListDetail.do");
         
        sampleService.updateList(commandMap.getMap());
         
        mv.addObject("PID", commandMap.get("PID"));
        return mv;
    }
    
    //삭제실행
    @RequestMapping(value="/sample/deleteList.do")
    public ModelAndView deleteBoard(CommandMap commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("redirect:/sample/mainlist.do");
         
        sampleService.deleteList(commandMap.getMap());
         
        return mv;
    }
  
    
}
