package com.patient.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.patient.app.entity.Appointment;
import com.patient.app.entity.AppointmentDelete;
import com.patient.app.entity.Doctor;
import com.patient.app.entity.Patient;
import com.patient.app.entity.Prescription;
import com.patient.app.repository.AppointmentRepository;
import com.patient.app.repository.DoctorRepository;
import com.patient.app.repository.PatientRepository;
import com.patient.app.repository.PrescriptionRepository;

import jakarta.servlet.http.HttpSession;
@Controller
public class ControllerAll {
	
	int count=0;
	
	@Autowired
	PatientRepository patientRepo;
	
	@Autowired
	DoctorRepository docRepo;
	
	@Autowired
	AppointmentRepository appRepo;

	@Autowired
	PrescriptionRepository preRepo;

	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@GetMapping("/registerdoc")
	public String registerdoc() {
		return "registerdoc";
	}

	@GetMapping("/")
	public String home() {
		return "start";
	}

	@GetMapping("/patlog")
	public String patlog() {
		return "index";
	}

	@GetMapping("/doclog")
	public String doclog() {
		return "doclog";
	}
	
	@PostMapping("/registered")
	public String registered(Patient patient) {
		patientRepo.save(patient);
		return "redirect:/";
	}

	@PostMapping("/registereddoc")
	public String registereddoc(Doctor doctor) {
		docRepo.save(doctor);
		return "redirect:/";
	}
	
	@GetMapping("/fail_login")
	public String fail_login() {
		return "fail_login";
	}

	@PostMapping("/authenticate")
	public String authenticate(Patient patient,HttpSession session) {
		if(patientRepo.existsById(patient.getEmail()) && patientRepo.findById(patient.getEmail()).get().getPassword().equals(patient.getPassword())) {
			session.setAttribute("patient", patient.getEmail());
			return "redirect:/home";
			}
		return "redirect:/fail_login";
	}

	@PostMapping("/authenticatedoc")
	public String authenticatedoc(Doctor doctor,HttpSession session) {
		if(docRepo.existsById(doctor.getEmail()) && docRepo.findById(doctor.getEmail()).get().getPassword().equals(doctor.getPassword())) {
			session.setAttribute("doctor", doctor.getEmail());
			return "redirect:/patientlist";
			}
		return "redirect:/fail_login";
	}
	
	@PostMapping("/cancel")
	public String cancel(AppointmentDelete dApp) {
		appRepo.deleteById(dApp.getAppId());
		return "redirect:/userdetails";
	}
	
	@GetMapping("/home")
	public ModelAndView display(HttpSession session) {
		ModelAndView mav= new ModelAndView("fail_login");
		String email = null;
		
		
		if(session.getAttribute("person")!=null) {
			mav = new ModelAndView("home");
		email = (String) session.getAttribute("person");
		}
		
		mav.addObject("email",email);
		
		return mav;
		
		
	}


	
	@PostMapping("/assignment")
	public String submitted(Appointment app) {
		app.setAppId(count++);
		app.setStatus("Active");
		appRepo.save(app);
		
		return "redirect:/docdetails";
	}
	
	@GetMapping("/docdetails")
	public ModelAndView DocDetails(HttpSession session) {
		
	    List<Doctor> doctors = new ArrayList<Doctor>();
		docRepo.findAll().forEach(doctors::add);
	    Map<String, Object> params = new HashMap<>();
	    
	    params.put("doctor", doctors);
	    params.put("email", session.getAttribute("person"));
	    
	    return new ModelAndView("doctorlist", params);
	}
	
	@GetMapping("/userdetails")
	public ModelAndView UserDetails(HttpSession session) {
		List<Appointment> apps = appRepo.findAllByEmail(session.getAttribute("person").toString());
		Map<String,Object> params = new HashMap<>();
		
		params.put("appointments", apps);
		params.put("email", session.getAttribute("person"));
		
		return new ModelAndView("appointed",params);
		
		
	}
	@GetMapping("/patientlist")
	public ModelAndView PatientList(HttpSession session) {
		List<Appointment> apps = appRepo.findByDocId(session.getAttribute("doctor").toString());
		Map<String,Object> params = new HashMap<>();
		
		params.put("appointments", apps);
		params.put("email", session.getAttribute("doctor"));
		
		return new ModelAndView("appointedDoc",params);
		
		
	}

	@PostMapping("/prescription")
	public String prescription(Appointment dApp) {

		appRepo.save(dApp);
		return "redirect:/prescriptionPage?appId=" + dApp.getAppId(); // Redirect to prescription page with appointment ID
	}

	@GetMapping("/prescriptionPage")
	public ModelAndView openPrescriptionPage(@RequestParam("appId") String appId) {


		ModelAndView mav = new ModelAndView("prescriptionPage");
		Appointment appointment = appRepo.findById(appId).orElse(null);

		mav.addObject("appointment", appointment);
		return mav;
	}



	@PostMapping("/savePrescription")
	public String savePrescription(Prescription prescription) {
		preRepo.save(prescription);

		return "redirect:/patientlist";
	}
	
	
	
}