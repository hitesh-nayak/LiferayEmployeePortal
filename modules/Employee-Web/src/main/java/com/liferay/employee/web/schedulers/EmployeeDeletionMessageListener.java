package com.liferay.employee.web.schedulers;

import com.liferay.employee.service.model.Employee;
import com.liferay.employee.service.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.StorageTypeAware;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {}, service = BaseMessageListener.class)

public class EmployeeDeletionMessageListener extends BaseMessageListener {

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) throws SchedulerException {
		String cronExpresion = CRON_EXPRESSION;

		String listenerClass = getClass().getName();
		Trigger jobTrigger = _triggerFactory.createTrigger(listenerClass, listenerClass, new Date(), null,
				cronExpresion);
		_schedulerEntryImpl = new SchedulerEntryImpl(getClass().getName(), jobTrigger);
		if (_initialized) {
            deactivate();
        }

		_schedulerEngineHelper.register(this, _schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
		_log.debug("Scheduled task registered: " + cronExpresion);
		_initialized = true;

	}

	@Deactivate
	protected void deactivate() {
		unregister();
	}

	private void unregister() {
		
		EmployeeDeletionMessageListener  deletionMessageListener = new EmployeeDeletionMessageListener();

		if (_initialized) {

			try {
				_schedulerEngineHelper.unschedule(EmployeeDeletionMessageListener.class.getName(), groupNameString, getStorageType());
			} catch (SchedulerException se) {
				if (_log.isWarnEnabled()) {
					_log.warn("Unable to unschedule trigger", se);
				}
			}

			_schedulerEngineHelper.unregister(this);
		}

		_initialized = false;
	}
	
	protected StorageType getStorageType() {
        if (_schedulerEntryImpl instanceof StorageTypeAware) {
            return ((StorageTypeAware) _schedulerEntryImpl).getStorageType();
        }
        return StorageType.MEMORY_CLUSTERED;
    }

	@Override
	protected void doReceive(Message message) throws Exception {

		_log.info("Executing scheduler");
		_log.info(getEmployees().size() + " employee(s) is/are over 60 days old. Log from Message Listener");
	}

	private List<Employee> getEmployees() {
		DynamicQuery dQuery = EmployeeLocalServiceUtil.dynamicQuery();
		Date currentDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.DAY_OF_MONTH, -60);
		Date dateSixtyDaysAgoDate = calendar.getTime();

		dQuery.add(RestrictionsFactoryUtil.le("createDate", dateSixtyDaysAgoDate));

		return EmployeeLocalServiceUtil.dynamicQuery(dQuery);

	}
	
	private static String groupNameString;
	private volatile boolean _initialized;
	private SchedulerEntryImpl _schedulerEntryImpl = null;
	@Reference
	private TriggerFactory _triggerFactory;
	@Reference
	private SchedulerEngineHelper _schedulerEngineHelper;
	private static final String CRON_EXPRESSION = "0 0/1 * * * ? *";

	private static Log _log = LogFactoryUtil.getLog(EmployeeDeletionMessageListener.class);
}
