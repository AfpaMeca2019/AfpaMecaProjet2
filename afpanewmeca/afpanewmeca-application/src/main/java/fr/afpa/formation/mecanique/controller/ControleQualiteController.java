package fr.afpa.formation.mecanique.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.afpa.formation.mecanique.business.ControleQualiteService;
import fr.afpa.formation.mecanique.business.EclairageService;
import fr.afpa.formation.mecanique.business.NiveauxService;
import fr.afpa.formation.mecanique.business.PneumatiqueService;
import fr.afpa.formation.mecanique.business.VisibiliteService;
import fr.afpa.formation.mecanique.persistence.entity.cq.ControleQualite;
import fr.afpa.formation.mecanique.persistence.entity.cq.Eclairage;
import fr.afpa.formation.mecanique.persistence.entity.cq.Niveau;
import fr.afpa.formation.mecanique.persistence.entity.cq.Pneumatique;
import fr.afpa.formation.mecanique.persistence.entity.cq.Visibilite;

@Controller
public class ControleQualiteController {
	@Autowired
	private ControleQualiteService cqs;
	@Autowired
	private NiveauxService ns;
	@Autowired
	private PneumatiqueService ps;
	@Autowired
	private EclairageService es;
	@Autowired
	private VisibiliteService vs;
	private ControleQualite cq;
	private Niveau n;
	private Eclairage e;
	private Visibilite v;
	private Pneumatique p;
	
	@GetMapping("/cq")
	public String showList(Model m) {
		m.addAttribute("listCQ", cqs.findAll());
		return "listControleQualite";
	}
	
	@PostMapping("/doCreateNiveau")
	public String doCreateNiveau(Niveau leN, Model m) throws Exception {
		ns.createNiveau(leN);
		this.n= leN;
		m.addAttribute("pneumatique",  new Pneumatique());
		return "createPneumatique";
	}
	
	@PostMapping("/doCreatePneumatique")
	public String doCreatePneumatique(Pneumatique p, Model m) throws Exception {
		ps.createPneumatique(p);
		this.p = p;
		m.addAttribute("eclairage",  new Eclairage());
		return "createEclairage";
	}
	
	@PostMapping("/doCreateEclairage")
	public String doCreateEclairage(Eclairage e, Model m) throws Exception {
		es.createEclairage(e);
		this.e= e;
		m.addAttribute("visibilite", new Visibilite());
		return "createVisibilite";
	}
	
	@PostMapping("/doCreateVisibilite")
	public String doCreateVisibilite(Visibilite e, Model m) throws Exception {
		vs.createVisibilite(e);
		this.v = e;
		cq.setE(es.findById(this.e.getId()));
		cq.setN(ns.findById(n.getId()));
		cq.setV(vs.findById(v.getId()));
		cq.setP(ps.findById(p.getId()));
		cq.setDateDebut(new Date());
		cqs.createCQ(cq);
		return "redirect:/cq";
	}
	
	@GetMapping("/createCQ")
	public String createCQ(Model m) {
		m.addAttribute("cq",  new ControleQualite());
		return "createControleQualite";
	}
	
	@PostMapping("/doCreate/cq")
	public String doCreateCQ(ControleQualite c, Model m) {
		this.cq = c;
		m.addAttribute("niveau",  new Niveau());
		return "createNiveau";
	}

}
