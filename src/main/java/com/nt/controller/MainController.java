package com.nt.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.domain.EmployeeDetails;
import com.nt.entity.EmployeeEntity;
import com.nt.service.EmployeeService;

@Controller
public class MainController {

	@Autowired
	private EmployeeService service;

	/**
	 * This method is used for lunch form page for register data
	 * 
	 * @param details
	 * @return String
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String lunchForm() {

		return "page";
	}

	/**
	 * This method is used for lunch form page for register data
	 * 
	 * @param details
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handleForm(@RequestParam("myfile") MultipartFile file, RedirectAttributes redirect) throws Exception {

		service.readfile(file);

		return "redirect:/sucess";
	}

	/**
	 * This method is used for controller go to sucess jsp page
	 * 
	 * @param details
	 * @return
	 */
	@RequestMapping(value = "/sucess", method = RequestMethod.GET)
	public String sucessMsg(@ModelAttribute("details") EmployeeDetails details) {

		return "sucess";
	}

	/**
	 * This method is used for find data by using employee id
	 * 
	 * @param id
	 * @param mod
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public String getData(@PathVariable("id") Integer id, Model mod) throws SQLException {
		List<EmployeeEntity> dataById = service.getDataById(id);
		EmployeeEntity e = new EmployeeEntity();
		BeanUtils.copyProperties(dataById, e);

		mod.addAttribute("value", dataById);
		return "data";
	}

	/**
	 * This method is used for delete records by using employe id
	 * 
	 * @param id
	 * @param mod
	 * @return
	 * @throws SQLException
	 */

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletBYID(@PathVariable("id") Integer id, Model mod) throws SQLException {
		service.deltRecord(id);
		String msg = id + " reords are Deleted ...";

		mod.addAttribute("msg", msg);
		return "data";
	}

}
