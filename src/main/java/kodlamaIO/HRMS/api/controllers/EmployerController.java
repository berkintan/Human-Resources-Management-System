package kodlamaIO.HRMS.api.controllers;

import kodlamaIO.HRMS.business.abstracts.EmployerService;
import kodlamaIO.HRMS.core.utilities.results.DataResult;
import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.entites.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();
    }

    @PostMapping("/register")
    public Result register(@RequestBody Employer employer) throws URISyntaxException {
        return this.employerService.register(employer);
    }
}
