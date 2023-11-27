package monthsago.travel16.controller;

import monthsago.travel16.Model.Schedule;
import monthsago.travel16.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ScheduleController {


    @Autowired
    private ScheduleService scheduleService;


    @GetMapping("/getschedule/{no}")
    public List<Schedule> getSchedule( @PathVariable String no) {

        return scheduleService.getSchedule(no);
    }
    @GetMapping("/getschedulebyNum/{no}")
    public Optional<Schedule> getScheduleByNum(@PathVariable Integer no) {

        return scheduleService.getScheduleNum(no);
    }
    @PostMapping("/saveschedule")
    public Schedule saveSchedule(@RequestBody Schedule schedule) {

     //=> id를 받아와서  reschedule 에 저장

        return   scheduleService.saveSchedule(schedule);
    }
    @DeleteMapping("/deleteschedule/{no}")
    public void deleteSchedule(@PathVariable Integer no) {
        scheduleService.deleteSchedule(no);
    }
    @PutMapping("/updateschedule/{no}")
    public void updateschedule(@PathVariable Integer no, @RequestBody Schedule schedule) {
        scheduleService.updateSchedule(no,schedule);
    }
}
