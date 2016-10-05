/*
 * Copyright 2016 EPAM Systems
 * 
 * 
 * This file is part of EPAM Report Portal.
 * https://github.com/epam/ReportPortal
 * 
 * Report Portal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Report Portal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Report Portal.  If not, see <http://www.gnu.org/licenses/>.
 */ 

package com.epam.ta.reportportal.core.widget.content;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.epam.ta.reportportal.database.OverallStatisticsDocumentHandler;
import com.epam.ta.reportportal.database.dao.LaunchRepository;
import com.epam.ta.reportportal.database.search.Filter;
import com.epam.ta.reportportal.ws.model.widget.ChartObject;

/**
 * Implementation of
 * {@link com.epam.ta.reportportal.core.widget.content.IContentLoadingStrategy}
 * for Overall Statistics
 * 
 * @author Dzmitry_Kavalets
 * @author Andrei_Ramanchuk
 */
@Service("OverallStatisticsContentLoader")
public class OverallStatisticsContentLoader extends StatisticBasedContentLoader implements IContentLoadingStrategy {

	@Autowired
	private LaunchRepository launchRepository;

	// data must be collected from launch collection
	private static final String COLLECTION_NAME = "launch";

	@Override
	public Map<String, List<ChartObject>> loadContent(Filter filter, Sort sorting, int quantity, List<String> contentFields,
			List<String> metaDataFields, Map<String, List<String>> options) {

		OverallStatisticsDocumentHandler overallStatisticsContentLoader = new OverallStatisticsDocumentHandler(contentFields);
		launchRepository.loadWithCallback(filter, sorting, quantity, contentFields, overallStatisticsContentLoader, COLLECTION_NAME);
		return assembleData(overallStatisticsContentLoader.getResult());
	}

	/**
	 * Transform handler output in widget content format
	 * 
	 * @param data
	 * @return
	 */
	private Map<String, List<ChartObject>> assembleData(Map<String, Integer> data) {
		Map<String, String> values = new HashMap<>();
		data.keySet().stream().forEach(key -> values.put(getFieldName(key), data.get(key).toString()));
		ChartObject chartObject = new ChartObject();
		chartObject.setValues(values);
		Map<String, List<ChartObject>> result = new HashMap<>();
		result.put(RESULT, Collections.singletonList(chartObject));
		return result;
	}

	/**
	 * Field name parser
	 * 
	 * @param fieldName
	 * @return
	 */
	private String getFieldName(String fieldName) {
		String[] split = fieldName.split("\\.");
		return split[split.length - 1];
	}
}