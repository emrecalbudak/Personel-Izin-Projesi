package orion.Dayoff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orion.Dayoff.Core.utilities.results.DataResult;
import orion.Dayoff.Core.utilities.results.Result;
import orion.Dayoff.Core.utilities.results.SuccessDataResult;
import orion.Dayoff.Core.utilities.results.SuccessResult;
import orion.Dayoff.entity.DayOff;
import orion.Dayoff.repository.DayOffRepository;

@Service
public class DayOffServiceImpl implements DayOffService{

	private DayOffRepository dayOffRepository;

	@Autowired
	public DayOffServiceImpl(DayOffRepository dayOffRepository) {
		super();
		this.dayOffRepository = dayOffRepository;
	}
	@Override
	public DataResult<List<DayOff>> getAll() {
		return new SuccessDataResult<List<DayOff>>
		(this.dayOffRepository.findAll(), "veriler listelendi");
	}

	@Override
	public Result add(DayOff dayOff) {
		this.dayOffRepository.save(dayOff);
		return new SuccessResult("Kayıt eklendi");
	}
}
