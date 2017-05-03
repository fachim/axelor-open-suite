/**
 * Axelor Business Solutions
 *
 * Copyright (C) 2017 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.hr.service.config;

import com.axelor.apps.base.db.Company;
import com.axelor.apps.base.db.Product;
import com.axelor.apps.hr.db.HRConfig;
import com.axelor.apps.hr.db.LeaveReason;
import com.axelor.apps.hr.exception.IExceptionMessage;
import com.axelor.apps.message.db.Template;
import com.axelor.exception.AxelorException;
import com.axelor.exception.db.IException;
import com.axelor.i18n.I18n;
import com.google.common.base.Strings;

public class HRConfigService {
	
	public HRConfig getHRConfig(Company company) throws AxelorException  {
		HRConfig hrConfig = company.getHrConfig();

		if(hrConfig == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG), company.getName()),IException.CONFIGURATION_ERROR);
		}
		return hrConfig;
	}
	
	public LeaveReason getLeaveReason(HRConfig hrConfig) throws AxelorException{
		LeaveReason leaveReason = hrConfig.getToJustifyLeaveReason();
		
		if(leaveReason == null){
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_LEAVE_REASON), hrConfig.getCompany().getName()), IException.CONFIGURATION_ERROR);
		}
		return leaveReason;
	}
	
	public String getLunchVoucherExportPath(HRConfig hrConfig) throws AxelorException{
		String lunchVoucherExportPath = hrConfig.getExportCodeForLunchVoucherManagement();
		if(Strings.isNullOrEmpty(lunchVoucherExportPath)){
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_LUNCH_VOUCHER_EXPORT_PATH), hrConfig.getCompany().getName()), IException.CONFIGURATION_ERROR);
		}
		return lunchVoucherExportPath;
	}
	
	public Product getKilometricExpenseProduct(HRConfig hrConfig) throws AxelorException{
		Product kilometricExpenseProduct = hrConfig.getKilometricExpenseProduct();

		if(kilometricExpenseProduct == null){
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_EXPENSE_TYPE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}
		
		return kilometricExpenseProduct;
	}
	
	
	// EXPENSE
	
	public Template getSentExpenseTemplate(HRConfig hrConfig) throws AxelorException  {
		
		Template sentExpenseTemplate = hrConfig.getSentExpenseTemplate();
		
		if(sentExpenseTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_SENT_EXPENSE_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}
		
		return sentExpenseTemplate;
		
	}
	
	public Template getValidatedExpenseTemplate(HRConfig hrConfig) throws AxelorException  {
		
		Template validatedExpenseTemplate = hrConfig.getValidatedExpenseTemplate();
		
		if(validatedExpenseTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_VALIDATED_EXPENSE_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}
		
		return validatedExpenseTemplate;
		
	}
	
	public Template getRefusedExpenseTemplate(HRConfig hrConfig) throws AxelorException  {
		
		Template refusedExpenseTemplate = hrConfig.getRefusedExpenseTemplate();
		
		if(refusedExpenseTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_REFUSED_EXPENSE_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}
		
		return refusedExpenseTemplate;
		
	}
	
	public Template getCanceledExpenseTemplate(HRConfig hrConfig) throws AxelorException  {

		Template refusedExpenseTemplate = hrConfig.getCanceledExpenseTemplate();

		if(refusedExpenseTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_CANCELED_EXPENSE_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}

		return refusedExpenseTemplate;

	}


	// TIMESHEET
	
	public Template getSentTimesheetTemplate(HRConfig hrConfig) throws AxelorException  {

		Template sentTimesheetTemplate = hrConfig.getSentTimesheetTemplate();
		
		if(sentTimesheetTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_SENT_TIMESHEET_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}
		
		return sentTimesheetTemplate;
		
	}
	
	public Template getValidatedTimesheetTemplate(HRConfig hrConfig) throws AxelorException  {
		
		Template validatedTimesheetTemplate = hrConfig.getValidatedTimesheetTemplate();
		
		if(validatedTimesheetTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_VALIDATED_TIMESHEET_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}
		
		return validatedTimesheetTemplate;
		
	}
	
	public Template getRefusedTimesheetTemplate(HRConfig hrConfig) throws AxelorException  {
		
		Template refusedTimesheetTemplate = hrConfig.getRefusedTimesheetTemplate();
		
		if(refusedTimesheetTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_REFUSED_TIMESHEET_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}
		
		return refusedTimesheetTemplate;
		
	}
	
	public Template getCanceledTimesheetTemplate(HRConfig hrConfig) throws AxelorException  {

		Template refusedTimesheetTemplate = hrConfig.getCanceledTimesheetTemplate();

		if(refusedTimesheetTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_CANCELED_TIMESHEET_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}

		return refusedTimesheetTemplate;

	}

	
	// LEAVE REQUEST
	
	public Template getSentLeaveTemplate(HRConfig hrConfig) throws AxelorException  {

		Template sentLeaveTemplate = hrConfig.getSentLeaveTemplate();
		
		if(sentLeaveTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_SENT_LEAVE_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}
		
		return sentLeaveTemplate;
		
	}
	
	public Template getValidatedLeaveTemplate(HRConfig hrConfig) throws AxelorException  {
		
		Template validatedLeaveTemplate = hrConfig.getValidatedLeaveTemplate();
		
		if(validatedLeaveTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_VALIDATED_LEAVE_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}
		
		return validatedLeaveTemplate;
		
	}
	
	public Template getRefusedLeaveTemplate(HRConfig hrConfig) throws AxelorException  {
		
		Template refusedLeaveTemplate = hrConfig.getRefusedLeaveTemplate();
		
		if(refusedLeaveTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_REFUSED_LEAVE_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}
		
		return refusedLeaveTemplate;
		
	}
	
	public Template getCanceledLeaveTemplate(HRConfig hrConfig) throws AxelorException  {

		Template refusedLeaveTemplate = hrConfig.getCanceledLeaveTemplate();

		if(refusedLeaveTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_CANCELED_LEAVE_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}

		return refusedLeaveTemplate;

	}

	
	// EXTRA HOURS
	
	public Template getSentExtraHoursTemplate(HRConfig hrConfig) throws AxelorException  {

		Template sentExtraHoursTemplate = hrConfig.getSentExtraHoursTemplate();
		
		if(sentExtraHoursTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_SENT_EXTRA_HOURS_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}
		
		return sentExtraHoursTemplate;
		
	}
	
	public Template getValidatedExtraHoursTemplate(HRConfig hrConfig) throws AxelorException  {
		
		Template validatedExtraHoursTemplate = hrConfig.getValidatedExtraHoursTemplate();
		
		if(validatedExtraHoursTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_VALIDATED_EXTRA_HOURS_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}
		
		return validatedExtraHoursTemplate;
		
	}
	
	public Template getRefusedExtraHoursTemplate(HRConfig hrConfig) throws AxelorException  {
		
		Template refusedExtraHoursTemplate = hrConfig.getRefusedExtraHoursTemplate();
		
		if(refusedExtraHoursTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_REFUSED_EXTRA_HOURS_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}
		
		return refusedExtraHoursTemplate;
		
	}

	public Template getCanceledExtraHoursTemplate(HRConfig hrConfig) throws AxelorException  {

		Template refusedExtraHoursTemplate = hrConfig.getCanceledExtraHoursTemplate();

		if(refusedExtraHoursTemplate == null)  {
			throw new AxelorException(String.format(I18n.get(IExceptionMessage.HR_CONFIG_CANCELED_EXTRA_HOURS_TEMPLATE), hrConfig.getCompany().getName()),IException.CONFIGURATION_ERROR);
		}

		return refusedExtraHoursTemplate;

	}

}
