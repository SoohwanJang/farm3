package com.farm.web.controller.seller.item;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.farm.web.dao.CategoryDao;
import com.farm.web.dao.MemberDao;
import com.farm.web.entity.Category;
import com.farm.web.entity.CategoryView;
import com.farm.web.entity.Item;
import com.farm.web.entity.Member;
import com.farm.web.entity.Origin;
import com.farm.web.entity.SellerCategoryCountView;
import com.farm.web.entity.SellerItemView;
import com.farm.web.service.ItemService;


@Controller("sellerItemController")
@RequestMapping("/seller/item/")
public class ItemController {
	
	@Autowired
	private ItemService spservice;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("list")
	public String list(@RequestParam(name = "q", defaultValue = "") String query,
			@RequestParam(name = "f", defaultValue = "name") String field,
			@RequestParam(name = "catg", defaultValue = "") String category,
			@RequestParam(name = "p", defaultValue = "1") Integer page,
			Model model,
			Principal principal
			) {
		
		String uid= principal.getName();
		List<SellerItemView> list = null;
		List<SellerCategoryCountView> count = null;
		list = spservice.getList(query,field,category,page,uid);
		count = spservice.getCountList();

		model.addAttribute("list",list);
		model.addAttribute("cl",count);

		return "seller/item/list";
	}
	
	@GetMapping("del")
	public String delete(@RequestParam(name = "item-id", defaultValue = "") Integer id) {
		spservice.delete(id);
		return "redirect:list";
	}
	
	@GetMapping("pub")
	public String updatePub(@RequestParam(name = "item-id", defaultValue = "") Integer id) {
		System.out.println(id);
		spservice.updatePub(id);
		return "redirect:list";
	}
	
	@PostMapping("pub")
	public String updatepub(@RequestParam(name = "item-id", defaultValue = "") Integer[] ids) {
		
		for(Integer id : ids)
			spservice.updatePub(id);
		
		return "redirect:list";
	}
	
	@GetMapping("reg")
	public String reg(
			Model model,
			Principal principal) {
		List<CategoryView> catList = null;
		catList = categoryDao.getList();
		
		List<Category> subList = null;
		subList = categoryDao.getSubList(1);
		
		model.addAttribute("catList", catList);
		model.addAttribute("subList", subList);
		
		String uid = principal.getName();
		Member member=null;

		member = spservice.getMember(uid);
		model.addAttribute("m",member);

		List<Origin> olist = spservice.getList();
		model.addAttribute("originlist",olist);
		
		return "seller/item/reg";
	}
	
	@PostMapping("reg")
	public String reg(MultipartFile file,HttpServletRequest request,
			@RequestParam(name = "store-qty", defaultValue = "") Integer qty,
			Principal principal
			) throws IOException, ParseException{
		
			Item item = new Item();
		
			String uid = principal.getName();
			Member member = memberDao.getByUid(uid);
			int sellerId =member.getId();
			item.setSellerId(sellerId);
			
			item.setName(request.getParameter("name"));
			item.setRegName(request.getParameter("regName"));
			item.setTag(request.getParameter("tag"));
			item.setDetail(request.getParameter("detail"));
			item.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
			item.setOriginId(Integer.parseInt(request.getParameter("originId")));
			item.setPrice(Integer.parseInt(request.getParameter("price")));
			item.setLeadTime(Integer.parseInt(request.getParameter("leadTime")));
			item.setDeliveryFee(Integer.parseInt(request.getParameter("deliveryFee")));
			
			
//			날짜변환
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String sd_ = request.getParameter("startDate");
			String ed_ = request.getParameter("endDate");
			Date sd = sdf.parse(sd_);
			Date ed = sdf.parse(sd_);
			System.out.println(sd);
			item.setStartDate(sd);
			item.setEndDate(ed);
		
			
			
		
        ////이미지업로드를 안한다면 업로드 금지하는거 추가하기////
		String path = request.getServletContext().getRealPath("/upload/"); 
		File file1 = new File(path);
		if(!file1.exists()) 
          file1.mkdir();
		path += file.getOriginalFilename();
		item.setImage(file.getOriginalFilename());
		FileOutputStream os = new FileOutputStream(path);
       
      InputStream is = file.getInputStream();
      
      byte[] buf = new byte[1024];
      int len = 0;
       while((len = is.read(buf)) != -1) // buf사이즈 만큼 read함 // is.read(buf) -> 다 못채웠으면 LEN만큼 반환함    
          os.write(buf, 0, len);
       
       
//      등록
		int result = spservice.insertSellerProduct(item,qty);
		
//		아이템 등록 및 입고 성공
		if(result==1)
			System.out.println("아이템 등록 및 입고 성공");
//		입고 실패
		if(result==0) {
			System.out.println("입고 실패");
		}
//		아이템 등록 실패
		if(result==0) {
			System.out.println("아이템 등록 실패");
		}
		
		return "redirect:/seller/index";
		
	}


}
