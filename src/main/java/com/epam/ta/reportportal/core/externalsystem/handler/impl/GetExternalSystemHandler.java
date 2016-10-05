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

package com.epam.ta.reportportal.core.externalsystem.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.ta.reportportal.commons.Predicates;
import com.epam.ta.reportportal.commons.validation.BusinessRule;
import com.epam.ta.reportportal.core.externalsystem.handler.IGetExternalSystemHandler;
import com.epam.ta.reportportal.database.dao.ExternalSystemRepository;
import com.epam.ta.reportportal.database.entity.ExternalSystem;
import com.epam.ta.reportportal.ws.converter.ExternalSystemResourceAssembler;
import com.epam.ta.reportportal.ws.model.ErrorType;
import com.epam.ta.reportportal.ws.model.externalsystem.ExternalSystemResource;

/**
 * Implementation of {@link IGetExternalSystemHandler} interface
 * 
 * @author Andrei_Ramanchuk
 */
@Service
public class GetExternalSystemHandler implements IGetExternalSystemHandler {

	@Autowired
	private ExternalSystemRepository externalSystemRepository;

	@Autowired
	private ExternalSystemResourceAssembler assembler;

	@Override
	public ExternalSystemResource getExternalSystem(String projectName, String id) {
		ExternalSystem exist = externalSystemRepository.findOne(id);
		BusinessRule.expect(exist, Predicates.notNull()).verify(ErrorType.EXTERNAL_SYSTEM_NOT_FOUND, id);
		return assembler.toResource(exist);
	}
}