package com.nestdigital.empApp.Controller;

import com.nestdigital.empApp.Dao.EmpDao;
import com.nestdigital.empApp.Model.EmpModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class EmpController {
@Autowired
    private EmpDao dao;

@CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee",consumes = "application/json",produces = "application/json")
    public String addemp(@RequestBody EmpModel emp){
    System.out.println(emp.toString());
    dao.save(emp);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewemp")
    public List<EmpModel> viewemp(){
    return (List<EmpModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/deleteemp",consumes = "application/json",produces = "application/json")
    public String deleteemp(@RequestBody EmpModel emp){
    dao.deleteEmpById(emp.getId());
    return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchemp",consumes = "application/json",produces = "application/json")
    public List<EmpModel> searchemp(@RequestBody EmpModel emp){
    return (List<EmpModel>) dao.searchemp(emp.getName());
    }
}
