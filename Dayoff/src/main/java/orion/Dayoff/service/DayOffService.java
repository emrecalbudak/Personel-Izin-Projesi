package orion.Dayoff.service;

import java.util.List;

import orion.Dayoff.Core.utilities.results.DataResult;
import orion.Dayoff.Core.utilities.results.Result;
import orion.Dayoff.entity.DayOff;

public interface DayOffService {
	DataResult<List<DayOff>> getAll();
	Result add(DayOff dayOff);
}
