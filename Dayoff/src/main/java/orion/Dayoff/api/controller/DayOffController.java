package orion.Dayoff.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import orion.Dayoff.Core.utilities.results.DataResult;
import orion.Dayoff.Core.utilities.results.Result;
import orion.Dayoff.service.DayOffService;
import orion.Dayoff.entity.DayOff;

@RestController
@RequestMapping("/api/dayoff")
@CrossOrigin
public class DayOffController {
	private DayOffService dayOffService;
	@Autowired
	public DayOffController (DayOffService dayOffService) {
		super();
		this.dayOffService= dayOffService;	
	}
	@GetMapping("/getall")
	public DataResult<List<DayOff>> getAll(){
		return this.dayOffService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody DayOff dayOff) {
		return this.dayOffService.add(dayOff);
	}

}
