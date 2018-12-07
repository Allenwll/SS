package com.allen.springboot.controller;

import com.allen.springboot.entity.Nutrition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
public class NutritionController {
	
	@RequestMapping("/nutrition-index")
	public String list() {
		return "student/list";
	}
	
	@ResponseBody
	@RequestMapping("/nutrition-list")
	public Object nutritionList(String sportsmanName) {
		String name=sportsmanName;
		List<Nutrition> list = new ArrayList<>();
		if(null!=name && name!=""){
			list.clear();
			list.add(new Nutrition(1L,"A2000",new Date(),"小明",180.1f,65.1f,70.0f,70.0f,70.0f,50.0f,163.5f,15.6f,65.5f,17.6f,
				22.2f,21.12f,15.0f,"dd"));
		}else{
			list.add(new Nutrition(1L,"A2000",new Date(),"小明",180.1f,65.1f,70.0f,70.0f,70.0f,50.0f,163.5f,15.6f,65.5f,17.6f,
				22.2f,21.12f,15.0f,"dd"));
			list.add(new Nutrition(2L,"A3000",new Date(),"小花",180.1f,65.1f,70.0f,70.0f,70.0f,50.0f,163.5f,15.6f,65.5f,17.6f,
				22.2f,21.12f,15.0f,"dd"));
			list.add(new Nutrition(3L,"A4000",new Date(),"芳芳",180.1f,65.1f,70.0f,70.0f,70.0f,50.0f,163.5f,15.6f,65.5f,17.6f,
				22.2f,21.12f,15.0f,"dd"));
			list.add(new Nutrition(4L,"A5000",new Date(),"熊大",180.1f,65.1f,70.0f,70.0f,70.0f,50.0f,163.5f,15.6f,65.5f,17.6f,
				22.2f,21.12f,15.0f,"dd"));
			list.add(new Nutrition(5L,"A6000",new Date(),"熊二",180.1f,65.1f,70.0f,70.0f,70.0f,50.0f,163.5f,15.6f,65.5f,17.6f,
				22.2f,21.12f,15.0f,"dd"));
		}
		
		return list;
	}
	
	
	/**
     * 导入excel文件
     *
     * @param request
     * @throws Exception
     */
    @RequestMapping(value = "/import", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView uploadExcel(HttpServletRequest request) throws Exception {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        InputStream in = null;
        List<List<Object>> listObj = null;
        MultipartFile file = multipartRequest.getFile("uploadFile");
        if (file.isEmpty()) {
            throw new Exception("文件不存在！");
        }
        in = file.getInputStream();
        //listObj = new ImportExcelUtil().getListByExcel(in, file.getOriginalFilename());
        in.close();

      //  nutritionService.importFile(listObj);

      //  List<Nutrition> nutritionList = nutritionService.findAll();

        ModelAndView mv = new ModelAndView("successImportExport");
        mv.addObject("type", "import");
       // mv.addObject("nutritionList", nutritionList);
        return mv;

    }

    /*@RequestMapping("/export")
    public ModelAndView exportFile(HttpServletResponse resp) {

    	nutritionService.exportFile(resp);

        ModelAndView mv = new ModelAndView("successImportExport");
        mv.addObject("type", "export");
        return mv;

    }*/
    
    @RequestMapping(value="/export",method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView exportToExcelByQueryOnName(HttpServletRequest request) {
    	System.out.println("查询被执行，等待………………………………》》》》》》》》》》》》》》》》》");
    	Map<String,String> conditionsMap=new HashMap<String,String>();
    	Map<String,String> titleMap=new HashMap<String,String>();
    	conditionsMap.put("beginDate", request.getParameter("beginDate"));
    	conditionsMap.put("endDate", request.getParameter("endDate"));
    	conditionsMap.put("sportsmanName", "sportsmanName");
    	titleMap.put("className","Nutrition");
    	titleMap.put("userName",request.getParameter("userName"));
    	//nutritionService.doExportToExcel(titleMap, conditionsMap);
        ModelAndView mv = new ModelAndView("successImportExport");
        mv.addObject("type", "export");
        return mv;
    }
}
