package ro.teamnet.zth.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.teamnet.zth.app.dao.JobDao;
import ro.teamnet.zth.app.domain.Job;
import ro.teamnet.zth.app.service.JobServiceImpl;

import java.util.List;

/**
 * Created by Mi on 5/6/2015.
 */
@Controller
@RequestMapping(value = "/jobs")
public class JobController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Job> getAllJobs() {
        JobServiceImpl jobService = new JobServiceImpl();
        return jobService.findAllJobs();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Job getOneJob(@PathVariable("id") String idJob) {
        JobServiceImpl jobService = new JobServiceImpl();
        return jobService.findOneJob(Integer.valueOf(idJob));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.OK)
    public void deleteJob(@PathVariable("id") String idJob) {
        JobServiceImpl jobService = new JobServiceImpl();
        jobService.deleteJob(Integer.valueOf(idJob));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void save(@RequestBody Job job) {
        JobServiceImpl jobService = new JobServiceImpl();
        jobService.saveJob(job);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@RequestBody Job job) {
        JobServiceImpl jobService = new JobServiceImpl();
        jobService.updateJob(job);
    }
}
