/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.store.jooq.udt;

import com.epam.ta.reportportal.store.jooq.JPublic;
import com.epam.ta.reportportal.store.jooq.udt.records.JParameterRecord;
import org.jooq.Schema;
import org.jooq.UDTField;
import org.jooq.impl.UDTImpl;

import javax.annotation.Generated;

/**
 * This class is generated by jOOQ.
 */
@Generated(value = { "http://www.jooq.org", "jOOQ version:3.10.4" }, comments = "This class is generated by jOOQ")
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JParameter extends UDTImpl<JParameterRecord> {

	private static final long serialVersionUID = -1102734017;

	/**
	 * The reference instance of <code>public.parameter</code>
	 */
	public static final JParameter PARAMETER = new JParameter();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<JParameterRecord> getRecordType() {
		return JParameterRecord.class;
	}

	/**
	 * The attribute <code>public.parameter.key</code>.
	 */
	public static final UDTField<JParameterRecord, String> KEY = createField("key", org.jooq.impl.SQLDataType.VARCHAR(256), PARAMETER, "");

	/**
	 * The attribute <code>public.parameter.value</code>.
	 */
	public static final UDTField<JParameterRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.CLOB, PARAMETER, "");

	/**
	 * No further instances allowed
	 */
	private JParameter() {
		super("parameter", null, null, false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Schema getSchema() {
		return JPublic.PUBLIC;
	}
}