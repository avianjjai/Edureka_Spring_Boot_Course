package com.example.submissionforms;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    @Autowired
    CustomerRepo repo;

    @RequestMapping("/")
    public String edureka() {
        return "edureka";
    }

    @RequestMapping("/details")
    public String details(Customers customers) {
        repo.save(customers);
        return "edureka";
    }

    @RequestMapping("/getdetails")
    public String getdetails() {
        return "ViewCustomers";
    }

    @PostMapping("/getdetails")
    public ModelAndView getdetails(@RequestParam("cid") int cid) {
        ModelAndView mv = new ModelAndView("Retrive");
        Customers customers = repo.findById(cid).orElse(null);
        mv.addObject(customers);
        return mv;
    }

    @RequestMapping("/customers")
    @ResponseBody
    public List<Customers> getCustomers() {
        return repo.findAll();
    }

    @RequestMapping("/customers/{cid}")
    @ResponseBody
    public Optional<Customers> getCustomer(@PathVariable("cid") int cid) {
        return repo.findById(cid);
    }

    @PostMapping("/customers")
    public Customers getCustomers3(@RequestBody Customers customers) {
        repo.save(customers);
        return customers;
    }

    @DeleteMapping("/customers/delete/{cid}")
    public Customers deleteCustomer(@PathVariable("cid") int cid) {
        Customers cust = repo.getReferenceById(cid);
        repo.delete(cust);
        return cust;
    }

    @PutMapping(path = "/customers", consumes = {"application/json"})
    public Customers updateCustomer(@RequestBody Customers customers) {
        repo.save(customers);
        return customers;
    }
}