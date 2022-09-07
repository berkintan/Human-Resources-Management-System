package kodlamaIO.HRMS.api.controllers;

import kodlamaIO.HRMS.business.abstracts.CandidateService;
import kodlamaIO.HRMS.core.utilities.results.DataResult;
import kodlamaIO.HRMS.core.utilities.results.Result;
import kodlamaIO.HRMS.entites.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll() {
        return this.candidateService.getAll();
    }

    @PostMapping("/register")
    public Result register(@RequestBody Candidate candidate) throws Exception {
        return this.candidateService.register(candidate);
    }
}
