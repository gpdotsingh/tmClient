package com.ing.client.tm.tmClient.util;

import java.util.List;
import com.ing.client.tm.tmClient.mapping.Root;
import com.ing.client.tm.tmClient.mapping.Trace;
import com.ing.client.tm.tmClient.vo.MetricsVO;

public class MetricsUtility {
	int status2xxCount, status4xxCount, status5xxCount, totalCount = 0;
	int maxTime, minTime = 0;
	
	public MetricsVO processAndReturnMetrics(Root traceData) {
		List<Trace> traces = traceData.getTraces();
		if(traces!=null && traces.size() != 0) {
			traces.forEach((t) -> {
					totalCount++;
					int status = t.getResponse().getStatus();
					if(status>=200 && status<300)
						status2xxCount++;
					else if(status>=400 && status<500)
						status4xxCount++;
					else if(status>=500)
						status5xxCount++;
					
					if(t.getTimeTaken()>maxTime)
						maxTime = t.getTimeTaken();
					
					if(totalCount==1 || t.getTimeTaken()<minTime)
						minTime = t.getTimeTaken();
			});
		}
		MetricsVO metricsVO = new MetricsVO();
		metricsVO.setTotalCount(totalCount);
		metricsVO.setStatusOKCount(status2xxCount);
		metricsVO.setStatus4XXCount(status4xxCount);
		metricsVO.setStatus5XXCount(status5xxCount);
		metricsVO.setMaxTime(maxTime);
		metricsVO.setMinTime(minTime);

		return metricsVO;
	}
}
