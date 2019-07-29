package org.sample.springboot.batch.configuration;

import java.math.BigDecimal;

import org.sample.springboot.batch.dao.entity.Voltage;
import org.springframework.batch.item.ItemProcessor;

public class VoltageProcessor implements ItemProcessor<Voltage, Voltage> {

	@Override
	public Voltage process(Voltage voltage) throws Exception {
		final BigDecimal volt = voltage.getVolt();
		final double time = voltage.getTime();
		
		final Voltage processedVoltage = new Voltage();
		processedVoltage.setVolt(volt);
		processedVoltage.setTime(time);
		return processedVoltage;
	}
	
}
